package com.jkg.io;

import java.io.File;
import java.io.IOException;



/**
 * �ļ���demo
 * @ClassName:  FileDemo   
 * @Description:TODO(������һ�仰��������������)   
 * @author: jiaokg 
 * @date:   2017��12��26�� ����12:18:13   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\test\\testDemo");
		System.out.println(file.exists());
		
		System.out.println(file.isDirectory());		//�Ƿ����ļ��У�Ŀ¼��
		System.out.println(file.isFile());			//�Ƿ����ļ�
		
		if (file.exists()) {
			file.delete();
			System.out.println("�ļ����ڣ�ɾ���ļ�");
		}else {
			//file.mkdirs();		//���Դ�������ļ���
			file.mkdir();		//ֻ���Դ���һ���ļ���
			System.out.println("�ļ������ڣ������ļ�");
		}
		
		File file2 = new File("D:/test/testDemo.txt");
		if (file2.exists()) {
			file.delete();
		}else {
			file2.createNewFile(); //�����ļ�
		}
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());
		System.out.println(file.getPath());
		System.out.println(file2.getName());
	}

}
