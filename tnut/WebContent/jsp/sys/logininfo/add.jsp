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
<li><a href="<%=path%>/LoginInfo/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.LoginInfo.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/LoginInfo/list?">${msg['label.LoginInfo.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/LoginInfo/add?">${msg['label.LoginInfo.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/LoginInfo/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="LoginInfo.id" value="${LoginInfo.id }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.LoginInfo.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="LoginInfo.code" ID="LoginInfo.code" value="${LoginInfo.code }" maxLength="20"   /></td>
		<td>${msg['label.LoginInfo.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="LoginInfo.name" ID="LoginInfo.name" value="${LoginInfo.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.LoginInfo.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="LoginInfo.type" ID="LoginInfo.type" value="${LoginInfo.type }" maxLength="20"   /></td>
		<td>${msg['label.LoginInfo.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="LoginInfo.status" ID="LoginInfo.status" value="${LoginInfo.status }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.LoginInfo.REMARK']}</td>
		<td><INPUT TYPE="TEXT" NAME="LoginInfo.remark" ID="LoginInfo.remark" value="${LoginInfo.remark }" maxLength="500"   /></td>
		<td>${msg['label.LoginInfo.REQ_ID']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="LoginInfo.req_id" ID="LoginInfo.req_id" value="${LoginInfo.req_id }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.LoginInfo.REQ_ADDR']}</td>
		<td><INPUT TYPE="TEXT" NAME="LoginInfo.req_addr" ID="LoginInfo.req_addr" value="${LoginInfo.req_addr }" maxLength="50"   /></td>
		<td>${msg['label.LoginInfo.REQ_PORT']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="LoginInfo.req_port" ID="LoginInfo.req_port" value="${LoginInfo.req_port }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.LoginInfo.REQ_URI']}</td>
		<td><INPUT TYPE="TEXT" NAME="LoginInfo.req_uri" ID="LoginInfo.req_uri" value="${LoginInfo.req_uri }" maxLength="20"   /></td>
		<td>${msg['label.LoginInfo.REQ_USER']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="LoginInfo.req_user" ID="LoginInfo.req_user" value="${LoginInfo.req_user }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="重置"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/LoginInfo/list?'">
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
