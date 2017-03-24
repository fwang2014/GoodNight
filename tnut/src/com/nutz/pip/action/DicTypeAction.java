package com.nutz.pip.action;

import java.sql.Date;
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
import com.nutz.pip.dao.user.DicTypeDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.cost.DicValue;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class DicTypeAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(DicTypeAction.class);
	
	private final String tab = "DicType";
	private final String menuCode = "207";

	@SuppressWarnings("unused")
	@Inject
	private DicTypeDao dicTypeDao;

	/**
	 * 数据查询列表
	 * @param pojo
	 * @param request
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@At("/DicType/list")
	@Ok("jsp:/jsp/DicType/list")
	@Fail("jsp:/error")
	public void list(@Param("::DicType.") DicType pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		List list = this.dicTypeDao.search(DicType.class, "id");
		request.setAttribute("list", list);
	}

	/**
	 * 准备新增数据
	 * @param pojo
	 * @param request
	 * @throws Exception
	 */
	@At("/DicType/add")
	@Ok("jsp:/jsp/DicType/add")
	@Fail("jsp:/error")
	public void add(@Param("::DicType.") DicType pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new DicType();
		}
		request.setAttribute("DicType", pojo);
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
		pojo.setStatus("0");

	}

	/**
	 * 保存或更新数据
	 * @param pojo
	 * @param request
	 * @throws Exception
	 */
	@At("/DicType/save")
	@Ok("redirect:/DicType/list?")
	@Fail("jsp:/error")
	public void save(@Param("::DicType.") DicType pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		if (pojo != null ) {
			if(MyUtil.isEmpty(pojo.getId())){
				pojo.setId(SeqNum.getPrimaryKeyForString());
				pojo.setUpdate_time(MyUtil.getCreateTime());
				this.dicTypeDao.save(pojo);
			}else{
				Object obj = request.getSession().getAttribute(Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}				
				pojo.setUpdate_time(MyUtil.getCreateTime());
				this.dicTypeDao.update(pojo);
			}			
		}
	}

	/**
	 * 更新单条记录
	 * @param pojo
	 * @param request
	 * @throws Exception
	 */
	@At("/DicType/update")
	@Ok("redirect:/DicType/list")
	@Fail("jsp:/error")
	public void update(@Param("::DicType.") DicType pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
	}

	/**
	 * 删除单条记录
	 * @param id
	 * @param request
	 * @throws Exception
	 */
	@At("/DicType/del")
	@Ok("redirect:/DicType/list")
	@Fail("jsp:/error")
	public void del(@Param("id") String id,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if(!MyUtil.isEmpty(id)){
			this.dicTypeDao.delById(id, DicType.class);
		}
	}

	/**
	 * 删除多条记录
	 * @param strs
	 * @param request
	 * @throws Exception
	 */
	@At("/DicType/dels")
	@Ok("redirect:/DicType/list")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.dicTypeDao.deleteByIds(DicType.class, ids);
	}

	/**
	 * 查看选中数据信息
	 * @param id
	 * @param request
	 * @throws Exception
	 */
	@At("/DicType/view")
	@Ok("jsp:/jsp/DicType/view")
	@Fail("jsp:/error")
	public void view(@Param("id") String id, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if(!MyUtil.isEmpty(id)){
			DicType pojo = this.dicTypeDao.find(id, DicType.class);
			request.setAttribute("DicType", pojo);
		}
	}
	
	/**
	 * 准备编辑数据
	 * @param id
	 * @param request
	 * @throws Exception
	 */
	@At("/DicType/edit")
	@Ok("jsp:/jsp/DicType/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") String id, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if(!MyUtil.isEmpty(id)){
			DicType pojo = this.dicTypeDao.find(id, DicType.class);
			request.setAttribute("DicType", pojo);
		}
	}
	
	/**
	 * 数据审核
	 * @param id
	 * @param request
	 * @throws Exception
	 */
	@At("/DicType/check")
	@Ok("redirect:/DicType/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") String ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if(!MyUtil.isEmpty(ids)){
			for(String id:ids){
				DicType pojo = this.dicTypeDao.find(id, DicType.class);
				pojo.setStatus("1");
				this.dicTypeDao.update(pojo);
			}			
		}
	}

}