package com.nutz.pip.dao.user;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.nutz.pip.common.DaoUtil;
import com.nutz.pip.dao.BasicDao;
import com.nutz.pip.model.cost.CostType;

@IocBean
public class CostDao extends BasicDao {
	private static final Log log = Logs.getLog(UserDao.class);

	public CostDao() {
		init();
	}

	private void init() {

		if (dao == null) {
			dao = DaoUtil.getDao();
		}

		if (dao != null) {
			// dao.create(CostType.class, true);
			if (!dao.exists(CostType.class)) {
				log.info("UserDao.init");
				dao.create(CostType.class, true);
			}
		} else {
			log.info("dao is null here:CostDao.init");
		}

	}

}
