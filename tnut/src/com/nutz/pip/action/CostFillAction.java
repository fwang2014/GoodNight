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
import com.nutz.pip.dao.user.CostFillDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.CostFill;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.cost.DicValue;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class CostFillAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(CostFillAction.class);
	
	private final String tab = "CostFill";
	private final String menuCode = "401";

	@SuppressWarnings("unused")
	@Inject
	private CostFillDao costFillDao;

	@At("/CostFill/list")
	@Ok("jsp:/jsp/CostFill/list")
	@Fail("jsp:/error")
	public void list(@Param("::CostFill.") CostFill pojo,
			HttpServletRequest request) throws Exception {
		
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		List list = this.costFillDao.search(CostFill.class, "id");
		request.setAttribute("list", list);

	}

	@At("/CostFill/add")
	@Ok("jsp:/jsp/CostFill/add")
	@Fail("jsp:/error")
	public void add(@Param("::CostFill.") CostFill pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new CostFill();
		}
		request.setAttribute("CostFill", pojo);
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
		pojo.setFill_date(MyUtil.getToday());
		pojo.setType("0");
		pojo.setStatus("0");
		pojo.setQty(1);
		pojo.setStart_value("0");
		pojo.setEnd_value("0");
		pojo.setValue_type("0");// 0：日期；1：数字

		/**
		 * 查询已审批房租类型列表集合
		 */
		List typeList = this.costFillDao
				.search(
						DicValue.class,
						Cnd
								.wrap("status ='1' and type_id in (select t1.id from tb_dic_type t1 where t1.value_type='"
										+ Constants.DIC_VALUE_TYPE_RENT
										+ "' and t1.status='1')"));
		request.setAttribute("typeList", typeList);
		/**
		 * 查询已审批陈本单位列表集合
		 */
		List unitList = this.costFillDao
				.search(
						DicValue.class,
						Cnd
								.wrap("status ='1' and type_id in (select t1.id from tb_dic_type t1 where t1.value_type='"
										+ Constants.DIC_VALUE_TYPE_UNIT
										+ "'  and t1.status='1')"));
		request.setAttribute("unitList", unitList);
	}

	@At("/CostFill/save")
	@Ok("redirect:/CostFill/list?")
	@Fail("jsp:/error")
	public void save(@Param("::CostFill.") CostFill pojo,
			HttpServletRequest request) throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId())) {
				pojo.setId(SeqNum.getPrimaryKeyForString());
				pojo.setUpdate_time(MyUtil.getCreateTime());
				this.costFillDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime());
				this.costFillDao.update(pojo);
			}
		}
	}

	@At("/CostFill/update")
	@Ok("redirect:/CostFill/list?")
	@Fail("jsp:/error")
	public void update(@Param("::CostFill.") CostFill pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
	}

	@At("/CostFill/del")
	@Ok("redirect:/CostFill/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.costFillDao.delById(id, DicType.class);
		}
	}

	@At("/CostFill/dels")
	@Ok("redirect:/CostFill/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.costFillDao.deleteByIds(CostFill.class, ids);
	}

	@At("/CostFill/view")
	@Ok("jsp:/jsp/CostFill/view")
	@Fail("jsp:/error")
	public void view(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			CostFill pojo = this.costFillDao.find(id, CostFill.class);
			request.setAttribute("CostFill", pojo);
		}
	}

	@At("/CostFill/edit")
	@Ok("jsp:/jsp/CostFill/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			CostFill pojo = this.costFillDao.find(id, CostFill.class);
			request.setAttribute("costFillDao.", pojo);
		}
	}

	@At("/CostFill/check")
	@Ok("redirect:/CostFill/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") String ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (String id : ids) {
				CostFill pojo = this.costFillDao.find(id, CostFill.class);
				pojo.setStatus("1");
				this.costFillDao.update(pojo);
			}
		}
	}

	/**
	 * 批量增加
	 * @param pojo
	 * @param request
	 * @throws Exception
	 */
	@At("/CostFill/batch_add")
	@Ok("jsp:/jsp/CostFill/batch_add")
	@Fail("jsp:/error")
	public void batch_add(@Param("::CostFill.") CostFill pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		if(pojo == null){
			pojo = new CostFill();
			request.setAttribute("CostFill", pojo);
		}
		pojo.setFill_date(MyUtil.getToday());
		
		/**
		 * 查询已审批房租类型列表集合
		 */
		List typeList = this.costFillDao
				.search(
						DicValue.class,
						Cnd
								.wrap("status ='1' and type_id in (select t1.id from tb_dic_type t1 where t1.value_type='"
										+ Constants.DIC_VALUE_TYPE_RENT
										+ "' and t1.status='1')"));
		request.setAttribute("typeList", typeList);
	}

	/**
	 * 批量保存
	 * @param pojo
	 * @param request
	 * @throws Exception
	 */
	@At("/CostFill/batch_save")
	@Ok("redirect:/CostFill/list?")
	@Fail("jsp:/error")
	public void batch_save(@Param("::CostFill.") CostFill pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		
		Object obj = request.getSession().getAttribute(Constants.KEY_LOGIN_USER);
		TSysUser user = (TSysUser) obj;
		
		if(pojo != null){
			String names[] = request.getParameterValues("name");
			String amts[] = request.getParameterValues("amt");
			String types[] = request.getParameterValues("type");
			
			if(names != null && names.length >0){
				for(int i=0;i<names.length;i++){
					String name = names[i];
					String amt = amts[i];
					String type = types[i];
					
					if(!MyUtil.isEmpty(name) && !MyUtil.isEmpty(amt)  && !MyUtil.isEmpty(type)){
						CostFill pojo2 = new CostFill();
						pojo2.setName(name);
						pojo2.setAmt(Float.valueOf(amt));
						pojo2.setType(type);
						
						pojo2.setCreate_by(user.getUser_name());
						pojo2.setFill_date(pojo.getFill_date());
						pojo2.setId(SeqNum.getPrimaryKeyForString());
						pojo2.setPrice(Float.valueOf(amt));
						pojo2.setQty(Float.valueOf("1.0"));
						pojo2.setRemark(pojo.getRemark());
						pojo2.setUpdate_by(user.getUser_name());
						pojo2.setUpdate_time(MyUtil.getCreateTime());
						pojo2.setCode(name);
						
						this.costFillDao.save(pojo2);
						
					}
				}
			}
		}

	}
	
	/**
	 * 房租填报
	 * @param pojo
	 * @param request
	 * @throws Exception
	 */
	@At("/CostFill/rent_add")
	@Ok("jsp:/jsp/CostFill/rent_add")
	@Fail("jsp:/error")
	public void rent_add(@Param("::CostFill.") CostFill pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		/**
		 * 查询已审批房租类型列表集合
		 */
		List typeList = this.costFillDao
				.search(
						DicValue.class,
						Cnd
								.wrap("status ='1' and type_id in (select t1.id from tb_dic_type t1 where t1.value_type='"
										+ Constants.DIC_VALUE_TYPE_RENT
										+ "' and t1.status='1')"));
		request.setAttribute("typeList", typeList);
	}
	
	/**
	 * 房租保存
	 * @param pojo
	 * @param request
	 * @throws Exception
	 */
	@At("/CostFill/rent_save")
	@Ok("redirect:/jsp/CostFill/list")
	@Fail("jsp:/error")
	public void rent_save(@Param("::CostFill.") CostFill pojo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
	}
}