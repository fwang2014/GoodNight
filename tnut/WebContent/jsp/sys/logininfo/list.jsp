<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.nutz.utils.DateConvertUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String tab = (String)request.getAttribute("tab");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/include/head.jsp" flush="true" />
</head>

<body data-spy="scroll" data-target=".sidebar-nav">

<jsp:include page="/include/top.jsp" flush="true" />

<div class="container-fluid">
<div class="row-fluid"><jsp:include
	page="/include/menu_sys.jsp" flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/LoginInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.LoginInfo.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/LoginInfo/list?">${msg['label.LoginInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/LoginInfo/add?">${msg['label.LoginInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">
<div class="btn-group">
<div class="btn-group" style="display: block;">
<button class="btn dropdown-toggle" data-toggle="dropdown">${msg['operate.relation']}
<span class="caret"></span></button>
<ul class="dropdown-menu">
	<li><a href="<%=path%>/${tab }/add?"><i class="icon-pencil"></i>${msg['operate.add']}</a></li>
	<li><a href="#" onclick="delIds('listForm','ids')"><i
		class="icon-remove"></i>${msg['operate.del']}</a></li>
	<li class="divider"></li>
	<li><a href="#" onclick="doCheck('listForm', 'ids')"><i
		class="icon-ok"></i>${msg['operate.check']}</a></li>
</ul>
</div>
<!-- /btn-group --></div>

<form action="<%=path %>/LoginInfo/list?" method="post"  id="listForm" name="listForm">
<table class="table table-bordered">
	<thead>
		<tr>
		<th><input type="checkbox" name="all" onclick="selectAll('ids')"/></th>
		<th>#</th>
		<th>${msg['label.LoginInfo.CODE']}</th>
		<th>${msg['label.LoginInfo.NAME']}</th>
		
		<th>${msg['label.LoginInfo.STATUS']}</th>
		<th>${msg['label.LoginInfo.REQ_ID']}</th>
		<th>${msg['label.LoginInfo.REQ_ADDR']}</th>
		<th>${msg['label.LoginInfo.REQ_PORT']}</th>
		<th>${msg['label.LoginInfo.REQ_URI']}</th>
		<th>${msg['label.LoginInfo.REQ_USER']}</th>
		<th>${msg['label.OPERATION']}</th>
		</tr>
	</thead>
<tbody>

<c:forEach items="${page.list}" var="tag" varStatus="id">
	<tr class="tr_data">
<td nowrap>
<c:if test="${tag.status =='0'}">
<input type="checkbox" name="ids" value="${tag.id}"/>
</c:if>
</td>
<td nowrap>${id.count}</td>
			<td nowrap>${tag.code}</td>
			<td nowrap title="${tag.remark}"><a href="<%=path %>/LoginInfo/view?id=${tag.id}">${tag.name}</a></td>
			
			<td nowrap>${tag.status}</td>
			<td nowrap>${tag.req_id}</td>
			<td nowrap>${tag.req_addr}</td>
			<td nowrap>${tag.req_port}</td>
			<td nowrap>${tag.req_uri}</td>
			<td nowrap>${tag.req_user}</td>
		<td nowrap><a href="<%=path %>/LoginInfo/view?id=${tag.id}"/>${msg['label.OPERATION.VIEW']}</a>
<c:if test="${tag.status =='0'}">
		<span class="divider">|</span>
		<a href="<%=path%>/LoginInfo/edit?id=${tag.id}" /><i class="icon-edit"></i></a>
</c:if>
	</td>
	</tr>
</c:forEach>
<tr class="tr_data">
<td colspan="12" align="center">
<jsp:include page="/include/pagination.jsp" flush="true" />
</td>
</tr>

</tbody>
</table>
</form>

</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" />

</div>
<!--/.fluid-container-->

<jsp:include page="/include/js.jsp" flush="true" />
<jsp:include page="/include/list_js.jsp" flush="true" />


</body>
</html>
