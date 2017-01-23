package com.sinsz.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenjianbo on 2017/1/23.
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter{

    private static final Logger log = LoggerFactory.getLogger(TimeClientHandler.class.getName());

    //发送消息内容的变量
    private ByteBuf firstBufMsg;

    public TimeClientHandler() {
        byte[] resp = "THIS".getBytes();
        firstBufMsg = Unpooled.buffer(resp.length);
        firstBufMsg.writeBytes(resp);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstBufMsg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = "当前时间为：" + new String(req,"UTF-8");
        System.out.println(body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.warn("释放资源 " + cause.getMessage() ,cause);
        ctx.close();
    }
}
