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
 * �ͻ���
 * @ClassName:  Client   
 * @Description:�ͻ���
 * @author: jiaokg 
 * @date:   2017��12��20�� ����12:05:14   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class Client {
	public static void main(String[] args) throws IOException {
		//�����ͻ��˵�socket
		Socket socket = new Socket("localhost", 8888);
		OutputStream outputStream = socket.getOutputStream();//�������ֽ�
		PrintWriter printWriter = new PrintWriter(outputStream);	//���ֽ�����װΪ��ӡ��
		printWriter.write("������jkg1,���룺1231");
		printWriter.flush();
		
		socket.shutdownOutput();
		
		//���ܷ��������ص�����
		InputStream inputStream = socket.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String info = null;
		while ((info = bufferedReader.readLine()) != null) {
			System.out.println("���ǿͻ���,��������"+info);
		}
		socket.shutdownInput();
		
		socket.close();	//�ر�socket���Զ��ر���
		outputStream.close();
		printWriter.close();
		inputStream.close();
		inputStreamReader.close();
		bufferedReader.close();
	}
}
