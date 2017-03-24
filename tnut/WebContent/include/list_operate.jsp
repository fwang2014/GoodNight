<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="btn-group">
	<div class="btn-group" style="display: block;">
	<button class="btn dropdown-toggle" data-toggle="dropdown">${msg['operate.relation']}
	<span class="caret"></span></button>
		<ul class="dropdown-menu">
			<li><a href="<%=path%>/${tab }/add?"><i class="icon-pencil"></i>${msg['operate.add']}</a></li>
			<li><a href="#" onclick="delIds('listForm','ids')"><i
				class="icon-remove"></i>${msg['operate.del']}</a></li>
			<li class="divider"></li>
			<li><a href="#" onclick="doCheck('listForm', 'ids')"><i	class="icon-ok"></i>${msg['operate.check']}</a></li>
		</ul>
	</div>
<!-- /btn-group -->
</div>
