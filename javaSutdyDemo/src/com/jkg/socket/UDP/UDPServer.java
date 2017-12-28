package com.jkg.socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * udp�ķ���
 * @ClassName:  UDPServer   
 * @Description:udp�ķ���
 * @author: jiaokg 
 * @date:   2017��12��20�� ����11:38:27   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//1��������������datagramSocket,ָ���˿ں�
		DatagramSocket datagramSocket = new DatagramSocket(8800);
		System.out.println("*************�������������������Ժ�***************");
		//2���������ݱ� ���ڽ��ܿͻ��˷��͵�����
		byte[] buf = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		//3�����ܿͻ�������
		datagramSocket.receive(datagramPacket); //��ȡ����֮ǰһֱ�������ģ�����ִ���������
		//4����ȡ����
		String info = new String(buf, 0, buf.length);
		System.out.println("���Ƿ��������ͻ�����Ϣ��"+info);
	}
}
