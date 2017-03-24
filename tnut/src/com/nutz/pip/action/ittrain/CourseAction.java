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
import com.nutz.pip.dao.ittrain.CourseDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.ittrain.Course;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class CourseAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(CourseAction.class);

	private final String tab = "Course";

	@SuppressWarnings("unused")
	@Inject
	private CourseDao courseDao;

	@At("/Course/list")
	@Ok("jsp:/jsp/ittrain/course/list")
	@Fail("jsp:/error")
	public void list(@Param("::Course.") Course pojo,@Param("cp") int cp, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", "304");
		//List list = this.courseDao.search(Course.class, "id");

		int currentPage = (cp>0?cp:Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.courseDao.getPage(Course.class, currentPage, pageSize, orderby);
		request.setAttribute("page", page);
		//request.setAttribute("list", page.getList());
	}

	@At("/Course/add")
	@Ok("jsp:/jsp/ittrain/course/add")
	@Fail("jsp:/error")
	public void add(@Param("::Course.") Course pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "304");
		if (pojo == null) {
			pojo = new Course();
		}
		request.setAttribute("Course", pojo);
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

	@At("/Course/save")
	@Ok("redirect:/Course/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Course.") Course pojo, HttpServletRequest request)
			throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.courseDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.courseDao.update(pojo);
			}
		}
	}

	@At("/Course/update")
	@Ok("redirect:/Course/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Course.") Course pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", "304");
	}

	@At("/Course/del")
	@Ok("redirect:/Course/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "304");
		if (!MyUtil.isEmpty(id)) {
			this.courseDao.delById(id, DicType.class);
		}
	}

	@At("/Course/dels")
	@Ok("redirect:/Course/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "304");
		String ids = MyUtil.getIdsFromArray(strs);
		this.courseDao.deleteByIds(Course.class, ids);
	}

	@At("/Course/view")
	@Ok("jsp:/jsp/ittrain/course/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "304");
		if (!MyUtil.isEmpty(id)) {
			Course pojo = this.courseDao.find(id, Course.class);
			request.setAttribute("Course", pojo);
		}
	}

	@At("/Course/edit")
	@Ok("jsp:/jsp/ittrain/course/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "304");
		if (!MyUtil.isEmpty(id)) {
			Course pojo = this.courseDao.find(id, Course.class);
			request.setAttribute("Course", pojo);
		}
	}

	@At("/Course/check")
	@Ok("redirect:/Course/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", "304");
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Course pojo = this.courseDao.find(id, Course.class);
				pojo.setStatus(1);
				this.courseDao.update(pojo);
			}
		}
	}
}