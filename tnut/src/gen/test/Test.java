package gen.test;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;

import com.nutz.pip.common.DaoUtil;

public class Test {
	
	public static final String SCHEMA = "sm";
	
	public static final String[] columnFilters = {"ID","CREATE_BY","CREATE_DATE","UPDATE_BY","UPDATE_TIME","REMARK"};
	
	public static final String[] columnFiltersAdd = {"ID","CREATE_BY","CREATE_DATE","UPDATE_BY","UPDATE_TIME"};
	
	public static final int[] SQL_TYPES = {Types.VARCHAR,Types.DATE,Types.NUMERIC};

	/**
	 * @deprecated
	 * @param table
	 * @return
	 */
	public static List<String[]> getTableColumns(String table) {
		List list = null;

		Dao dao = DaoUtil.getDao();
		Sql sql = Sqls.create("select * from " + table + " t where 1=2");

		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql arg2)
					throws SQLException {

				ResultSetMetaData rsd = rs.getMetaData();				

				// DatabaseMetaData dmd = conn.getMetaData();

				int count = rsd.getColumnCount();

				List<String[]> list = new ArrayList<String[]>();

				for (int i = 1; i <= count; i++) {
					String name = rsd.getColumnName(i);
					String type = rsd.getColumnTypeName(i);
					String catalogName = rsd.getCatalogName(i);
					String columnLabel = rsd.getColumnLabel(i);
					String schemaName = rsd.getSchemaName(i);
					String tableName = rsd.getTableName(i);

					String strs[] = new String[2];
					strs[0] = name;
					strs[1] = type;
					list.add(strs);

					System.out.println("name=" + name + "\ttype=" + type);
					System.out.println("catalogName=" + catalogName
							+ "\tcolumnLabel=" + columnLabel);
					System.out.println("schemaName=" + schemaName
							+ "\ttableName=" + tableName);
				}

				return list;
			}

		});
		dao.execute(sql);
		list = (List) sql.getResult();

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String[]> getTableColumnsAll(String table,String schema,boolean bool) {
		List list = null;
		StringBuffer buf = new StringBuffer();
		/*buf.append("select * from ");
		buf.append(table);
		buf.append(" t where 1=2 ");*/
		buf.append("select t.* from information_schema.columns t where 1=1 and t.table_name='"+table+"' and table_schema='"+schema+"'");

		Dao dao = DaoUtil.getDao();
		Sql sql = Sqls.create(buf.toString());
		
		final boolean b = bool;

		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql arg2)
					throws SQLException {			

				List<String[]> list = new ArrayList<String[]>();
				
				if(b){
					System.out.println();
					System.out.println("-------------show column info enable start-------------------------------");
				}
				
				while (rs.next()) {
					String name = rs.getString("COLUMN_NAME");//字段名称
					String type = rs.getString("DATA_TYPE");//数据类型 如：varchar
					String comment = rs.getString("COLUMN_COMMENT");//注释
					String nullable = rs.getString("IS_NULLABLE");//是否可为空
					String columnType = rs.getString("COLUMN_TYPE");//字段类型 如 :varchar(20)
					
					String column_default = rs.getString("column_default");//默认值
					String character_maximum_length = rs.getString("character_maximum_length");//字符最大长度
					String numeric_precision = rs.getString("numeric_precision");//数字精度
					String numeric_scale = rs.getString("numeric_scale");//小数位数
					String ordinal_position = rs.getString("ordinal_position");//字段排序位置
					String column_key = rs.getString("column_key");//主键 如：PRI				

					String strs[] = new String[12];
					strs[0] = name;
					strs[1] = type;
					strs[2] = comment;
					strs[3] = nullable;
					strs[4] = columnType;
					
					strs[5] = column_default;
					strs[6] = character_maximum_length;
					strs[7] = numeric_precision;
					strs[8] = numeric_scale;
					strs[9] = ordinal_position;
					strs[10] = column_key;
					
					//根据ID字段备注名称获得表名中文显示信息
					if("ID".equals(name.toUpperCase())){
						if(comment.endsWith("ID")){
							strs[11]=comment.substring(0, comment.length()-2);
						}else{
							strs[11]=comment;
						}
					}
					
					list.add(strs);
					
					if(b){
						
						for(String str:strs){
							System.out.print(str+"\t|\t");
						}
						System.out.println();
					}
					
				}
				
				if(b){
					System.out.println("-------------show column info enable end-------------------------------");
					System.out.println();
				}

				return list;
			}

		});
		dao.execute(sql);
		list = (List) sql.getResult();


		return list;
	}

	public static PrintStream getOut() {
		return System.out;
	}

	/**
	 * 获取数据库表字段注释信息
	 * @deprecated
	 * @param table
	 * @return
	 */
	public static List getColumnComment(String table) {
		List list = null;

		Dao dao = DaoUtil.getDao();
		Sql sql = Sqls.create("select * from " + table + " t where id=1");

		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql arg2)
					throws SQLException {

				DatabaseMetaData dbmd = conn.getMetaData();
				ResultSet rs2 = dbmd.getColumns(null, "OPS$AIMSADM",
						"AIRCRAFTS", "CODE");
				
				List list = new ArrayList();
				
				if (rs.next()) {
					//String remark = rs.getObject(12)==null?"null":rs.getObject(12).toString();
					String remark = rs.getObject("Remarks")==null?"null":rs.getObject("Remarks").toString();
					System.out.println("Remarks: " + remark);
					list.add(remark);
				}

				return list;
			}

		});
		dao.execute(sql);
		list = (List) sql.getResult();

		return list;
	}
	
	/**
	 * 根据表名得到类名
	 * 如：t_sm_cost --> TSmCost
	 * @param table
	 * @return
	 */
	public static String getClassNameByTable(String table){
		StringBuffer buf = new StringBuffer();
		if(table == null || table.length()== 0) return "";
		String strs[] = table.split("_");
		if(strs != null && strs.length>0){
			for(String str:strs){
				buf.append(getCapitalWord(str));
			}
		}
		
		String tem = buf.toString();
		if(tem != null && tem.length() > 0 && tem.startsWith("Tb")){
			tem = tem.substring(2);
			buf.setLength(0);
			buf.append(tem);
		}
		
		if(tem != null && tem.length() > 0 && tem.startsWith("T")){
			tem = tem.substring(1);
			buf.setLength(0);
			buf.append(tem);
		}
		
		return buf.toString();
	}
	
	/**
	 * 根据表名得到变量名 首字母小写
	 * 如：t_sm_cost --> smCost
	 * @param table
	 * @return
	 */
	public static String getVariableByString(String str){
		StringBuffer buf = new StringBuffer();
		
		if(str != null && str.length() > 0){
			buf.append(str.substring(0, 1).toLowerCase());
			buf.append(str.substring(1));
		}
		
		return buf.toString();
	}
	
	/**
	 * 将字符串第一个设成大写
	 * @param str
	 * @return
	 */
	public static String getCapitalWord(String str){
		StringBuffer buf = new StringBuffer();
		if(str == null || str.length()== 0) return "";
		buf.append(str.toUpperCase().substring(0,1));
		buf.append(str.toLowerCase().substring(1));
		return buf.toString();
	}
	
	/**
	 * 根据字段类型返回JAVA类型字符
	 * @param type
	 * @return
	 */
	public static String getTypeByStr(String type){
		StringBuffer buf = new StringBuffer();
		//System.out.println(type);
		if("VARCHAR".equals(type.toUpperCase())){
			buf.append("String");
		}else if("DATE".equals(type.toUpperCase()) || "DATETIME".equals(type)){
			buf.append("Date");
		}else if("FLOAT".equals(type.toUpperCase())){
			buf.append("float");
		}else if("INTEGER".equals(type.toUpperCase())){
			buf.append("long");
		}else if("INT".equals(type.toUpperCase())){
			buf.append("long");
		}else if("DATETIME".equals(type.toUpperCase())){
			buf.append("Date");
		}else{		
			buf.append("String");
		}
		//System.out.println(type+"\t"+buf.toString());
		
		return buf.toString();
	}
	

	public static void main(String args[]) {
		String table = "t_sm_cost_list";//"tb_cost_type";
		String schema = "sm";
		//Test.getTableColumns("tb_cost_type");
		//Test.getColumnComment(table);
		//Test.getTableColumnsAll(table, schema);
		
		String tab = Test.getClassNameByTable(table);
		//System.out.println(tab);
		
		System.out.println(Test.getVariableByString("SmUserList"));

	}
}
