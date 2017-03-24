<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/include/head.jsp" flush="true" />
</head>

<body data-spy="scroll" data-target=".sidebar-nav">

<jsp:include page="/include/top.jsp" flush="true" />

<div class="container-fluid">
<div class="row-fluid"><jsp:include page="/include/menu_cost.jsp"
	flush="true" />
<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/SmCost/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.SmCost.TABLE_CN']}${msg['display.label.view']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/SmCost/list?">${msg['label.SmCost.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/SmCost/add?">${msg['label.SmCost.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path%>/SmCost/list?" method="post" id="viewForm"
	name="viewForm"><INPUT TYPE="hidden" NAME="SmCost.id"
	value="${SmCost.id }" />
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.SmCost.ID']}</td>
		<td colspan="3"}>${SmCost.id }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.CODE']}</td>
		<td colspan="3"}>${SmCost.code }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.NAME']}</td>
		<td colspan="3"}>${SmCost.name }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.TYPE']}</td>
		<td colspan="3"}>${SmCost.type }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.HAPPENDATE']}</td>
		<td colspan="3"}>${SmCost.happendate }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.FILLDATE']}</td>
		<td colspan="3"}>${SmCost.filldate }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.FILLUSER']}</td>
		<td colspan="3"}>${SmCost.filluser }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.PRICE']}</td>
		<td colspan="3"}>${SmCost.price }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.QTY']}</td>
		<td colspan="3"}>${SmCost.qty }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.AMOUNT']}</td>
		<td colspan="3"}>${SmCost.amount }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.REMARK']}</td>
		<td colspan="3"}>${SmCost.remark }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.UNIT']}</td>
		<td colspan="3"}>${SmCost.unit }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.STATUS']}</td>
		<td colspan="3"}>${SmCost.status }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.CREATE_BY']}</td>
		<td colspan="3"}>${SmCost.create_by }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.CREATE_DATE']}</td>
		<td colspan="3"}>${SmCost.create_date }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.UPDATE_BY']}</td>
		<td colspan="3"}>${SmCost.update_by }</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.UPDATE_TIME']}</td>
		<td colspan="3"}>${SmCost.update_time }</td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type="submit"
			name="btn_save" class="btn btn-info" value="${msg['operate.back']}">
		</td>
	</tr>
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

</body>
</html>
