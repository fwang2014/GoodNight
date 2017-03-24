package com.nutz.pip.action.ittrain;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
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
import com.nutz.pip.dao.ittrain.ClassMemberDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.ittrain.Class2;
import com.nutz.pip.model.ittrain.ClassMember;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class ClassMemberAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(ClassMemberAction.class);

	private final String tab = "ClassMember";
	private final String menuCode = "303";
	

	@SuppressWarnings("unused")
	@Inject
	private ClassMemberDao classMemberDao;

	@At("/ClassMember/list")
	@Ok("jsp:/jsp/ittrain/classmember/list")
	@Fail("jsp:/error")
	public void list(@Param("pid") int pid,
			@Param("cp") int cp, HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		if(Lang.isEmpty(pid) || pid==0){
			pid = request.getAttribute("pid")==null?0:Integer.parseInt((String)request.getAttribute("pid"));
		}
		
		if(!Lang.isEmpty(pid) && pid != 0){
			
			Class2 pojo = this.classMemberDao.find(pid, Class2.class);
			if(pojo != null){
				request.setAttribute("parent", pojo);
				request.setAttribute("pid", pojo.getId());
			}else{
				throw new Exception("param not exists error");
			}
							
			int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
			int pageSize = -1;//Constants.INT_PAGE_PAGESIZE_DEFAULT;
			String orderby = "id";
			List<ClassMember> list = this.classMemberDao.search(ClassMember.class, Cnd.wrap("class_id='"+pid+"'"));

			int totalCount = list==null?0:list.size();
			Pagination page = new Pagination(currentPage,pageSize,totalCount,list);
			request.setAttribute("page", page);
		}
		
	}

	@At("/ClassMember/add")
	@Ok("jsp:/jsp/ittrain/classmember/add")
	@Fail("jsp:/error")
	public void add(@Param("::ClassMember.") ClassMember pojo,@Param("pid") int pid,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new ClassMember();
		}
		request.setAttribute("ClassMember", pojo);
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
		pojo.setClass_id(pid);
	}

	@At("/ClassMember/save")
	@Ok("redirect:/ClassMember/list?pid=${pid}")
	@Fail("jsp:/error")
	public void save(@Param("::ClassMember.") ClassMember pojo,@Param("pid") int pid,
			HttpServletRequest request) throws Exception {
		request.setAttribute("pid", pid);
		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.classMemberDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.classMemberDao.update(pojo);
			}
			if(!Lang.isEmpty(pid) && pid!=0){
				Class2 class2 = this.classMemberDao.find(pid, Class2.class);
				int count = this.classMemberDao.searchCount(ClassMember.class, Cnd.wrap("class_id='"+pid+"'"));
				class2.setClass_member_num(count);
				this.classMemberDao.update(class2);
			}
		}
	}

	@At("/ClassMember/update")
	@Ok("redirect:/ClassMember/list?")
	@Fail("jsp:/error")
	public void update(@Param("::ClassMember.") ClassMember pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/ClassMember/del")
	@Ok("redirect:/ClassMember/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.classMemberDao.delById(id, DicType.class);
		}
	}

	@At("/ClassMember/dels")
	@Ok("redirect:/ClassMember/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.classMemberDao.deleteByIds(ClassMember.class, ids);
	}

	@At("/ClassMember/view")
	@Ok("jsp:/jsp/ittrain/classmember/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id,@Param("pid") int pid, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			ClassMember pojo = this.classMemberDao.find(id, ClassMember.class);
			request.setAttribute("ClassMember", pojo);
			request.setAttribute("pid", pid);
		}
	}

	@At("/ClassMember/edit")
	@Ok("jsp:/jsp/ittrain/classmember/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			ClassMember pojo = this.classMemberDao.find(id, ClassMember.class);
			request.setAttribute("ClassMember", pojo);
		}
	}

	@At("/ClassMember/check")
	@Ok("redirect:/ClassMember/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				ClassMember pojo = this.classMemberDao.find(id,
						ClassMember.class);
				pojo.setStatus(1);
				this.classMemberDao.update(pojo);
			}
		}
	}
}