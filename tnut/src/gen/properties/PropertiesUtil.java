package gen.properties;

import gen.test.FileUtil;
import gen.test.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import com.nutz.pip.common.MyUtil;

public class PropertiesUtil {
	
	/**
	 * 
	 * @param list
	 * @param table
	 * @param filePath
	 */
	public void genTablePropInfo(List<String[]> list ,String table,String fileName,String folder) {
		//List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA);

		PrintStream ps = Test.getOut();
		StringBuffer buf = new StringBuffer();
		
		table = Test.getClassNameByTable(table);
		
		//ps.println();
		//ps.println("----------------------------this is data "+table+" table properties start------------------------------");
		buf.append("\n");
		buf.append("----------------------------this is data "+table+" table properties start------------------------------");
		
		buf.append("#TABLE ["+table+"] LABEL LIST");
		for(String[] str:list){
			String name = str[0].toUpperCase();
			String comment = str[2];
			//ps.println("label."+table+"."+name+"="+comment);
			buf.append("label."+table+"."+name+"="+comment);
			
			if("ID".equals(name.toUpperCase())){
				buf.append("label."+table+".TABLE_CN="+str[11]);
			}
			buf.append("\n");
		}
		//ps.println("----------------------------this is data "+table+" table properties end------------------------------");
		//ps.println();
		buf.append("----------------------------this is data "+table+" table properties end------------------------------");
		buf.append("\n");
		try {
			FileUtil.createAllFile(buf.toString(), fileName,folder, false, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @deprecated
	 * @param list
	 * @param table
	 */
	public void outTablePropInfo(List<String[]> list ,String table) {
		//List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA);

		PrintStream ps = Test.getOut();
		
		table = Test.getClassNameByTable(table);
		
		ps.println();
		ps.println("----------------------------this is data "+table+" table properties start------------------------------");
		
		ps.println("#TABLE ["+table+"] LABEL LIST");
		
		for(String[] str:list){
			String name = str[0].toUpperCase();
			String comment = str[2];
			ps.println("label."+table+"."+name+"="+comment);
			
			if("ID".equals(name.toUpperCase())){
				ps.println("label."+table+".TABLE_CN="+str[11]);
				//ps.println("");
			}
			
		}
		ps.println("----------------------------this is data "+table+" table properties end------------------------------");
		ps.println();
	}

	/**
	 * @deprecated
	 * @param table
	 */
	private void outTablePropInfo(String table) {
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,false);

		PrintStream ps = Test.getOut();
		
		ps.println();
		ps.println("----------------------------this is data "+table+" table properties start------------------------------");
		
		for(String[] str:list){
			String name = str[0];
			String comment = str[2];
			ps.println(table+"."+name+"="+comment);
		}
		ps.println("----------------------------this is data "+table+" table properties end------------------------------");
		ps.println();
	}
	
	public static void main(String args[]){
		String table = "tb_cost_type";
		String fileName = "test.properties";
		String folder = "D:/tem/gen/";
		String today = MyUtil.getToday();
		String project = "tnut";
		//String fileName = Test.getClassNameByTable(table);
		//filePath = filePath + ""+project+"/"+today+"/"+fileName+"/label.properties";
		
		PropertiesUtil util = new PropertiesUtil();
		//util.outTablePropInfo(table);
		
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,false);
		util.genTablePropInfo(list, table, fileName,folder);
	}

}
