package com.sinsz.test.nio;

public class TimeClient {

	public static void main(String[] args) {

		int port = 7777;

		if(args != null && args.length > 0){

			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {

			}

		}

		TimeClientHandle handle = new TimeClientHandle("127.0.0.1",port);

		new Thread(handle,"TimeClient-001").start();

	}

}
