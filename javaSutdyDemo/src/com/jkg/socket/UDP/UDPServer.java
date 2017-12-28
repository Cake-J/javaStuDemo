package com.jkg.socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * udp的服务
 * @ClassName:  UDPServer   
 * @Description:udp的服务
 * @author: jiaokg 
 * @date:   2017年12月20日 下午11:38:27   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//1、创建服务器的datagramSocket,指定端口号
		DatagramSocket datagramSocket = new DatagramSocket(8800);
		System.out.println("*************服务器正在启动，请稍后***************");
		//2、创建数据报 用于接受客户端发送的数据
		byte[] buf = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		//3、接受客户端数据
		datagramSocket.receive(datagramPacket); //读取数据之前一直是阻塞的，即不执行下面代码
		//4、读取数据
		String info = new String(buf, 0, buf.length);
		System.out.println("我是服务器，客户端消息："+info);
	}
}
