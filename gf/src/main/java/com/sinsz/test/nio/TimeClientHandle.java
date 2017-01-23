package com.sinsz.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 客户端处理
 */
public class TimeClientHandle implements Runnable {

    private String host;

    private int port;

    private Selector selector;

    private SocketChannel socketChannel;

    private volatile boolean stop;

    private volatile boolean reSend;

    /**
     * 初始
     * @param host
     * @param port
     */
    public TimeClientHandle(String host,int port) {
        this.host = host == null? "127.0.0.1":host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        //发送
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        //重发与接收
        while (!stop){

            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (IOException e) {
                        if(key != null){
                            key.cancel();
                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        if (selector != null){
            try {
                selector.close();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.exit(1);
            }
        }
    }

    /**
     * 判断是否已建立连接
     * @throws IOException
     */
    private void doConnect() throws IOException{
        if(socketChannel.connect(new InetSocketAddress(host,port))){
            unSend();
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        }else{
            reSend();
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }
    }

    /**
     * 数据存入缓冲区
     * @param sc
     * @throws IOException
     */
    private void doWrite(SocketChannel sc) throws IOException{
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        sc.write(writeBuffer);
        //表示无可用数据是执行打印
        if (!writeBuffer.hasRemaining()){
            System.out.println("消息发送成功！");
            unSend();
        }
    }

    /**
     * 处理输入
     * @param key
     * @throws IOException
     */
    private void handleInput(SelectionKey key) throws IOException{
        if (key.isValid()){
            SocketChannel sc = (SocketChannel)key.channel();
            //判断是否连接成功，执行重发
            if (sc.finishConnect()){
                sc.register(selector,SelectionKey.OP_READ);
                if(reSend){
                    doWrite(sc);
                }
            }else {
                System.exit(1);
            }
            //判断是否准备好读取
            if(key.isReadable()){
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println("现在时刻为："+body);
                    stop();
                }else if(readBytes < 0){
                    key.cancel();
                    sc.close();
                }else{
                }
            }
        }
    }

    private void stop(){
        this.stop = true;
    }

    private void reSend(){
        this.reSend = true;
    }

    private void unSend(){
        this.reSend = false;
    }

}
