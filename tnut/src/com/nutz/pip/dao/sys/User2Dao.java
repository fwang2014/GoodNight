package com.nutz.pip.dao.sys;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.nutz.pip.dao.BasicDao;

@SuppressWarnings("unused")
@IocBean
@InjectName
public class User2Dao extends BasicDao {
	private static final Log log = Logs.getLog(User2Dao.class);

}