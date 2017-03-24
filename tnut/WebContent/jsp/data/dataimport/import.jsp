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
<li><a href="<%=path%>/DataimportInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li>${msg['label.DataimportInfo.TABLE_CN']}${msg['display.label.detail']}</li>

</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li ><a href="<%=path%>/DataimportInfo/list?">${msg['label.DataimportInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/DataimportInfo/add?">${msg['label.DataimportInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
<li class="active"><a href="<%=path%>/DataimportInfo/import?">${msg['label.DataimportInfo.IMPORT']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/DataimportInfo/saveImport?" method="post"  id="importForm" name="importForm" onsubmit="return valForm(this);" enctype="multipart/form-data">
<INPUT TYPE="hidden" NAME="DataimportInfo.id" value="${DataimportInfo.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.DataimportInfo.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="DataimportInfo.code" ID="DataimportInfo.code" value="${DataimportInfo.code }" maxLength="20"   /></td>
		<td>${msg['label.DataimportInfo.NAME']}</td>
		<td>
			<INPUT TYPE="TEXT" NAME="DataimportInfo.name" ID="DataimportInfo.name" value="${DataimportInfo.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportInfo.TYPE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="DataimportInfo.type" ID="DataimportInfo.type" value="${DataimportInfo.type }" maxLength="20"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.DataimportInfo.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportInfo.status" ID="DataimportInfo.status" value="${DataimportInfo.status }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportInfo.DOC']}<font color="red">*</font></td></td>
		<td>
			<input type="file" name="doc" id="doc" />
		</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/DataimportInfo/list?'">
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
