package com.nutz.pip.action.customer;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
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
import com.nutz.pip.dao.customer.DothingDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.customer.Customer;
import com.nutz.pip.model.customer.Dothing;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class DothingAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(DothingAction.class);

	private final String tab = "Dothing";
	private final String menuCode = "602";

	@SuppressWarnings("unused")
	@Inject
	private DothingDao dothingDao;

	@At("/Dothing/list")
	@Ok("jsp:/jsp/customer/dothing/list")
	@Fail("jsp:/error")
	public void list(@Param("::Dothing.") Dothing pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.dothingDao.search(Dothing.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.dothingDao.getPage(Dothing.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/Dothing/add")
	@Ok("jsp:/jsp/customer/dothing/add")
	@Fail("jsp:/error")
	public void add(@Param("::Dothing.") Dothing pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new Dothing();
		}
		
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
		
		pojo.setCode(String.valueOf(System.currentTimeMillis()));
		pojo.setEnd_time(MyUtil.getToday());
		pojo.setStart_time(MyUtil.getToday());
		request.setAttribute("Dothing", pojo);
		
		List list = this.dothingDao.search(Customer.class, Cnd.wrap("1=1"));
		request.setAttribute("list", list);
	}

	@At("/Dothing/save")
	@Ok("redirect:/Dothing/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Dothing.") Dothing pojo,
			HttpServletRequest request) throws Exception {
		
		if (pojo != null) {
			String hour1 =request.getParameter("hour1");
			String min1 =request.getParameter("min1");
			String hour2 =request.getParameter("hour2");
			String min2 =request.getParameter("min2");
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				
				StringBuffer buf1 = new StringBuffer();
				buf1.setLength(0);
				buf1.append(pojo.getStart_time()).append(" ").append(hour1).append(":").append(min1);
				pojo.setStart_time(buf1.toString());
				
				StringBuffer buf2 = new StringBuffer();
				buf2.setLength(0);
				buf2.append(pojo.getEnd_time()).append(" ").append(hour2).append(":").append(min2);
				pojo.setEnd_time(buf2.toString());
				
				this.dothingDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.dothingDao.update(pojo);
			}
		}
	}

	@At("/Dothing/update")
	@Ok("redirect:/Dothing/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Dothing.") Dothing pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/Dothing/del")
	@Ok("redirect:/Dothing/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.dothingDao.delById(id, DicType.class);
		}
	}

	@At("/Dothing/dels")
	@Ok("redirect:/Dothing/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.dothingDao.deleteByIds(Dothing.class, ids);
	}

	@At("/Dothing/view")
	@Ok("jsp:/jsp/customer/dothing/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Dothing pojo = this.dothingDao.find(id, Dothing.class);
			request.setAttribute("Dothing", pojo);
		}
	}

	@At("/Dothing/edit")
	@Ok("jsp:/jsp/customer/dothing/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Dothing pojo = this.dothingDao.find(id, Dothing.class);
			request.setAttribute("Dothing", pojo);
		}
	}

	@At("/Dothing/check")
	@Ok("redirect:/Dothing/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Dothing pojo = this.dothingDao.find(id, Dothing.class);
				pojo.setStatus(1);
				this.dothingDao.update(pojo);
			}
		}
	}
}
