package com.nutz.pip.dao.sys;

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
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.sm.sys.TSysUser;
import com.nutz.pip.model.sys.RoleMenu;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class RoleMenuAction {
@SuppressWarnings("unused")
private static final org.nutz.log.Log log = org.nutz.log.Logs.getLog(RoleMenuAction.class);

private final String tab = "RoleMenu";
private final String menuCode = "205";

@SuppressWarnings("unused")
@Inject
private RoleMenuDao roleMenuDao;

	@At("/RoleMenu/list")
	@Ok("jsp:/jsp/sys/rolemenu/list")
	@Fail("jsp:/error")
	public void list(@Param("::RoleMenu.") RoleMenu pojo,@Param("cp") int cp,HttpServletRequest request)  throws Exception {

	request.setAttribute("tab", tab);
	request.setAttribute("menuActive", menuCode);
	//List list = this.roleMenuDao.search(RoleMenu.class, "id");
	//request.setAttribute("list", list);
	int currentPage = (cp>0?cp:Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
	int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
	String orderby = "id";
	Pagination page = this.roleMenuDao.getPage(RoleMenu.class, currentPage, pageSize, orderby);
	request.setAttribute("page", page);
	}

	@At("/RoleMenu/add")
	@Ok("jsp:/jsp/sys/rolemenu/add")
	@Fail("jsp:/error")
	public void add(@Param("::RoleMenu.") RoleMenu pojo,HttpServletRequest request)  throws Exception {

	request.setAttribute("tab", tab);
	request.setAttribute("menuActive", menuCode);
	if (pojo == null) {
	pojo = new RoleMenu();
	}
	request.setAttribute("RoleMenu", pojo);
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

	@At("/RoleMenu/save")
	@Ok("redirect:/RoleMenu/list?")
	@Fail("jsp:/error")
	public void save(@Param("::RoleMenu.") RoleMenu pojo,HttpServletRequest request)  throws Exception {

	if (pojo != null ) {
	if(MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0 ){
	pojo.setId(SeqNum.getPrimaryKeyForInt1());
	pojo.setUpdate_time(MyUtil.getCreateTime2());
	pojo.setCreate_date(MyUtil.getCreateTime2());
	this.roleMenuDao.save(pojo);
	}else{
	Object obj = request.getSession().getAttribute(Constants.KEY_LOGIN_USER);
	if (obj instanceof TSysUser) {
	TSysUser user = (TSysUser) obj;
	pojo.setUpdate_by(user.getUser_name());
	}				
	pojo.setUpdate_time(MyUtil.getCreateTime2());
	this.roleMenuDao.update(pojo);
	}		
	}
	}

	@At("/RoleMenu/update")
	@Ok("redirect:/RoleMenu/list?")
	@Fail("jsp:/error")
	public void update(@Param("::RoleMenu.") RoleMenu pojo,HttpServletRequest request)  throws Exception {

	request.setAttribute("menuActive", menuCode);
	}

	@At("/RoleMenu/del")
	@Ok("redirect:/RoleMenu/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id,HttpServletRequest request)  throws Exception {

	request.setAttribute("menuActive", menuCode);
		if(!MyUtil.isEmpty(id)){
		this.roleMenuDao.delById(id, DicType.class);
		}
	}

	@At("/RoleMenu/dels")
	@Ok("redirect:/RoleMenu/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[],HttpServletRequest request)  throws Exception {

	request.setAttribute("menuActive", menuCode);
	String ids = MyUtil.getIdsFromArray(strs);
	this.roleMenuDao.deleteByIds(RoleMenu.class, ids);
	}

	@At("/RoleMenu/view")
	@Ok("jsp:/jsp/sys/rolemenu/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id,HttpServletRequest request)  throws Exception {

	request.setAttribute("tab", tab);
	request.setAttribute("menuActive", menuCode);
	if(!MyUtil.isEmpty(id)){
	RoleMenu pojo = this.roleMenuDao.find(id, RoleMenu.class);
	request.setAttribute("RoleMenu", pojo);
	}
	}

	@At("/RoleMenu/edit")
	@Ok("jsp:/jsp/sys/rolemenu/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id,HttpServletRequest request)  throws Exception {

	request.setAttribute("tab", tab);
	request.setAttribute("menuActive", menuCode);
	if(!MyUtil.isEmpty(id)){
	RoleMenu pojo = this.roleMenuDao.find(id, RoleMenu.class);
	request.setAttribute("RoleMenu", pojo);
	}
	}

	@At("/RoleMenu/check")
	@Ok("redirect:/RoleMenu/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
	throws Exception {
	request.setAttribute("menuActive", menuCode);
	if(!MyUtil.isEmpty(ids)){
	for(int id:ids){
	RoleMenu pojo = this.roleMenuDao.find(id, RoleMenu.class);
	pojo.setStatus(1);
	this.roleMenuDao.update(pojo);
	}			
	}
	}
}