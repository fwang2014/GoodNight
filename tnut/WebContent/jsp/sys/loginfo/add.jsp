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
<div class="row-fluid"><jsp:include
	page="/include/menu_sys.jsp" flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/LogInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.LogInfo.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/LogInfo/list?">${msg['label.LogInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/LogInfo/add?">${msg['label.LogInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/LogInfo/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="LogInfo.id" value="${LogInfo.id }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.LogInfo.CODE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="LogInfo.code" ID="LogInfo.code" value="${LogInfo.code }" maxLength="50"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.LogInfo.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="LogInfo.name" ID="LogInfo.name" value="${LogInfo.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.LogInfo.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="LogInfo.type" ID="LogInfo.type" value="${LogInfo.type }" maxLength="20"   /></td>
		<td>${msg['label.LogInfo.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="LogInfo.status" ID="LogInfo.status" value="${LogInfo.status }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.LogInfo.REMARK']}</td>
		<td><INPUT TYPE="TEXT" NAME="LogInfo.remark" ID="LogInfo.remark" value="${LogInfo.remark }" maxLength="500"   /></td>
	<tr>
		<td colspan="4" align="center">
		
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/LogInfo/list?'">
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
