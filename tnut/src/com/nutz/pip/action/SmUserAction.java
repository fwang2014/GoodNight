package com.nutz.pip.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutz.pip.Constants;

import com.nutz.pip.common.Encrypt;
import com.nutz.pip.common.MyUtil;
import com.nutz.pip.common.SeqNum;
import com.nutz.pip.dao.SmUserDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.SmUser;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class SmUserAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(SmUserAction.class);
	
	private final String tab = "SmUser";
	private final String menuCode = "207";

	@SuppressWarnings("unused")
	@Inject
	private SmUserDao smUserDao;

	@SuppressWarnings("unchecked")
	@At("/SmUser/list")
	@Ok("jsp:/jsp/SmUser/list")
	@Fail("jsp:/error")
	public void list(@Param("::SmUser.") SmUser pojo, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		List list = this.smUserDao.search(SmUser.class, "id");
		request.setAttribute("list", list);
		
	}

	@At("/SmUser/add")
	@Ok("jsp:/jsp/SmUser/add")
	@Fail("jsp:/error")
	public void add(@Param("::SmUser.") SmUser pojo, HttpServletRequest request,HttpSession session)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		if(pojo == null){
			pojo = new SmUser();
			pojo.setCreatedate(new Date(System.currentTimeMillis()));
			Object obj = session.getAttribute(Constants.KEY_LOGIN_USER);
			if(obj instanceof TSysUser){
				TSysUser user = 	(TSysUser)		obj;	
				pojo.setCreateuser(user.getUser_name());
			}else{
				System.out.println(obj.getClass());
			}
			
			//Constants.KEY_LOGIN_USER
			//pojo.setId(SeqNum.getPrimaryKeyForString());
			pojo.setType("0");
			pojo.setStatus("0");
			request.setAttribute("SmUser", pojo);
		}
	}

	@At("/SmUser/save")
	@Ok("redirect:/SmUser/list?")
	@Fail("jsp:/error")
	public void save(@Param("::SmUser.") SmUser pojo, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		if(pojo != null){
			pojo.setId(SeqNum.getPrimaryKeyForString());
			
			/**
			 * 加密密码
			 */
			String ps = Encrypt.encode(pojo.getPassword(),
					Constants.VALUE_ENCRYTP_METHOD);
			pojo.setPassword(ps);
			
			pojo.setLastupdatetime(MyUtil.getCreateTime());
			this.smUserDao.save(pojo);
		}
	}

	@At("/SmUser/update")
	@Ok("redirect:/SmUser/list?")
	@Fail("jsp:/error")
	public void update(@Param("::SmUser.") SmUser pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		if(pojo != null && pojo.getId()!=null){
			pojo.setLastupdatetime(MyUtil.getCreateTime());
			this.smUserDao.save(pojo);
		}

	}

	@At("/SmUser/del")
	@Ok("redirect:/SmUser/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		this.smUserDao.delById(id, SmUser.class);
	}

	@At("/SmUser/dels")
	@Ok("redirect:/SmUser/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		String ids = MyUtil.getIdsFromArray(strs);
		
		this.smUserDao.deleteByIds(SmUser.class, ids);
		
	}

	@At("/SmUser/view")
	@Ok("jsp:/jsp/SmUser/view")
	@Fail("jsp:/error")
	public void view(@Param("id") String id, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		if(id != null && id.length()>0){
			SmUser pojo = this.smUserDao.find(id, SmUser.class);
			request.setAttribute("SmUser", pojo);
		}
	}
	
	

}