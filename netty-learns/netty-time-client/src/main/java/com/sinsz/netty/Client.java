package com.sinsz.netty;

import com.sinsz.netty.client.TimeClient;

/**
 * 客户端启动
 */
public class Client {

	public static void main(String[] args) throws InterruptedException {
		int port = 7777;
		if(args !=null && args.length > 0){
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
			}
		}
		new TimeClient().connect(port,"127.0.0.1");
	}

}
