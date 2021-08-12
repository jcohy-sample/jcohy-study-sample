package com.jcohy.sample.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Copyright: Copyright (c) 2020 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/9/24:11:08
 * @since 1.0.0
 */
public class BioDemo {

	public static void main(String[] args) throws Exception{
		ExecutorService executorService = Executors.newCachedThreadPool();
		ServerSocket serverSocket = new ServerSocket(6666);
		System.out.println("服务器启动.....");
		while (true){
			System.out.println("等待客户端连接.....");
			final Socket socket = serverSocket.accept();
			System.out.println("客户端连接成功.....");
			executorService.execute(() -> {
				handler(socket);
			});
		}

	}

	private static void handler(Socket socket) {

		try {
			while (true){
				System.out.println(Thread.currentThread().getId()+":"+Thread.currentThread().getName());
				byte[] bytes = new byte[1024];
				InputStream inputStream = socket.getInputStream();
				int read = inputStream.read(bytes);
				if(read != -1){
					System.out.println(new String(bytes,0,read));
				}else{
					break;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
