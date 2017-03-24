package com.nutz.pip.action.ittrain;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
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
import com.nutz.pip.dao.MyTagDao;
import com.nutz.pip.dao.file.FileUploadDao;
import com.nutz.pip.dao.ittrain.ConsultDao;
import com.nutz.pip.filter.LoginFilter;
import com.nutz.pip.model.cost.DicType;
import com.nutz.pip.model.cost.DicValue;
import com.nutz.pip.model.file.FileUpload;
import com.nutz.pip.model.ittrain.Consult;
import com.nutz.pip.model.sm.sys.TSysUser;

@IocBean
@InjectName
@Filters(@By(type = LoginFilter.class, args = { "USER", "/default.jsp" }))
public class ConsultAction {
	@SuppressWarnings("unused")
	private static final Log log = Logs.getLog(ConsultAction.class);

	private final String tab = "Consult";

	@SuppressWarnings("unused")
	@Inject
	private ConsultDao consultDao;
	@Inject
	private FileUploadDao fileUploadDao;

	@At("/Consult/list")
	@Ok("jsp:/jsp/ittrain/consult/list")
	@Fail("jsp:/error")
	public void list(@Param("::Consult.") Consult pojo,@Param("cp") int cp,
			HttpServletRequest request) throws Exception {

		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", "301");
		//List list = this.consultDao.search(Consult.class, "id");
		//request.setAttribute("list", list);
		
		int currentPage = (cp>0?cp:Constants.INT_PAGE_CURRENTPAGE_DEFAULT);
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.consultDao.getPage(Consult.class, currentPage, pageSize, orderby);
		request.setAttribute("page", page);
	}

	@At("/Consult/add")
	@Ok("jsp:/jsp/ittrain/consult/add")
	@Fail("jsp:/error")
	public void add(@Param("::Consult.") Consult pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", "301");
		if (pojo == null) {
			pojo = new Consult();
		}
		request.setAttribute("Consult", pojo);
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

	@At("/Consult/save")
	@Ok("redirect:/Consult/list?")
	@Fail("jsp:/error")
	public void save(@Param("::Consult.") Consult pojo,
			HttpServletRequest request) throws Exception {

		if (pojo != null) {
			if (MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0) {
				pojo.setId(SeqNum.getPrimaryKeyForInt1());
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				pojo.setCreate_date(MyUtil.getCreateTime2());
				this.consultDao.save(pojo);
			} else {
				Object obj = request.getSession().getAttribute(
						Constants.KEY_LOGIN_USER);
				if (obj instanceof TSysUser) {
					TSysUser user = (TSysUser) obj;
					pojo.setUpdate_by(user.getUser_name());
				}
				pojo.setUpdate_time(MyUtil.getCreateTime2());
				this.consultDao.update(pojo);
			}
		}
	}

	@At("/Consult/update")
	@Ok("redirect:/Consult/list?")
	@Fail("jsp:/error")
	public void update(@Param("::Consult.") Consult pojo,
			HttpServletRequest request) throws Exception {

		request.setAttribute("menuActive", "301");
	}

	@At("/Consult/del")
	@Ok("redirect:/Consult/list?")
	@Fail("jsp:/error")
	public void del(@Param("id") String id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "301");
		if (!MyUtil.isEmpty(id)) {
			this.consultDao.delById(id, DicType.class);
		}
	}

