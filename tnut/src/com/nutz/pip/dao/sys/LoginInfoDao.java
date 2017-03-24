package com.nutz.pip.dao.sys;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;

import com.nutz.pip.dao.BasicDao;

@SuppressWarnings("unused")
@IocBean
@InjectName
public class LoginInfoDao extends BasicDao {
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(LoginInfoDao.class);

}