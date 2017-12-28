package com.jkg.socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端
 * @ClassName:  Client   
 * @Description:客户端
 * @author: jiaokg 
 * @date:   2017年12月20日 上午12:05:14   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class Client {
	public static void main(String[] args) throws IOException {
		//创建客户端的socket
		Socket socket = new Socket("localhost", 8888);
		OutputStream outputStream = socket.getOutputStream();//获得输出字节
		PrintWriter printWriter = new PrintWriter(outputStream);	//将字节流包装为打印流
		printWriter.write("姓名：jkg1,密码：1231");
		printWriter.flush();
		
		socket.shutdownOutput();
		
		//接受服务器返回的数据
		InputStream inputStream = socket.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String info = null;
		while ((info = bufferedReader.readLine()) != null) {
			System.out.println("我是客户端,服务器："+info);
		}
		socket.shutdownInput();
		
		socket.close();	//关闭socket会自动关闭流
		outputStream.close();
		printWriter.close();
		inputStream.close();
		inputStreamReader.close();
		bufferedReader.close();
	}
}
