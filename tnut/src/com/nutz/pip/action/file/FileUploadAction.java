package com.nutz.pip.action.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.nutz.pip.common.PreviewImage;
import com.nutz.pip.common.SeqNum;
import com.nutz.pip.dao.file.FileUploadDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.file.FileUpload;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class FileUploadAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(FileUploadAction.class);

	private final String tab = "FileUpload";
	private final String menuCode = "503";

	@SuppressWarnings("unused")
	@Inject
	private FileUploadDao fileUploadDao;

	@At("/FileUpload/list")
	@Ok("jsp:/jsp/file/list")
	@Fail("jsp:/error")
	public void list(@Param("::FileUpload.") FileUpload pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		List list = this.fileUploadDao.search(FileUpload.class, "id");
		request.setAttribute("list", list);
	}

	@At("/FileUpload/add")
	@Ok("jsp:/jsp/file/add")
	@Fail("jsp:/error")
	public void add(@Param("::FileUpload.") FileUpload pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
		request.setAttribute("tab", tab);
		if (pojo == null) {
			pojo = new FileUpload();
		}
		request.setAttribute("FileUpload", pojo);
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

	@At("/FileUpload/save")
	@Ok("redirect:/FileUpload/list?")
	@Fail("jsp:/error")
	public void save(@Param("::FileUpload.") FileUpload pojo,
			HttpServletRequest request) throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.fileUploadDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.fileUploadDao.update(pojo);
			}
		}
	}

	@At("/FileUpload/update")
	@Ok("redirect:/FileUpload/list?")
	@Fail("jsp:/error")
	public void update(@Param("::FileUpload.") FileUpload pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
		request.setAttribute("tab", tab);
	}

	@At("/FileUpload/del")
	@Ok("redirect:/FileUpload/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		request.setAttribute("tab", tab);
		if (!MyUtil.isEmpty(id)) {
			this.fileUploadDao.delById(id, DicType.class);
		}
	}

	@At("/FileUpload/dels")
	@Ok("redirect:/FileUpload/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		request.setAttribute("tab", tab);
		String ids = MyUtil.getIdsFromArray(strs);
		this.fileUploadDao.deleteByIds(FileUpload.class, ids);
	}

	@At("/FileUpload/view")
	@Ok("jsp:/jsp/file/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		request.setAttribute("tab", tab);
		if (!MyUtil.isEmpty(id)) {
			FileUpload pojo = this.fileUploadDao.find(id, FileUpload.class);
			request.setAttribute("FileUpload", pojo);
		}
	}

	@At("/FileUpload/edit")
	@Ok("jsp:/jsp/file/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		request.setAttribute("tab", tab);
		if (!MyUtil.isEmpty(id)) {
			FileUpload pojo = this.fileUploadDao.find(id, FileUpload.class);
			request.setAttribute("FileUpload", pojo);
		}
	}

	@At("/FileUpload/check")
	@Ok("redirect:/FileUpload/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		request.setAttribute("tab", tab);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				FileUpload pojo = this.fileUploadDao.find(id, FileUpload.class);
				pojo.setStatus(1);
				this.fileUploadDao.update(pojo);
			}
		}
	}
	
	@At("/displayImage")
	@Ok("raw")
	@Fail("jsp:/error")
	public void displayImage(@Param("id") int id, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		request.setAttribute("tab", tab);
		
		if(!Lang.isEmpty(id)){
			FileUpload fu = fileUploadDao.find(id, FileUpload.class);
			String filePath = fu.getSave_path();
			//BufferedInputStream bis = new BufferedInputStream();
			
			File file = new File(filePath);  
			FileInputStream tradFis = new FileInputStream(file);  
			BufferedInputStream tradBis = new BufferedInputStream(tradFis); 
			
			new PreviewImage(tradBis,response.getOutputStream());   
			response.flushBuffer();
			
		}
	}
}
