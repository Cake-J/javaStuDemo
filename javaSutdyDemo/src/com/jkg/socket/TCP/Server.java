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
 * ������
 * @ClassName:  Server   
 * @Description:������ 
 * @author: jiaokg 
 * @date:   2017��12��16�� ����4:43:31   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("********�������������������Ժ�*****************");
		Socket socket = null;
		/*
		Socket socket = serverSocket.accept();
		InputStream inputStream = socket.getInputStream();//��������ֽ�
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//ת��Ϊ�����ַ�
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//�ַ����뻺����
		String info = null;
		while ((info = bufferedReader.readLine()) != null) {
			System.out.println("���Ƿ����������յ��ͻ�����Ϣ��"+info);
		}
		socket.shutdownInput();
		
		//��������Ӧ
		OutputStream outputStream = socket.getOutputStream();//�ֽ������
		PrintWriter printWriter = new PrintWriter(outputStream);
		printWriter.write("��ӭ����");
		printWriter.flush();
		socket.shutdownOutput();
		
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		outputStream.close();
		printWriter.close();
		serverSocket.close();
		*/
		//���̷߳�����
		//��ѭ��ȷ���߳�һֱ����
		while (true) {
			//����accept������ʼ����
			socket = serverSocket.accept();
			ServerThread serverThread = new ServerThread(socket);
			serverThread.start();
		}
	}

}
