package com.sinsz.netty.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.string.StringDecoder;


/**
 * netty案例01
 */
public class EchoServer {

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
                     .childHandler(new ChildChannelHandler());
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

    /**
     * 子处理通道
     */
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            //自定义截断符
            ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
            //自定义截断符
            socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
            socketChannel.pipeline().addLast(new StringDecoder());
            socketChannel.pipeline().addLast(new EchoServerHandler());
            socketChannel.pipeline().addLast(new ProtobufEncoder());
        }

    }

    @ChannelHandler.Sharable
    public class EchoServerHandler extends ChannelInboundHandlerAdapter {
        private int counter = 0;

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            String body = msg.toString();
            System.out.println("[number: "+ ++counter +",body: " + body + "]");
            body += "$_";
            ByteBuf byteBuf = Unpooled.copiedBuffer(body.getBytes());
            ctx.writeAndFlush(byteBuf);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }

}
