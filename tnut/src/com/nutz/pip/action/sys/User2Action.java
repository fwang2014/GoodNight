package com.nutz.pip.action.sys;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
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
import com.nutz.pip.common.MyUtil;
import com.nutz.pip.common.SeqNum;
import com.nutz.pip.common.page.Pagination;
import com.nutz.pip.dao.sys.User2Dao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.SmUser;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.misc.Phonebook;
import com.nutz.pip.model.sm.sys.TSysUser;
import com.nutz.pip.model.sys.User2;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class User2Action {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(User2Action.class);

	private final String tab = "User2";
	private final String menuCode = "201";

	@SuppressWarnings("unused")
	@Inject
	private User2Dao user2Dao;

	@At("/User2/list")
	@Ok("jsp:/jsp/sys/user/list")
	@Fail("jsp:/error")
	public void list(@Param("::User.") User2 pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.user2Dao.search(User.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.user2Dao.getPage(User2.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}
	
	@At("/User2/list2")
	@Ok("jsp:/jsp/sys/user/list2")
	@Fail("jsp:/error")
	public void list2(@Param("::TSysUser.") TSysUser pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_SEARCH;
		String orderby = "user_id";
		Pagination page = this.user2Dao.getPage(TSysUser.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}
	
	@At("/User2/list3")
	@Ok("jsp:/jsp/sys/user/list3")
	@Fail("jsp:/error")
	public void list3(@Param("::SmUser.") SmUser pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_SEARCH;
		String orderby = "id";
		Pagination page = this.user2Dao.getPage(SmUser.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/User2/add")
	@Ok("jsp:/jsp/sys/user/add")
	@Fail("jsp:/error")
	public void add(@Param("::User.") User2 pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new User2();
		}
		request.setAttribute("User", pojo);
		Object obj = request.getSession()
				.getAttribute(Constants.KEY_LOGIN_USER);
		if (obj instanceof TSysUser) {
			TSysUser user = (TSysUser) obj;
			pojo.setCreate_by(user.getUser_name());
			pojo.setUpdate_by(user.getUser_name());
		} else {
			System.out.println(obj.getClass());
		}
		pojo.setCreate_date(new Date(System.currentTimeMillis()));
		pojo.setType("0");
		pojo.setStatus(0);
		pojo.setPassword(Constants.PASSWORD_DEFAULT_VALUE);
	}

	@At("/User2/save")
	@Ok("redirect:/User2/list?")
	@Fail("jsp:/error")
	public void save(@Param("::User.") User2 pojo, HttpServletRequest request)
			throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.user2Dao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.user2Dao.update(pojo);
			}
		}
	}

	@At("/User2/update")
	@Ok("redirect:/User2/list?")
	@Fail("jsp:/error")
	public void update(@Param("::User.") User2 pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/User2/del")
	@Ok("redirect:/User2/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.user2Dao.delById(id, DicType.class);
		}
	}

	@At("/User2/dels")
	@Ok("redirect:/User2/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.user2Dao.deleteByIds(User2.class, ids);
	}

	@At("/User2/view")
	@Ok("jsp:/jsp/sys/user/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			User2 pojo = this.user2Dao.find(id, User2.class);
			request.setAttribute("User", pojo);
		}
	}

	@At("/User2/edit")
	@Ok("jsp:/jsp/sys/user/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			User2 pojo = this.user2Dao.find(id, User2.class);
			request.setAttribute("User", pojo);
		}
	}

	@At("/User2/check")
	@Ok("redirect:/User2/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				User2 pojo = this.user2Dao.find(id, User2.class);
				pojo.setStatus(1);
				this.user2Dao.update(pojo);
			}
		}
	}
	
	/**
	 * 手机号码检查是否重复
	 * @param ids
	 * @param request
	 * @throws Exception
	 */
	@At("/User/checkAccountName")
	@Ok("json")
	@Fail("jsp:/error")
	public Object checkPhone(@Param("accountName") String accountName, HttpServletRequest request)
			throws Exception {
		//System.out.println("---------->@At(\"/User/checkAccountName\")");
		request.setAttribute("menuActive", menuCode);
		Object result = null;
		if (!MyUtil.isEmpty(accountName)) {
			String name2 = "account_name";
			String op = Constants.OP_EQUAL;
			String value = accountName;
			User2 pojo = user2Dao.findByCondition(User2.class, Cnd.where(name2, op, value));
			result = pojo;	

		}
		return result;
	}
}