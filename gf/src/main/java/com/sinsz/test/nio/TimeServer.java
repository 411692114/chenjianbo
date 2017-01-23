package com.sinsz.test.nio;

import java.io.IOException;

public class TimeServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		int port = 7777;
		
		if(args != null && args.length > 0){
			
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				
			}
			
		}

		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

		new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
		
	}

}
