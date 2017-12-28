package com.jkg.socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 服务器
 * @ClassName:  Server   
 * @Description:服务器 
 * @author: jiaokg 
 * @date:   2017年12月16日 下午4:43:31   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("********服务器正在启动，请稍后*****************");
		Socket socket = null;
		/*
		Socket socket = serverSocket.accept();
		InputStream inputStream = socket.getInputStream();//获得输入字节
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//转换为输入字符
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//字符放入缓存中
		String info = null;
		while ((info = bufferedReader.readLine()) != null) {
			System.out.println("我是服务器，接收到客户端信息："+info);
		}
		socket.shutdownInput();
		
		//服务器响应
		OutputStream outputStream = socket.getOutputStream();//字节输出流
		PrintWriter printWriter = new PrintWriter(outputStream);
		printWriter.write("欢迎您！");
		printWriter.flush();
		socket.shutdownOutput();
		
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		outputStream.close();
		printWriter.close();
		serverSocket.close();
		*/
		//多线程服务器
		//死循环确定线程一直存在
		while (true) {
			//调用accept方法开始监听
			socket = serverSocket.accept();
			ServerThread serverThread = new ServerThread(socket);
			serverThread.start();
		}
	}

}
