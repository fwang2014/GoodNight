package com.nutz.pip.action.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
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
public class FileDownloadAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(FileDownloadAction.class);

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
	public void displayImage(@Param("id") int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("menuActive", menuCode);
		request.setAttribute("tab", tab);

		if (!Lang.isEmpty(id)) {
			FileUpload fu = fileUploadDao.find(id, FileUpload.class);
			String filePath = fu.getSave_path();
			// BufferedInputStream bis = new BufferedInputStream();

			File file = new File(filePath);
			FileInputStream tradFis = new FileInputStream(file);
			BufferedInputStream tradBis = new BufferedInputStream(tradFis);

			new PreviewImage(tradBis, response.getOutputStream());
			response.flushBuffer();

		}
	}

	private static final String CONTENT_TYPE = "text/html; charset=GBK";

	/**
	 * 文件下载
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@At("/Download")
	@Ok("raw")
	@Fail("jsp:/error")
	public void download(@Param("id") int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {

			if (!Lang.isEmpty(id) && id > 0) {
				FileUpload pojo = this.fileUploadDao.find(id, FileUpload.class);
				String filename = pojo.getSave_path();

				response.setContentType(CONTENT_TYPE);
				// 得到下载文件的名字
				// String filename=request.getParameter("filename");

				// 解决中文乱码问题
				//String filename = new String(request.getParameter("filename").getBytes("iso-8859-1"), "gbk");

				// 创建file对象
				//File file = new File("F://book//WebRoot//" + filename);
				File file = new File(filename);

				// 设置response的编码方式
				response.setContentType("application/x-msdownload");

				// 写明要下载的文件的大小
				response.setContentLength((int) file.length());

				// 设置附加文件名
				// response.setHeader("Content-Disposition","attachment;filename="+filename);

				// 解决中文乱码
				response.setHeader("Content-Disposition",
						"attachment;filename=" + new String

						(filename.getBytes("gbk"), "iso-8859-1"));

				// 读出文件到i/o流
				FileInputStream fis = new FileInputStream(file);
				BufferedInputStream buff = new BufferedInputStream(fis);

				byte[] b = new byte[1024];// 相当于我们的缓存

				long k = 0;// 该值用于计算当前实际下载了多少字节

				// 从response对象中得到输出流,准备下载

				OutputStream myout = response.getOutputStream();

				// 开始循环下载

				while (k < file.length()) {

					int j = buff.read(b, 0, 1024);
					k += j;

					// 将b中的数据写到客户端的内存
					myout.write(b, 0, j);

				}

				// 将写入到客户端的内存的数据,刷新到磁盘
				myout.flush();
			}
		} catch (Exception ex) {
			request.setAttribute("error", ex.getLocalizedMessage());
		}

	}

}
