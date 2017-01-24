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
public class TimeClientHandler2 extends ChannelInboundHandlerAdapter{

    private static final Logger log = LoggerFactory.getLogger(TimeClientHandler2.class.getName());



    private int counter;

    private byte[] resp;

    public TimeClientHandler2() {
        resp = ("THIS" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //发送消息内容的变量
        ByteBuf firstBufMsg;
        for (int i = 0; i < 100; i++) {
            firstBufMsg = Unpooled.buffer(resp.length);
            firstBufMsg.writeBytes(resp);
            ctx.writeAndFlush(firstBufMsg);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");*/
        String body = "当前时间为：" + msg + " ；计数：" + ++counter;
        System.out.println(body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.warn("释放资源 " + cause.getMessage() ,cause);
        ctx.close();
    }
}
