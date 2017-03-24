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
import com.nutz.pip.dao.sys.LogInfoDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.sm.sys.TSysUser;
import com.nutz.pip.model.sys.LogInfo;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class LogInfoAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(LogInfoAction.class);

	private final String tab = "LogInfo";
	private final String menuCode = "208";

	@SuppressWarnings("unused")
	@Inject
	private LogInfoDao logInfoDao;

	@At("/LogInfo/list")
	@Ok("jsp:/jsp/sys/loginfo/list")
	@Fail("jsp:/error")
	public void list(@Param("::LogInfo.") LogInfo pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.logInfoDao.search(LogInfo.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.logInfoDao.getPage(LogInfo.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/LogInfo/add")
	@Ok("jsp:/jsp/sys/loginfo/add")
	@Fail("jsp:/error")
	public void add(@Param("::LogInfo.") LogInfo pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new LogInfo();
		}
		request.setAttribute("LogInfo", pojo);
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

	@At("/LogInfo/save")
	@Ok("redirect:/LogInfo/list?")
	@Fail("jsp:/error")
	public void save(@Param("::LogInfo.") LogInfo pojo,
			HttpServletRequest request) throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.logInfoDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.logInfoDao.update(pojo);
			}
		}
	}

	@At("/LogInfo/update")
	@Ok("redirect:/LogInfo/list?")
	@Fail("jsp:/error")
	public void update(@Param("::LogInfo.") LogInfo pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/LogInfo/del")
	@Ok("redirect:/LogInfo/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.logInfoDao.delById(id, DicType.class);
		}
	}

	@At("/LogInfo/dels")
	@Ok("redirect:/LogInfo/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.logInfoDao.deleteByIds(LogInfo.class, ids);
	}

	@At("/LogInfo/view")
	@Ok("jsp:/jsp/sys/loginfo/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			LogInfo pojo = this.logInfoDao.find(id, LogInfo.class);
			request.setAttribute("LogInfo", pojo);
		}
	}

	@At("/LogInfo/edit")
	@Ok("jsp:/jsp/sys/loginfo/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			LogInfo pojo = this.logInfoDao.find(id, LogInfo.class);
			request.setAttribute("LogInfo", pojo);
		}
	}

	@At("/LogInfo/check")
	@Ok("redirect:/LogInfo/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				LogInfo pojo = this.logInfoDao.find(id, LogInfo.class);
				pojo.setStatus(1);
				this.logInfoDao.update(pojo);
			}
		}
	}
}