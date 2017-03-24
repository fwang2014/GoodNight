package com.nutz.pip.action.sys;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
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
import com.nutz.pip.dao.sys.UserRoleDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.sm.sys.TSysUser;
import com.nutz.pip.model.sys.UserRole;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class UserRoleAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs.getLog(UserRoleAction.class);

	private final String tab = "UserRole";
	private final String menuCode = "204";

	@SuppressWarnings("unused")
	@Inject
	private UserRoleDao userRoleDao;

	@At("/UserRole/list")
	@Ok("jsp:/jsp/sys/userrole/list")
	@Fail("jsp:/error")
	public void list(@Param("::UserRole.") UserRole pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.userRoleDao.search(UserRole.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.userRoleDao.getPage(UserRole.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/UserRole/add")
	@Ok("jsp:/jsp/sys/userrole/add")
	@Fail("jsp:/error")
	public void add(@Param("::UserRole.") UserRole pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new UserRole();
		}
		request.setAttribute("UserRole", pojo);
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
	}

	@At("/UserRole/save")
	@Ok("redirect:/UserRole/list?")
	@Fail("jsp:/error")
	public void save(@Param("::UserRole.") UserRole pojo,
			HttpServletRequest request) throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.userRoleDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.userRoleDao.update(pojo);
			}
		}
	}

	@At("/UserRole/update")
	@Ok("redirect:/UserRole/list?")
	@Fail("jsp:/error")
	public void update(@Param("::UserRole.") UserRole pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/UserRole/del")
	@Ok("redirect:/UserRole/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.userRoleDao.delById(id, DicType.class);
		}
	}

	@At("/UserRole/dels")
	@Ok("redirect:/UserRole/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.userRoleDao.deleteByIds(UserRole.class, ids);
	}

	@At("/UserRole/view")
	@Ok("jsp:/jsp/sys/userrole/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			UserRole pojo = this.userRoleDao.find(id, UserRole.class);
			request.setAttribute("UserRole", pojo);
		}
	}

	@At("/UserRole/edit")
	@Ok("jsp:/jsp/sys/userrole/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			UserRole pojo = this.userRoleDao.find(id, UserRole.class);
			request.setAttribute("UserRole", pojo);
		}
	}

	@At("/UserRole/check")
	@Ok("redirect:/UserRole/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				UserRole pojo = this.userRoleDao.find(id, UserRole.class);
				pojo.setStatus(1);
				this.userRoleDao.update(pojo);
			}
		}
	}
}