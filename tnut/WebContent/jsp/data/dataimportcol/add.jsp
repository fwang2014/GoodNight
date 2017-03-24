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
<li><a href="<%=path%>/DataimportCol/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.DataimportCol.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class=""><a href="<%=path%>/DataimportCol/list?">${msg['label.DataimportCol.TABLE_CN']}${msg['display.label.list']}</a></li>
<li class="active"><a href="<%=path%>/DataimportCol/add?">${msg['label.DataimportCol.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/DataimportCol/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="DataimportCol.id" value="${DataimportCol.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.DataimportCol.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="DataimportCol.code" ID="DataimportCol.code" value="${DataimportCol.code }" maxLength="50"   /></td>
		<td>${msg['label.DataimportCol.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportCol.name" ID="DataimportCol.name" value="${DataimportCol.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportCol.TYPE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="DataimportCol.type" ID="DataimportCol.type" value="${DataimportCol.type }" maxLength="20"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.DataimportCol.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportCol.status" ID="DataimportCol.status" value="${DataimportCol.status }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td colspan="3">${msg['label.DataimportCol.REMARK']}</td>
		<td>
		<textarea rows="3" cols="50" NAME="DataimportCol.remark" ID="DataimportCol.remark" style="width:85%">${DataimportCol.remark }</textarea>
		</td>
		<td>${msg['label.DataimportCol.IMPORT_PART_ID']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportCol.import_part_id" ID="DataimportCol.import_part_id" value="${DataimportCol.import_part_id }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/DataimportCol/list?'">
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
