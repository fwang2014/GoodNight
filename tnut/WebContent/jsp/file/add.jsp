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

<link href="<%=path%>/assets/css/datetimepicker.css" rel="stylesheet">

</head>

<body data-spy="scroll" data-target=".sidebar-nav">

<jsp:include page="/include/top.jsp" flush="true" />

<div class="container-fluid">
<div class="row-fluid">
	<jsp:include	page="/include/menu_data.jsp" flush="true" />
<div class="span9">

<div>

<ul class="breadcrumb">
<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/FileUpload/list?" class="label label-info">IT${msg['label.FileUpload.TABLE_CN']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.FileUpload.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/FileUpload/list?">${msg['label.FileUpload.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/FileUpload/add?">${msg['label.FileUpload.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/FileUpload/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="FileUpload.id" value="${FileUpload.id }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.FileUpload.CODE']}<font color="red">*</font></td></td>
		<td>
			<INPUT TYPE="TEXT" NAME="FileUpload.code" ID="FileUpload.code" value="${FileUpload.code }" 
		 	 maxLength="20"   valNullable="N" valMsg="Input Something here,please" style="margin: 0 auto;"/></td>
		<td>${msg['label.FileUpload.NAME']}<font color="red">*</font></td>
		<td>
			<INPUT TYPE="TEXT" NAME="FileUpload.name" ID="FileUpload.name" value="${FileUpload.name }" 
				  maxLength="50"   valNullable="N" valMsg="Input Something here,please" style="margin: 0 auto;"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.FileUpload.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="FileUpload.type" ID="FileUpload.type" value="${FileUpload.type }" maxLength="20"   readonly="readonly" /></td>
		<td>${msg['label.FileUpload.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="FileUpload.status" ID="FileUpload.status" value="${FileUpload.status }"   readonly="readonly"  onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.FileUpload.REMARK']}</td>
		<td><INPUT TYPE="TEXT" NAME="FileUpload.remark" ID="FileUpload.remark" value="${FileUpload.remark }" maxLength="500"   /></td>
		<td>${msg['label.FileUpload.FILE_TYPE']}<font color="red">*</font></td></td>
		<td>
				<INPUT TYPE="TEXT" NAME="FileUpload.file_type" ID="FileUpload.file_type" value="${FileUpload.file_type }"  maxLength="20"   valNullable="N" valMsg="Input Something here,please"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.FileUpload.FILE_SIZE']}</td>
		<td><INPUT TYPE="TEXT" NAME="FileUpload.file_size" ID="FileUpload.file_size" value="${FileUpload.file_size }"    /></td>
		<td>${msg['label.FileUpload.FILE_OLD_NAME']}<font color="red">*</font></td></td>
		<td>
				<INPUT TYPE="TEXT" NAME="FileUpload.file_old_name" ID="FileUpload.file_old_name" value="${FileUpload.file_old_name }"  maxLength="200"   valNullable="N" valMsg="Input Something here,please"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.FileUpload.FILE_NEW_NAME']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="FileUpload.file_new_name" ID="FileUpload.file_new_name" value="${FileUpload.file_new_name }" maxLength="200"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.FileUpload.SAVE_PATH']}<font color="red">*</font></td></td>
		<td>
				<INPUT TYPE="TEXT" NAME="FileUpload.save_path" ID="FileUpload.save_path" value="${FileUpload.save_path==null?"#": FileUpload.save_path}" 
				  maxLength="200"   valNullable="N" valMsg="Input Something here,please" readonly="readonly"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.FileUpload.SAVE_TEM_PATH']}</td>
		<td><INPUT TYPE="TEXT" NAME="FileUpload.save_tem_path" ID="FileUpload.save_tem_path" value="${FileUpload.save_tem_path }" maxLength="200"   /></td>
		<td>${msg['label.FileUpload.REF_ID']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="FileUpload.ref_id" ID="FileUpload.ref_id" value="${FileUpload.ref_id }"    onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.FileUpload.REF_TYPE']}</td>
		<td colspan="3"><INPUT TYPE="TEXT" NAME="FileUpload.ref_type" ID="FileUpload.ref_type" value="${FileUpload.ref_type }" maxLength="20"   /></td>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="重置"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/FileUpload/list?'">
		</td>
	</tr>
</table>
</form>


</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" />
<jsp:include page="/include/js.jsp" flush="true" />

<script type="text/javascript">
	$('.form_date').datetimepicker({
	    language:  'cs',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
	});	
</script>

</body>
</html>
