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
	<li class="nav-header">我的业务</li>
	<li ${ menuActive==null?"class='active'":"" }><a href="<%=path%>/welcome?"><i		class="icon-home"></i>首页</a></li>
	<li id="li_101" ${ menuActive!=null&&"101"==menuActive?"class='active'":"" }><a href="<%=path%>/cost/index?ma=101"><i		class="icon-eye-open"></i>房租水电管理</a></li>
	<li id="li_102"><a href="<%=path%>/fm/daily/statChart?"><i		class="icon-plane"></i>进货成本管理</a></li>
	<li id="li_103"><a href="#"><i class="icon-comment"></i>项目成本科目管理</a></li>
	<li id="li_104"><a href="#"><i class="icon-shopping-cart"></i>工时成本管理</a></li>
	<li id="li_106" ${ menuActive=='106'?"class='active'":"" }><a href="<%=path%>/CostFill/list?ma=106"><i class="icon-tint"></i>成本管理</a></li>
	<li id="li_105" ${ menuActive=='105'?"class='active'":"" }><a href="<%=path %>/sys?ma=105"><i class="icon-cog"></i>系统管理</a></li>
	<li class="nav-header"><a href="#" class="btn btn-small" onclick="toggleMenu('li_201,li_202,li_203,li_204,li_205,li_206')"><i		class="icon-plus"></i>功能原型</a></li>
	<li id="li_201" style="display:none;"><a href="<%=path%>/toSliderShow?" target="_blank"><i		class="icon-folder-close"></i>SliderShow</a></li>
	<li id="li_202" style="display:none;"><a href="<%=path%>/toCss3Menu?" target="_blank"><i		class="icon-thumbs-up"></i>CSS2Menu1</a></li>
	<li id="li_203" style="display:none;"><a href="<%=path%>/toCss3Menu2?" target="_blank"><i		class="icon-thumbs-up"></i>CSS2Menu2</a></li>
	<li id="li_204" style="display:none;"><a href="<%=path%>/toCss3Menu4?" target="_blank"><i		class="icon-thumbs-up"></i>CSS2Menu4</a></li>
	<li id="li_205" style="display:none;"><a href="<%=path%>/toCss3Menu5?" target="_blank"><i		class="icon-thumbs-up"></i>CSS2Menu5</a></li>
	<li id="li_206" style="display:none;"><a href="<%=path%>/toFusionCharts?" target="_blank"><i		class="icon-shopping-cart"></i>FusionCharts</a></li>
	<li class="nav-header"><a href="#" class="btn btn-small"  onclick="toggleMenu('li_301,li_302,li_303')">
	<i		class="icon-plus"></i>数据管理</a></li>
	<li id="li_301" style="display:none;"><a href="<%=path%>/db/table?"><i class="icon-headphones"></i>表管理</a></li>
	<li id="li_302" style="display:none;"><a href="#"><i class="icon-music"></i>表维护</a></li>
	<li id="li_303" style="display:none;"><a href="#"><i class="icon-envelope"></i>性能优化[${menuActive }]</a></li>
</ul>
</div>
<!--/.well --></div>
<!--/span-->

<SCRIPT LANGUAGE="JavaScript">
<!--

	function toggleMenu(ids){
		var aids = ids.split(",");
		for(var i=0;i<aids.length;i++){
			var id = aids[i];
			var li = document.getElementById(id);
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
