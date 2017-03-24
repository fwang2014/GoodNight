package com.nutz.pip.action;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;

@IocBean
@InjectName
public class SysAction {

	@At("/sys")
	@Ok("redirect:/SmUser/list?")
	@Fail("jsp:/error")
	/*
	 * * 系统管理之用户管理
	 */
	public void toSmUserList(HttpServletRequest request) {

	}

	@At("/datadic")
	@Ok("redirect:/DicType/list?")
	@Fail("jsp:/error")
	/*
	 * * 数据字典
	 */
	public void toDicTypeList(HttpServletRequest request) {

	}

}
