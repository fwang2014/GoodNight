package com.nutz.pip.action.customer;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.random.StringGenerator;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.FieldMeta;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import com.nutz.pip.Constants;
import com.nutz.pip.common.MyUtil;
import com.nutz.pip.common.SeqNum;
import com.nutz.pip.common.page.Pagination;
import com.nutz.pip.dao.customer.CustomerDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.customer.Customer;
import com.nutz.pip.model.file.FileUpload;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class CustomerAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(CustomerAction.class);

	private final String tab = "Customer";
	private final String menuCode = "601";

	@SuppressWarnings("unused")
	@Inject
	private CustomerDao customerDao;

	@At("/Customer/list")
	@Ok("jsp:/jsp/customer/customer/list")
	@Fail("jsp:/error")
	public void list(@Param("::Customer.") Customer pojo, @Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		// List list = this.customerDao.search(Customer.class, "id");
		// request.setAttribute("list", list);
		int currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.customerDao.getPage(Customer.class, currentPage,
				pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/Customer/add")
	@Ok("jsp:/jsp/customer/customer/add")
	@Fail("jsp:/error")
	public void add(@Param("::Customer.") Customer pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (pojo == null) {
			pojo = new Customer();
		}
		request.setAttribute("Customer", pojo);
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
		pojo.setCode(MyUtil.getToday()+new StringGenerator(4).next());
	}

	@At("/Customer/save")
	@Ok("redirect:/Customer/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Customer.") Customer pojo,
			HttpServletRequest request) throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.customerDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.customerDao.update(pojo);
			}
		}
	}

	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	@At("/Customer/saveAll")
	@Ok("redirect:/Customer/list?")
	@Fail("jsp:/error")
	public void saveAll(@Param("::Customer.") Customer pojo,
			@Param("theFile") TempFile[] tfs, HttpServletRequest request)
			throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				pojo = this.customerDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.customerDao.update(pojo);
			}
		}

		try {
			if (tfs != null) {
				for (TempFile tf : tfs) {
					File f = tf.getFile(); // 这个是保存的临时文件
					FieldMeta meta = tf.getMeta(); // 这个原本的文件信息
					String oldName = meta.getFileLocalName(); // 这个时原本的文件名称
					String file_new_name = meta.getName();
					String file_size = "-1";
					String file_type = meta.getContentType();
					String save_path = f.getAbsolutePath();
					// TODO do what you wanna to do here ...}
					// System.out.println("oldName:"+oldName);
					// System.out.println("f.getAbsolutePath():"+f.getAbsolutePath());

					FileUpload fu = new FileUpload();
					fu.setCode(String.valueOf(MyUtil.getCurrentCode()));
					fu.setName(tab);
					fu.setFile_new_name(oldName);
					fu.setFile_old_name(oldName);
					fu.setFile_size(file_size);
					fu.setFile_type(file_type);
					fu.setSave_path(save_path);
					fu.setSave_tem_path(save_path);
					fu.setCreate_date(MyUtil.getCreateTime2());
					fu.setUpdate_time(MyUtil.getCreateTime2());

					if (pojo != null) {
						fu.setRef_id(pojo.getId());
						fu.setRef_type(tab);
						fu.setRef_type(tab);
					}
					this.customerDao.save(fu);
					// this.fileUploadDao.save(fu);

				}
			}
		} catch (Exception ex) {
			request.setAttribute("error", ex.getLocalizedMessage());
		}
	}

	@At("/Customer/update")
	@Ok("redirect:/Customer/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Customer.") Customer pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", menuCode);
	}

	@At("/Customer/del")
	@Ok("redirect:/Customer/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			this.customerDao.delById(id, DicType.class);
		}
	}

	@At("/Customer/dels")
	@Ok("redirect:/Customer/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", menuCode);
		String ids = MyUtil.getIdsFromArray(strs);
		this.customerDao.deleteByIds(Customer.class, ids);
	}

	@At("/Customer/view")
	@Ok("jsp:/jsp/customer/customer/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Customer pojo = this.customerDao.find(id, Customer.class);
			request.setAttribute("Customer", pojo);
			
			List<FileUpload> fileList = this.customerDao.search(FileUpload.class, Cnd.where("ref_id", "=", pojo.getId()));
			request.setAttribute("fileList", fileList);
		}
	}

	@At("/Customer/edit")
	@Ok("jsp:/jsp/customer/customer/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(id)) {
			Customer pojo = this.customerDao.find(id, Customer.class);
			request.setAttribute("Customer", pojo);
			
			List<FileUpload> fileList = this.customerDao.search(FileUpload.class, Cnd.where("ref_id", "=", pojo.getId()));
			request.setAttribute("fileList", fileList);
		}
	}

	@At("/Customer/check")
	@Ok("redirect:/Customer/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", menuCode);
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Customer pojo = this.customerDao.find(id, Customer.class);
				pojo.setStatus(1);
				this.customerDao.update(pojo);
			}
		}
	}
}