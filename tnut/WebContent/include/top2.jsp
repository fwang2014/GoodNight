<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<a class="brand" href="#">家庭财务管理系统[FFMS]</a>
<div class="nav-collapse collapse">
<p class="navbar-text pull-right">当前用户： <a href="#"
	class="navbar-link"><i class="icon-user icon-white"></i>${USER==null?"未登陆":USER.user_name }</a></p>
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
		<li><a href="fm/daily/index?"><i class="icon-asterisk"></i>每日收支</a></li>
		<li><a href="#"><i class="icon-fire"></i>统计查询</a></li>
		<li><a href="#"><i class="icon-tint"></i>账户管理</a></li>
		<li class="divider"></li>
		<li class="nav-header"><i class="icon-plus"></i>系统管理</li>
		<li><a href="#"><i class="icon-certificate"></i>辅助工具</a></li>
		<li><a href="<%=path%>/fm/cost/index?"><i class="icon-wrench"></i>原始版本</a></li>
	</ul>
	</li>
</ul>
</div>
<!--/.nav-collapse --></div>
</div>
</div>

