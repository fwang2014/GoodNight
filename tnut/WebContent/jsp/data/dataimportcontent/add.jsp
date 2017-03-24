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
<li><a href="<%=path%>/DataimportContent/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.DataimportContent.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li ><a href="<%=path%>/DataimportContent/list?">${msg['label.DataimportContent.TABLE_CN']}${msg['display.label.list']}</a></li>
<li class="active"><a href="<%=path%>/DataimportContent/add?">${msg['label.DataimportContent.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/DataimportContent/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="DataimportContent.id" value="${DataimportContent.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.DataimportContent.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="DataimportContent.code" ID="DataimportContent.code" value="${DataimportContent.code }" maxLength="20"   /></td>
		<td>${msg['label.DataimportContent.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportContent.name" ID="DataimportContent.name" value="${DataimportContent.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportContent.TYPE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="DataimportContent.type" ID="DataimportContent.type" value="${DataimportContent.type }" maxLength="20"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.DataimportContent.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportContent.status" ID="DataimportContent.status" value="${DataimportContent.status }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td colspan="3">${msg['label.DataimportContent.REMARK']}</td>
		<td>
		<textarea rows="3" cols="50" NAME="DataimportContent.remark" ID="DataimportContent.remark" style="width:85%">${DataimportContent.remark }</textarea>
		</td>
		<td>${msg['label.DataimportContent.IMPORT_PART_ID']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportContent.import_part_id" ID="DataimportContent.import_part_id" value="${DataimportContent.import_part_id }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportContent.CONTENT']}</td>
		<td><INPUT TYPE="TEXT" NAME="DataimportContent.content" ID="DataimportContent.content" value="${DataimportContent.content }" maxLength="2000"   /></td>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/DataimportContent/list?'">
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
