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
import com.nutz.pip.dao.cost.CostFillDao2;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.CostFill2;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class CostFillAction2 {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(CostFillAction2.class);

	private final String tab = "CostFill2";
	private final String menuCode = "405";

	@SuppressWarnings("unused")
	@Inject
	private CostFillDao2 costFillDao2;

	/**
	 * 查询 编码，名称，类型，状态，开始时间和结束时间
	 * 
	 * @param pojo
	 * @param cp
	 * @param request
	 * @throws Exception
	 */
	@At("/CostFill2/search")
	@Ok("jsp:/jsp/cost/costfill/searchlist")
	@Fail("jsp:/error")
	public void search(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.search");
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		request.setAttribute("search", form);

		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_SEARCH;

		List<CostFill2> list = null;
		int count = 0;
		if (!Lang.isEmpty(form.getCode()) && form.getCode().length() > 0) {
			list = costFillDao2.searchByPage(CostFill2.class, Cnd.where("code",
					"like", "%" + form.getCode() + "%"), currentPage, pageSize);
			count = costFillDao2.searchCount(CostFill2.class, Cnd.where("code",
					"like", "%" + form.getCode() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}else 
		if (!Lang.isEmpty(form.getName()) && form.getName().length() > 0) {
			list = costFillDao2.searchByPage(CostFill2.class, Cnd.where("name",
					"like", "%" + form.getName() + "%"), currentPage, pageSize);
			count = costFillDao2.searchCount(CostFill2.class, Cnd.where("name",
					"like", "%" + form.getName() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}else 
		if (!Lang.isEmpty(form.getType()) && form.getType().length() > 0) {
			list = costFillDao2.searchByPage(CostFill2.class, Cnd.where("type",
					"like", "%" + form.getType() + "%"), currentPage, pageSize);
			count = costFillDao2.searchCount(CostFill2.class, Cnd.where("type",
					"like", "%" + form.getType() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}else 
		if (!Lang.isEmpty(form.getStatus()) && form.getStatus().length() > 0) {
			list = costFillDao2.searchByPage(CostFill2.class, Cnd.where(
					"status", "like", "%" + form.getStatus() + "%"),
					currentPage, pageSize);
			count = costFillDao2.searchCount(CostFill2.class, Cnd.where(
					"status", "like", "%" + form.getStatus() + "%"));
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
				list = costFillDao2.searchByPage(CostFill2.class, Cnd.where(
						"update_time", ">=", form.getStartDate()).and(
						"update_time", "<=", form.getEndDate()), currentPage,
						pageSize);
				count = costFillDao2.searchCount(CostFill2.class, Cnd.where(
						"update_time", ">=", form.getStartDate()).and(
						"update_time", "<=", form.getEndDate()));
				Pagination page = new Pagination(currentPage, pageSize, count,
						list);
				request.setAttribute("page", page);
			} else {
				// 如果开始时间不为空
				if (!Lang.isEmpty(form.getStartDate())) {
					list = costFillDao2.searchByPage(CostFill2.class, Cnd.where(
							"update_time", ">=", form.getStartDate()),
							currentPage, pageSize);
					count = costFillDao2.searchCount(CostFill2.class, Cnd.where(
							"update_time", ">=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				} else {// 结束时间不为空
					list = costFillDao2.searchByPage(CostFill2.class, Cnd.where(
							"update_time", "<=", form.getStartDate()),
							currentPage, pageSize);
					count = costFillDao2.searchCount(CostFill2.class, Cnd.where(
							"update_time", "<=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				}
			}
		}
	}

	@At("/CostFill2/exportAll")
	@Ok("jsp:/jsp/cost/costfill/exportall")
	@Fail("jsp:/error")
	public void exportExcelAll(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.exportExcelAll");
		this.search(form, cp, request);
		Pagination page = (Pagination) request.getAttribute("page");
		// System.out.println(page.getList().size());
	}

	@At("/CostFill2/list")
	@Ok("jsp:/jsp/cost/costfill/list")
	@Fail("jsp:/error")
	public void list(@Param("::CostFill2.") CostFill2 pojo,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.costFillDao2.search(CostFill2.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.costFillDao2.getPage(CostFill2.class,
				currentPage, pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/CostFill2/add")
	@Ok("jsp:/jsp/cost/costfill/add")
	@Fail("jsp:/error")
	public void add(@Param("::CostFill2.") CostFill2 pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// 防止重复提交，设置数据提交前验证字符
		request.getSession().setAttribute(Constants.KEY_REPEAT_SUBMIT,
				System.currentTimeMillis() + "");
		if (pojo == null) {
			pojo = new CostFill2();
		}
		request.setAttribute("CostFill2", pojo);
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

	@At("/CostFill2/save")
	@Ok("redirect:/CostFill2/list?")
	@Fail("jsp:/error")
	public void save(@Param("::CostFill2.") CostFill2 pojo,
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
				if (MyUtil.isEmpty(pojo.getId())) {
					pojo.setId(SeqNum.getPrimaryKeyForString());
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setCreate_date(MyUtil.getCreateTime2());
					this.costFillDao2.save(pojo);
				} else {
					Object obj = request.getSession().getAttribute(
							Constants.KEY_LOGIN_USER);
					if (obj instanceof TSysUser) {
						TSysUser user = (TSysUser) obj;
						pojo.setUpdate_by(user.getUser_name());
					}
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setStatus(Constants.VALUE_EDITED_STATUS);
					this.costFillDao2.update(pojo);
				}
			}
		} else {
			String error = "No repeat sumbit!";
			request.setAttribute("error", error);
			throw new Exception(error);
		}
	}

	@At("/CostFill2/update")
	@Ok("redirect:/CostFill2/list?")
	@Fail("jsp:/error")
	public void update(@Param("::CostFill2.") CostFill2 pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/CostFill2/del")
	@Ok("redirect:/CostFill2/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.costFillDao2.delById(id, DicType.class);
		}
	}

	@At("/CostFill2/dels")
	@Ok("redirect:/CostFill2/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		// 数据软删除
		for (String str : strs) {
			int id = Integer.parseInt(str);
			CostFill2 pojo = this.costFillDao2.find(id, CostFill2.class);
			pojo.setStatus(Constants.VALUE_DEL_STATUS);
			this.costFillDao2.update(pojo);
		}
	}

	@At("/CostFill2/delss")
	@Ok("redirect:/CostFill2/list?")
	@Fail("jsp:/error")
	public void delss(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		// 数据彻底删除
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.costFillDao2.deleteByIds(CostFill2.class, ids);
	}

	@At("/CostFill2/view")
	@Ok("jsp:/jsp/cost/costfill/view")
	@Fail("jsp:/error")
	public void view(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			CostFill2 pojo = this.costFillDao2.find(id, CostFill2.class);
			request.setAttribute("CostFill2", pojo);
		}
	}

	@At("/CostFill2/edit")
	@Ok("jsp:/jsp/cost/costfill/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			CostFill2 pojo = this.costFillDao2.find(id, CostFill2.class);
			request.setAttribute("CostFill2", pojo);
		}
	}

	@At("/CostFill2/check")
	@Ok("redirect:/CostFill2/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") String ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (String id : ids) {
				CostFill2 pojo = this.costFillDao2.find(id, CostFill2.class);
				pojo.setStatus(Constants.VALUE_CHECKED_STATUS);
				this.costFillDao2.update(pojo);
			}
		}
	}

	@At("/CostFill2/checkName")
	@Ok("json")
	@Fail("jsp:/error")
	public void checkName(@Param("name") String name, HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		// TODO
	}
}