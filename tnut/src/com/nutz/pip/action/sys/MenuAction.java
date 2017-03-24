package com.nutz.pip.action.sys;

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
import com.nutz.pip.dao.sys.MenuDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.misc.Phonebook;
import com.nutz.pip.model.sm.sys.TSysUser;
import com.nutz.pip.model.sys.Menu;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class MenuAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(MenuAction.class);

	private final String tab = "Menu";
	private final String menuCode = "203";

	@SuppressWarnings("unused")
	@Inject
	private MenuDao menuDao;

	@At("/Menu/list")
	@Ok("jsp:/jsp/sys/menu/list")
	@Fail("jsp:/error")
	public void list(@Param("::Menu.") Menu pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.menuDao.search(Menu.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.menuDao.getPage(Menu.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/Menu/add")
	@Ok("jsp:/jsp/sys/menu/add")
	@Fail("jsp:/error")
	public void add(@Param("::Menu.") Menu pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new Menu();
		}
		request.setAttribute("Menu", pojo);
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

	@At("/Menu/save")
	@Ok("redirect:/Menu/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Menu.") Menu pojo, HttpServletRequest request)
			throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.menuDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setStatus(Constants.VALUE_EDITED_STATUS);
				this.menuDao.update(pojo);
			}
		}
	}

	@At("/Menu/update")
	@Ok("redirect:/Menu/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Menu.") Menu pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/Menu/del")
	@Ok("redirect:/Menu/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.menuDao.delById(id, DicType.class);
		}
	}

	@At("/Menu/dels")
	@Ok("redirect:/Menu/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		
		// 数据软删除
		for (String str : strs) {
			int id = Integer.parseInt(str);
			Phonebook pojo = this.menuDao.find(id, Phonebook.class);
			pojo.setStatus(Constants.VALUE_DEL_STATUS);
			this.menuDao.update(pojo);
		}		
	}
	
	@At("/Menu/delss")
	@Ok("redirect:/Menu/list?")
	@Fail("jsp:/error")
	public void delss(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {		
		// 数据彻底删除
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.menuDao.deleteByIds(Phonebook.class, ids);	
	}

	@At("/Menu/view")
	@Ok("jsp:/jsp/sys/menu/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Menu pojo = this.menuDao.find(id, Menu.class);
			request.setAttribute("Menu", pojo);
		}
	}

	@At("/Menu/edit")
	@Ok("jsp:/jsp/sys/menu/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Menu pojo = this.menuDao.find(id, Menu.class);
			request.setAttribute("Menu", pojo);
		}
	}

	@At("/Menu/check")
	@Ok("redirect:/Menu/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Menu pojo = this.menuDao.find(id, Menu.class);
				pojo.setStatus(1);
				this.menuDao.update(pojo);
			}
		}
	}
}
