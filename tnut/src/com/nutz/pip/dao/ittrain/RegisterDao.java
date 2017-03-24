package com.nutz.pip.dao.ittrain;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.nutz.pip.dao.BasicDao;

@SuppressWarnings("unused")
@IocBean
@InjectName
public class RegisterDao extends BasicDao {
	private static final Log log = Logs.getLog(RegisterDao.class);

}
