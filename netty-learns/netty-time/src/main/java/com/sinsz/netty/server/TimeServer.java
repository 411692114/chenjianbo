package com.sinsz.netty.server;


import com.sinsz.netty.handler.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * netty案例01
 */
public class TimeServer {

    public void bind(int port) throws Exception{
        //配置服务端线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() * 2);
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            //基本设置
            bootstrap.group(bossGroup,workerGroup)
                     .channel(NioServerSocketChannel.class)
                     .option(ChannelOption.SO_BACKLOG,128)
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
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }

    }

}
