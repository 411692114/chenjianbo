package com.sinsz.netty.core;

import com.sinsz.netty.proto.IMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author chenjianbo
 * @date 2017/4/7
 */
public class MessageDecode extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in == null) {
            ctx.close();
            return ;
        }
        if (in.readableBytes() < 6) {
            return ;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        //因为包头预留了两个字节的大小，所以要预先读掉两个字节
        byte packet = in.readByte();
        byte version = in.readByte();
        System.out.println("dataLength = " + dataLength);
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }
        byte[] body = new byte[dataLength];
        in.readBytes(body);
        Object object = IMessage.IMessageBuf.parseFrom(body);
        out.add(object);
    }
}
