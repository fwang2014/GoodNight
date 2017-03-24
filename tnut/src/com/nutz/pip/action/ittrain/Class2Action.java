package com.nutz.pip.action.ittrain;

import java.util.Date;
import java.util.List;

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
import com.nutz.pip.dao.ittrain.Class2Dao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.ittrain.Class2;
import com.nutz.pip.model.ittrain.Consult;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class Class2Action {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(Class2Action.class);

	private final String tab = "Class2";

	@SuppressWarnings("unused")
	@Inject
	private Class2Dao class2Dao;

	@At("/Class2/list")
	@Ok("jsp:/jsp/ittrain/class/list")
	@Fail("jsp:/error")
	public void list(@Param("::Class2.") Class2 pojo,@Param("cp") int cp, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", "303");
		//List list = this.class2Dao.search(Class2.class, "id");
		//request.setAttribute("list", list);
		
		int currentPage = (cp>0?cp:Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.class2Dao.getPage(Class2.class, currentPage, pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/Class2/add")
	@Ok("jsp:/jsp/ittrain/class/add")
	@Fail("jsp:/error")
	public void add(@Param("::Class2.") Class2 pojo, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", "303");
		if (pojo == null) {
			pojo = new Class2();
		}
		request.setAttribute("Class2", pojo);
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

	@At("/Class2/save")
	@Ok("redirect:/Class2/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Class2.") Class2 pojo, HttpServletRequest request)
			throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.class2Dao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.class2Dao.update(pojo);
			}
		}
	}

	@At("/Class2/update")
	@Ok("redirect:/Class2/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Class2.") Class2 pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", "303");
	}

	@At("/Class2/del")
	@Ok("redirect:/Class2/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "303");
		if (!MyUtil.isEmpty(id)) {
			this.class2Dao.delById(id, DicType.class);
		}
	}

	@At("/Class2/dels")
	@Ok("redirect:/Class2/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "303");
		String ids = MyUtil.getIdsFromArray(strs);
		this.class2Dao.deleteByIds(Class2.class, ids);
	}

	@At("/Class2/view")
	@Ok("jsp:/jsp/ittrain/class/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "303");
		if (!MyUtil.isEmpty(id)) {
			Class2 pojo = this.class2Dao.find(id, Class2.class);
			request.setAttribute("Class2", pojo);
		}
	}

	@At("/Class2/edit")
	@Ok("jsp:/jsp/ittrain/class/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", "303");
		if (!MyUtil.isEmpty(id)) {
			Class2 pojo = this.class2Dao.find(id, Class2.class);
			request.setAttribute("Class2", pojo);
		}
	}

	@At("/Class2/check")
	@Ok("redirect:/Class2/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", "303");
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Class2 pojo = this.class2Dao.find(id, Class2.class);
				pojo.setStatus(1);
				this.class2Dao.update(pojo);
			}
		}
	}
}
