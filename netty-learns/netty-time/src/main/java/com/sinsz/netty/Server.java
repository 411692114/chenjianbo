package com.sinsz.netty;

import com.sinsz.netty.server.EchoServer;

public class Server {

    /**
     * 服务端启动入口
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int port = 7777;
        if(args !=null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
            }
        }
        //new TimeServer().bind(port);
        new EchoServer().bind(port);
    }

}
