package com.nutz.pip.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutz.pip.Constants;
import com.nutz.pip.common.Encrypt;
import com.nutz.pip.common.MyUtil;
import com.nutz.pip.dao.user.UserDao;
import com.nutz.pip.model.misc.SysBean;
import com.nutz.pip.model.sm.sys.TSysUser;
import com.nutz.pip.model.sys.LoginInfo;

@IocBean
@InjectName
/*
 * * 系统用户控制器
 */
public class UserAction {
	private static final org.nutz.log.Log log = org.nutz.log.Logs.getLog(UserAction.class);

	@Inject
	private UserDao userDao;

	@At("/user/list")
	@Ok("jsp:/jsp/userlist")
	@Fail("jsp:/error")
	/*
	 * * 用户列表
	 */
	public void list(HttpServletRequest request) {
		System.out.println("UserAction.list");
		List<TSysUser> list = userDao.search(TSysUser.class, "user_id");
		System.out.println(list == null ? null : list.size());
		String result = Json.toJson(list);
		System.out.println(result);
	}
	
	@At("/tologin")
	@Ok("jsp:/default")
	@Fail("jsp:/error")
	/*
	 * * 用户列表
	 */
	public void toLogin(HttpServletRequest request) {
		System.out.println("UserAction.toLogin");
	}

