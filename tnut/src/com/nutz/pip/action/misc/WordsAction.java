package com.nutz.pip.action.misc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
import com.nutz.pip.dao.misc.WordsDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.misc.Words;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class WordsAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(WordsAction.class);

	private final String tab = "Words";
	private final String menuCode = "210";

	@SuppressWarnings("unused")
	@Inject
	private WordsDao wordsDao;

	@At("/Words/list")
	@Ok("jsp:/jsp/misc/words/list")
	@Fail("jsp:/error")
	public void list(@Param("::Words.") Words pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.wordsDao.search(Words.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.wordsDao.getPage(Words.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/Words/add")
	@Ok("jsp:/jsp/misc/words/add")
	@Fail("jsp:/error")
	public void add(@Param("::Words.") Words pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);

		// 防止重复提交，设置数据提交前验证字符
		request.getSession().setAttribute(Constants.KEY_REPEAT_SUBMIT,
				System.currentTimeMillis()+"");

		if (pojo == null) {
			pojo = new Words();
		}
		request.setAttribute("Words", pojo);
		Object obj = request.getSession()
				.getAttribute(Constants.KEY_LOGIN_USER);
		if (obj instanceof TSysUser) {
			TSysUser user = (TSysUser) obj;
			pojo.setCreate_by(user.getUser_name());
			pojo.setUpdate_by(user.getUser_name());
		} else {
			System.out.println(obj.getClass());
		}
		pojo.setCode(MyUtil.getToday());
		pojo.setCreate_date(new Date(System.currentTimeMillis()));
		pojo.setType("1");
		pojo.setStatus(0);
	}

	@At("/Words/save")
	@Ok("redirect:/Words/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Words.") Words pojo, HttpServletRequest request)
			throws Exception {

		/**
		 * 先验证重复提交验证码
		 */
		String token = request.getSession().getAttribute(
				Constants.KEY_REPEAT_SUBMIT) == null ? null : (String) request
				.getSession().getAttribute(Constants.KEY_REPEAT_SUBMIT);
		//Object sa = request.getSession().getAttribute("TOKEN");
		//String token = sa == null?null:(String)sa;
		String token2 = request.getParameter(Constants.KEY_REPEAT_SUBMIT);
		boolean bool = false;
		if (token != null && token.equals(token2)) {
			bool = true;
			if (pojo != null) {
				if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
					pojo.setId(SeqNum.getPrimaryKeyForInt1());
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setCreate_date(MyUtil.getCreateTime2());
					this.wordsDao.save(pojo);
				} else {
					Object obj = request.getSession().getAttribute(
							Constants.KEY_LOGIN_USER);
					if (obj instanceof TSysUser) {
						TSysUser user = (TSysUser) obj;
						pojo.setUpdate_by(user.getUser_name());
					}
					pojo.setUpdate_time(MyUtil.getCreateTime2());
					pojo.setStatus(Constants.VALUE_EDITED_STATUS);
					this.wordsDao.update(pojo);
				}
			}
		} else {
			String error = "No repeat sumbit!";
			request.setAttribute("error", error);
			throw new Exception(error);
		}
		if(!bool){
			throw new Exception("test token error");
		}
		
	}

	@At("/Words/update")
	@Ok("redirect:/Words/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Words.") Words pojo, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/Words/del")
	@Ok("redirect:/Words/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.wordsDao.delById(id, DicType.class);
		}
	}

	@At("/Words/dels")
	@Ok("redirect:/Words/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		// String ids = MyUtil.getIdsFromArray(strs);
		// this.wordsDao.deleteByIds(Words.class, ids);

		// 数据软删除
		for (String str : strs) {
			int id = Integer.parseInt(str);
			Words pojo = this.wordsDao.find(id, Words.class);
			pojo.setStatus(Constants.VALUE_DEL_STATUS);
			this.wordsDao.update(pojo);
		}

	}

	// 数据彻底删除
	@At("/Words/delss")
	@Ok("redirect:/Words/list?")
	@Fail("jsp:/error")
	public void delss(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.wordsDao.deleteByIds(Words.class, ids);
	}

	@At("/Words/view")
	@Ok("jsp:/jsp/misc/words/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Words pojo = this.wordsDao.find(id, Words.class);
			request.setAttribute("Words", pojo);
		}
	}

	@At("/Words/edit")
	@Ok("jsp:/jsp/misc/words/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Words pojo = this.wordsDao.find(id, Words.class);
			request.setAttribute("Words", pojo);
		}
	}

	@At("/Words/check")
	@Ok("redirect:/Words/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Words pojo = this.wordsDao.find(id, Words.class);
				pojo.setStatus(Constants.VALUE_CHECKED_STATUS);
				this.wordsDao.update(pojo);
			}
		}
	}
}