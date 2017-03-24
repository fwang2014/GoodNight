package com.nutz.pip.common;

import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc2;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.nutz.pip.Constants;
import com.nutz.pip.action.UserAction;

public class DaoUtil {
	private static final Log log = Logs.getLog(UserAction.class);
	
	public static Dao getDao(){
		Dao dao = null;
		Ioc2 ioc = new NutIoc(new JsonLoader(Constants.PATH_SYS_DATASOURCE_FILE));
		//ioc.addValueProxyMaker(new ScanValueProxyMaker());
		dao = ioc.get(Dao.class, "dao");
		
		if(dao  == null){
			log.equals("Dao can not found from js file!");
		}
		
		return dao;
	}
	

}