	@At("/user/login")
	@Ok("redirect:/welcome?")
	// @Ok(">>:${USER == null ? '/jsp/register' : '/jsp/index'}")
	@Fail("redirect:/error?")
	/*
	 * * 用户登陆
	 */
	public void checkLogin(@Param("::form.") TSysUser user,
			HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("UserAction.checkLogin");

		try {
			//System.out.println("----------------------------------11111111111111111:");
			
			//LogAction log2 = new LogAction();
			/*com.nutz.pip.model.sys.Log pojo = new com.nutz.pip.model.sys.Log();
			pojo.setCode(MyUtil.getCreateTime());
			pojo.setCreate_by("-1");
			pojo.setCreate_date(MyUtil.getCreateTime2());
			pojo.setName("UserAction.checkLogin");
			pojo.setRemark("UserAction.checkLogin start..."+" uri:"+request.getRequestURI()+" login user:"+user.getUser_name());
			pojo.setReq_ip(request.getRemoteAddr());
			pojo.setStatus(0);
			pojo.setType("0");
			pojo.setUpdate_by("-1");
			pojo.setUpdate_time(MyUtil.getCreateTime2());
			//log2.save(pojo, request);
			this.userDao.save(pojo);*/
			
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setCode(MyUtil.getCreateTime());
			loginInfo.setCreate_by("-1");
			loginInfo.setCreate_date(MyUtil.getCreateTime2());
			loginInfo.setName("login start "+user.getUser_name());
			loginInfo.setRemark("login start ");
			loginInfo.setReq_id(request.getRemoteAddr());
			loginInfo.setReq_addr(request.getRemoteAddr());
			loginInfo.setReq_port(request.getRemoteHost());
			loginInfo.setReq_uri(request.getRequestURI());
			loginInfo.setReq_user(user.getUser_name());
			loginInfo.setStatus(1);
			loginInfo.setType("0");
			loginInfo.setUpdate_by("-1");
			loginInfo.setUpdate_time(MyUtil.getCreateTime2());
			this.userDao.save(loginInfo);

			Map msg = (Map) request.getAttribute("msg");
			
			if("Y".equals(Constants.FLAG_SYS_RES_LOAD)){
				Set set = msg.keySet();
				Iterator it = set.iterator();
				while(it.hasNext()){
					String key = (String)it.next();
					String value = (String)msg.get(key);
					System.out.println("key="+key+";value="+value);
					
					SysBean bean = new SysBean();
					bean.setCode(key);
					bean.setName(key);
					bean.setRemark(value);
					bean.setType("msg");
					bean.setStatus(0);
					bean.setCreate_by("-1");
					bean.setCreate_date(MyUtil.getCreateTime2());
					this.userDao.save(bean);
					
				}
			}
			
			

			// 验证验证码是否一致
			if (MyUtil.isEmpty(user.getRand())) {
				String key = "error.rand.is.empty";
				String value = msg.get(key) == null ? null : msg.get(key)
						.toString();
				session.setAttribute("error", value);
				// Mvcs.setLocalizationKey(key);
				// Map msg = Mvcs.getLocaleMessage(key);
				// /session.setAttribute("error", "rand code is empty!");
				
				/*pojo = new com.nutz.pip.model.sys.Log();
				pojo.setCode(MyUtil.getCreateTime());
				pojo.setCreate_by("-1");
				pojo.setCreate_date(MyUtil.getCreateTime2());
				pojo.setName("UserAction.checkLogin rand code empty");
				pojo.setRemark("UserAction.checkLogin "+value+" login user:"+user.getUser_name());
				pojo.setReq_ip(request.getRemoteAddr());
				pojo.setStatus(0);
				pojo.setType("0");
				pojo.setUpdate_by("-1");
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				//log2.save(pojo, request);
				this.userDao.save(pojo);*/
				
				loginInfo = new LoginInfo();
				loginInfo.setCode(MyUtil.getCreateTime());
				loginInfo.setCreate_by("-1");
				loginInfo.setCreate_date(MyUtil.getCreateTime2());
				loginInfo.setName("login rand check ");
				loginInfo.setRemark("login rand check:"+value);
				loginInfo.setReq_id(request.getRemoteAddr());
				loginInfo.setReq_addr(request.getRemoteAddr());
				loginInfo.setReq_port(request.getRemoteHost());
				loginInfo.setReq_uri(request.getRequestURI());
				loginInfo.setReq_user(user.getUser_name());
				loginInfo.setStatus(1);
				loginInfo.setType("0");
				loginInfo.setUpdate_by("-1");
				loginInfo.setUpdate_time(MyUtil.getCreateTime2());
				this.userDao.save(loginInfo);
				
				throw new Exception(value);
			}
			//System.out.println("----------------------------------22222222222222222:");
			
			String rand2 = (String) request.getSession().getAttribute("rand");
			if (!user.getRand().equals(rand2)) {

				/*
				 * session.setAttribute("error",
				 * "input rand code is not matched with them!"); //String value
				 * = Mvcs.getl.getLocaleMessage("error.rand.is.empty"); throw
				 * new Exception("rand is not matched with them!");
				 */

				String key = "error.rand.is.not.match";
				/*
				 * Mvcs.setLocalizationKey(key); Map msg =
				 * Mvcs.getLocaleMessage(key); //session.setAttribute("error",
				 * "rand code is empty!"); throw new
				 * Exception(msg.get(key)==null?null:msg.get(key).toString());
				 */

				// String key = "error.rand.is.empty";
				String value = msg.get(key) == null ? null : msg.get(key)
						.toString();
				session.setAttribute("error", value);
				
				/*pojo = new com.nutz.pip.model.sys.Log();
				pojo.setCode(MyUtil.getCreateTime());
				pojo.setCreate_by("-1");
				pojo.setCreate_date(MyUtil.getCreateTime2());
				pojo.setName("UserAction.checkLogin rand check");
				pojo.setRemark("UserAction.checkLogin "+value+" login user:"+user.getUser_name());
				pojo.setReq_ip(request.getRemoteAddr());
				pojo.setStatus(0);
				pojo.setType("0");
				pojo.setUpdate_by("-1");
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				//log2.save(pojo, request);
				this.userDao.save(pojo);*/
				
				loginInfo = new LoginInfo();
				loginInfo.setCode(MyUtil.getCreateTime());
				loginInfo.setCreate_by("-1");
				loginInfo.setCreate_date(MyUtil.getCreateTime2());
				loginInfo.setName("login rand check ");
				loginInfo.setRemark("login rand check:"+value);
				loginInfo.setReq_id(request.getRemoteAddr());
				loginInfo.setReq_addr(request.getRemoteAddr());
				loginInfo.setReq_port(request.getRemoteHost());
				loginInfo.setReq_uri(request.getRequestURI());
				loginInfo.setReq_user(user.getUser_name());
				loginInfo.setStatus(1);
				loginInfo.setType("0");
				loginInfo.setUpdate_by("-1");
				loginInfo.setUpdate_time(MyUtil.getCreateTime2());
				this.userDao.save(loginInfo);
				
				// Mvcs.setLocalizationKey(key);
				// Map msg = Mvcs.getLocaleMessage(key);
				// /session.setAttribute("error", "rand code is empty!");
				throw new Exception(value);
			}

			// 验证用户和密码是否有效
			String ps = Encrypt.encode(user.getPassword(),
					Constants.VALUE_ENCRYTP_METHOD);

			List<TSysUser> list = userDao.search(TSysUser.class, Cnd.where(
					"account_name", "=", user.getUser_name()).and("password",
					"=", ps));

			int size = list == null ? 0 : list.size();
			if (size > 0) {
				log.info("login success!");
				session.setAttribute(Constants.KEY_LOGIN_USER, list.get(0));
				
				//log2 = new LogAction();
				/*pojo = new com.nutz.pip.model.sys.Log();
				pojo.setCode(MyUtil.getCreateTime());
				pojo.setCreate_by(user.getUser_name());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				pojo.setName("UserAction.checkLogin success");
				pojo.setRemark("UserAction.checkLogin success");
				pojo.setReq_ip(request.getRemoteAddr());
				pojo.setStatus(0);
				pojo.setType("0");
				pojo.setUpdate_by("-1");
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				//log2.save(pojo, request);
				this.userDao.save(pojo);*/
				
				loginInfo = new LoginInfo();
				loginInfo.setCode(MyUtil.getCreateTime());
				loginInfo.setCreate_by(user.getAccount_name());
				loginInfo.setCreate_date(MyUtil.getCreateTime2());
				loginInfo.setName("login success ");
				loginInfo.setRemark("login success!");
				loginInfo.setReq_id(request.getRemoteAddr());
				loginInfo.setReq_addr(request.getRemoteAddr());
				loginInfo.setReq_port(request.getRemoteHost());
				loginInfo.setReq_uri(request.getRequestURI());
				loginInfo.setReq_user(request.getRemoteUser());
				loginInfo.setStatus(1);
				loginInfo.setType("0");
				loginInfo.setUpdate_by(user.getUser_name());
				loginInfo.setUpdate_time(MyUtil.getCreateTime2());
				this.userDao.save(loginInfo);
			} else {
				log.info("login failed!");
				String key = "login.error.username.or.password";
				String value = msg.get(key) == null ? null : msg.get(key)
						.toString();
				session.setAttribute("error", value);
				
				//log2 = new LogAction();
				/*pojo = new com.nutz.pip.model.sys.Log();
				pojo.setCode(MyUtil.getCreateTime());
				pojo.setCreate_by("-1");
				pojo.setCreate_date(MyUtil.getCreateTime2());
				pojo.setName("UserAction.checkLogin fail");
				pojo.setRemark("UserAction.checkLogin "+value+" login user:"+user.getUser_name());
				pojo.setReq_ip(request.getRemoteAddr());
				pojo.setStatus(0);
				pojo.setType("0");
				pojo.setUpdate_by("-1");
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				//log2.save(pojo, request);
				this.userDao.save(pojo);*/
				
				loginInfo = new LoginInfo();
				loginInfo.setCode(MyUtil.getCreateTime());
				loginInfo.setCreate_by("-1");
				loginInfo.setCreate_date(MyUtil.getCreateTime2());
				loginInfo.setName("login failed");
				loginInfo.setRemark("login failed"+value);
				loginInfo.setReq_id(request.getRemoteAddr());
				loginInfo.setReq_addr(request.getRemoteAddr());
				loginInfo.setReq_port(request.getRemoteHost());
				loginInfo.setReq_uri(request.getRequestURI());
				loginInfo.setReq_user(user.getUser_name());
				loginInfo.setStatus(1);
				loginInfo.setType("0");
				loginInfo.setUpdate_by("-1");
				loginInfo.setUpdate_time(MyUtil.getCreateTime2());
				this.userDao.save(loginInfo);
				
				throw new Exception(value);
			}

		} catch (Exception ex) {
			//System.out.println("----------------------------------error:"+ex.getLocalizedMessage());			
			request.setAttribute("error", ex);
			throw new Exception(ex);
		}
	}

