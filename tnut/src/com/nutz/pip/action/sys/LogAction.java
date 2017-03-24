package com.nutz.pip.action.sys;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
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
import com.nutz.pip.common.page.SearchForm;
import com.nutz.pip.dao.sys.LogDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.sm.sys.TSysUser;
import com.nutz.pip.model.sys.Log;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class LogAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(LogAction.class);

	private final String tab = "Log";
	private final String menuCode = "206";

	@SuppressWarnings("unused")
	@Inject
	private LogDao logDao;

	/**
	 * 查询 编码，名称，类型，状态，开始时间和结束时间
	 * 
	 * @param pojo
	 * @param cp
	 * @param request
	 * @throws Exception
	 */
	@At("/Log/search")
	@Ok("jsp:/jsp/sys/log/searchlist")
	@Fail("jsp:/error")
	public void search(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.search");
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		form.setTypeParam("1");
		request.setAttribute("search", form);

		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_SEARCH;

		List<Log> list = null;
		int count = 0;
		if (!Lang.isEmpty(form.getCode()) && form.getCode().length() > 0) {
			list = logDao.searchByPage(Log.class, Cnd.where("code", "like", "%"
					+ form.getCode() + "%"), currentPage, pageSize);
			count = logDao.searchCount(Log.class, Cnd.where("code", "like", "%"
					+ form.getCode() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		} else if (!Lang.isEmpty(form.getName()) && form.getName().length() > 0) {
			list = logDao.searchByPage(Log.class, Cnd.where("name", "like", "%"
					+ form.getName() + "%"), currentPage, pageSize);
			count = logDao.searchCount(Log.class, Cnd.where("name", "like", "%"
					+ form.getName() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		} else if (!Lang.isEmpty(form.getType()) && form.getType().length() > 0) {
			list = logDao.searchByPage(Log.class, Cnd.where("type", "like", "%"
					+ form.getType() + "%"), currentPage, pageSize);
			count = logDao.searchCount(Log.class, Cnd.where("type", "like", "%"
					+ form.getType() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		} else if (!Lang.isEmpty(form.getStatus())
				&& form.getStatus().length() > 0) {
			list = logDao.searchByPage(Log.class, Cnd.where("status", "like",
					"%" + form.getStatus() + "%"), currentPage, pageSize);
			count = logDao.searchCount(Log.class, Cnd.where("status", "like",
					"%" + form.getStatus() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		} else
		// 如果开始或结束时间有不为空的
		if (!Lang.isEmpty(form.getStartDate())
				|| !Lang.isEmpty(form.getEndDate())) {
			// 如果开始和结束时间都不为空
			if (!Lang.isEmpty(form.getStartDate())
					&& form.getStartDate().length() > 0
					&& !Lang.isEmpty(form.getEndDate())
					&& form.getEndDate().length() > 0) {
				list = logDao.searchByPage(Log.class, Cnd.where("update_time",
						">=", form.getStartDate()).and("update_time", "<=",
						form.getEndDate()), currentPage, pageSize);
				count = logDao.searchCount(Log.class, Cnd.where("update_time",
						">=", form.getStartDate()).and("update_time", "<=",
						form.getEndDate()));
				Pagination page = new Pagination(currentPage, pageSize, count,
						list);
				request.setAttribute("page", page);
			} else {
				// 如果开始时间不为空
				if (!Lang.isEmpty(form.getStartDate())) {
					list = logDao.searchByPage(Log.class, Cnd.where(
							"update_time", ">=", form.getStartDate()),
							currentPage, pageSize);
					count = logDao.searchCount(Log.class, Cnd.where(
							"update_time", ">=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				} else {// 结束时间不为空
					list = logDao.searchByPage(Log.class, Cnd.where(
							"update_time", "<=", form.getStartDate()),
							currentPage, pageSize);
					count = logDao.searchCount(Log.class, Cnd.where(
							"update_time", "<=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				}
			}
		}
	}

	@At("/Log/exportAll")
	@Ok("jsp:/jsp/sys/log/exportall")
	@Fail("jsp:/error")
	public void exportExcelAll(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.exportExcelAll");
		this.search(form, cp, request);
		Pagination page = (Pagination) request.getAttribute("page");
		// System.out.println(page.getList().size());
	}

	@At("/Log/list")
	@Ok("jsp:/jsp/sys/log/list")
	@Fail("jsp:/error")
	public void list(@Param("::Log.") Log pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		SearchForm form = new SearchForm();
		form.setTypeParam("1");
		form.setDictCode("input");
		request.setAttribute("search", form);
		// List list = this.logDao.search(Log.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.logDao.getPage(Log.class, currentPage, pageSize,
				orderby);
		request.setAttribute("page", page);
	}

	@At("/Log/add")
	@Ok("jsp:/jsp/sys/log/add")
	@Fail("jsp:/error")
	public void add(@Param("::Log.") Log pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new Log();
		}
		request.setAttribute("Log", pojo);
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

	@At("/Log/save")
	@Ok("redirect:/Log/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Log.") Log pojo, HttpServletRequest request)
			throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.logDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.logDao.update(pojo);
			}
		}
	}

	@At("/Log/update")
	@Ok("redirect:/Log/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Log.") Log pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/Log/del")
	@Ok("redirect:/Log/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.logDao.delById(id, DicType.class);
		}
	}

	@At("/Log/dels")
	@Ok("redirect:/Log/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.logDao.deleteByIds(Log.class, ids);
	}

	@At("/Log/view")
	@Ok("jsp:/jsp/sys/log/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Log pojo = this.logDao.find(id, Log.class);
			request.setAttribute("Log", pojo);
		}
	}

	@At("/Log/edit")
	@Ok("jsp:/jsp/sys/log/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Log pojo = this.logDao.find(id, Log.class);
			request.setAttribute("Log", pojo);
		}
	}

	@At("/Log/check")
	@Ok("redirect:/Log/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Log pojo = this.logDao.find(id, Log.class);
				pojo.setStatus(1);
				this.logDao.update(pojo);
			}
		}
	}
}