package com.nutz.pip.action.misc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Xmls;
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
import com.nutz.pip.dao.misc.PhonebookDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.misc.Phonebook;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class PhonebookAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(PhonebookAction.class);

	private final String tab = "Phonebook";
	private final String menuCode = "603";

	@SuppressWarnings("unused")
	@Inject
	private PhonebookDao phonebookDao;

	/**
	 * 查询 编码，名称，类型，状态，开始时间和结束时间
	 * 
	 * @param pojo
	 * @param cp
	 * @param request
	 * @throws Exception
	 */
	@At("/Phonebook/search")
	@Ok("jsp:/jsp/misc/phonebook/searchlist")
	@Fail("jsp:/error")
	public void search(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.search");
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		request.setAttribute("search", form);

		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_SEARCH;

		List<Phonebook> list = null;
		int count = 0;
		if (!Lang.isEmpty(form.getCode()) && form.getCode().length() > 0) {
			list = phonebookDao.searchByPage(Phonebook.class, Cnd.where("code",
					"like", "%" + form.getCode() + "%"), currentPage, pageSize);
			count = phonebookDao.searchCount(Phonebook.class, Cnd.where("code",
					"like", "%" + form.getCode() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		if (!Lang.isEmpty(form.getName()) && form.getName().length() > 0) {
			list = phonebookDao.searchByPage(Phonebook.class, Cnd.where("name",
					"like", "%" + form.getName() + "%"), currentPage, pageSize);
			count = phonebookDao.searchCount(Phonebook.class, Cnd.where("name",
					"like", "%" + form.getName() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		if (!Lang.isEmpty(form.getType()) && form.getType().length() > 0) {
			list = phonebookDao.searchByPage(Phonebook.class, Cnd.where("type",
					"like", "%" + form.getType() + "%"), currentPage, pageSize);
			count = phonebookDao.searchCount(Phonebook.class, Cnd.where("type",
					"like", "%" + form.getType() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		if (!Lang.isEmpty(form.getStatus()) && form.getStatus().length() > 0) {
			list = phonebookDao.searchByPage(Phonebook.class, Cnd.where(
					"status", "like", "%" + form.getStatus() + "%"),
					currentPage, pageSize);
			count = phonebookDao.searchCount(Phonebook.class, Cnd.where(
					"status", "like", "%" + form.getStatus() + "%"));
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
				list = phonebookDao.searchByPage(Phonebook.class, Cnd.where(
						"update_time", ">=", form.getStartDate()).and(
						"update_time", "<=", form.getEndDate()), currentPage,
						pageSize);
				count = phonebookDao.searchCount(Phonebook.class, Cnd.where(
						"update_time", ">=", form.getStartDate()).and(
						"update_time", "<=", form.getEndDate()));
				Pagination page = new Pagination(currentPage, pageSize, count,
						list);
				request.setAttribute("page", page);
			} else {
				// 如果开始时间不为空
				if (!Lang.isEmpty(form.getStartDate())) {
					list = phonebookDao.searchByPage(Phonebook.class, Cnd
							.where("update_time", ">=", form.getStartDate()),
							currentPage, pageSize);
					count = phonebookDao.searchCount(Phonebook.class, Cnd
							.where("update_time", ">=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				} else {// 结束时间不为空
					list = phonebookDao.searchByPage(Phonebook.class, Cnd
							.where("update_time", "<=", form.getStartDate()),
							currentPage, pageSize);
					count = phonebookDao.searchCount(Phonebook.class, Cnd
							.where("update_time", "<=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				}
			}
		}
	}

	@At("/Phonebook/exportAll")
	@Ok("jsp:/jsp/misc/phonebook/exportall")
	@Fail("jsp:/error")
	public void exportExcelAll(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.exportExcelAll");
		this.search(form, cp, request);
		Pagination page = (Pagination) request.getAttribute("page");
		// System.out.println(page.getList().size());
	}

	@At("/Phonebook/list")
	@Ok("jsp:/jsp/misc/phonebook/list")
	@Fail("jsp:/error")
	public void list(@Param("::Phonebook.") Phonebook pojo,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.phonebookDao.search(Phonebook.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.phonebookDao.getPage(Phonebook.class,
				currentPage, pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/Phonebook/add")
	@Ok("jsp:/jsp/misc/phonebook/add")
	@Fail("jsp:/error")
	public void add(@Param("::Phonebook.") Phonebook pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// 防止重复提交，设置数据提交前验证字符
		request.getSession().setAttribute(Constants.KEY_REPEAT_SUBMIT,
				System.currentTimeMillis() + "");
		if (pojo == null) {
			pojo = new Phonebook();
		}
		request.setAttribute("Phonebook", pojo);
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
		pojo.setCode(System.currentTimeMillis()+"");
		pojo.setArea_code("0");
	}

	@At("/Phonebook/save")
	@Ok("redirect:/Phonebook/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Phonebook.") Phonebook pojo,
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
					this.phonebookDao.save(pojo);
				} else {
					Object obj = request.getSession().getAttribute(
							Constants.KEY_LOGIN_USER);
					if (obj instanceof TSysUser) {
						TSysUser user = (TSysUser) obj;
						pojo.setUpdate_by(user.getUser_name());
					}
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setStatus(Constants.VALUE_EDITED_STATUS);
					this.phonebookDao.update(pojo);
				}
			}
		} else {
			String error = "No repeat sumbit!";
			request.setAttribute("error", error);
			throw new Exception(error);
		}
	}

	@At("/Phonebook/update")
	@Ok("redirect:/Phonebook/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Phonebook.") Phonebook pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/Phonebook/del")
	@Ok("redirect:/Phonebook/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.phonebookDao.delById(id, DicType.class);
		}
	}

	@At("/Phonebook/dels")
	@Ok("redirect:/Phonebook/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		// 数据软删除
		for (String str : strs) {
			int id = Integer.parseInt(str);
			Phonebook pojo = this.phonebookDao.find(id, Phonebook.class);
			pojo.setStatus(Constants.VALUE_DEL_STATUS);
			this.phonebookDao.update(pojo);
		}
	}

	@At("/Phonebook/delss")
	@Ok("redirect:/Phonebook/list?")
	@Fail("jsp:/error")
	public void delss(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		// 数据彻底删除
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.phonebookDao.deleteByIds(Phonebook.class, ids);
	}

	@At("/Phonebook/view")
	@Ok("jsp:/jsp/misc/phonebook/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Phonebook pojo = this.phonebookDao.find(id, Phonebook.class);
			request.setAttribute("Phonebook", pojo);
		}
	}

	@At("/Phonebook/edit")
	@Ok("jsp:/jsp/misc/phonebook/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Phonebook pojo = this.phonebookDao.find(id, Phonebook.class);
			request.setAttribute("Phonebook", pojo);
		}
	}

	@At("/Phonebook/check")
	@Ok("redirect:/Phonebook/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Phonebook pojo = this.phonebookDao.find(id, Phonebook.class);
				pojo.setStatus(Constants.VALUE_CHECKED_STATUS);
				this.phonebookDao.update(pojo);
			}
		}
	}
	
	/**
	 * 手机号码姓名检查是否重复
	 * @param ids
	 * @param request
	 * @throws Exception
	 */
	@At("/Phonebook/checkName")
	@Ok("raw")
	@Fail("jsp:/error")
	public Object checkName(@Param("name") String name, HttpServletRequest request)
			throws Exception {
		//System.out.println("---------->@At(\"/Phonebook/checkName\")");
		StringBuffer xml = new StringBuffer();
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(name)) {
			String name2 = "name";
			String op = Constants.OP_EQUAL;
			String value = name;
			Phonebook pojo = this.phonebookDao.findByCondition(Phonebook.class, Cnd.where(name2, op, value));
			//result = pojo;	
			//result = Json.toJson(pojo);
			//System.out.println(result);
			//StringBuffer xml = new StringBuffer();
			
			/*xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> ");
			xml.append("<items>");
			xml.append("<id>").append(pojo.getId()).append("</id>");
			xml.append("<code>").append(pojo.getCode()).append("</code>");
			xml.append("<name>").append(pojo.getName()).append("</name>");
			xml.append("<phone>").append(pojo.getPhone()).append("</phone>");
			xml.append("</items>");*/
			xml.append(Json.toJson(pojo));
			//result = xml.toString();
			System.out.println(xml.toString());
		}
		return xml.toString();
	}
	
	/**
	 * 手机号码检查是否重复
	 * @param ids
	 * @param request
	 * @throws Exception
	 */
	@At("/Phonebook/checkPhone")
	@Ok("json")
	@Fail("jsp:/error")
	public Object checkPhone(@Param("phone") String phone, HttpServletRequest request)
			throws Exception {
		//System.out.println("---------->@At(\"/Phonebook/checkPhone\")");
		request.setAttribute("menuActive", menuCode);
		//StringBuffer xml = new StringBuffer();
		Object result = null;
		if (!MyUtil.isEmpty(phone)) {
			String name2 = "phone";
			String op = Constants.OP_EQUAL;
			String value = phone;
			Phonebook pojo = this.phonebookDao.findByCondition(Phonebook.class, Cnd.where(name2, op, value));
			result = pojo;	
			//xml.append(Json.toJson(pojo));
			//result = xml.toString();
			//System.out.println(xml.toString());
		}
		return result;
	}
}
