package com.nutz.pip.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
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
import com.nutz.pip.dao.user.DicValueDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.cost.DicValue;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class DicValueAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(DicValueAction.class);
	
	private final String tab = "DicValue";
	private final String menuCode = "207";

	@SuppressWarnings("unused")
	@Inject
	private DicValueDao dicValueDao;

	@At("/DicValue/list")
	@Ok("jsp:/jsp/DicValue/list")
	@Fail("jsp:/error")
	public void list(@Param("typeId") String typeId, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if(MyUtil.isEmpty(typeId)){
			typeId = (String)request.getSession().getAttribute("DicValue.typeId");
		}
		
		if (!MyUtil.isEmpty(typeId)) {
			request.getSession().setAttribute("DicValue.typeId", typeId);
			String name = "type_id";
			String op = "=";
			String value = typeId;
			List list = this.dicValueDao.search(DicValue.class, Cnd.where(name,
					op, value));
			request.setAttribute("list", list);
			
			DicType pojo = this.dicValueDao.find(value, DicType.class);
			request.setAttribute("DicType", pojo);
		}
	}

	@At("/DicValue/add")
	@Ok("jsp:/jsp/DicValue/add")
	@Fail("jsp:/error")
	public void add(@Param("::DicValue.") DicValue pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new DicValue();
		}
		request.setAttribute("DicValue", pojo);

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

	@At("/DicValue/save")
	@Ok("redirect:/DicValue/list?")
	@Fail("jsp:/error")
	public void save(@Param("::DicValue.") DicValue pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo != null ) {
			if(MyUtil.isEmpty(pojo.getId())){
				pojo.setId(SeqNum.getPrimaryKeyForString());
				pojo.setUpdate_time(MyUtil.getCreateTime());
				this.dicValueDao.save(pojo);
			}else{
				Object obj = request.getSession().getAttribute(Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}				
				pojo.setUpdate_time(MyUtil.getCreateTime());
				this.dicValueDao.update(pojo);
			}			
		}
	}

	@At("/DicValue/update")
	@Ok("jsp:/jsp/DicValue/list")
	@Fail("jsp:/error")
	public void update(@Param("::DicValue.") DicValue pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
	}

	@At("/DicValue/del")
	@Ok("jsp:/jsp/DicValue/list")
	@Fail("jsp:/error")
	public void del(@Param("::DicValue.") DicValue pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
	}

	@At("/DicValue/dels")
	@Ok("redirect:/DicValue/list")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.dicValueDao.deleteByIds(DicType.class, ids);
	}

	@At("/DicValue/view")
	@Ok("jsp:/jsp/DicValue/view")
	@Fail("jsp:/error")
	public void view(@Param("id") String id, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if(!MyUtil.isEmpty(id)){
			DicValue pojo = this.dicValueDao.find(id, DicValue.class);
			request.setAttribute("DicValue", pojo);
		}
	}
	
	@At("/DicValue/edit")
	@Ok("jsp:/jsp/DicValue/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") String id, HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if(!MyUtil.isEmpty(id)){
			DicValue pojo = this.dicValueDao.find(id, DicValue.class);
			request.setAttribute("DicValue", pojo);
		}
	}
	
	/**
	 * 数据审核
	 * @param id
	 * @param request
	 * @throws Exception
	 */
	@At("/DicValue/check")
	@Ok("redirect:/DicValue/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") String ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if(!MyUtil.isEmpty(ids)){
			for(String id:ids){
				DicValue pojo = this.dicValueDao.find(id, DicValue.class);
				pojo.setStatus("1");
				this.dicValueDao.update(pojo);
			}			
		}
	}

}