package com.sinsz.netty.core;

import com.google.protobuf.MessageLite;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author chenjianbo
 * @date 2017/4/6
 */
public class MessageEncode extends MessageToByteEncoder<MessageLite> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageLite msg, ByteBuf byteBuf) throws Exception {
        byte[] content = msg.toByteArray();
        byte[] head = new byte[6];
        System.arraycopy(intToByteArray(content.length), 0, head, 0, 4);
        head[4] = 1;
        head[5] = 0;
        byteBuf.writeBytes(head);
        byteBuf.writeBytes(content);
    }

    private byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        //由高位到低位
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return result;
    }

}