	@At("/Consult/dels")
	@Ok("redirect:/Consult/list?")
	@Fail("jsp:/error")
	public void dels(@Param("ids") String strs[], HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "301");
		String ids = MyUtil.getIdsFromArray(strs);
		this.consultDao.deleteByIds(Consult.class, ids);
	}

	@At("/Consult/view")
	@Ok("jsp:/jsp/ittrain/consult/view")
	@Fail("jsp:/error")
	public void view(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "301");
		if (!MyUtil.isEmpty(id)) {
			Consult pojo = this.consultDao.find(id, Consult.class);
			request.setAttribute("Consult", pojo);
		}
	}

	@At("/Consult/edit")
	@Ok("jsp:/jsp/ittrain/consult/add")
	@Fail("jsp:/error")
	public void edit(@Param("id") int id, HttpServletRequest request)
			throws Exception {

		request.setAttribute("menuActive", "301");
		if (!MyUtil.isEmpty(id)) {
			Consult pojo = this.consultDao.find(id, Consult.class);
			request.setAttribute("Consult", pojo);
		}
	}

	@At("/Consult/check")
	@Ok("redirect:/Consult/list?")
	@Fail("jsp:/error")
	public void check(@Param("ids") int ids[], HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", "301");
		if (!MyUtil.isEmpty(ids)) {
			for (int id : ids) {
				Consult pojo = this.consultDao.find(id, Consult.class);
				pojo.setStatus(1);
				this.consultDao.update(pojo);
			}
		}
	}
	
	/**
	 * 准备上载图片
	 * @param ids
	 * @param request
	 * @throws Exception
	 */
	@At("/Consult/upload")
	@Ok("jsp:/jsp/ittrain/consult/upload")
	@Fail("jsp:/error")
	public void upload(HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", "301");
		
		int currentPage = Constants.INT_PAGE_CURRENTPAGE_DEFAULT;
		int pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;
		String orderby = "id";
		Pagination page = this.consultDao.getPage(Consult.class, currentPage, pageSize, orderby);
		request.setAttribute("page", page);
		
	}
	
	/**
	 * 保存上载图片
	 * @param ids
	 * @param request
	 * @throws Exception
	 */
	@At("/Consult/uploadSave")
	@Ok("redirect:/Consult/list?")
	@Fail("jsp:/error")
	public void uploadSave(@Param("id") int id, HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", "301");
		
	}
	
	/**
	 * 上载图片保存
	 * @param id
	 * @param f
	 */
	@AdaptBy(type = UploadAdaptor.class, args = { "${app.root}/WEB-INF/tmp" })
	@At("/uploadPhoto")
	@Ok("redirect:/uploadManage?")
	@Fail("jsp:/error")
	public void uploadPhoto( @Param("photo") TempFile tf,HttpServletRequest request){    	
		try{
			
			if(tf != null){
				File f = tf.getFile();                       // 这个是保存的临时文件    
				FieldMeta meta = tf.getMeta();               // 这个原本的文件信息    
				String oldName = meta.getFileLocalName();    // 这个时原本的文件名称    
				// TODO do what you wanna to do here ...}
				System.out.println("oldName:"+oldName);
			}
		}catch(Exception ex){
			request.setAttribute("error", ex.getLocalizedMessage());
		}

		
	}
	
	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	@At("/uploadPhotos")
	@Ok("redirect:/uploadManage?")
	@Fail("jsp:/error")
	public void uploadPhotos(@Param("::Consult.") Consult pojo, @Param("photo") TempFile[] tfs,HttpServletRequest request){   
		try{						
			if(tfs != null){
				for(TempFile tf:tfs){
					File f = tf.getFile();                       // 这个是保存的临时文件    
					FieldMeta meta = tf.getMeta();               // 这个原本的文件信息    
					String oldName = meta.getFileLocalName();    // 这个时原本的文件名称    
					String file_new_name = meta.getName();
					String file_size = "-1";
					String file_type = meta.getContentType();
					String save_path = f.getAbsolutePath();
					// TODO do what you wanna to do here ...}
					//System.out.println("oldName:"+oldName);
					//System.out.println("f.getAbsolutePath():"+f.getAbsolutePath());
					
					FileUpload fu = new FileUpload();
					fu.setCode(String.valueOf(MyUtil.getCurrentCode()));
					fu.setName("uploadPhotos");
					fu.setFile_new_name(file_new_name);
					fu.setFile_old_name(oldName);
					fu.setFile_size(file_size);
					fu.setFile_type(file_type);
					fu.setSave_path(save_path);
					fu.setSave_tem_path(save_path);
					fu.setCreate_date(MyUtil.getCreateTime2());
					fu.setUpdate_time(MyUtil.getCreateTime2());
					
					if(pojo != null){
						fu.setRef_id(pojo.getId());
						fu.setRef_type(tab);
					}
					
					this.fileUploadDao.save(fu);
					
				}
			}
		}catch(Exception ex){
			request.setAttribute("error", ex.getLocalizedMessage());
		}
		

	}
	
	/**
	 * 上载图片管理
	 * @param ids
	 * @param request
	 * @throws Exception
	 */
	@At("/uploadManage")
	@Ok("jsp:/jsp/ittrain/consult/uploadlist")
	@Fail("jsp:/error")
	public void uploadManage(HttpServletRequest request)
			throws Exception {
		request.setAttribute("menuActive", "301");
		
	}
	
	@At("/Consult/search")
	@Ok("jsp:/jsp/ittrain/consult/search")
	@Fail("jsp:/error")
	public void search(@Param("::Consult.") Consult pojo,HttpServletRequest request)throws Exception{
		try{
			if(pojo != null && pojo.getCode() != null){
				
			}
		}catch(Exception ex){
			request.setAttribute("error", ex.getLocalizedMessage());
		}
	}
	
	@At("/typeahead")
	@Ok("raw")
	@Fail("jsp:/error")
	public Object getDataSource(@Param("key") String key,HttpServletRequest request)throws Exception{
		StringBuffer buf = new StringBuffer();
		System.out.println("----------------------------------getDataSource:"+key);
		try{
			//["Alabama","Alaska","Arizona"]
			if(key != null && key.length() > 0){
				String str = "";
				MyTagDao dao = new MyTagDao();
				List<DicValue> list = dao.getDictValueByCode(key);
				buf.append("[");
				for(DicValue dic:list){
					buf.append("\"");
					buf.append(dic.getRemark());
					buf.append("\",");
				}
				String tem = buf.toString();
				if(tem.endsWith(",")){
					buf.setLength(0);
					buf.append(tem.substring(0, tem.length()-1));
				}
				buf.append("]");
				//List list = this.consultDao.search(DicValue.class, Cnd.wrap(str));
				System.out.println(buf.toString());
			}
		}catch(Exception ex){
			request.setAttribute("error", ex.getLocalizedMessage());
		}
		return buf.toString();
	}
}
