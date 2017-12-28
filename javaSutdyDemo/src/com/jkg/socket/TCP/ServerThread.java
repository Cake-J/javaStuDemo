package com.jkg.socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * �������߳�
 * @ClassName:  ServerThread   
 * @Description:�������߳� 
 * @author: jiaokg 
 * @date:   2017��12��20�� ����10:38:37   
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
			inputStream = socket.getInputStream();//��������ֽ�
			inputStreamReader = new InputStreamReader(inputStream);//ת��Ϊ�����ַ�
			bufferedReader = new BufferedReader(inputStreamReader);//�ַ����뻺����
			String info = null;
			while ((info = bufferedReader.readLine()) != null) {
				System.out.println("���Ƿ����������յ��ͻ�����Ϣ��"+info);
			}
			socket.shutdownInput();
			
			//��������Ӧ
			outputStream = socket.getOutputStream();//�ֽ������
			printWriter = new PrintWriter(outputStream);
			printWriter.write("��ӭ����");
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
