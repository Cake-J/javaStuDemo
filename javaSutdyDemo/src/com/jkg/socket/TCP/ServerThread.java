package com.jkg.socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * 服务器线程
 * @ClassName:  ServerThread   
 * @Description:服务器线程 
 * @author: jiaokg 
 * @date:   2017年12月20日 下午10:38:37   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class ServerThread extends Thread {
	
	Socket socket = null;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public synchronized void start() {
		super.start();
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		OutputStream outputStream = null;
		PrintWriter printWriter = null;
		try {
			inputStream = socket.getInputStream();//获得输入字节
			inputStreamReader = new InputStreamReader(inputStream);//转换为输入字符
			bufferedReader = new BufferedReader(inputStreamReader);//字符放入缓存中
			String info = null;
			while ((info = bufferedReader.readLine()) != null) {
				System.out.println("我是服务器，接收到客户端信息："+info);
			}
			socket.shutdownInput();
			
			//服务器响应
			outputStream = socket.getOutputStream();//字节输出流
			printWriter = new PrintWriter(outputStream);
			printWriter.write("欢迎您！");
			printWriter.flush();
			socket.shutdownOutput();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (inputStreamReader != null) {
					inputStreamReader.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
