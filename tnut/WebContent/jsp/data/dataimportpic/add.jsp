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
<li><a href="<%=path%>/DataimportPic/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.DataimportPic.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/DataimportPic/list?">${msg['label.DataimportPic.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/DataimportPic/add?">${msg['label.DataimportPic.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/DataimportPic/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="DataimportPic.id" value="${DataimportPic.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.DataimportPic.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="DataimportPic.code" ID="DataimportPic.code" value="${DataimportPic.code }" maxLength="50"   /></td>
		<td>${msg['label.DataimportPic.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportPic.name" ID="DataimportPic.name" value="${DataimportPic.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportPic.TYPE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="DataimportPic.type" ID="DataimportPic.type" value="${DataimportPic.type }" maxLength="20"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.DataimportPic.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportPic.status" ID="DataimportPic.status" value="${DataimportPic.status }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td colspan="3">${msg['label.DataimportPic.REMARK']}</td>
		<td>
		<textarea rows="3" cols="50" NAME="DataimportPic.remark" ID="DataimportPic.remark" style="width:85%">${DataimportPic.remark }</textarea>
		</td>
		<td>${msg['label.DataimportPic.IMPORT_PART_ID']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportPic.import_part_id" ID="DataimportPic.import_part_id" value="${DataimportPic.import_part_id }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportPic.PIC_NAME']}</td>
		<td><INPUT TYPE="TEXT" NAME="DataimportPic.pic_name" ID="DataimportPic.pic_name" value="${DataimportPic.pic_name }" maxLength="20"   /></td>
		<td>${msg['label.DataimportPic.PIC_TYPE']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportPic.pic_type" ID="DataimportPic.pic_type" value="${DataimportPic.pic_type }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportPic.PIC_SIZE']}</td>
		<td><INPUT TYPE="TEXT" NAME="DataimportPic.pic_size" ID="DataimportPic.pic_size" value="${DataimportPic.pic_size }" maxLength="20"   /></td>
		<td>${msg['label.DataimportPic.PIC_TEM_PATH']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="DataimportPic.pic_tem_path" ID="DataimportPic.pic_tem_path" value="${DataimportPic.pic_tem_path }"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.DataimportPic.PIC_SAVE_PATH']}</td>
		<td colspan="3"><INPUT TYPE="TEXT" NAME="DataimportPic.pic_save_path" ID="DataimportPic.pic_save_path" value="${DataimportPic.pic_save_path }" maxLength="20"   /></td>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/DataimportPic/list?'">
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
