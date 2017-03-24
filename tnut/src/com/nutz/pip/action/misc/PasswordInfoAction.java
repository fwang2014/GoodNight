package com.nutz.pip.action.misc;

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
import com.nutz.pip.dao.misc.PasswordInfoDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.misc.PasswordInfo;
import com.nutz.pip.model.sm.sys.TSysUser;
import com.nutz.pip.model.sys.User2;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class PasswordInfoAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(PasswordInfoAction.class);

	private final String tab = "PasswordInfo";
	private final String menuCode = "211";

	@SuppressWarnings("unused")
	@Inject
	private PasswordInfoDao passwordInfoDao;
	
	@At("/PasswordInfo/userlist")
	@Ok("jsp:/jsp/misc/passwordinfo/userlist")
	@Fail("jsp:/error")
	public void userlist(@Param("::PasswordInfo.") PasswordInfo pojo,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.passwordInfoDao.search(PasswordInfo.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.passwordInfoDao.getPage(User2.class,
				currentPage, pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/PasswordInfo/list")
	@Ok("jsp:/jsp/misc/passwordinfo/list")
	@Fail("jsp:/error")
	public void list(@Param("::PasswordInfo.") PasswordInfo pojo,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.passwordInfoDao.search(PasswordInfo.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.passwordInfoDao.getPage(PasswordInfo.class,
				currentPage, pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/PasswordInfo/add")
	@Ok("jsp:/jsp/misc/passwordinfo/add")
	@Fail("jsp:/error")
	public void add(@Param("::PasswordInfo.") PasswordInfo pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// 防止重复提交，设置数据提交前验证字符
		request.getSession().setAttribute(Constants.KEY_REPEAT_SUBMIT,
				System.currentTimeMillis() + "");
		if (pojo == null) {
			pojo = new PasswordInfo();
		}
		request.setAttribute("PasswordInfo", pojo);
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
		pojo.setCode(MyUtil.getCreateTime());
	}

	@At("/PasswordInfo/save")
	@Ok("redirect:/PasswordInfo/list?")
	@Fail("jsp:/error")
	public void save(@Param("::PasswordInfo.") PasswordInfo pojo,
			HttpServletRequest request) throws Exception {

		/**
		 * 先验证重复提交验证码
		 */
		String token = request.getSession().getAttribute(
				Constants.KEY_REPEAT_SUBMIT) == null ? null : (String) request
				.getSession().getAttribute(Constants.KEY_REPEAT_SUBMIT);
		String token2 = request.getParameter(Constants.KEY_REPEAT_SUBMIT);
		if (token != null && token.equals(token2)) {
			if (pojo != null) {
				if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
					pojo.setId(SeqNum.getPrimaryKeyForInt1());
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setCreate_date(MyUtil.getCreateTime2());
					this.passwordInfoDao.save(pojo);
				} else {
					Object obj = request.getSession().getAttribute(
							Constants.KEY_LOGIN_USER);
					if (obj instanceof TSysUser) {
						TSysUser user = (TSysUser) obj;
						pojo.setUpdate_by(user.getUser_name());
					}
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setStatus(Constants.VALUE_EDITED_STATUS);
					this.passwordInfoDao.update(pojo);
				}
			}
		} else {
			String error = "No repeat sumbit!";
			request.setAttribute("error", error);
			throw new Exception(error);
		}
	}

	@At("/PasswordInfo/update")
	@Ok("redirect:/PasswordInfo/list?")
	@Fail("jsp:/error")
	public void update(@Param("::PasswordInfo.") PasswordInfo pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/PasswordInfo/del")
	@Ok("redirect:/PasswordInfo/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.passwordInfoDao.delById(id, DicType.class);
		}
	}

	@At("/PasswordInfo/dels")
	@Ok("redirect:/PasswordInfo/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		// 数据软删除
		for (String str : strs) {
			int id = Integer.parseInt(str);
			PasswordInfo pojo = this.passwordInfoDao.find(id,
					PasswordInfo.class);
			pojo.setStatus(Constants.VALUE_DEFAULT_STATUS);
			this.passwordInfoDao.update(pojo);
		}
	}

	@At("/PasswordInfo/delss")
	@Ok("redirect:/PasswordInfo/list?")
	@Fail("jsp:/error")
	public void delss(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		// 数据彻底删除
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.passwordInfoDao.deleteByIds(PasswordInfo.class, ids);
	}

	@At("/PasswordInfo/view")
	@Ok("jsp:/jsp/misc/passwordinfo/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			PasswordInfo pojo = this.passwordInfoDao.find(id,
					PasswordInfo.class);
			request.setAttribute("PasswordInfo", pojo);
		}
	}

	@At("/PasswordInfo/edit")
	@Ok("jsp:/jsp/misc/passwordinfo/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id,@Param("uid") int uid, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			PasswordInfo pojo = this.passwordInfoDao.find(id,
					PasswordInfo.class);
			request.setAttribute("PasswordInfo", pojo);
		}
		if (!MyUtil.isEmpty(uid)) {
			User2 user = this.passwordInfoDao.find(uid, User2.class);
			PasswordInfo pojo = new PasswordInfo();
			
			pojo.setCode(user.getCode());
			pojo.setUser_id(user.getId());
			pojo.setName(user.getName());
			pojo.setRemark(user.getName());
			pojo.setStatus(Constants.VALUE_EDITED_STATUS);
			
			request.setAttribute("PasswordInfo", pojo);
		}
	}

	@At("/PasswordInfo/check")
	@Ok("redirect:/PasswordInfo/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				PasswordInfo pojo = this.passwordInfoDao.find(id,
						PasswordInfo.class);
				pojo.setStatus(Constants.VALUE_CHECKED_STATUS);
				this.passwordInfoDao.update(pojo);
			}
		}
	}
}
