package gen.java;

import gen.test.Test;

import java.io.PrintStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.lang.Lang;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutz.pip.Constants;
import com.nutz.pip.common.page.Pagination;
import com.nutz.pip.common.page.SearchForm;
import com.nutz.pip.model.ittrain.Consult;
import com.nutz.pip.model.misc.SysBean;
import com.nutz.pip.model.misc.Words;


public class JavaUtil {
	
	public void outAction(List<String[]> list,String table,String module){
		PrintStream ps = Test.getOut();
		
		table = Test.getClassNameByTable(table);
		String variable = Test.getVariableByString(table);
		
		ps.println("----------------------------this is data "+table+" table java action start------------------------------");
		ps.println();
		
		ps.println("@IocBean");
		ps.println("@InjectName");
		ps.println("@Filters(@By(type = LoginFilter.class, args = { \"USER\", \"/default.jsp\" }))");
		ps.println("public class "+table+"Action {");
		
		ps.println("@SuppressWarnings(\"unused\")");
		ps.println("private static final org.nutz.log.Log log = org.nutz.log.Logs.getLog("+table+"Action.class);");
		ps.println();
		ps.println("private final String tab = \""+table+"\";");
		ps.println("private final String menuCode = \"101\";");
		ps.println();
		ps.println("@SuppressWarnings(\"unused\")");
		ps.println("@Inject");
		ps.println("private "+table+"Dao "+variable+"Dao;");
		ps.println();
		
		//search and export excel start
		ps.println("\t/**");
		ps.println("\t* 查询 编码，名称，类型，状态，开始时间和结束时间");
		ps.println("\t * @param pojo");
		ps.println("\t * @param cp");
		ps.println("\t* @param request");
		ps.println("\t* @throws Exception");
		ps.println("\t*/");
		ps.println("\t@At(\"/"+table+"/search\")");
		ps.println("\t@Ok(\"jsp:/jsp/"+module+"/"+table.toLowerCase()+"/searchlist\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void search(@Param(\"::search.\") SearchForm form, @Param(\"cp\") int cp,");
		ps.println("\tHttpServletRequest request) throws Exception {");
		ps.println("\t//System.out.println(\"SysBeanAction.search\");");
		ps.println("\trequest.setAttribute(\"tab\", tab);");
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		ps.println("\trequest.setAttribute(\"search\", form);");
		ps.println("\t");
		ps.println("\tint currentPage = (cp > 0 ? cp : Constants.INT_PAGE_CURRENTPAGE_DEFAULT);");
		ps.println("\tint pageSize = Constants.INT_PAGE_PAGESIZE_SEARCH;");
		ps.println("\t");
		ps.println("\tList<"+table+"> list = null;");
		ps.println("\tint count = 0;");
		ps.println("\tif(!Lang.isEmpty(form.getCode()) && form.getCode().length()>0){");
		ps.println("\tlist = "+variable+"Dao.searchByPage("+table+".class, Cnd.where(\"code\", \"like\", \"%\"+form.getCode()+\"%\"), currentPage, pageSize);");
		ps.println("\tcount = "+variable+"Dao.searchCount("+table+".class, Cnd.where(\"code\", \"like\", \"%\"+form.getCode()+\"%\"));");
		ps.println("\tPagination page = new Pagination(currentPage,pageSize,count,list);");
		ps.println("\trequest.setAttribute(\"page\", page);");
		ps.println("\t}else ");
		ps.println("\tif(!Lang.isEmpty(form.getName()) && form.getName().length()>0){");
		ps.println("\tlist = "+variable+"Dao.searchByPage("+table+".class, Cnd.where(\"name\", \"like\", \"%\"+form.getName()+\"%\"), currentPage, pageSize);");
		ps.println("\tcount = "+variable+"Dao.searchCount("+table+".class, Cnd.where(\"name\", \"like\", \"%\"+form.getName()+\"%\"));");
		ps.println("\tPagination page = new Pagination(currentPage,pageSize,count,list);");
		ps.println("\trequest.setAttribute(\"page\", page);");
		ps.println("\t}else ");
		ps.println("\tif(!Lang.isEmpty(form.getType()) && form.getType().length()>0){");
		ps.println("\tlist = "+variable+"Dao.searchByPage("+table+".class, Cnd.where(\"type\", \"like\", \"%\"+form.getType()+\"%\"), currentPage, pageSize);");
		ps.println("\tcount = "+variable+"Dao.searchCount("+table+".class, Cnd.where(\"type\", \"like\", \"%\"+form.getType()+\"%\"));");
		ps.println("\tPagination page = new Pagination(currentPage,pageSize,count,list);");
		ps.println("\trequest.setAttribute(\"page\", page);");
		ps.println("\t}else ");
		ps.println("\tif(!Lang.isEmpty(form.getStatus()) && form.getStatus().length()>0){");
		ps.println("\tlist = "+variable+"Dao.searchByPage("+table+".class, Cnd.where(\"status\", \"like\", \"%\"+form.getStatus()+\"%\"), currentPage, pageSize);");
		ps.println("\tcount = "+variable+"Dao.searchCount("+table+".class, Cnd.where(\"status\", \"like\", \"%\"+form.getStatus()+\"%\"));");
		ps.println("\tPagination page = new Pagination(currentPage,pageSize,count,list);");
		ps.println("\trequest.setAttribute(\"page\", page);");
		ps.println("\t}else ");
		ps.println("\t//如果开始或结束时间有不为空的");
		ps.println("\tif(!Lang.isEmpty(form.getStartDate()) || !Lang.isEmpty(form.getEndDate())){");
		ps.println("\t//如果开始和结束时间都不为空");
		ps.println("\tif(!Lang.isEmpty(form.getStartDate()) && form.getStartDate().length()>0 && !Lang.isEmpty(form.getEndDate()) && form.getEndDate().length()>0){");
		ps.println("\tlist = "+variable+"Dao.searchByPage("+table+".class, ");
		ps.println("\tCnd.where(\"update_time\", \">=\", form.getStartDate()).and(\"update_time\", \"<=\", form.getEndDate()), currentPage, pageSize);");
		ps.println("\tcount = "+variable+"Dao.searchCount("+table+".class, ");
		ps.println("\tCnd.where(\"update_time\", \">=\", form.getStartDate()).and(\"update_time\", \"<=\", form.getEndDate()));");
		ps.println("\tPagination page = new Pagination(currentPage,pageSize,count,list);");
		ps.println("\trequest.setAttribute(\"page\", page);");
		ps.println("\t}else{");
		ps.println("\t//如果开始时间不为空");
		ps.println("\tif(!Lang.isEmpty(form.getStartDate())){");
		ps.println("\tlist = "+variable+"Dao.searchByPage("+table+".class, ");
		ps.println("\tCnd.where(\"update_time\", \">=\", form.getStartDate()), currentPage, pageSize);");
		ps.println("\tcount = "+variable+"Dao.searchCount("+table+".class, ");
		ps.println("\tCnd.where(\"update_time\", \">=\", form.getStartDate()));");
		ps.println("\tPagination page = new Pagination(currentPage,pageSize,count,list);");
		ps.println("\trequest.setAttribute(\"page\", page);");
		ps.println("\t}else{//结束时间不为空");
		ps.println("\tlist = "+variable+"Dao.searchByPage("+table+".class, ");
		ps.println("\tCnd.where(\"update_time\", \"<=\", form.getStartDate()), currentPage, pageSize);");
		ps.println("\tcount = "+variable+"Dao.searchCount("+table+".class, ");
		ps.println("\tCnd.where(\"update_time\", \"<=\", form.getStartDate()));");
		ps.println("\tPagination page = new Pagination(currentPage,pageSize,count,list);");
		ps.println("\trequest.setAttribute(\"page\", page);");
		ps.println("\t}");
		ps.println("\t}");
		ps.println("\t}");
		ps.println("\t}");
		ps.println("");
		ps.println("\t@At(\"/"+table+"/exportAll\")");
		ps.println("\t@Ok(\"jsp:/jsp/"+module+"/"+table.toLowerCase()+"/exportall\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void exportExcelAll(@Param(\"::search.\") SearchForm form, @Param(\"cp\") int cp,");
		ps.println("\tHttpServletRequest request) throws Exception {");
		ps.println("\t//System.out.println(\"SysBeanAction.exportExcelAll\");");
		ps.println("\tthis.search(form, cp, request);");
		ps.println("\tPagination page = (Pagination)request.getAttribute(\"page\");");
		ps.println("\t//System.out.println(page.getList().size());");
		ps.println("\t}");
		ps.println("");
		//search end
		
		//list method
		ps.println("\t@At(\"/"+table+"/list\")");
		ps.println("\t@Ok(\"jsp:/jsp/"+module+"/"+table.toLowerCase()+"/list\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void list(@Param(\"::"+table+".\") "+table+" pojo,@Param(\"cp\") int cp,HttpServletRequest request)  throws Exception {");
		ps.println();
		
		ps.println("\trequest.setAttribute(\"tab\", tab);");
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		ps.println("\t//List list = this."+variable+"Dao.search("+table+".class, \"id\");");
		ps.println("\t//request.setAttribute(\"list\", list);");
		
		ps.println("\tint currentPage = (cp>0?cp:Constants.INT_PAGE_CURRENTPAGE_DEFAULT);");
		ps.println("\tint pageSize = Constants.INT_PAGE_PAGESIZE_DEFAULT;");
		ps.println("\tString orderby = \"id\";");
		ps.println("\tPagination page = this."+variable+"Dao.getPage("+table+".class, currentPage, pageSize, orderby);");
		ps.println("\trequest.setAttribute(\"page\", page);");
		
		ps.println("\t}");
		ps.println();
		
		//add method
		ps.println("\t@At(\"/"+table+"/add\")");
		ps.println("\t@Ok(\"jsp:/jsp/"+module+"/"+table.toLowerCase()+"/add\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void add(@Param(\"::"+table+".\") "+table+" pojo,HttpServletRequest request)  throws Exception {");
		ps.println();
		
		ps.println("\trequest.setAttribute(\"tab\", tab);");
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		
		ps.println("\t// 防止重复提交，设置数据提交前验证字符");
		ps.println("\trequest.getSession().setAttribute(Constants.KEY_REPEAT_SUBMIT,");
		ps.println("\tSystem.currentTimeMillis()+\"\");");
		
		ps.println("\tif (pojo == null) {");
		ps.println("\tpojo = new "+table+"();");
		ps.println("\t}");
		ps.println("\trequest.setAttribute(\""+table+"\", pojo);");
		ps.println("\tObject obj = request.getSession()");
		ps.println("\t.getAttribute(Constants.KEY_LOGIN_USER);");
		ps.println("\tif (obj instanceof TSysUser) {");
		ps.println("\tTSysUser user = (TSysUser) obj;");
		ps.println("\tpojo.setCreate_by(user.getUser_name());");
		ps.println("\tpojo.setUpdate_by(user.getUser_name());");
		ps.println("\t} else {");
		ps.println("\tSystem.out.println(obj.getClass());");
		ps.println("\t}");
		ps.println("\tpojo.setCreate_date(new Date(System.currentTimeMillis()));");
		ps.println("\tpojo.setType(\"0\");");
		ps.println("\tpojo.setStatus(0);");
		
		ps.println("\t}");
		ps.println();
		
		//save method
		ps.println("\t@At(\"/"+table+"/save\")");
		ps.println("\t@Ok(\"redirect:/"+table+"/list?\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void save(@Param(\"::"+table+".\") "+table+" pojo,HttpServletRequest request)  throws Exception {");
		ps.println();
		
		/*ps.println("\trequest.setAttribute(\"menuActive\", \"105\");");
		ps.println("\tif (pojo != null && MyUtil.isEmpty(pojo.getId())) {");
		ps.println("\tpojo.setId(SeqNum.getPrimaryKeyForString());");
		ps.println("\tpojo.setUpdate_time(MyUtil.getCreateTime());");
		ps.println("\tthis."+variable+"Dao.save(pojo);");
		ps.println("\t}");*/
		
		ps.println("\t/**");
		ps.println("\t * 先验证重复提交验证码");
		ps.println("\t*/");
		ps.println("\tString token = request.getSession().getAttribute(");
		ps.println("\tConstants.KEY_REPEAT_SUBMIT) == null ? null : (String) request");
		ps.println("\t.getSession().getAttribute(Constants.KEY_REPEAT_SUBMIT);");
		ps.println("\tString token2 = request.getParameter(Constants.KEY_REPEAT_SUBMIT);");
		
		ps.println("\tif (token != null && token.equals(token2)) {");
		
		ps.println("\tif (pojo != null ) {");
		ps.println("\tif(MyUtil.isEmpty(pojo.getId()) || pojo.getId() == 0 ){");
		
		//update by fwang 20130923
		//ps.println("\tpojo.setId(SeqNum.getPrimaryKeyForString());");
		ps.println("\tpojo.setId(SeqNum.getPrimaryKeyForInt1());");
		
		ps.println("\tpojo.setUpdate_time(MyUtil.getCreateTime2());");
		//add by fwang 2013.09.23
		ps.println("\tpojo.setCreate_date(MyUtil.getCreateTime2());");
		
		ps.println("\tthis."+variable+"Dao.save(pojo);");
		ps.println("\t}else{");
		ps.println("\tObject obj = request.getSession().getAttribute(Constants.KEY_LOGIN_USER);");
		ps.println("\tif (obj instanceof TSysUser) {");
		ps.println("\tTSysUser user = (TSysUser) obj;");
		ps.println("\tpojo.setUpdate_by(user.getUser_name());");
		ps.println("\t}				");
		ps.println("\tpojo.setUpdate_time(MyUtil.getCreateTime2());");
		ps.println("\tpojo.setStatus(Constants.VALUE_EDITED_STATUS);");
		ps.println("\tthis."+variable+"Dao.update(pojo);");
		ps.println("\t}		");	
		ps.println("\t}");
		
		ps.println("\t} else {");
		ps.println("\tString error = \"No repeat sumbit!\";");
		ps.println("\trequest.setAttribute(\"error\", error);");
		ps.println("\tthrow new Exception(error);");
		ps.println("\t}");
		
		ps.println("\t}");
		ps.println();
		
		//update method
		ps.println("\t@At(\"/"+table+"/update\")");
		ps.println("\t@Ok(\"redirect:/"+table+"/list?\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void update(@Param(\"::"+table+".\") "+table+" pojo,HttpServletRequest request)  throws Exception {");
		ps.println();
		
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		
		ps.println("\t}");
		ps.println();
		
		//del method
		ps.println("\t@At(\"/"+table+"/del\")");
		ps.println("\t@Ok(\"redirect:/"+table+"/list?\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void del(@Param(\"id\") String id,HttpServletRequest request)  throws Exception {");
		ps.println();	
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		
		ps.println("\t\tif(!MyUtil.isEmpty(id)){");
		ps.println("\t\tthis."+variable+"Dao.delById(id, DicType.class);");
		ps.println("\t\t}");
		
		ps.println("\t}");
		ps.println();
		
		//dels method
		ps.println("\t@At(\"/"+table+"/dels\")");
		ps.println("\t@Ok(\"redirect:/"+table+"/list?\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void dels(@Param(\"ids\") String strs[],HttpServletRequest request)  throws Exception {");
		ps.println();
		
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		//ps.println("\tString ids = MyUtil.getIdsFromArray(strs);");
		//ps.println("\tthis."+variable+"Dao.deleteByIds("+table+".class, ids);");
		
		ps.println("\t//数据软删除");
		ps.println("\tfor(String str : strs){");
		ps.println("\tint id = Integer.parseInt(str);");
		ps.println("\t"+table+" pojo = this."+variable+"Dao.find(id, "+table+".class);");
		ps.println("\tpojo.setStatus(Constants.VALUE_DEL_STATUS);");
		ps.println("\tthis."+variable+"Dao.update(pojo);");
		ps.println("\t}");
		
		ps.println("\t}");
		ps.println();
		
		//delss method
		ps.println("\t@At(\"/"+table+"/delss\")");
		ps.println("\t@Ok(\"redirect:/"+table+"/list?\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void delss(@Param(\"ids\") String strs[],HttpServletRequest request)  throws Exception {");
		ps.println();
		ps.println("\t//数据彻底删除");
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		ps.println("\tString ids = MyUtil.getIdsFromArray(strs);");
		ps.println("\tthis."+variable+"Dao.deleteByIds("+table+".class, ids);");
		
		ps.println("\t}");
		ps.println();
		
		//view method
		ps.println("\t@At(\"/"+table+"/view\")");
		ps.println("\t@Ok(\"jsp:/jsp/"+module+"/"+table.toLowerCase()+"/view\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void view(@Param(\"id\") int id,HttpServletRequest request)  throws Exception {");
		ps.println();
		
		ps.println("\trequest.setAttribute(\"tab\", tab);");
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		ps.println("\tif(!MyUtil.isEmpty(id)){");
		ps.println("\t"+table+" pojo = this."+variable+"Dao.find(id, "+table+".class);");
		ps.println("\trequest.setAttribute(\""+table+"\", pojo);");
		ps.println("\t}");
		
		ps.println("\t}");
		ps.println();
		
		//edit method
		ps.println("\t@At(\"/"+table+"/edit\")");
		ps.println("\t@Ok(\"jsp:/jsp/"+module+"/"+table.toLowerCase()+"/add\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void edit(@Param(\"id\") int id,HttpServletRequest request)  throws Exception {");
		ps.println();
		ps.println("\trequest.setAttribute(\"tab\", tab);");
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		ps.println("\tif(!MyUtil.isEmpty(id)){");
		ps.println("\t"+table+" pojo = this."+variable+"Dao.find(id, "+table+".class);");
		ps.println("\trequest.setAttribute(\""+table+"\", pojo);");
		ps.println("\t}");
		ps.println("\t}");
		ps.println();
		
		//check method
		ps.println("\t@At(\"/"+table+"/check\")");
		ps.println("\t@Ok(\"redirect:/"+table+"/list?\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void check(@Param(\"ids\") int ids[], HttpServletRequest request)");
		ps.println("\tthrows Exception {");
		ps.println("\trequest.setAttribute(\"menuActive\", menuCode);");
		
		ps.println("\tif(!MyUtil.isEmpty(ids)){");
		ps.println("\t\tfor(int id:ids){");
		ps.println("\t\t"+table+" pojo = this."+variable+"Dao.find(id, "+table+".class);");
		ps.println("\t\tpojo.setStatus(Constants.VALUE_CHECKED_STATUS);");
		ps.println("\t\tthis."+variable+"Dao.update(pojo);");
		ps.println("\t}			");
		ps.println("\t}");		
		ps.println("\t}");
		
		ps.println();
		
		//checkName method(jQuery post action)
		ps.println("\t@At(\"/"+table+"/checkName\")");
		ps.println("\t@Ok(\"json\")");
		ps.println("\t@Fail(\"jsp:/error\")");
		ps.println("\tpublic void checkName(@Param(\"name\") String name, HttpServletRequest request)");
		ps.println("\tthrows Exception {");
		ps.println("\t\trequest.setAttribute(\"menuActive\", menuCode);");
		ps.println("\t\t//TODO");	
		ps.println("\t}");
		
		ps.println("}");
		
		
		ps.println("----------------------------this is data "+table+" table java action start------------------------------");
		ps.println();
	}
	
	public void outDao(List<String[]> list,String table){
		PrintStream ps = Test.getOut();
		
		table = Test.getClassNameByTable(table);
		
		ps.println("----------------------------this is data "+table+" table java dao start------------------------------");
		ps.println();
		
		ps.println("@SuppressWarnings(\"unused\")");
		ps.println("@IocBean");
		ps.println("@InjectName");//
		ps.println("public class "+table+"Dao extends BasicDao {");
		ps.println("private static final org.nutz.log.Log log = org.nutz.log.Logs.getLog("+table+"Dao.class);");
		ps.println();
				
		ps.println("}");
			
		ps.println("----------------------------this is data "+table+" table java dao start------------------------------");
		ps.println();
	}
	
	public static void main(String args[]){
		String table ="tb_dic_type";
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,true);
		JavaUtil java = new JavaUtil();
		java.outAction(list, table,"data");
		java.outDao(list, table);
	}

}
