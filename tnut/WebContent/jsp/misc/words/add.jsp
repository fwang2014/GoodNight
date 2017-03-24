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
<li><a href="<%=path%>/Words/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.Words.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/Words/list?">${msg['label.Words.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/Words/add?">${msg['label.Words.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Words/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="Words.id" value="${Words.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.Words.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Words.code" ID="Words.code" value="${Words.code }" maxLength="20"   /></td>
		<td>${msg['label.Words.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Words.name" ID="Words.name" value="${Words.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Words.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Words.type" ID="Words.type" value="${Words.type }" maxLength="20"  readonly="readonly" /></td>
		<td>${msg['label.Words.STATUS']}</td>
		<td>
			<INPUT TYPE="TEXT" NAME="Words.status" ID="Words.status" value="${Words.status }"    onblur="valNumber(this)"  readonly="readonly"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Words.REMARK']}</td>
		<td colspan="3">
			<textarea rows="3" cols="50" style="width:85%" NAME="Words.remark" ID="Words.remark">${Words.remark }</textarea>
		</td>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/Words/list?'">
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
