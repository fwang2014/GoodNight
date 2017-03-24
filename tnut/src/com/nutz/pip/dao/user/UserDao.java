package com.nutz.pip.dao.user;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.nutz.pip.dao.BasicDao;

@IocBean
public class UserDao extends BasicDao {
	private static final Log log = Logs.getLog(UserDao.class);
	
	public UserDao(){
		this.init();
	}
	
	private void init(){
		//Dao dao = new NutDao(DBFactory.getInstance().getDataSource());

	}

}
