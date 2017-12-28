package com.jkg.socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP客户端实现
 * @ClassName:  UDPClient   
 * @Description:UDP客户端实现 
 * @author: jiaokg 
 * @date:   2017年12月21日 上午12:03:58   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class UDPClient {
	public static void main(String[] args) throws IOException {
		//1、定义服务器地址，端口号，数据
		InetAddress address = InetAddress.getByName("localhost");
		byte[] buf = "姓名：jkg，密码：123".getBytes();
		//2、创建数据报传递数据
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, address, 8800);
		//3、创建datagramSocket对象
		DatagramSocket datagramSocket = new DatagramSocket();
		//4、向服务器发送数据
		datagramSocket.send(datagramPacket);
	}
}
