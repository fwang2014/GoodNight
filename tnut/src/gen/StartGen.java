/**
 * 
 */
package gen;

import gen.java.JavaUtil;
import gen.jsp.JspUtil;
import gen.pojo.PojoUtil;
import gen.properties.PropertiesUtil;
import gen.test.Test;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class StartGen {

	/**
	 * 
	 */
	public StartGen() {
		// TODO Auto-generated constructor stub
	}
	
	public void outCode(){
		String table = "tb_cost_type";//"t_sm_user";
		//table = "tb_dic_type";//数据字典类型表
		table = "tb_dic_value";//数据字典值表
		table = "tb_cost_fill";//成本填报表
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,true);
		
		if(list == null || list.size()==0){
			System.out.println("list data is null");
			return;
		}
		
		//生成资源文件
		PropertiesUtil prop = new PropertiesUtil();
		prop.outTablePropInfo(list, table);
		
		//生成数据库表映射对象代买
		PojoUtil pojo = new PojoUtil();
		pojo.outPojo(list, table);		
		
		//生成JAVA的Action代码
		JavaUtil java = new JavaUtil();
		java.outDao(list, table);
		java.outAction(list, table,"data");
		
		
		//生成JSP动态代码
		JspUtil jsp = new JspUtil();
		jsp.outDataList(list, table);
		jsp.outDataAdd(list, table);
		jsp.outDataView(list, table);
	}
	
	public void outCode2(String table,String module){
		//String table = "tb_cost_type";//"t_sm_user";
		//table = "tb_dic_type";//数据字典类型表
		//table = "tb_dic_value";//数据字典值表
		//table = "tb_cost_fill";//成本填报表
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,true);
		
		if(list == null || list.size()==0){
			System.out.println("list data is null");
			return;
		}
		
		//生成资源文件
		PropertiesUtil prop = new PropertiesUtil();
		prop.outTablePropInfo(list, table);
		
		//生成数据库表映射对象代买
		PojoUtil pojo = new PojoUtil();
		pojo.outPojo(list, table);		
		
		//生成JAVA的Action代码
		JavaUtil java = new JavaUtil();
		java.outDao(list, table);
		java.outAction(list, table, module);
		
		
		//生成JSP动态代码
		JspUtil jsp = new JspUtil();
		jsp.outDataList(list, table);
		jsp.outDataAdd(list, table);
		jsp.outDataView(list, table);
	}
	
	/**
	 * @deprecated
	 * @param table
	 * @param folder
	 */
	public void genFiles(String table,String folder){
		//String table = "tb_cost_type";//"t_sm_user";
		//table = "tb_dic_type";//数据字典类型表
		//table = "tb_dic_value";//数据字典值表
		//table = "tb_cost_fill";//成本填报表
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,true);
		
		if(list == null || list.size()==0){
			System.out.println("list data is null");
			return;
		}
		
		String fileName = "label.properties";
		
		//生成资源文件
		PropertiesUtil prop = new PropertiesUtil();
		//prop.outTablePropInfo(list, table);
		prop.genTablePropInfo(list, table, fileName,folder);
		
		//生成数据库表映射对象代买
		PojoUtil pojo = new PojoUtil();
		pojo.outPojo(list, table);		
		
		//生成JAVA的Action代码
		JavaUtil java = new JavaUtil();
		java.outDao(list, table);
		java.outAction(list, table,"data");
		
		
		//生成JSP动态代码
		JspUtil jsp = new JspUtil();
		jsp.outDataList(list, table);
		jsp.outDataAdd(list, table);
		jsp.outDataView(list, table);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String table ="tb_consult";
		table = "tb_register";
		table = "tb_class2";
		table ="tb_course";
		table ="tb_consult";
		table = "tb_file_upload";
		table = "tb_register";
		table = "tb_class_member";
		//String folder = "D:/tem/test/20130923";
		
		table = "tb_user";
		table = "tb_role";
		table = "tb_menu";
		table = "tb_log";
		table = "tb_user_role";
		table = "tb_role_menu";
		table = "tb_register";
		
		table = "tb_customer";
		table = "tb_dothing";
		
		table = "tb_log_info";
		table = "tb_login_info";
		
		table = "tb_words";
		table = "tb_password_info";
		
		table = "tb_sys_bean";
		table = "tb_log";
		
		table = "tb_phonebook";
		
		table = "tb_dataimport_info";
		table = "tb_dataimport_part";
		table = "tb_dataimport_col";
		table = "tb_dataimport_content";
		table = "tb_dataimport_pic";
		
		table = "t_sm_cost";
		table = "t_sm_costtype";
		table = "t_sm_statterm";
		table = "tb_cost_fill";
		
		StartGen gen = new StartGen();
		//gen.genFiles(table,folder);
		//gen.outCode();
		String module = "cost";
		gen.outCode2(table,module);
	}

}