	/* 登出 */
	@At("/welcome")
	@Ok("jsp:/jsp/index")
	public void welcome(HttpSession session,HttpServletRequest request) {
		request.setAttribute("code", MyUtil.getCreateTime());
		
		// 防止重复提交，设置数据提交前验证字符
		request.getSession().setAttribute(Constants.KEY_REPEAT_SUBMIT,
				System.currentTimeMillis()+"");
		// session.invalidate(); //销毁会话,啥都米有了
	}

	/* 登出 */
	@At("/error")
	@Ok("jsp:/error")
	public void toError(HttpSession session) {
		// session.invalidate(); //销毁会话,啥都米有了
	}

	/* 登出 */
	@At("/logout")
	@Ok("jsp:/default")
	public void logout(HttpSession session) {
		session.invalidate(); // 销毁会话,啥都米有了
	}

	@At("/user/add")
	@Ok("jsp:/jsp/user/add")
	@Fail("jsp:/error")
	/*
	 * * 用户新增
	 */
	public void toAdd(@Param("::.") TSysUser user, HttpServletRequest request) {
		request.setAttribute(Constants.KEY_REQUEST_POJO, user);
	}

	@At("/user/save")
	@Ok("jsp:/jsp/user/list")
	@Fail("jsp:/error")
	/*
	 * * 用户保存
	 */
	public void doSave(@Param("::.") TSysUser user, HttpServletRequest request) {
		userDao.save(user);
	}

