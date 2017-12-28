package com.jkg.io;

import java.io.File;
import java.io.IOException;



/**
 * 文件的demo
 * @ClassName:  FileDemo   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiaokg 
 * @date:   2017年12月26日 上午12:18:13   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\test\\testDemo");
		System.out.println(file.exists());
		
		System.out.println(file.isDirectory());		//是否是文件夹（目录）
		System.out.println(file.isFile());			//是否是文件
		
		if (file.exists()) {
			file.delete();
			System.out.println("文件存在，删除文件");
		}else {
			//file.mkdirs();		//可以创建多层文件夹
			file.mkdir();		//只可以创建一层文件夹
			System.out.println("文件不存在，创建文件");
		}
		
		File file2 = new File("D:/test/testDemo.txt");
		if (file2.exists()) {
			file.delete();
		}else {
			file2.createNewFile(); //创建文件
		}
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());
		System.out.println(file.getPath());
		System.out.println(file2.getName());
	}

}
