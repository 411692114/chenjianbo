package com.sinsz.netty.server;

import com.sinsz.netty.core.MessageDecode;
import com.sinsz.netty.core.MessageEncode;
import com.sinsz.netty.proto.IMessage;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author chenjianbo
 * @date 2017/4/7
 */
public class MessageServer {

    public void bind(int port) throws Exception{
        //配置服务端线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() * 2);
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            //基本设置
            bootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, false)
                    .option(ChannelOption.TCP_NODELAY, true) //设置封包 使用一次大数据的写操作，而不是多次小数据的写操作
                    .option(ChannelOption.SO_BACKLOG, 128)   //挂起的连接
                    .childHandler(new ChildHandler());
            //绑定端口，同步等待成功
            ChannelFuture future = bootstrap.bind(port).sync();
            //等待服务器监听端口关闭你
            future.channel().closeFuture().sync();
        }finally {
            //退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

class ChildHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("decoder", new MessageDecode())
                     .addLast("encoder", new MessageEncode())
                     .addLast(new MessageHandler());
    }

}

class MessageHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        IMessage.IMessageBuf message = (IMessage.IMessageBuf)msg;
        System.out.println(
                "username：" + message.getUsername() +
                "content：" + message.getContent() +
                "state：" + message.getState()
        );
        IMessage.IMessageBuf result = IMessage.IMessageBuf.newBuilder()
                .setContent("响应成功")
                .setUsername(message.getUsername())
                .setState(true)
                .build();
        ctx.channel().writeAndFlush(result);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace(System.out);
        ctx.close();
    }
}