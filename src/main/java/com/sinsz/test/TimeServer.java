package com.sinsz.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		int port = 8088;
		
		if(args != null && args.length > 0){
			
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				
			}
			
		}
		
		ServerSocket server = null;
		
		try {
			
			server = new ServerSocket(port);
			
			System.out.println("通信服务已启动，端口号为：" + port);
			
			Socket socket = null;

			TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(50,1000);
			
			while(true){
				//线程阻塞
				socket = server.accept();

				executePool.execute(new TimeServerHandler(socket));

				//new Thread(new TimeServerHandler(socket)).start();
				
			}
			
		} finally {
			
			if(server != null){
				
				server.close();
				
			}
			
		}
		
	}

}
