package com.sinsz.test.aio;

/**
 * Created by chenjianbo on 2017/1/22.
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 7777;

        if(args != null && args.length > 0){

            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }

        }

        AsyncTimeServerHandler handler = new AsyncTimeServerHandler(port);

        new Thread(handler,"服务器001").start();
    }
}
