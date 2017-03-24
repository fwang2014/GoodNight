package com.nutz.pip.action.data;

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
import com.nutz.pip.dao.data.DataimportPartDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.data.DataimportPart;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class DataimportPartAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(DataimportPartAction.class);

	private final String tab = "DataimportPart";
	private final String menuCode = "505";

	@SuppressWarnings("unused")
	@Inject
	private DataimportPartDao dataimportPartDao;

	/**
	 * 查询 编码，名称，类型，状态，开始时间和结束时间
	 * 
	 * @param pojo
	 * @param cp
	 * @param request
	 * @throws Exception
	 */
	@At("/DataimportPart/search")
	@Ok("jsp:/jsp/data/partdataimportpart/searchlist")
	@Fail("jsp:/error")
	public void search(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.search");
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		request.setAttribute("search", form);

		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_SEARCH;

		List<DataimportPart> list = null;
		int count = 0;
		if (!Lang.isEmpty(form.getCode()) && form.getCode().length() > 0) {
			list = dataimportPartDao.searchByPage(DataimportPart.class, Cnd
					.where("code", "like", "%" + form.getCode() + "%"),
					currentPage, pageSize);
			count = dataimportPartDao.searchCount(DataimportPart.class, Cnd
					.where("code", "like", "%" + form.getCode() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		if (!Lang.isEmpty(form.getName()) && form.getName().length() > 0) {
			list = dataimportPartDao.searchByPage(DataimportPart.class, Cnd
					.where("name", "like", "%" + form.getName() + "%"),
					currentPage, pageSize);
			count = dataimportPartDao.searchCount(DataimportPart.class, Cnd
					.where("name", "like", "%" + form.getName() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		if (!Lang.isEmpty(form.getType()) && form.getType().length() > 0) {
			list = dataimportPartDao.searchByPage(DataimportPart.class, Cnd
					.where("type", "like", "%" + form.getType() + "%"),
					currentPage, pageSize);
			count = dataimportPartDao.searchCount(DataimportPart.class, Cnd
					.where("type", "like", "%" + form.getType() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		if (!Lang.isEmpty(form.getStatus()) && form.getStatus().length() > 0) {
			list = dataimportPartDao.searchByPage(DataimportPart.class, Cnd
					.where("status", "like", "%" + form.getStatus() + "%"),
					currentPage, pageSize);
			count = dataimportPartDao.searchCount(DataimportPart.class, Cnd
					.where("status", "like", "%" + form.getStatus() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		// 如果开始或结束时间有不为空的
		if (!Lang.isEmpty(form.getStartDate())
				|| !Lang.isEmpty(form.getEndDate())) {
			// 如果开始和结束时间都不为空
			if (!Lang.isEmpty(form.getStartDate())
					&& form.getStartDate().length() > 0
					&& !Lang.isEmpty(form.getEndDate())
					&& form.getEndDate().length() > 0) {
				list = dataimportPartDao.searchByPage(DataimportPart.class, Cnd
						.where("update_time", ">=", form.getStartDate()).and(
								"update_time", "<=", form.getEndDate()),
						currentPage, pageSize);
				count = dataimportPartDao.searchCount(DataimportPart.class, Cnd
						.where("update_time", ">=", form.getStartDate()).and(
								"update_time", "<=", form.getEndDate()));
				Pagination page = new Pagination(currentPage, pageSize, count,
						list);
				request.setAttribute("page", page);
			} else {
				// 如果开始时间不为空
				if (!Lang.isEmpty(form.getStartDate())) {
					list = dataimportPartDao
							.searchByPage(DataimportPart.class, Cnd.where(
									"update_time", ">=", form.getStartDate()),
									currentPage, pageSize);
					count = dataimportPartDao
							.searchCount(DataimportPart.class, Cnd.where(
									"update_time", ">=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				} else {// 结束时间不为空
					list = dataimportPartDao
							.searchByPage(DataimportPart.class, Cnd.where(
									"update_time", "<=", form.getStartDate()),
									currentPage, pageSize);
					count = dataimportPartDao
							.searchCount(DataimportPart.class, Cnd.where(
									"update_time", "<=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				}
			}
		}
	}

	@At("/DataimportPart/exportAll")
	@Ok("jsp:/jsp/data/dataimportpart/exportall")
	@Fail("jsp:/error")
	public void exportExcelAll(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.exportExcelAll");
		this.search(form, cp, request);
		Pagination page = (Pagination) request.getAttribute("page");
		// System.out.println(page.getList().size());
	}

	@At("/DataimportPart/list")
	@Ok("jsp:/jsp/data/dataimportpart/list")
	@Fail("jsp:/error")
	public void list(@Param("pid") int pid,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		if(!Lang.isEmpty(pid) && pid > 0){
			int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
			int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
			//String orderby = "id";
			
			List<DataimportPart> list=	this.dataimportPartDao.searchByPage(DataimportPart.class, Cnd.where("import_id", "=", pid), currentPage, pageSize);
			Pagination page = new Pagination(currentPage, pageSize,list.size(), list);
			request.setAttribute("page", page);
		}
		
	}

	@At("/DataimportPart/add")
	@Ok("jsp:/jsp/data/dataimportpart/add")
	@Fail("jsp:/error")
	public void add(@Param("::DataimportPart.") DataimportPart pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// 防止重复提交，设置数据提交前验证字符
		request.getSession().setAttribute(Constants.KEY_REPEAT_SUBMIT,
				System.currentTimeMillis() + "");
		if (pojo == null) {
			pojo = new DataimportPart();
		}
		request.setAttribute("DataimportPart", pojo);
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

	@At("/DataimportPart/save")
	@Ok("redirect:/DataimportPart/list?")
	@Fail("jsp:/error")
	public void save(@Param("::DataimportPart.") DataimportPart pojo,
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
					this.dataimportPartDao.save(pojo);
				} else {
					Object obj = request.getSession().getAttribute(
							Constants.KEY_LOGIN_USER);
					if (obj instanceof TSysUser) {
						TSysUser user = (TSysUser) obj;
						pojo.setUpdate_by(user.getUser_name());
					}
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setStatus(Constants.VALUE_EDITED_STATUS);
					this.dataimportPartDao.update(pojo);
				}
			}
		} else {
			String error = "No repeat sumbit!";
			request.setAttribute("error", error);
			throw new Exception(error);
		}
	}

	@At("/DataimportPart/update")
	@Ok("redirect:/DataimportPart/list?")
	@Fail("jsp:/error")
	public void update(@Param("::DataimportPart.") DataimportPart pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/DataimportPart/del")
	@Ok("redirect:/DataimportPart/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.dataimportPartDao.delById(id, DicType.class);
		}
	}

	@At("/DataimportPart/dels")
	@Ok("redirect:/DataimportPart/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		// 数据软删除
		for (String str : strs) {
			int id = Integer.parseInt(str);
			DataimportPart pojo = this.dataimportPartDao.find(id,
					DataimportPart.class);
			pojo.setStatus(Constants.VALUE_DEFAULT_STATUS);
			this.dataimportPartDao.update(pojo);
		}
	}

	@At("/DataimportPart/delss")
	@Ok("redirect:/DataimportPart/list?")
	@Fail("jsp:/error")
	public void delss(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		// 数据彻底删除
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.dataimportPartDao.deleteByIds(DataimportPart.class, ids);
	}

	@At("/DataimportPart/view")
	@Ok("jsp:/jsp/data/dataimportpart/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			DataimportPart pojo = this.dataimportPartDao.find(id,
					DataimportPart.class);
			request.setAttribute("DataimportPart", pojo);
		}
	}

	@At("/DataimportPart/edit")
	@Ok("jsp:/jsp/data/dataimportpart/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			DataimportPart pojo = this.dataimportPartDao.find(id,
					DataimportPart.class);
			request.setAttribute("DataimportPart", pojo);
		}
	}

	@At("/DataimportPart/check")
	@Ok("redirect:/DataimportPart/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				DataimportPart pojo = this.dataimportPartDao.find(id,
						DataimportPart.class);
				pojo.setStatus(Constants.VALUE_CHECKED_STATUS);
				this.dataimportPartDao.update(pojo);
			}
		}
	}
}
