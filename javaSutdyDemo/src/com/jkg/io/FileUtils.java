package com.jkg.io;

import java.io.File;
import java.io.IOException;

/**
 * file的工具类，实现过滤，遍历等
 * @ClassName:  FileUtils   
 * @Description:  
 * @author: jiaokg 
 * @date:   2017年12月26日 下午9:29:29   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class FileUtils {
	public static void listDirectory(File dir) throws IOException{
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录"+dir+"不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir+"不是目录");
		}
		String[] list = dir.list();	//子目录
		for (String file : list) {
			System.out.println(file+"+++");
		}
		
		File[] listFiles = dir.listFiles();//子目录＋父目录
		for (File file : listFiles) {
			System.out.println(file+"---");
			if (file.isDirectory()) {
				listDirectory(file);//递归子目录
			}
		}
		
		
	}
}
