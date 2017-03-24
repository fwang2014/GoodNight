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
<li><a href="<%=path%>/PasswordInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.PasswordInfo.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class=""><a href="<%=path%>/PasswordInfo/list?">${msg['label.PasswordInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/PasswordInfo/add?">${msg['label.PasswordInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
<li class="active"><a href="<%=path%>/PasswordInfo/userlist?">${msg['label.User.TABLE_CN']}${msg['display.label.list']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/PasswordInfo/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="PasswordInfo.id" value="${PasswordInfo.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.PasswordInfo.USER_ID']}</td>
		<td>
			<INPUT TYPE="TEXT" NAME="PasswordInfo.user_id" ID="PasswordInfo.user_id" value="${PasswordInfo.user_id }" 
			   onblur="valNumber(this)" />
		</td>
		<td>${msg['label.User.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="name" ID="name" value="${PasswordInfo.name }"  maxLength="50"   />
		</td>
	</tr>
	
	<tr>
		
		<td>${msg['label.PasswordInfo.OLD.PASSWORD']}</td>
		<td>
				<INPUT TYPE="password" NAME="old_password" ID="old_password" value=""  maxLength="50"   />
		</td>
		<td>${msg['label.PasswordInfo.CODE']}</td>
		<td><INPUT TYPE="password" NAME="PasswordInfo.code" ID="PasswordInfo.code" value="" maxLength="20"   /></td>
	</tr>
	<tr>
		
		<td>${msg['label.PasswordInfo.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="PasswordInfo.name" ID="PasswordInfo.name" value="${PasswordInfo.name }"  maxLength="50"   />
		</td>
		<td>${msg['label.PasswordInfo.PASSWORD.CONFIRM']}</td>
		<td><INPUT TYPE="password" NAME="password_confirm" ID="password_confirm" value="" maxLength="50"   /></td>
	</tr>
	<tr>
		<td>${msg['label.PasswordInfo.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="PasswordInfo.type" ID="PasswordInfo.type" value="${PasswordInfo.type }" maxLength="20" readonly="readonly"  /></td>
		<td>${msg['label.PasswordInfo.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="PasswordInfo.status" ID="PasswordInfo.status" value="${PasswordInfo.status }"   readonly="readonly"   onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.PasswordInfo.REMARK']}</td>
		<td colspan="3">
			<textarea rows="3" cols="50" NAME="PasswordInfo.remark" ID="PasswordInfo.remark" style="width:85%">${PasswordInfo.remark }</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/PasswordInfo/list?'">
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
