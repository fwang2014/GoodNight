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
<div class="row-fluid"><jsp:include page="/include/menu_cost.jsp"
	flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/SmCosttype/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.SmCosttype.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li ><a href="<%=path%>/SmCosttype/list?">${msg['label.SmCosttype.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li class="active"><a href="<%=path%>/SmCosttype/add?">${msg['label.SmCosttype.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/SmCosttype/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="SmCosttype.id" value="${SmCosttype.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.SmCosttype.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="SmCosttype.code" ID="SmCosttype.code" value="${SmCosttype.code }" maxLength="50"   /></td>
		<td>${msg['label.SmCosttype.NAME']}<font color="red">*</font></td></td>
		<td>
				<INPUT TYPE="TEXT" NAME="SmCosttype.name" ID="SmCosttype.name" value="${SmCosttype.name }"  maxLength="50"   valNullable="N" valMsg="Input Something here,please"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.SmCosttype.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="SmCosttype.type" ID="SmCosttype.type" value="${SmCosttype.type }" maxLength="20"   /></td>
	</tr><tr>
		<td >${msg['label.SmCosttype.REMARK']}</td>
		<td colspan="3">
		<textarea rows="3" cols="50" NAME="SmCosttype.remark" ID="SmCosttype.remark" style="width:85%">${SmCosttype.remark }</textarea>
		</td>
	<tr>
		<td>${msg['label.SmCosttype.STATUS']}</td>
		<td><INPUT TYPE="TEXT" NAME="SmCosttype.status" ID="SmCosttype.status" value="${SmCosttype.status }"   onblur="valNumber(this)" /></td>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/SmCosttype/list?'">
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
			var url = "<%=path%>
	/Phonebook/checkPhone?";
						var value = this.value;
						jQuery.post(url, {
							phone : value
						}, function(data) {
							if (data) {
								//alert(data.name);
								var json = eval('(' + data + ')');
								//alert(json);
								var name = json.name;
								var phone = json.phone;
								var result = confirm(name + "[" + phone
										+ "]已经存在，是否继续添加？");
								if (result) {
									//确认后操作
							} else {
								//取消后操作
							}
						}

					}	);
					}
				});
		});
</script>

</body>
</html>
