<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="mytag" uri="http://java.sun.com/jsp/mytag"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="navbar navbar-inverse navbar-fixed-top">
<div class="navbar-inner">
<div class="container-fluid">
<button type="button" class="btn btn-navbar" data-toggle="collapse"
	data-target=".nav-collapse"><span class="icon-bar"></span> <span
	class="icon-bar"></span> <span class="icon-bar"></span></button>
<a class="brand" href="#">综合管理平台[秋风IT工作室]——2013.09</a>
<div class="nav-collapse collapse">
<p class="navbar-text pull-right">当前用户： <a href="<%=path %>/tologin?"
	class="navbar-link"><i class="icon-user icon-white"></i>${USER==null?"未登陆":USER.user_name }</a>
	&nbsp;
	角色： <a href="#"
	class="navbar-link"><i class="icon-user icon-white"></i>系统管理员</a>
	&nbsp;
	功能组： 
	<a href="<%=path%>/Consult/list?"	class="navbar-link"><i class="icon-user icon-white"></i>IT培训</a>
</p>
<ul class="nav">
	<li class="active"><a href="<%=path%>/welcome?"><i
		class="icon-home"></i>首页</a></li>
	<li><a href="#about"><i class="icon-comment icon-white"></i>关于</a></li>
	<li><a href="#contact"><i class="icon-envelope icon-white"></i>联系我们</a></li>
	<li><a href="<%=path%>/logout?"><i
		class="icon-share icon-white"></i>安全退出</a></li>
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown"><i class="icon-random icon-white"></i>快捷通道 <b
		class="caret"></b></a>
	<ul class="dropdown-menu">
		<li><a href="<%=path%>/Consult/list?"><i class="icon-asterisk"></i>IT培训管理系统</a></li>
		<li><a href="<%=path%>/sys?"><i class="icon-fire"></i>系统管理</a></li>
		<li><a href="<%=path%>/cost/index?"><i class="icon-tint"></i>成本管理</a></li>
		<li class="divider"></li>
		<li class="nav-header"><i class="icon-plus"></i>系统管理</li>
		<li><a href="#"><i class="icon-certificate"></i>辅助工具</a></li>
		<li><a href="<%=path%>/fm/cost/index?"><i class="icon-wrench"></i>原始版本</a></li>
		<li class="divider"></li>
		<li><a href="<%=path%>/Game/Poker/index?"><i class="icon-wrench"></i>游戏：扑克</a></li>
	</ul>
	</li>
</ul>
</div>
<!--/.nav-collapse --></div>
</div>
</div>

