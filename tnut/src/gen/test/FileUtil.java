package gen.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	
	public static void createAllFile(String content, String fileName,String fileFolder,
			boolean isAppend, boolean isShow) throws IOException{
		
		File f = new File(fileFolder);
		if(!f.exists()){
			f.mkdirs();
		}
		StringBuffer buf = new StringBuffer();
		buf.append(fileFolder).append("/").append(fileName);
		f = new File(buf.toString());
		//f.createNewFile();
		createFile(content, buf.toString(), isAppend, isShow);
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
		// 构造文件
		File f = new File(filePath);
		
		/*System.out.println("filePath:"+filePath);
		
		if(filePath.lastIndexOf(".")>-1){
			f.createNewFile();
			
		}else{
			f.mkdirs();
		}*/
		
		
		
		// 文件是否存在
		boolean bool = f.exists();
		if (!bool) {
			f.createNewFile();
		}
		// 读取文件内容
		StringBuffer buf = new StringBuffer();
		BufferedReader input = new BufferedReader(new FileReader(f));
		while (true) {
			String s = input.readLine();
			if (s != null) {
				buf.append(s).append("\n");
			} else {
				break;
			}
		}
		// 关闭读取文件流
		input.close();

		// 是否需要显示原文件内容
		if (isShow) {
			System.out.println(buf.toString());
		}

		// 是否文件为新增内容
		if (isAppend) {
			buf.append(content);
		} else {
			buf.setLength(0);
			buf.append(content);
		}

		// 将新文件文件写入文件中
		BufferedWriter output = new BufferedWriter(new FileWriter(f));
		output.write(buf.toString());
		output.close();
	}
	
	public static void main(String args[]){
		String content = "hellow my file create!\nmy heart has gone! 12345";
		String filePath = "D:/tem/temFiles/test.txt";
		String fileName = "label.properties";
		String fileFolder = "d://tem/test/20130923";
		boolean isAppend = true;
		boolean isShow = true;
		try {
			//FileUtil.createFile(content, filePath, isAppend, isShow);
			FileUtil.createAllFile(content, fileName, fileFolder, isAppend, isShow);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
