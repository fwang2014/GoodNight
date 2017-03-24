/**
 * 
 */
package com.nutz.pip.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.View;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.mvc.view.JspView;

import com.nutz.pip.Constants;
import com.nutz.pip.action.misc.SysBeanAction;
import com.nutz.pip.action.sys.LogAction;
import com.nutz.pip.common.MyUtil;
import com.nutz.pip.model.misc.SysBean;
import com.nutz.pip.model.sm.sys.TSysUser;

/**
 * @author Administrator
 *
 */
public class LoginFilter extends CheckSession {
	private String url;
	private String key;
	
	//@Inject
	//protected Dao dao;

	public LoginFilter(String key, String url) {
		super(key, url);
		//System.out.println("LoginFilter -> LoginFilter:"+key+"\t"+url);
		this.key = key;
		this.url = url;
	}

	@Override
	public View match(ActionContext ac) {
		
		if("Y".equals(Constants.FLAG_SYS_BEANS_LOAD)){
			System.out.println("-------------------match start...");
			//String names[] = ac.getIoc().getNames();
			com.nutz.pip.action.misc.SysBeanAction action =ac.getIoc().get(SysBeanAction.class, "sysBeanAction");
			Ioc ioc = ac.getIoc();
			String names[] = ioc.getNames();
			for(String name:names){
				//System.out.println(name);
				this.loadSysBean(name,action,ac.getRequest());
			}
			ac.getRequest().setAttribute("LOAD_SYS_BEAN", "Y");

			System.out.println("------------------------match end");
		}
		

		
		//ac.getIoc().get(arg0, arg1)
		/*if(la != null){
			System.out.println("com.nutz.pip.action.sys.LogAction is not null");
		}else{
			System.out.println("com.nutz.pip.action.sys.LogAction is null object");
		}*/
		
		//System.out.println("LoginFilter -> match");		
		HttpSession sess = ac.getRequest().getSession();
		/*Object obj = sess.getAttribute("login");
		System.out.println("obj:"+obj);*/
		Object obj = sess.getAttribute(key);
		//System.out.println("user:"+obj);
		View view = null;
		
		String id = ac.getRequest().getRemoteHost();
		String user = ac.getRequest().getRemoteUser();
		com.nutz.pip.action.sys.LogAction la =ac.getIoc().get(LogAction.class, "logAction");
		try {
			if(la != null){
				writeLog(id,user,ac.getRequest(),la);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("filter writeLog exception occur");
			e.printStackTrace();
		}
		
		if(obj==null){	
			view = new JspView(url);
			//System.out.println("view is null");
			
			//String tem = ac.getRequest().getRemoteAddr();
			//int tem2 = ac.getRequest().getRemotePort();
			
			StringBuffer buf = new StringBuffer();
			int port = ac.getRequest().getRemotePort();
			buf.append("id").append(":").append(port);
			sess.setAttribute("id",buf.toString());
			Object lc = sess.getAttribute("loginCount");
			if(lc == null){
				sess.setAttribute("loginCounct",new Integer(1));
			}else{
				int count = (Integer)lc;
				count++;
				if(count >3){
					view = new JspView("/error.jsp");
				}
			}
			
			String url = ac.getPath();
			if(url.indexOf("index")>0){
				sess.setAttribute("url",url);
			}
			//System.out.println("------------------>url:"+url);
						
		}else{			
			//System.out.println("view is not null");
		}
		//View view = new View();
		return view;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	private void writeLog(String id,String user,HttpServletRequest request,LogAction la) throws Exception{
		/*Dao dao = new NutDao(DBFactory.getInstance().getDataSource());
		TSysLoginLog log = new TSysLoginLog();
		log.setId(SeqNum.getPrimaryKeyForString());
		log.setLogin_ip(id);
		log.setLogin_time(new Date(System.currentTimeMillis()).toLocaleString());
		log.setStatus("Fail");
		log.setType("not Logined");
		log.setUser_id(user==null?"none":user);
		dao.insert(log);*/
		
		com.nutz.pip.model.sys.Log pojo = new com.nutz.pip.model.sys.Log();
		pojo.setCode(MyUtil.getCreateTime());
		
		pojo.setCreate_date(MyUtil.getCreateTime2());
		pojo.setName("URI:"+request.getRequestURI());
		pojo.setRemark(" URI:"+request.getRequestURI()+" Host:"+request.getRemoteHost()+" Port:"+request.getRemotePort()+" user:"+request.getRemoteUser());
		pojo.setReq_ip(request.getRemoteAddr());
		pojo.setStatus(0);
		pojo.setType("0");
		pojo.setUpdate_by("-1");
		pojo.setUpdate_time(MyUtil.getCreateTime2());
		
		TSysUser su = (TSysUser)request.getSession().getAttribute(Constants.KEY_LOGIN_USER);
		if(su == null){
			pojo.setCreate_by("-1");
		}else{
			pojo.setCreate_by(su.getAccount_name());
		}
		//String loginUser = su.getAccount_name();
			
		la.save(pojo, request);
	}
	
	private void loadSysBean(String name,SysBeanAction action,HttpServletRequest request){
		
		//if(dao != null){
			String type = "bean";
			if(name.endsWith("Action")){
				type = "Action";
			}else if(name.endsWith("Dao")){
				type = "Dao";
			}else{
				type = "Bean";
			}
			SysBean bean = new SysBean();
			bean.setCode(name);
			bean.setName(name);
			bean.setRemark(name);
			bean.setType(type);
			bean.setStatus(0);
			bean.setCreate_by("-1");
			bean.setCreate_date(MyUtil.getCreateTime2());
			//dao.insert(bean);
			try {
				action.save(bean, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		
		
		/*try {
			new SysBeanAction().save(bean, ac.getRequest());
		} catch (Exception e) {
			e.printStackTrace();						
		}*/
	}
}
