<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	page="/include/menu_customer.jsp" flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/Dothing/list?" class="label label-info">${msg['display.label.nav.customer']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Dothing.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/Dothing/list?">${msg['label.Dothing.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Dothing/add?">${msg['label.Dothing.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example"><jsp:include
	page="/include/list_operate.jsp" flush="true" />

<form action="<%=path%>/Dothing/list?" method="post" id="listForm"
	name="listForm">
<table class="table table-bordered">
	<thead>
		<tr>
			<th><input type="checkbox" name="all" onclick="selectAll('ids')"></th>
			<th>#</th>		
			<th>${msg['label.Dothing.CUSTOMER_NAME']}</th>
			<th>${msg['label.Dothing.CODE']}</th>
			<th>${msg['label.Dothing.NAME']}</th>
			<th>${msg['label.Dothing.STATUS']}</th>
			<th>${msg['label.Dothing.START_TIME']}</th>
			<th>${msg['label.Dothing.END_TIME']}</th>
			<th>${msg['label.Dothing.DO_TYPE']}</th>
			<th>${msg['label.Dothing.DO_STATUS']}</th>		
			<th>${msg['label.OPERATION']}</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${page.list}" var="tag" varStatus="id">
			<tr class="tr_data">
				<td nowrap><c:if test="${tag.status =='0'}">
					<input type="checkbox" name="ids" value="${tag.id}" />
				</c:if></td>
				<td nowrap>${id.count}</td>
				<td nowrap><a href="<%=path%>/Customer/view?id=${tag.customer_id}">${tag.customer_name}</a></td>
				<td nowrap>${tag.code}</td>
				<td nowrap title="${tag.remark}"><a
					href="<%=path%>/Dothing/view?id=${tag.id}">${tag.name}</a></td>
				<td nowrap>${tag.status_name}</td>
				<td nowrap>${tag.start_time}</td>
				<td nowrap>${tag.end_time}</td>
				<td nowrap>${tag.do_type_name}</td>
				<td nowrap>${tag.do_status_name}</td>
				
				<td nowrap><a href="<%=path%>/Dothing/view?id=${tag.id}" />${msg['label.OPERATION.VIEW']}</a>
				<c:if test="${tag.status =='0'}">
					<span class="divider">|</span>
					<a href="<%=path%>/Dothing/edit?id=${tag.id}" /><i
						class="icon-edit"></i></a>
				</c:if></td>
			</tr>
		</c:forEach>
		<tr class="tr_data">
			<td colspan="11" align="center"><jsp:include
				page="/include/pagination.jsp" flush="true" /></td>
		</tr>

	</tbody>
</table>
</form>

</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" /></div>
<!--/.fluid-container-->

<jsp:include page="/include/js.jsp" flush="true" />

<jsp:include page="/include/list_js.jsp" flush="true" />

</body>
</html>
