package com.nutz.pip.dao.sys;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Logs;

import com.nutz.pip.dao.BasicDao;
import com.nutz.pip.model.sys.Log;

@SuppressWarnings("unused")
@IocBean
@InjectName
public class UserRoleDao extends BasicDao {
private static final org.nutz.log.Log log = Logs.getLog(UserRoleDao.class);

}
