package com.jkg.io;

import java.io.File;
import java.io.IOException;

/**
 * file�Ĺ����࣬ʵ�ֹ��ˣ�������
 * @ClassName:  FileUtils   
 * @Description:  
 * @author: jiaokg 
 * @date:   2017��12��26�� ����9:29:29   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class FileUtils {
	public static void listDirectory(File dir) throws IOException{
		if (!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼"+dir+"������");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir+"����Ŀ¼");
		}
		String[] list = dir.list();	//��Ŀ¼
		for (String file : list) {
			System.out.println(file+"+++");
		}
		
		File[] listFiles = dir.listFiles();//��Ŀ¼����Ŀ¼
		for (File file : listFiles) {
			System.out.println(file+"---");
			if (file.isDirectory()) {
				listDirectory(file);//�ݹ���Ŀ¼
			}
		}
		
		
	}
}
