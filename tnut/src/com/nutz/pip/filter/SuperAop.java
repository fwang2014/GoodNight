package com.nutz.pip.filter;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

@IocBean
@InjectName
public class SuperAop implements MethodInterceptor {
	private static final Log log = Logs.getLog(SuperAop.class);

	public void filter(InterceptorChain chain) throws Throwable {
		System.out.println("SuperAop.filter");
		chain.doChain();		
		log.info("SuperAop.filter");
	}

}
