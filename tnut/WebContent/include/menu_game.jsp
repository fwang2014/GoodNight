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
	<li class="nav-header"><a href="#" class="btn btn-small"	onclick="toggleMenu('P01')"><i
		class="icon-plus"></i>游戏</a></li>	
	<li id="P01" style="display: none" ${ menuActive=='P01'?"class='active'":"" } ><a href="<%=path%>/Game/Poker/index"><i
		class="icon-home"></i>扑克</a></li>	
	<li id="P02" style="display: none" ${ menuActive=='P02'?"class='active'":"" } ><a href="<%=path%>/Game/Poker/Landlords/index"><i
		class="icon-home"></i>斗地主</a></li>

	<li class="nav-header"><a href="#" class="btn btn-small"
		onclick="toggleMenu('li_401')"><i
		class="icon-plus"></i>成本管理</a></li>
	
	<li id="li_401" style="display: none"><a href="<%=path%>/CostFill/list?ma=401"><i
		class="icon-home"></i>成本管理</a></li>	
		
	<li class="nav-header">
		<a href="#" class="btn btn-small" 
			onclick="toggleMenu('li_301,li_302,li_303,li_304,li_305,li_306,li_307,li_308')">
		<i	class="icon-plus"></i>培训管理</a>
	</li>
	
	<li id="li_301" style="display: none" ${ menuActive=='301'?"class='active'":"" } ><a href="<%=path%>/Consult/list?">
	<i		class="icon-headphones"></i>咨询</a></li>
	<li id="li_302" style="display: none" ${ menuActive=='302'?"class='active'":"" }><a href="<%=path%>/Register/list?">
	<i		class="icon-music"></i>登记</a></li>
	<li id="li_303" style="display: none" ${ menuActive=='303'?"class='active'":"" }><a href="<%=path%>/Class2/list?">
	<i		class="icon-envelope"></i>班级</a></li>
	<li id="li_304" style="display: none" ${ menuActive=='304'?"class='active'":"" }><a href="<%=path%>/Course/list?">
	<i		class="icon-envelope"></i>课程</a></li>
	<li class="divider" style="display: none">培训阶段</li>
	<li id="li_304" style="display: none"><a href="#">
	<i		class="icon-envelope"></i>课堂培训</a></li>
	<li id="li_305" style="display: none"><a href="#">
	<i		class="icon-envelope"></i>课外辅导</a></li>
	<li class="divider" style="display: none">培训阶段</li>
	<li id="li_306" style="display: none"><a href="#">
	<i		class="icon-envelope"></i>项目设计</a></li>
	<li id="li_307" style="display: none"><a href="#">
	<i		class="icon-envelope"></i>学员考核</a></li>
	<li class="divider" style="display: none">培训阶段</li>
	<li id="li_308" style="display: none"><a href="#">
	<i		class="icon-envelope"></i>就业管理</a></li>

	<li class="nav-header"><a href="#" class="btn btn-small"
		onclick="toggleMenu('li_601,li_602,li_603')"><i class="icon-plus"></i>客户管理</a></li>
	<li id="li_601" style="display: none" ${ menuActive== '601'?"class='active'":"" }><a
		href="<%=path%>/Customer/list?"><i class="icon-user"></i>客户信息</a></li>
	<li id="li_602" style="display: none" ${ menuActive== '602'?"class='active'":"" }><a
		href="<%=path%>/Dothing/list?"><i class="icon-tags"></i>客户事务</a></li>
	<li id="li_603" style="display: none" ${ menuActive== '603'?"class='active'":"" }><a
		href="<%=path%>/Phonebook/list?"><i class="icon-tag"></i>电话薄</a></li>


	<li class="nav-header"><a href="#" class="btn btn-small"
		onclick="toggleMenu('li_201,li_202,li_203,li_204,li_205,li_206,li_207,li_208,li_209,li_210,li_211')"><i
		class="icon-plus"></i>系统管理</a></li>
	<li id="li_201" style="display: none" ${ menuActive!=null&&"201"==menuActive?"class='active'":"" }><a
		href="<%=path%>/User2/list"><span class="badge badge-warning">01</span>用户管理</a></li>
	<li id="li_202" style="display: none" ${ menuActive!=null&&	"202"==menuActive?"class='active'":"" }>
	<a		href="<%=path%>/Role/list?"><span class="badge badge-important">02</span>角色管理</a></li>
	<li id="li_203" style="display: none" ${ menuActive!=null&&	"203"==menuActive?"class='active'":"" }>
	<a		href="<%=path%>/Menu/list?"><span class="badge badge-info">03</span>菜单管理</a></li>
	<li id="li_204" style="display: none" ${ menuActive!=null&&	"204"==menuActive?"class='active'":"" }>
	<a		href="<%=path%>/UserRole/list?"><span class="badge">04</span>用户权限管理</a></li>
	<li id="li_205" style="display: none" ${ menuActive!=null&&	"205"==menuActive?"class='active'":"" }>
	<a href="<%=path%>/RoleMenu/list?"><span class="badge">05</span>角色权限管理</a></li>
	<li id="li_206" style="display: none" ${ menuActive=='206'?"class='active'":"" }>
		<a href="<%=path%>/Log/list?"><span class="badge">06</span>日志管理</a>
	</li>
	<li id="li_208" style="display: none" ${ menuActive=='208'?"class='active'":"" }>
		<a href="<%=path%>/LogInfo/list?"><span class="badge">07</span>日志信息参照管理</a>
	</li>
	<li id="li_209" style="display: none" ${ menuActive=='209'?"class='active'":"" }>
		<a href="<%=path%>/LoginInfo/list?"><span class="badge">08</span>登录信息管理</a>
	</li>
	<li id="li_207" style="display: none" ${ menuActive=='207'?"class='active'":"" }>
		<a href="<%=path%>/sys?ma=207"><span class="badge">09</span>系统综合管理</a>
	</li>
	<li id="li_210" style="display: none" ${ menuActive=='210'?"class='active'":"" }>
		<a href="<%=path%>/Words/list?"><span class="badge">10</span>留言管理</a>
	</li>
	<li id="li_211" style="display: none" ${ menuActive=='211'?"class='active'":"" }>
		<a href="<%=path%>/PasswordInfo/list?"><span class="badge">11</span>密码管理</a>
	</li>


	<li class="nav-header"><a href="#" class="btn btn-small"
		onclick="toggleMenu('li_501,li_502,li_503,li_504,li_505')" class="icon-plus"><i class="icon-plus"></i>数据管理</a></li>
	<li id="li_501" style="display: none" ${ menuActive=='501'?"class='active'":"" }><a href="<%=path%>/DataCheck/list?">
		<span	class="badge">01</span>审核管理??</a></li>
	<li id="li_502" style="display: none" ${ menuActive=='502'?"class='active'":"" }><a href="<%=path%>/WorkFlow/list?">
		<span	class="badge">02</span>工作流??</a></li>
	<li id="li_503" style="display: none" ${ menuActive=='503'?"class='active'":"" }><a href="<%=path%>/FileUpload/list?">
		<span	class="badge">03</span>文件上载管理</a></li>
	<li id="li_504" style="display: none" ${ menuActive=='504'?"class='active'":"" }><a href="<%=path%>/SysBean/list?">
		<span	class="badge">04</span>系统BEAN管理</a></li>
	<li id="li_505" style="display: none" ${ menuActive=='505'?"class='active'":"" }><a href="<%=path%>/DataimportInfo/list?">
		<span	class="badge">05</span>数据导入</a></li>
		
	<li class="nav-header"><a href="#" class="btn btn-small" onclick="toggleMenu('li_701,li_702,li_703,li_704,li_705,li_706,li_707')"><i class="icon-plus"></i>功能原型</a></li>
	<li id="li_701" style="display:none;"><a href="<%=path%>/toSliderShow?" target="_blank"><i		class="icon-folder-close"></i>SliderShow</a></li>
	<li id="li_702" style="display:none;"><a href="<%=path%>/toCss3Menu?" target="_blank"><i		class="icon-thumbs-up"></i>CSS2Menu1</a></li>
	<li id="li_703" style="display:none;"><a href="<%=path%>/toCss3Menu2?" target="_blank"><i		class="icon-thumbs-up"></i>CSS2Menu2</a></li>
	<li id="li_704" style="display:none;"><a href="<%=path%>/toCss3Menu4?" target="_blank"><i		class="icon-thumbs-up"></i>CSS2Menu4</a></li>
	<li id="li_705" style="display:none;"><a href="<%=path%>/toCss3Menu5?" target="_blank"><i		class="icon-thumbs-up"></i>CSS2Menu5</a></li>
	<li id="li_706" style="display:none;"><a href="<%=path%>/toFusionCharts?" target="_blank"><i		class="icon-shopping-cart"></i>FusionCharts</a></li>	
	<li id="li_707" style="display: none"><a href="<%=path%>/cost/index?ma=400"><i		class="icon-home"></i>房租水电管理</a></li>	
</ul>
</div>
<!--/.well --></div>
<!--/span-->

<SCRIPT LANGUAGE="JavaScript">
	function toggleMenu(ids) {
		var aids = ids.split(",");
		//alert(aids.length);
		for ( var i = 0; i < aids.length; i++) {
			var id = aids[i];
			var li = document.getElementById(id);
			//alert(id);
			if (li.style.display == "none") {
				li.style.display = "block";
			} else {
				li.style.display = "none";
			}
		}
	}

	toggleMenu('P01,P02');

	//-->
</SCRIPT>
