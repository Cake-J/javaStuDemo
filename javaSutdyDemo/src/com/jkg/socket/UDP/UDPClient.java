package com.jkg.socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP�ͻ���ʵ��
 * @ClassName:  UDPClient   
 * @Description:UDP�ͻ���ʵ�� 
 * @author: jiaokg 
 * @date:   2017��12��21�� ����12:03:58   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class UDPClient {
	public static void main(String[] args) throws IOException {
		//1�������������ַ���˿ںţ�����
		InetAddress address = InetAddress.getByName("localhost");
		byte[] buf = "������jkg�����룺123".getBytes();
		//2���������ݱ���������
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, address, 8800);
		//3������datagramSocket����
		DatagramSocket datagramSocket = new DatagramSocket();
		//4�����������������
		datagramSocket.send(datagramPacket);
	}
}
