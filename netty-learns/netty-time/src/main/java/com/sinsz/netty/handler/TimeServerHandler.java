package com.sinsz.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;


/**
 * 业务实现
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 开始读写
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //读取数据
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("收到指令为：" + body);
        String currentTime = "THIS" .equalsIgnoreCase(body) ? new Date().toString():"指令错误";
        //将数据写入字节流
        //将字符串转换为字节流
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        //①将数据写入缓存素组中
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //②将缓存数组中的数据发送给对方
        ctx.flush();
    }

    /**
     * 异常时
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}