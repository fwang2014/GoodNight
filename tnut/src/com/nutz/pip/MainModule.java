package com.nutz.pip;

//https://github.com/howe/
/**
 * cd D:\MongoDB
 > mongod --dbpath D:\MongoDB\data 

 git@github.com:Rekoe/rkCms.git
 */
import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.LoadingBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.UrlMappingBy;
import org.nutz.mvc.impl.NutLoading;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import com.nutz.pip.filter.AuthorityFilter;
import com.nutz.pip.init.MyUrlMappingImpl;


@Modules(scanPackage = true)
@UrlMappingBy(MyUrlMappingImpl.class)
@LoadingBy(NutLoading.class)
//@Ok("ioc:json")
//@Fail("ioc:json")
@IocBy(type = ComboIocProvider.class, args = {
		"*org.nutz.ioc.loader.json.JsonLoader", "ioc/",
		"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "com.nutz.pip" })
@Filters( { @By(type = AuthorityFilter.class) })
@Localization("msg")
@Encoding(input = "UTF-8", output = "UTF-8")
/*@SetupBy(StartSetup.class)
@Views( { FreemarkerViewMaker.class, JPEGViewMaker.class, JSONPViewMaker.class,
		AjaxViewMaker.class })*/
@Fail("jsp:/error")
@IocBean
public class MainModule {
	
	private static final Log log = Logs.getLog(MainModule.class);
	
	public MainModule(){
		init();
	}
	
	private void init(){
		System.out.println("MainModule.init()");
		
		
		
	}
	
	@At("/toLogin")
	@Aop("superAop")
	@Ok("jsp:/default")
	public void toLogin(HttpServletRequest request){
		//System.out.println("MainModule.initPage()");
		log.info("MainModule.toLogin()");
		//request.getSession().getServletContext().
	}
	
	@At("/initPage")
	@Aop("superAop")
	@Ok("jsp:/jsp/index")
	public void initPage(HttpServletRequest request){
		System.out.println("MainModule.initPage()");
		log.info("MainModule.initPage()");
	}
	
	@At("/toSliderShow")
	@Aop("superAop")
	//@Ok("forward:/sliderShow/index.html")
	@Ok("redirect:/sliderShow/fs_aux.html")
	public void toSliderShow(HttpServletRequest request){
		System.out.println("MainModule.toSliderShow()");
		log.info("MainModule.toSliderShow()");
	}
	
	@At("/toCss3Menu")
	@Aop("superAop")
	//@Ok("forward:/sliderShow/index.html")
	@Ok("redirect:/css3Menu/menu1/index.html")
	public void toCss3Menu(HttpServletRequest request){
		System.out.println("MainModule.toSliderShow()");
		log.info("MainModule.toSliderShow()");
	}
	
	@At("/toCss3Menu2")
	@Aop("superAop")
	//@Ok("forward:/sliderShow/index.html")
	@Ok("redirect:/css3Menu/menu2/index.html")
	public void toCss3Menu2(HttpServletRequest request){
		System.out.println("MainModule.toSliderShow()");
		log.info("MainModule.toSliderShow()");
	}
	
	@At("/toCss3Menu4")
	@Aop("superAop")
	//@Ok("forward:/sliderShow/index.html")
	@Ok("redirect:/css3Menu/menu4/index.html")
	public void toCss3Menu4(HttpServletRequest request){
		System.out.println("MainModule.toSliderShow()");
		log.info("MainModule.toSliderShow()");
	}
	
	@At("/toCss3Menu5")
	@Aop("superAop")
	//@Ok("forward:/sliderShow/index.html")
	@Ok("redirect:/css3Menu/menu5/index.html")
	public void toCss3Menu5(HttpServletRequest request){
		System.out.println("MainModule.toSliderShow()");
		log.info("MainModule.toSliderShow()");
	}
	
	@At("/toFusionCharts")
	@Aop("superAop")
	//@Ok("forward:/sliderShow/index.html")
	@Ok("redirect:/fusioncharts/index.jsp")
	public void toFusionCharts(HttpServletRequest request){
		System.out.println("MainModule.toSliderShow()");
		log.info("MainModule.toSliderShow()");
	}

}
