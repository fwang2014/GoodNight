package gen.pojo;

import gen.test.Test;

import java.io.PrintStream;
import java.util.List;

import com.nutz.utils.DateConvertUtil;

public class PojoUtil {
	
	public void outPojo(List<String[]> list,String table){
		PrintStream ps = Test.getOut();
						
		String table2 = Test.getClassNameByTable(table);
		
		ps.println();
		ps.println("----------------------------this is data "+table+" table java Pojo start------------------------------");
		ps.println();
		
		ps.println("@SuppressWarnings(\"serial\")");
		ps.println("@Table(\""+table+"\")");
		ps.println("public class "+table2+" implements Serializable{");
		ps.println();
		
		for(String[] strs:list){
			
			String name = strs[0].toLowerCase();//字段名称
			String type = strs[1];//数据类型 如：varchar
			String comment = strs[2];//注释
			String nullable = strs[3];//是否可为空
			String columnType = strs[4];//字段类型 如 :varchar(20)
			
			String column_default = strs[5];//默认值
			String character_maximum_length = strs[6];//字符最大长度
			String numeric_precision = strs[7];//数字精度
			String numeric_scale = strs[8];//小数位数
			String ordinal_position = strs[9];//字段排序位置
			String column_key = strs[10];//主键
			
			

			ps.println();
			ps.println("\t@Column");
			ps.println("\t@Comment(\""+comment+"\")");
			
			//ps.println(type.toUpperCase());
			if("VARCHAR".equals(type.toUpperCase())){
				ps.println("\t@ColDefine(type=ColType.VARCHAR,width="+character_maximum_length+")");
			}
			
			if("DATE".equals(type.toUpperCase())){
				ps.println("\t@ColDefine(type=ColType.DATE)");
			}
			
			if(numeric_precision != null && Integer.parseInt(numeric_precision) > 0){
				ps.println("\t@ColDefine(type=ColType.FLOAT,width="+numeric_precision+",precision="+numeric_scale+")");				
			}
			
			type = Test.getTypeByStr(type);
			String cap = Test.getCapitalWord(name);
			
			if("PRI".equals(column_key)){
				//ps.println("\t@Name");
				if("String".equals(type)){
					ps.println("\t@Name");
				}else{
					ps.println("\t@Id");
				}
				
			}
			
			if(column_default != null && column_default.length()>0){
				ps.println("\t@Default(\""+column_default+"\")");
			}
			

									
			ps.println("\tprivate "+type+" "+name+";");
			ps.println();
			
			/*if("create_date".equals(name)){
				//ps.println("\tpublic "+type+" get"+cap+"() {");
				ps.println("\tpublic String get"+cap+"() {");
				ps.println("\t\treturn DateConvertUtil.convertDate(create_date, \"yyyy-MM-dd\");");
				ps.println("\t\t//return "+name+";");
				ps.println("\t}");
			}else if("update_time".equals(name)){
				//ps.println("\tpublic "+type+" get"+cap+"() {");
				ps.println("\tpublic String get"+cap+"() {");
				ps.println("\t\treturn DateConvertUtil.convertDate(update_time, \"yyyy-MM-dd HH:mm:ss\");");
				ps.println("\t\t//return "+name+";");
				ps.println("\t}");
			}else{
				ps.println("\tpublic "+type+" get"+cap+"() {");
				ps.println("\t\treturn "+name+";");
				ps.println("\t}");
			}*/
			
			if(name.endsWith("date") || name.endsWith("DATE")){
				//ps.println("\tpublic "+type+" get"+cap+"() {");
				ps.println("\tpublic String get"+cap+"() {");
				ps.println("\t\treturn DateConvertUtil.convertDate("+name+", \"yyyy-MM-dd\");");
				ps.println("\t\t//return "+name+";");
				ps.println("\t}");
			}else if(name.endsWith("time") || name.endsWith("TIME")){
				//ps.println("\tpublic "+type+" get"+cap+"() {");
				ps.println("\tpublic String get"+cap+"() {");
				ps.println("\t\treturn DateConvertUtil.convertDate("+name+", \"yyyy-MM-dd HH:mm:ss\");");
				ps.println("\t\t//return "+name+";");
				ps.println("\t}");
			}else{
				ps.println("\tpublic "+type+" get"+cap+"() {");
				ps.println("\t\treturn "+name+";");
				ps.println("\t}");
			}
			
			
			ps.println();
			ps.println("\tpublic void set"+cap+"("+type+" "+name+") {");
			ps.println("\t\tthis."+name+" = "+name+";");
			ps.println("\t}");
			
		}

		
		ps.println("}");
		
		ps.println();
		ps.println("----------------------------this is data "+table+" table java Pojo end------------------------------");
		ps.println();		
		
	}
	
	public static void main(String args[]){
		String table = "t_sm_cost";//"tb_cost_type";
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,true);
		PojoUtil pojo = new PojoUtil();
		pojo.outPojo(list, table);
	}

}
