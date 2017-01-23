package com.sinsz.test.aio.client;

/**
 * 客户端
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 7777;

        if(args != null && args.length > 0){

            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }

        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port),"客户端001").start();

    }
}
