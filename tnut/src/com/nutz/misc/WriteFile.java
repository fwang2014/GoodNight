/**
 * 
 */
package com.nutz.misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Administrator
 * 
 */
public class WriteFile {

	/**
	 * 
	 */
	public WriteFile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 生成文件
	 * 
	 * @param content
	 *            文件内容
	 * @param prePath
	 *            文件路径
	 * @param isAppend
	 *            是否为新增内容，否则将覆盖原文件内容
	 * @param isShow
	 *            是否后台输出显示
	 * @throws IOException
	 */
	public static void createFile(String content, String filePath,
			boolean isAppend, boolean isShow) throws IOException {
		//构造文件
		File f = new File(filePath);
		//文件是否存在
		boolean bool = f.exists();
		if (!bool) {
			f.createNewFile();
		}
		//读取文件内容
		StringBuffer buf = new StringBuffer();
		BufferedReader input = new BufferedReader(new FileReader(f));
		while(true){
			String s = input.readLine();
			if(s != null){
				buf.append(s).append("\n");
			}else{
				break;
			}
		}
		//关闭读取文件流
		input.close();
		
		//是否需要显示原文件内容
		if(isShow){
			System.out.println(buf.toString());
		}
		
		//是否文件为新增内容
		if(isAppend){
			buf.append(content);
		}else{
			buf.setLength(0);
			buf.append(content);
		}
		
		//将新文件文件写入文件中
		BufferedWriter output = new BufferedWriter(new FileWriter(f));
		output.write(buf.toString());
		output.close();
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String s = new String();
		String s1 = new String();

		File f = new File("D:/tem/temFiles/123.txt");
		if (f.exists()) {
			System.out.print("文件存在");
		} else {
			f.createNewFile();
		}

		System.out.print("文件不存在");
		// f.createNewFile();// 不存在则创建 }
		BufferedReader input = new BufferedReader(new FileReader(f));
		while ((s = input.readLine()) != null) {
			s1 += s + "\n";
		}
		System.out.println(s1);
		input.close();
		s1 += "\n 添加的内容!";
		BufferedWriter output = new BufferedWriter(new FileWriter(f));
		output.write(s1);
		output.close();

	}

}
