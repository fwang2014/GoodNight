package com.nutz.pip;

import java.io.File;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.AnnotationIocLoader;
import org.nutz.lang.Lang;

//import com.mysql.jdbc.StringUtils;

public class Test {
	
	public void Test2(){
		/*File file = new File("c:/work/project/com"); // 得到文件的包的路径
		List list = file.list(); // 得到包下的文件 最后在用
		for (int i = 0; i < list.size(); i++) {
			File file = (File) list.get(i);
			Class cc = Class.forName("com.controller." + file.getName);
		}*/
	}
	
	public Test(){
		//this.getClass().
	}
	
	public static void main(String[] args) {
		
		String classPath = getResourcePath();
		System.out.println(classPath);
		File file = new File(classPath);//"D:/dev/java/workspace/tnut/build/classes/com/nutz/pip");
		System.out.println("fileName:"+file.getName());
		
		file = new File("D:/dev/java/workspace/tnut/build/classes/com/nutz/pip");
		String files[] = file.list();
		File fs[] = file.listFiles();
		/*for(String f:files){
			System.out.println(f);
		}*/
		for(File f:fs){
			System.out.println(f.getName());
		}
	}
	
	public static String getFolderPath(String filePath,String fileName){
		StringBuffer buf = new StringBuffer();
		if(!Lang.isEmpty(filePath)){
			String sign = "/";
			int dot = filePath.indexOf(sign);
			
		}
		return buf.toString();
	}
	
	/**
	 * 获得当前类型实际路径
	 * @return
	 */
	private static String getResourcePath() {
		String className = Test.class.getName();
		String classNamePath = className.replace(".", "/") + ".class";
		URL is = Test.class.getClassLoader().getResource(classNamePath);
		String path = is.getFile();
		path = StringUtils.replace(path, "%20", " ");

		return StringUtils.removeStart(path, "/");
	}
	
	
	
	public static void main2(String args[]){
		System.out.println("start...");
		Ioc ioc = new NutIoc(new AnnotationIocLoader("Table"));       
		System.out.println(ioc.getNames());
		for(String name:ioc.getNames()){
			System.out.println(name);
		}
		//UserAction action = ioc.get(UserAction.class);      
		//action.login("wendal", "qazwsxedc");
		
		System.out.println("end!");
	}

}
