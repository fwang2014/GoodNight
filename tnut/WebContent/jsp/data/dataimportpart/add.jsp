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
	page="/include/menu_data.jsp" flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/DataimportPart/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.DataimportPart.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li ><a href="<%=path%>/DataimportPart/list?">${msg['label.DataimportPart.TABLE_CN']}${msg['display.label.list']}</a></li>
<li class="active"><a href="<%=path%>/DataimportPart/add?">${msg['label.DataimportPart.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/DataimportPart/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="DataimportPart.id" value="${DataimportPart.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.DataimportPart.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="DataimportPart.code" ID="DataimportPart.code" value="${DataimportPart.code }" maxLength="20"   /></td>
		<td>${msg['label.DataimportPart.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportPart.name" ID="DataimportPart.name" value="${DataimportPart.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportPart.TYPE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="DataimportPart.type" ID="DataimportPart.type" value="${DataimportPart.type }" maxLength="20"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.DataimportPart.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportPart.status" ID="DataimportPart.status" value="${DataimportPart.status }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>

		<td>${msg['label.DataimportPart.IMPORT_ID']}</td>
		<td colspan="3">
				<INPUT TYPE="TEXT" NAME="DataimportPart.import_id" ID="DataimportPart.import_id" value="${DataimportPart.import_id }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportPart.REMARK']}</td>
		<td colspan="3">
		<textarea rows="3" cols="50" NAME="DataimportPart.remark" ID="DataimportPart.remark" style="width:85%">${DataimportPart.remark }</textarea>
		</td>

	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/DataimportPart/list?'">
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
