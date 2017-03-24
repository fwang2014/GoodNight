package com.nutz.pip.dao;

import java.util.List;

import javax.sql.DataSource;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.nutz.pip.model.cost.DicValue;

@IocBean
public class MyTagDao  {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(MyTagDao.class);
	
	protected static Dao dao = getDao();
	
	public static Dao getDao(){
		if(dao == null){
			//NutDao nd = new NutDao();
			//Dao dao = new NutDao(dataSource);
			dao = new NutDao(getDataSource());
			//dao.create(arg0, arg1)
		}
		return dao;
	}
	
	public List<DicValue> getDictValueByCode(String code){
		List list = null;
		String str = " status='1' and type_id in (select id from tb_dic_type t1 where t1.value_type='"+code+"' and t1.status='1')";
		list = dao.query(DicValue.class, Cnd.wrap(str));		
		return list;
	}
	
	public static DataSource getDataSource(){
		SimpleDataSource ds = new SimpleDataSource();//ds.setDriverClassName("org.postgresql.Driver"); //默认加载了大部分数据库的驱动!!
		//ds.setjdbcUrl("jdbc:postgresql://localhost:5432/mydatabase");
		ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/sm?useUnicode=true&characterEncoding=utf-8");
		ds.setUsername("sm");
		ds.setPassword("sm");
		//...
		//ds.close();  // 这个DataSource不是一个连接池,所以关不关都行
		return ds;
	}
	
	public static DataSource getDataSource2(){
		SimpleDataSource ds = new SimpleDataSource();//ds.setDriverClassName("org.postgresql.Driver"); //默认加载了大部分数据库的驱动!!
		JsonLoader jl = new JsonLoader();
		//jl.
		return ds;
	}

}