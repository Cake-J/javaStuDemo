package com.jkg.io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 编码的demo
 * @ClassName:  EncodeDemo   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiaokg 
 * @date:   2017年12月25日 下午9:48:32   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class EncodeDemo {
	public static void main(String[] args) throws IOException {
		String s = "学习adc";
		byte[] bytes = s.getBytes();
		for (byte b : bytes) {
			//System.out.print(b+" "); //-47 -89 -49 -80 97 100 99 
			//把字节转换为int，以16进制的方式显示(默认编码方式GBK)
			/*  
		     * 0xff(十六进制)，其为int类型，所以其二进制为：0000 0000 0000 0000 0000 0000 1111 1111  
		     * & 0xff 意思是不足32位进行补位，取低8位  
		     * b位8位
		     *	b = -47 
		     * 二进制：0010 1111 
		     * 反码：1101 0000 
		     * 补码：1101 0001
		     * b & 0xff 负数时：b的补码与0xff进行运算 
		     * 1101 0001 & 0000 0000 0000 0000 0000 0000 1111 1111 = 0000 0000 0000 0000 0000 0000 1101 0001 十进制：209
		      */  
			System.out.print(Integer.toHexString(b & 0xff)+" ");
			/**
			 * d1 a7 cf b0 61 64 63  
			 * 	学	      习      a  b  c
			 * gbk编码中午占用两个字节，英文占用一个字节
			 */
		}
		System.out.println();
		byte[] bytes2 = s.getBytes("gbk");
		for (byte b : bytes2) {
			//System.out.print((b & 0xff)+" "); //209 167 207 176 97 100 99
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte[] bytes3 = s.getBytes("utf-8");
		for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
			/**
			 * e5 ad a6  e4 b9 a0  61 64 63 （utf-8 中文占用3个字节，英文占用1个字节）
			 *    学    		习		a  b  c  
			 */
		}
		/**
		 * 什么编码方式编码，就要使用什么编码读取，否则乱码
		 */
		System.out.println();
		byte[] bytes4 = s.getBytes("utf-16be");
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b) + " ");
			/**
			 * 5b 66 4e 60 0 61 0 64 0 63 （utf-16be编码中文英文都占两个字节）
			 * 	学           习       a    b    c
			 */
		}
	}
}
