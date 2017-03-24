package com.nutz.pip.action.sys;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
import com.nutz.pip.dao.sys.RoleDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.sm.sys.TSysUser;
import com.nutz.pip.model.sys.Role;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class RoleAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(RoleAction.class);

	private final String tab = "Role";
	private final String menuCode = "202";

	@SuppressWarnings("unused")
	@Inject
	private RoleDao roleDao;

	@At("/Role/list")
	@Ok("jsp:/jsp/sys/role/list")
	@Fail("jsp:/error")
	public void list(@Param("::Role.") Role pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.roleDao.search(Role.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.roleDao.getPage(Role.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/Role/add")
	@Ok("jsp:/jsp/sys/role/add")
	@Fail("jsp:/error")
	public void add(@Param("::Role.") Role pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new Role();
		}
		request.setAttribute("Role", pojo);
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

	@At("/Role/save")
	@Ok("redirect:/Role/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Role.") Role pojo, HttpServletRequest request)
			throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.roleDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.roleDao.update(pojo);
			}
		}
	}

	@At("/Role/update")
	@Ok("redirect:/Role/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Role.") Role pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/Role/del")
	@Ok("redirect:/Role/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.roleDao.delById(id, DicType.class);
		}
	}

	@At("/Role/dels")
	@Ok("redirect:/Role/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.roleDao.deleteByIds(Role.class, ids);
	}

	@At("/Role/view")
	@Ok("jsp:/jsp/sys/role/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Role pojo = this.roleDao.find(id, Role.class);
			request.setAttribute("Role", pojo);
		}
	}

	@At("/Role/edit")
	@Ok("jsp:/jsp/sys/role/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Role pojo = this.roleDao.find(id, Role.class);
			request.setAttribute("Role", pojo);
		}
	}

	@At("/Role/check")
	@Ok("redirect:/Role/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Role pojo = this.roleDao.find(id, Role.class);
				pojo.setStatus(1);
				this.roleDao.update(pojo);
			}
		}
	}
}