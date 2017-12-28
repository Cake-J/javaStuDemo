package com.jkg.io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * �����demo
 * @ClassName:  EncodeDemo   
 * @Description:TODO(������һ�仰��������������)   
 * @author: jiaokg 
 * @date:   2017��12��25�� ����9:48:32   
 *     
 * @Copyright: 2017 www.jgk.com Inc. All rights reserved.
 */
public class EncodeDemo {
	public static void main(String[] args) throws IOException {
		String s = "ѧϰadc";
		byte[] bytes = s.getBytes();
		for (byte b : bytes) {
			//System.out.print(b+" "); //-47 -89 -49 -80 97 100 99 
			//���ֽ�ת��Ϊint����16���Ƶķ�ʽ��ʾ(Ĭ�ϱ��뷽ʽGBK)
			/*  
		     * 0xff(ʮ������)����Ϊint���ͣ������������Ϊ��0000 0000 0000 0000 0000 0000 1111 1111  
		     * & 0xff ��˼�ǲ���32λ���в�λ��ȡ��8λ  
		     * bλ8λ
		     *	b = -47 
		     * �����ƣ�0010 1111 
		     * ���룺1101 0000 
		     * ���룺1101 0001
		     * b & 0xff ����ʱ��b�Ĳ�����0xff�������� 
		     * 1101 0001 & 0000 0000 0000 0000 0000 0000 1111 1111 = 0000 0000 0000 0000 0000 0000 1101 0001 ʮ���ƣ�209
		      */  
			System.out.print(Integer.toHexString(b & 0xff)+" ");
			/**
			 * d1 a7 cf b0 61 64 63  
			 * 	ѧ	      ϰ      a  b  c
			 * gbk��������ռ�������ֽڣ�Ӣ��ռ��һ���ֽ�
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
			 * e5 ad a6  e4 b9 a0  61 64 63 ��utf-8 ����ռ��3���ֽڣ�Ӣ��ռ��1���ֽڣ�
			 *    ѧ    		ϰ		a  b  c  
			 */
		}
		/**
		 * ʲô���뷽ʽ���룬��Ҫʹ��ʲô�����ȡ����������
		 */
		System.out.println();
		byte[] bytes4 = s.getBytes("utf-16be");
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b) + " ");
			/**
			 * 5b 66 4e 60 0 61 0 64 0 63 ��utf-16be��������Ӣ�Ķ�ռ�����ֽڣ�
			 * 	ѧ           ϰ       a    b    c
			 */
		}
	}
}
