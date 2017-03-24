package com.nutz.pip.action.data;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;

import org.nutz.dao.Cnd;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import com.nutz.pip.Constants;
import com.nutz.pip.common.MyUtil;
import com.nutz.pip.common.SeqNum;
import com.nutz.pip.common.excel.ExcelUtil;
import com.nutz.pip.common.page.Pagination;
import com.nutz.pip.common.page.SearchForm;
import com.nutz.pip.dao.data.DataimportInfoDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.data.DataimportInfo;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class DataimportInfoAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(DataimportInfoAction.class);

	private final String tab = "DataimportInfo";
	private final String menuCode = "101";

	@SuppressWarnings("unused")
	@Inject
	private DataimportInfoDao dataimportInfoDao;
	
	/**
	 * 文档导入
	 * @param request
	 * @throws Exception
	 */
	@At("/DataimportInfo/import")
	@Ok("jsp:/jsp/data/dataimport/import")
	@Fail("jsp:/error")
	public void docImport( HttpServletRequest request) throws Exception {
		System.out.println("DataimportInfoAction.docImport");
		
	}
	
	/**
	 * 文档导入保存
	 * @param request
	 * @throws Exception
	 */
	@AdaptBy(type = UploadAdaptor.class, args = { "${app.root}/WEB-INF/tmp/doc" })
	@At("/DataimportInfo/saveImport")
	@Ok("redirect:/DataimportInfo/list?")
	@Fail("jsp:/error")
	public void saveImport(@Param("doc") TempFile tf, HttpServletRequest request) throws Exception {
		System.out.println("DataimportInfoAction.saveImport");
		if(tf != null){	
			String fileName = tf.getMeta().getFileLocalName();
			DataimportInfo pojo = new DataimportInfo();
			pojo.setCode(System.currentTimeMillis()+"");
			pojo.setCreate_by(Constants.VALUE_DEFAULT_CREATE_BY);
			pojo.setCreate_date(MyUtil.getCreateTime2());
			pojo.setIs_read("Y");
			pojo.setName("EXCEL DATA IMPORT ["+fileName+"]");
			pojo.setRemark(pojo.getName());
			pojo.setStatus(Constants.VALUE_DEFAULT_STATUS);
			pojo.setType(Constants.VALUE_DEFAULT_TYPE);
			pojo.setUpdate_by(Constants.VALUE_DEFAULT_CREATE_BY);
			pojo.setUpdate_time(MyUtil.getCreateTime2());
			pojo = this.dataimportInfoDao.save(pojo);
			long import_id = pojo.getId();
			
			ExcelUtil util = new ExcelUtil(tf.getFile());
			Sheet sheets[] = util.getSheets();
			for(Sheet sheet:sheets){
				util.saveSheet(this.dataimportInfoDao, sheet, import_id);
			}
			System.out.println("DataimportInfoAction.saveImport success");
		}
	}

	/**
	 * 查询 编码，名称，类型，状态，开始时间和结束时间
	 * 
	 * @param pojo
	 * @param cp
	 * @param request
	 * @throws Exception
	 */
	@At("/DataimportInfo/search")
	@Ok("jsp:/jsp/data/dataimport/searchlist")
	@Fail("jsp:/error")
	public void search(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.search");
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		request.setAttribute("search", form);

		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_SEARCH;

		List<DataimportInfo> list = null;
		int count = 0;
		if (!Lang.isEmpty(form.getCode()) && form.getCode().length() > 0) {
			list = dataimportInfoDao.searchByPage(DataimportInfo.class, Cnd
					.where("code", "like", "%" + form.getCode() + "%"),
					currentPage, pageSize);
			count = dataimportInfoDao.searchCount(DataimportInfo.class, Cnd
					.where("code", "like", "%" + form.getCode() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		if (!Lang.isEmpty(form.getName()) && form.getName().length() > 0) {
			list = dataimportInfoDao.searchByPage(DataimportInfo.class, Cnd
					.where("name", "like", "%" + form.getName() + "%"),
					currentPage, pageSize);
			count = dataimportInfoDao.searchCount(DataimportInfo.class, Cnd
					.where("name", "like", "%" + form.getName() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		if (!Lang.isEmpty(form.getType()) && form.getType().length() > 0) {
			list = dataimportInfoDao.searchByPage(DataimportInfo.class, Cnd
					.where("type", "like", "%" + form.getType() + "%"),
					currentPage, pageSize);
			count = dataimportInfoDao.searchCount(DataimportInfo.class, Cnd
					.where("type", "like", "%" + form.getType() + "%"));
			Pagination page = new Pagination(currentPage, pageSize, count, list);
			request.setAttribute("page", page);
		}
		if (!Lang.isEmpty(form.getStatus()) && form.getStatus().length() > 0) {
			list = dataimportInfoDao.searchByPage(DataimportInfo.class, Cnd
					.where("status", "like", "%" + form.getStatus() + "%"),
					currentPage, pageSize);
			count = dataimportInfoDao.searchCount(DataimportInfo.class, Cnd
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
				list = dataimportInfoDao.searchByPage(DataimportInfo.class, Cnd
						.where("update_time", ">=", form.getStartDate()).and(
								"update_time", "<=", form.getEndDate()),
						currentPage, pageSize);
				count = dataimportInfoDao.searchCount(DataimportInfo.class, Cnd
						.where("update_time", ">=", form.getStartDate()).and(
								"update_time", "<=", form.getEndDate()));
				Pagination page = new Pagination(currentPage, pageSize, count,
						list);
				request.setAttribute("page", page);
			} else {
				// 如果开始时间不为空
				if (!Lang.isEmpty(form.getStartDate())) {
					list = dataimportInfoDao
							.searchByPage(DataimportInfo.class, Cnd.where(
									"update_time", ">=", form.getStartDate()),
									currentPage, pageSize);
					count = dataimportInfoDao
							.searchCount(DataimportInfo.class, Cnd.where(
									"update_time", ">=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				} else {// 结束时间不为空
					list = dataimportInfoDao
							.searchByPage(DataimportInfo.class, Cnd.where(
									"update_time", "<=", form.getStartDate()),
									currentPage, pageSize);
					count = dataimportInfoDao
							.searchCount(DataimportInfo.class, Cnd.where(
									"update_time", "<=", form.getStartDate()));
					Pagination page = new Pagination(currentPage, pageSize,
							count, list);
					request.setAttribute("page", page);
				}
			}
		}
	}

	@At("/DataimportInfo/exportAll")
	@Ok("jsp:/jsp/data/dataimport/exportall")
	@Fail("jsp:/error")
	public void exportExcelAll(@Param("::search.") SearchForm form,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {
		// System.out.println("SysBeanAction.exportExcelAll");
		this.search(form, cp, request);
		Pagination page = (Pagination) request.getAttribute("page");
		// System.out.println(page.getList().size());
	}

	@At("/DataimportInfo/list")
	@Ok("jsp:/jsp/data/dataimport/list")
	@Fail("jsp:/error")
	public void list(@Param("::DataimportInfo.") DataimportInfo pojo,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.dataimportInfoDao.search(DataimportInfo.class,
		// "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.dataimportInfoDao.getPage(DataimportInfo.class,
				currentPage, pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/DataimportInfo/add")
	@Ok("jsp:/jsp/data/dataimport/add")
	@Fail("jsp:/error")
	public void add(@Param("::DataimportInfo.") DataimportInfo pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// 防止重复提交，设置数据提交前验证字符
		request.getSession().setAttribute(Constants.KEY_REPEAT_SUBMIT,
				System.currentTimeMillis() + "");
		if (pojo == null) {
			pojo = new DataimportInfo();
		}
		request.setAttribute("DataimportInfo", pojo);
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

	@AdaptBy(type = UploadAdaptor.class, args = { "${app.root}/WEB-INF/tmp/doc" })
	@At("/DataimportInfo/save")
	@Ok("redirect:/DataimportInfo/list?")
	@Fail("jsp:/error")
	public void save(@Param("::DataimportInfo.") DataimportInfo pojo,@Param("doc") TempFile tf,
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
					this.dataimportInfoDao.save(pojo);
				} else {
					Object obj = request.getSession().getAttribute(
							Constants.KEY_LOGIN_USER);
					if (obj instanceof TSysUser) {
						TSysUser user = (TSysUser) obj;
						pojo.setUpdate_by(user.getUser_name());
					}
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setStatus(Constants.VALUE_EDITED_STATUS);
					this.dataimportInfoDao.update(pojo);
				}
			}
		} else {
			String error = "No repeat sumbit!";
			request.setAttribute("error", error);
			throw new Exception(error);
		}
	}

	@At("/DataimportInfo/update")
	@Ok("redirect:/DataimportInfo/list?")
	@Fail("jsp:/error")
	public void update(@Param("::DataimportInfo.") DataimportInfo pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/DataimportInfo/del")
	@Ok("redirect:/DataimportInfo/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.dataimportInfoDao.delById(id, DicType.class);
		}
	}

	@At("/DataimportInfo/dels")
	@Ok("redirect:/DataimportInfo/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		// 数据软删除
		for (String str : strs) {
			int id = Integer.parseInt(str);
			DataimportInfo pojo = this.dataimportInfoDao.find(id,
					DataimportInfo.class);
			pojo.setStatus(Constants.VALUE_DEFAULT_STATUS);
			this.dataimportInfoDao.update(pojo);
		}
	}

	@At("/DataimportInfo/delss")
	@Ok("redirect:/DataimportInfo/list?")
	@Fail("jsp:/error")
	public void delss(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		// 数据彻底删除
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.dataimportInfoDao.deleteByIds(DataimportInfo.class, ids);
	}

	@At("/DataimportInfo/view")
	@Ok("jsp:/jsp/data/dataimport/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			DataimportInfo pojo = this.dataimportInfoDao.find(id,
					DataimportInfo.class);
			request.setAttribute("DataimportInfo", pojo);
		}
	}

	@At("/DataimportInfo/edit")
	@Ok("jsp:/jsp/data/dataimport/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			DataimportInfo pojo = this.dataimportInfoDao.find(id,
					DataimportInfo.class);
			request.setAttribute("DataimportInfo", pojo);
		}
	}

	@At("/DataimportInfo/check")
	@Ok("redirect:/DataimportInfo/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				DataimportInfo pojo = this.dataimportInfoDao.find(id,
						DataimportInfo.class);
				pojo.setStatus(Constants.VALUE_CHECKED_STATUS);
				this.dataimportInfoDao.update(pojo);
			}
		}
	}
}