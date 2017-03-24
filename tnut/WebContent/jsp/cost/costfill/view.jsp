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
	<li><a href="<%=path%>/CostFill2/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.CostFill.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/CostFill2/list?">${msg['label.CostFill.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/CostFill2/add?">${msg['label.CostFill.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/CostFill/list?" method="post"  id="viewForm" name="viewForm">
<INPUT TYPE="hidden" NAME="CostFill.id" value="${CostFill.id }"/>
<table class="table table-bordered">
	<tr>
		<td width="25%">${msg['label.CostFill.ID']}</td>
		<td colspan="3"}>${CostFill.id }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.CODE']}</td>
		<td colspan="3"}>${CostFill.code }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.NAME']}</td>
		<td colspan="3"}>${CostFill.name }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.START_VALUE']}</td>
		<td colspan="3"}>${CostFill.start_value }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.END_VALUE']}</td>
		<td colspan="3"}>${CostFill.end_value }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.VALUE_TYPE']}</td>
		<td colspan="3"}>${CostFill.value_type }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.PRICE']}</td>
		<td colspan="3"}>${CostFill.price }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.QTY']}</td>
		<td colspan="3"}>${CostFill.qty }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.AMT']}</td>
		<td colspan="3"}>${CostFill.amt }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.UNIT']}</td>
		<td colspan="3"}>${CostFill.unit }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.TYPE']}</td>
		<td colspan="3"}>${CostFill.type }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.STATUS']}</td>
		<td colspan="3"}>${CostFill.status }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.CREATE_BY']}</td>
		<td colspan="3"}>${CostFill.create_by }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.CREATE_DATE']}</td>
		<td colspan="3"}>${CostFill.create_date }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.UPDATE_BY']}</td>
		<td colspan="3"}>${CostFill.update_by }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.UPDATE_TIME']}</td>
		<td colspan="3"}>${CostFill.update_time }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.REMARK']}</td>
		<td colspan="3"}>${CostFill.remark }</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.FILL_DATE']}</td>
		<td colspan="3"}>${CostFill.fill_date }</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.back']}"> 
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
