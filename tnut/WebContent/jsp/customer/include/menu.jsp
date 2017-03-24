<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="span3">
<div class="well sidebar-nav">
<ul class="nav nav-list">
	<li class="nav-header"><i class="icon-home"></i>首页(IT培训管理)</li>
	<li class="nav-header"><a href="#" class="btn btn-small" onclick="toggleMenu('li_300,li_301,li_302,li_303,li_304,li_305,li_306,li_305,li_306,li_307,li_308')"><i class="icon-plus"></i>IT培训管理</a></li>
	<li id="li_300" style="display:none"><a href="<%=path%>/welcome?"><i class="icon-home"></i>首页(IT培训管理)</a></li>
	<li id="li_301" style="display:none" ${ menuActive=='301'?"class='active'":"" } ><a href="<%=path%>/Consult/list?"><i class="icon-headphones"></i>咨询</a></li>
	<li id="li_302" style="display:none" ${ menuActive=='302'?"class='active'":"" }><a href="<%=path%>/Register/list?"><i class="icon-music"></i>登记</a></li>
	<li id="li_303" style="display:none" ${ menuActive=='303'?"class='active'":"" }><a href="<%=path %>/Class2/list?"><i class="icon-envelope"></i>班级</a></li>
	<li id="li_304" style="display:none" ${ menuActive=='304'?"class='active'":"" }><a href="<%=path %>/Course/list?"><i class="icon-envelope"></i>课程</a></li>
	<li class="divider" style="display:none">培训阶段</li>
	<li id="li_304" style="display:none"><a href="#"><i class="icon-envelope"></i>课堂培训</a></li>
	<li id="li_305" style="display:none"><a href="#"><i class="icon-envelope"></i>课外辅导</a></li>
	<li class="divider" style="display:none">培训阶段</li>
	<li id="li_306" style="display:none"><a href="#"><i class="icon-envelope"></i>项目设计</a></li>
	<li id="li_307" style="display:none"><a href="#"><i class="icon-envelope"></i>学员考核</a></li>
	<li class="divider" style="display:none">培训阶段</li>
	<li id="li_308" style="display:none"><a href="#"><i class="icon-envelope"></i>就业管理</a></li>
	
	<li class="nav-header"><a href="#" class="btn btn-small" onclick="toggleMenu('li_201,li_202,li_203,li_204,li_205,li_206')"><i class="icon-plus"></i>系统管理</a></li>
	<li id="li_201" style="" ${ menuActive!=null&&"201"==menuActive?"class='active'":"" }><a href="<%=path%>/User2/list"><i class="icon-eye-open"></i>用户管理</a></li>
	<li id="li_202" style="" ${ menuActive!=null&&"202"==menuActive?"class='active'":"" }><a href="<%=path%>/Role/list?"><i		class="icon-plane"></i>角色管理</a></li>
	<li id="li_203" style="" ${ menuActive!=null&&"203"==menuActive?"class='active'":"" }><a href="<%=path%>/Menu/list?"><i class="icon-shopping-cart"></i>菜单管理</a></li>
	<li id="li_204" style="" ${ menuActive!=null&&"204"==menuActive?"class='active'":"" }><a href="<%=path%>/UserRole/list?"><i class="icon-comment"></i>用户权限管理</a></li>
	<li id="li_205" style="" ${ menuActive!=null&&"205"==menuActive?"class='active'":"" }><a href="<%=path%>/RoleMenu/list?"><i class="icon-shopping-cart"></i>角色权限管理</a></li>
	<li id="li_206" style="" ${ menuActive=='206'?"class='active'":"" }><a href="<%=path%>/Log/list?"><i class="icon-tint"></i>日志管理</a></li>
	
	
	<li class="nav-header"><a href="#" class="btn btn-small" onclick="toggleMenu('li_501,li_502')"><i class="icon-plus"></i>数据管理</a></li>
	<li id="li_501" style="display:none" ${ menuActive=='501'?"class='active'":"" }><a href="<%=path%>/DataCheck/list?"><i class="icon-shopping-cart"></i>审核管理</a></li>
	<li id="li_502" style="display:none" ${ menuActive=='502'?"class='active'":"" }><a href="<%=path%>/WorkFlow/list?"><i class="icon-shopping-cart"></i>工作流</a></li>
</ul>
</div>
<!--/.well --></div>
<!--/span-->

<SCRIPT LANGUAGE="JavaScript">
<!--

	function toggleMenu(ids){
		var aids = ids.split(",");
		//alert(aids.length);
		for(var i=0;i<aids.length;i++){
			var id = aids[i];
			var li = document.getElementById(id);
			//alert(id);
			if(li.style.display == "none"){
				li.style.display = "block";
			}else{
				li.style.display = "none";
			}
		}
	}

	//var tem ="li1,li2,li3";
	//toggleMenu(tem);

//-->
</SCRIPT>