	@At("/user/del")
	@Ok("jsp:/jsp/user/list")
	@Fail("jsp:/error")
	/*
	 * * 用户删除
	 */
	public void doDel(@Param("::.") TSysUser user, HttpServletRequest request) {
		boolean bool = userDao.delById(user.getUser_id(), TSysUser.class);
		log.info("doDel:" + bool);
	}

	@At("/user/dels")
	@Ok("jsp:/jsp/user/list")
	@Fail("jsp:/error")
	/*
	 * * 用户批量删除
	 */
	public void doDels(@Param("ids") String[] ids, HttpServletRequest request) {

	}

	@At("/user/view")
	@Ok("jsp:/jsp/user/view")
	@Fail("jsp:/error")
	/*
	 * * 用户查看
	 */
	public void toView(@Param("::.") TSysUser user, HttpServletRequest request) {

	}

	@At("/user/update")
	@Ok("jsp:/jsp/user/view")
	@Fail("jsp:/error")
	/*
	 * * 用户更新
	 */
	public void doUpdate(@Param("::.") TSysUser user, HttpServletRequest request) {

	}

	@At("/user/search")
	@Ok("jsp:/jsp/user/list")
	@Fail("jsp:/error")
	/*
	 * * 用户条件查询分页数据集合
	 */
	public void doSearch(@Param("::.") TSysUser user, HttpServletRequest request) {
		Class c = TSysUser.class;
		Condition condition = Cnd.where("1", "=", "1");
		int currentPage = Constants.INT_PAGE_CURRENTPAGE_DEFAULT;
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		this.userDao.searchByPage(c, condition, currentPage, pageSize);
	}
	
	
	public static void main(String args[]){
		String ps = Encrypt.encode("111",Constants.VALUE_ENCRYTP_METHOD);
		System.out.println(ps);
	}

}
