package com.sinsz.netty;

import com.sinsz.netty.server.MessageServer;

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
        new MessageServer().bind(port);
    }

}
