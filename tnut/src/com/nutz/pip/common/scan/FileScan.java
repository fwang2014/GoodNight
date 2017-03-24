package com.nutz.pip.common.scan;

import java.io.File;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.nutz.lang.Lang;

import com.nutz.pip.Test;

public class FileScan {
	
	//private class cls = FileScan.class;

	/**
	 * 获得当前类型实际路径
	 * @return
	 */
	private static String getResourcePath() {
		String className = FileScan.class.getName();
		String classNamePath = className.replace(".", "/") + ".class";
		URL is = Test.class.getClassLoader().getResource(classNamePath);
		
		Package pkg = Test.class.getPackage();
		System.out.println("Package:"+pkg.getName());
		
		System.out.println("----------------------URL:"+is);
		String path = is.getFile();
		
		System.out.println("------------------------------File path1:"+path);
		path = StringUtils.replace(path, "%20", " ");
		
		System.out.println("-----------------------------------------File path2:"+path);
		path = StringUtils.removeStart(path, "/");
		
		System.out.println("------------------------------------------File path3:"+path);
		return path;
	}
	
	public static String getFolderPath(String filePath,String fileName,String separator){
		StringBuffer buf = new StringBuffer();
		if(!Lang.isEmpty(filePath) && !Lang.isEmpty(fileName)){
			//String sign = "/";
			//int dot = filePath.indexOf(sign);
			String cutStr = separator+fileName;
			if(filePath.endsWith(cutStr)){
				buf.append(filePath.substring(0, filePath.length()-cutStr.length()));
			}else{
				buf.append(filePath.substring(0, filePath.length()-fileName.length()-1));
			}
		}
		return buf.toString();
	}
	
	public static String getFolderPath(String filePath,String fileName){
		StringBuffer buf = new StringBuffer();
		if(!Lang.isEmpty(filePath) && !Lang.isEmpty(fileName)){
			if(filePath.endsWith(fileName)){
				buf.append(filePath.substring(0, filePath.length()-fileName.length()-1));
			}else{
				buf.append(filePath);
			}
		}
		return buf.toString();
	}
	
	public void scanFiles(){
		String filePath = getResourcePath();
		System.out.println(filePath);
		File file = new File(filePath);//"D:/dev/java/workspace/tnut/build/classes/com/nutz/pip");
		
		
		String fileName = file.getName();
		String separator = file.separator;
		String folder = getFolderPath(filePath, fileName);
		folder = file.getParent();
		
		System.out.println("filePath:"+filePath);
		System.out.println("fileName:"+fileName);
		System.out.println("separator:"+separator);
		System.out.println("folder:"+folder);
		
		file = new File(folder);//("D:/dev/java/workspace/tnut/build/classes/com/nutz/pip");
		String files[] = file.list();
		File fs[] = file.listFiles();
		/*for(String f:files){
			System.out.println(f);
		}*/
		for(File f:fs){
			System.out.println(f.getName());
			System.out.println(f.getParent());
			System.out.println(f.getPath());
		}
	}
	 
	public static void main(String args[]){
		FileScan scan = new FileScan();
		scan.scanFiles();
	}
}
