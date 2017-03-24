package com.nutz.pip.action.cost;

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
import com.nutz.pip.dao.cost.SmCostDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.cost.SmCost;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class SmCostAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(SmCostAction.class);

	private final String tab = "SmCost";
	private final String menuCode = "402";

	@SuppressWarnings("unused")
	@Inject
	private SmCostDao smCostDao;

	/**
	 * 查询 编码，名称，类型，状态，开始时间和结束时间
	 * 
	 * @param pojo
	 * @param cp
	 * @param request
	 * @throws Exception
	 */
	@At("/SmCost/search")
	@Ok("jsp:/jsp/cost/smcost/searchlist")
	@Fail("jsp:/error")
	public void search(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.search");
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		request.setAttribute("search", form);

		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_SEARCH;

		List<SmCost> list = null;
		int count = 0;
		if (!Lang.isEmpty(form.getCode()) && form.getCode().length() > 0) {
			list = smCostDao.searchByPage(SmCost.class, Cnd.where("code",
					"like", "%" + form.getCode() + "%"), currentPage, pageSize);
			count = smCostDao.searchCount(SmCost.class, Cnd.where("code",
					"like", "%" + form.getCode() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}else 
		if (!Lang.isEmpty(form.getName()) && form.getName().length() > 0) {
			list = smCostDao.searchByPage(SmCost.class, Cnd.where("name",
					"like", "%" + form.getName() + "%"), currentPage, pageSize);
			count = smCostDao.searchCount(SmCost.class, Cnd.where("name",
					"like", "%" + form.getName() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}else 
		if (!Lang.isEmpty(form.getType()) && form.getType().length() > 0) {
			list = smCostDao.searchByPage(SmCost.class, Cnd.where("type",
					"like", "%" + form.getType() + "%"), currentPage, pageSize);
			count = smCostDao.searchCount(SmCost.class, Cnd.where("type",
					"like", "%" + form.getType() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}else 
		if (!Lang.isEmpty(form.getStatus()) && form.getStatus().length() > 0) {
			list = smCostDao.searchByPage(SmCost.class, Cnd.where("status",
					"like", "%" + form.getStatus() + "%"), currentPage,
					pageSize);
			count = smCostDao.searchCount(SmCost.class, Cnd.where("status",
					"like", "%" + form.getStatus() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}else 
		// 如果开始或结束时间有不为空的
		if (!Lang.isEmpty(form.getStartDate())
				|| !Lang.isEmpty(form.getEndDate())) {
			// 如果开始和结束时间都不为空
			if (!Lang.isEmpty(form.getStartDate())
					&& form.getStartDate().length() > 0
					&& !Lang.isEmpty(form.getEndDate())
					&& form.getEndDate().length() > 0) {
				list = smCostDao.searchByPage(SmCost.class, Cnd.where(
						"update_time", ">=", form.getStartDate()).and(
						"update_time", "<=", form.getEndDate()), currentPage,
						pageSize);
				count = smCostDao.searchCount(SmCost.class, Cnd.where(
						"update_time", ">=", form.getStartDate()).and(
						"update_time", "<=", form.getEndDate()));
				Pagination page = new Pagination(currentPage, pageSize, count,
						list);
				request.setAttribute("page", page);
			} else {
				// 如果开始时间不为空
				if (!Lang.isEmpty(form.getStartDate())) {
					list = smCostDao.searchByPage(SmCost.class, Cnd.where(
							"update_time", ">=", form.getStartDate()),
							currentPage, pageSize);
					count = smCostDao.searchCount(SmCost.class, Cnd.where(
							"update_time", ">=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				} else {// 结束时间不为空
					list = smCostDao.searchByPage(SmCost.class, Cnd.where(
							"update_time", "<=", form.getStartDate()),
							currentPage, pageSize);
					count = smCostDao.searchCount(SmCost.class, Cnd.where(
							"update_time", "<=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				}
			}
		}
	}

	@At("/SmCost/exportAll")
	@Ok("jsp:/jsp/cost/smcost/exportall")
	@Fail("jsp:/error")
	public void exportExcelAll(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.exportExcelAll");
		this.search(form, cp, request);
		Pagination page = (Pagination) request.getAttribute("page");
		// System.out.println(page.getList().size());
	}

	@At("/SmCost/list")
	@Ok("jsp:/jsp/cost/smcost/list")
	@Fail("jsp:/error")
	public void list(@Param("::SmCost.") SmCost pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.smCostDao.search(SmCost.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.smCostDao.getPage(SmCost.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/SmCost/add")
	@Ok("jsp:/jsp/cost/smcost/add")
	@Fail("jsp:/error")
	public void add(@Param("::SmCost.") SmCost pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// 防止重复提交，设置数据提交前验证字符
		request.getSession().setAttribute(Constants.KEY_REPEAT_SUBMIT,
				System.currentTimeMillis() + "");
		if (pojo == null) {
			pojo = new SmCost();
		}
		request.setAttribute("SmCost", pojo);
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

	@At("/SmCost/save")
	@Ok("redirect:/SmCost/list?")
	@Fail("jsp:/error")
	public void save(@Param("::SmCost.") SmCost pojo, HttpServletRequest request)
			throws Exception {

		/**
		 * 先验证重复提交验证码
		 */
		String token = request.getSession().getAttribute(
				Constants.KEY_REPEAT_SUBMIT) == null ? null : (String) request
				.getSession().getAttribute(Constants.KEY_REPEAT_SUBMIT);
		String token2 = request.getParameter(Constants.KEY_REPEAT_SUBMIT);
		if (token != null && token.equals(token2)) {
			if (pojo != null) {
				if (MyUtil.isEmpty(pojo.getId())) {
					pojo.setId(SeqNum.getPrimaryKeyForString());
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setCreate_date(MyUtil.getCreateTime2());
					this.smCostDao.save(pojo);
				} else {
					Object obj = request.getSession().getAttribute(
							Constants.KEY_LOGIN_USER);
					if (obj instanceof TSysUser) {
						TSysUser user = (TSysUser) obj;
						pojo.setUpdate_by(user.getUser_name());
					}
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setStatus(Constants.VALUE_EDITED_STATUS);
					this.smCostDao.update(pojo);
				}
			}
		} else {
			String error = "No repeat sumbit!";
			request.setAttribute("error", error);
			throw new Exception(error);
		}
	}

	@At("/SmCost/update")
	@Ok("redirect:/SmCost/list?")
	@Fail("jsp:/error")
	public void update(@Param("::SmCost.") SmCost pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/SmCost/del")
	@Ok("redirect:/SmCost/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.smCostDao.delById(id, DicType.class);
		}
	}

	@At("/SmCost/dels")
	@Ok("redirect:/SmCost/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		// 数据软删除
		for (String str : strs) {
			int id = Integer.parseInt(str);
			SmCost pojo = this.smCostDao.find(id, SmCost.class);
			pojo.setStatus(Constants.VALUE_DEL_STATUS);
			this.smCostDao.update(pojo);
		}
	}

	@At("/SmCost/delss")
	@Ok("redirect:/SmCost/list?")
	@Fail("jsp:/error")
	public void delss(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		// 数据彻底删除
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.smCostDao.deleteByIds(SmCost.class, ids);
	}

	@At("/SmCost/view")
	@Ok("jsp:/jsp/cost/smcost/view")
	@Fail("jsp:/error")
	public void view(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			SmCost pojo = this.smCostDao.find(id, SmCost.class);
			request.setAttribute("SmCost", pojo);
		}
	}

	@At("/SmCost/edit")
	@Ok("jsp:/jsp/cost/smcost/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			SmCost pojo = this.smCostDao.find(id, SmCost.class);
			request.setAttribute("SmCost", pojo);
		}
	}

	@At("/SmCost/check")
	@Ok("redirect:/SmCost/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") String ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (String id : ids) {
				SmCost pojo = this.smCostDao.find(id, SmCost.class);
				pojo.setStatus(Constants.VALUE_CHECKED_STATUS);
				this.smCostDao.update(pojo);
			}
		}
	}

	@At("/SmCost/checkName")
	@Ok("json")
	@Fail("jsp:/error")
	public void checkName(@Param("name") String name, HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		// TODO
	}
}