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
<div class="row-fluid"><jsp:include page="/include/menu_sys.jsp"
	flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/Log/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Log.TABLE_CN']}${msg['display.label.search.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/Log/list?">${msg['label.Log.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Log/add?">${msg['label.Log.TABLE_CN']}${msg['display.label.add']}</a></li>
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
	<li><a href="#" onclick="delIds('searchForm','ids')"><i
		class="icon-remove"></i>${msg['operate.del']}</a></li>
	<li class="divider"></li>
	<li><a href="#" onclick="doCheck('searchForm', 'ids')"><i
		class="icon-ok"></i>${msg['operate.check']}</a></li>
	<li class="divider"></li>
	<li><a href="#myModal" role="button" class="btn" data-toggle="modal"><i
		class="icon-tag"></i>${msg['operate.search']}</a></li>
	<li><a href="#" onclick="exportExcelAll('searchForm','ids')"><i
		class="icon-tag"></i>${msg['operate.export.excel.all']}</a></li>
		
</ul>
</div>
<!-- /btn-group --></div>

<form action="<%=path%>/SysBean/search?" method="post" id="searchForm"	name="searchForm">

<input name="search.code" id="search.code" value="${search.code }" type="hidden">
<input name="search.name" id="search.name" value="${search.name }" type="hidden">
<input name="search.type" id="search.type" value="${search.type }" type="hidden">
<input name="search.status" id="search.status" value="${search.status }" type="hidden">
<input name="search.startDate" id="search.startDate" value="${search.startDate }" type="hidden">
<input name="search.endDate" id="search.endDate" value="${search.endDate }" type="hidden">

<table class="table table-bordered">
	<thead>
		<tr>
			<th><input type="checkbox" name="all" onclick="selectAll('ids')"></th>
			<th>#</th>
			<th>${msg['label.Log.CODE']}</th>
			<th>${msg['label.Log.NAME']}</th>
			<th>${msg['label.Log.CREATE_BY']}</th>
			<th>${msg['label.Log.STATUS']}</th>
			<th>${msg['label.Log.REQ_IP']}</th>
			<th>${msg['label.OPERATION']}</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${page.list}" var="tag" varStatus="id">
			<tr class="tr_data">
				<td nowrap>
				<!-- 只是审核后的数据才能导出 -->
				<c:if test="${tag.status =='1'}">
					<input type="checkbox" name="ids" value="${tag.id}" />
				</c:if>
				</td>
				<td nowrap>${id.count}</td>
				<td nowrap>${tag.code}</td>
				<td nowrap title="${tag.remark}"><a
					href="<%=path%>/Log/view?id=${tag.id}">${tag.name}</a></td>
				<td nowrap>${tag.create_by}</td>
				<td nowrap>
					<c:choose>
						<c:when test="${tag.status=='0'}"><span class="label">${msg['status.default']}</span></c:when>
					</c:choose>
					<c:choose>
						<c:when test="${tag.status=='1'}"><span class="label label-success">${msg['status.checked']}</span></c:when>
					</c:choose>
					<c:choose>
						<c:when test="${tag.status=='2'}"><span class="label label-important">${msg['status.edited']}</span></c:when>
					</c:choose>
					<c:choose>
						<c:when test="${tag.status=='-1'}"><span class="label label-warning">${msg['status.deleted']}</span></c:when>
					</c:choose>
				</td>
				<td nowrap>${tag.req_ip}</td>
				<td nowrap><a href="<%=path%>/Log/view?id=${tag.id}" />${msg['label.OPERATION.VIEW']}</a>
				<c:if test="${tag.status =='0'}">
					<span class="divider">|</span>
					<a href="<%=path%>/Log/edit?id=${tag.id}" /><i class="icon-edit"></i></a>
				</c:if></td>
			</tr>
		</c:forEach>
		<tr class="tr_data">
			<td colspan="8" align="center"><jsp:include
				page="/include/pagination_search.jsp" flush="true" /></td>
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


<jsp:include page="/include/searchForm.jsp" flush="true" />

</body>
</html>
