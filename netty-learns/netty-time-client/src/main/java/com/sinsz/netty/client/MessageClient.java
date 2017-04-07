package com.sinsz.netty.client;

import com.sinsz.netty.core.MessageDecode;
import com.sinsz.netty.core.MessageEncode;
import com.sinsz.netty.proto.IMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author chenjianbo
 * @date 2017/4/7
 */
public class MessageClient {

    public void connect(int port,String host) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .remoteAddress(host, port)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new MessageDecode())
                                         .addLast("encoder", new MessageEncode())
                                         .addLast(new MessageHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(host,port).sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

}
class MessageHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        IMessage.IMessageBuf messageBuf = IMessage.IMessageBuf.newBuilder()
                .setUsername("陈健波")
                .setContent("发起请求")
                .setState(false)
                .build();
        ctx.channel().writeAndFlush(messageBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        IMessage.IMessageBuf message = (IMessage.IMessageBuf)msg;
        System.out.println(
                "username：" + message.getUsername() +
                        "content：" + message.getContent() +
                        "state：" + message.getState()
        );
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace(System.out);
        ctx.close();
    }
}