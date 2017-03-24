package com.nutz.pip.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutz.pip.dao.user.CostDao;
import com.nutz.pip.model.cost.CostType;

@IocBean
@InjectName
/*
 * * 系统用户控制器
 */
public class CostAction {
	private static final Log log = Logs.getLog(CostAction.class);

	@Inject
	private CostDao costDao;

	@At("/cost/index")
	@Ok("jsp:/jsp/cost/houseRent")
	@Fail("jsp:/error")
	/*
	 * * 房租水电费用管理首页
	 */
	public void index(@Param("ma") String ma, HttpServletRequest request)
			throws Exception {
		try {
			request.setAttribute("menuActive", ma);

			List<CostType> list = costDao.search(CostType.class, "id");
			request.setAttribute("list", list);

			// log.info("CostAction.index");
			// int count = costDao.searchCount(TSysUser.class);
			// System.out.println("count:"+count);
		} catch (Exception ex) {
			request.setAttribute("error", ex);
			throw new Exception(ex);
		}

	}

	/**
	 * 新增类型
	 * @param request
	 * @throws Exception
	 */
	@At("/cost/add")
	@Ok("jsp:/jsp/cost/houseRentAdd")
	@Fail("jsp:/error")
	public void toAdd(HttpServletRequest request) throws Exception {
		try {
			request.setAttribute("menuActive", "101");

		} catch (Exception ex) {
			request.setAttribute("error", ex);
			throw new Exception(ex);
		}

	}

	/**
	 * 保存类型
	 * @param costtype
	 * @param request
	 * @throws Exception
	 */
	@At("/cost/save")
	@Ok("jsp:/jsp/cost/houseRent")
	@Fail("jsp:/error")
	public void doSave(@Param("::form.") CostType costtype,
			HttpServletRequest request) throws Exception {
		try {
			request.setAttribute("menuActive", "101");
			costDao.save(costtype);
		} catch (Exception ex) {
			request.setAttribute("error", ex);
			throw new Exception(ex);
		}

	}
	
	/**
	 * 更新类型
	 * @param costtype
	 * @param request
	 * @throws Exception
	 */
	@At("/cost/update")
	@Ok("jsp:/jsp/cost/houseRent")
	@Fail("jsp:/error")
	public void doUpdate(@Param("::form.") CostType costtype,
			HttpServletRequest request) throws Exception {
		try {
			request.setAttribute("menuActive", "101");
			costDao.update(costtype);
		} catch (Exception ex) {
			request.setAttribute("error", ex);
			throw new Exception(ex);
		}

	}
	
	/**
	 * 删除类型
	 * @param costtype
	 * @param request
	 * @throws Exception
	 */
	@At("/cost/delIds")
	@Ok("jsp:/jsp/cost/houseRent")
	@Fail("jsp:/error")
	public void doUpdate(@Param("ids") String ids,
			HttpServletRequest request) throws Exception {
		try {
			request.setAttribute("menuActive", "101");
			costDao.deleteByIds(CostType.class, ids);
		} catch (Exception ex) {
			request.setAttribute("error", ex);
			throw new Exception(ex);
		}

	}

}
