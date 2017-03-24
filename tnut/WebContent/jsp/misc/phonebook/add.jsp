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
	page="/include/menu_customer.jsp" flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/Phonebook/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Phonebook.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/Phonebook/list?">${msg['label.Phonebook.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li><a href="<%=path%>/Phonebook/add?">${msg['label.Phonebook.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Phonebook/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="Phonebook.id" value="${Phonebook.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		
		<td>${msg['label.Phonebook.NAME']}</td>
		<td>
				<input TYPE="text" NAME="Phonebook.name" ID="Phonebook.name" value="${Phonebook.name }"  maxLength="20" valNullable="N" />
		</td>
				<td>${msg['label.Phonebook.PHONE']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Phonebook.phone" ID="Phonebook.phone" value="${Phonebook.phone }"  maxLength="20"  valNullable="N" />
		</td>
	</tr>
	<tr>
		
		<td>${msg['label.Phonebook.AREA_CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Phonebook.area_code" ID="Phonebook.area_code" value="${Phonebook.area_code }" maxLength="20"   /></td>
		<td>${msg['label.Phonebook.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Phonebook.code" ID="Phonebook.code" value="${Phonebook.code }" maxLength="20"   /></td>
	</tr>
	<tr>
		<td>${msg['label.Phonebook.TYPE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="Phonebook.type" ID="Phonebook.type" value="${Phonebook.type }" maxLength="20" readonly="readonly"  valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.Phonebook.STATUS']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Phonebook.status" ID="Phonebook.status" value="${Phonebook.status }" readonly="readonly" onblur="valNumber(this)" />
		</td>
	</tr>
	
	<tr>
		<td>${msg['label.Phonebook.REMARK']}</td>
		<td  colspan="3">
		<textarea rows="3" cols="50" NAME="Phonebook.remark" ID="Phonebook.remark" style="width:85%">${Phonebook.remark }</textarea>
		</td>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/Phonebook/list?'">
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

<script language="javascript">

$(document).ready(function(){
	  // 在这里写你的代码...
	$("input[type='text']").change(function(){
		//alert(this.id)
		var id = this.id;
		if("Phonebook.name" == id){
			//alert(id);
			var url = "<%=path%>/Phonebook/checkName?";
			var value = this.value;
			jQuery.post(url,{name:value},function(data){				
				if(data){
					var json = eval('(' + data + ')');
					var name = json.name;
					var phone = json.phone;
					var result = confirm(name+"["+phone+"]已经存在，是否继续添加？");
					if(result){
						//确认后操作
					}else{
						//取消后操作
					}
				}
					
			});
			//alert(this.value);
		}
		if("Phonebook.phone" == id){
			var url = "<%=path%>/Phonebook/checkPhone?";
			var value = this.value;
			jQuery.post(url,{phone:value},function(data){
				if(data){
					//alert(data.name);
					var json = eval('(' + data + ')');
					//alert(json);
					var name = json.name;
					var phone = json.phone;
					var result = confirm(name+"["+phone+"]已经存在，是否继续添加？");
					if(result){
						//确认后操作
					}else{
						//取消后操作
					}
				}
				
			});
		}
	});
}); 

</script>

</body>
</html>
