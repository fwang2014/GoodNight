package com.nutz.pip.action.ittrain;

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
import com.nutz.pip.dao.ittrain.RegisterDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.ittrain.Register;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class RegisterAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(RegisterAction.class);

	private final String tab = "Register";
	private final String menuCode = "302";

	@SuppressWarnings("unused")
	@Inject
	private RegisterDao registerDao;

	@At("/Register/list")
	@Ok("jsp:/jsp/ittrain/register/list")
	@Fail("jsp:/error")
	public void list(@Param("::Register.") Register pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", "302");
		// List list = this.registerDao.search(Register.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.registerDao.getPage(Register.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/Register/add")
	@Ok("jsp:/jsp/ittrain/register/add")
	@Fail("jsp:/error")
	public void add(@Param("::Register.") Register pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", "302");
		if (pojo == null) {
			pojo = new Register();
		}
		request.setAttribute("Register", pojo);
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

	@At("/Register/save")
	@Ok("redirect:/Register/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Register.") Register pojo,
			HttpServletRequest request) throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.registerDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.registerDao.update(pojo);
			}
		}
	}

	@At("/Register/update")
	@Ok("redirect:/Register/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Register.") Register pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", "302");
	}

	@At("/Register/del")
	@Ok("redirect:/Register/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "302");
		if (!MyUtil.isEmpty(id)) {
			this.registerDao.delById(id, DicType.class);
		}
	}

	@At("/Register/dels")
	@Ok("redirect:/Register/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "302");
		String ids = MyUtil.getIdsFromArray(strs);
		this.registerDao.deleteByIds(Register.class, ids);
	}

	@At("/Register/view")
	@Ok("jsp:/jsp/ittrain/register/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "302");
		if (!MyUtil.isEmpty(id)) {
			Register pojo = this.registerDao.find(id, Register.class);
			request.setAttribute("Register", pojo);
		}
	}

	@At("/Register/edit")
	@Ok("jsp:/jsp/ittrain/register/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "302");
		if (!MyUtil.isEmpty(id)) {
			Register pojo = this.registerDao.find(id, Register.class);
			request.setAttribute("Register", pojo);
		}
	}

	@At("/Register/check")
	@Ok("redirect:/Register/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", "302");
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Register pojo = this.registerDao.find(id, Register.class);
				pojo.setStatus(1);
				this.registerDao.update(pojo);
			}
		}
	}
}