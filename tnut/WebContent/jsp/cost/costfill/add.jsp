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
	<li><a href="<%=path%>/CostFill2/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.CostFill.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li><a href="<%=path%>/CostFill2/list?">${msg['label.CostFill.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li  class="active"><a href="<%=path%>/CostFill2/add?">${msg['label.CostFill.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/CostFill/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="CostFill.id" value="${CostFill.id }"/>
<INPUT TYPE="hidden" NAME="TOKEN" value="${TOKEN }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.CostFill.CODE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.code" ID="CostFill.code" value="${CostFill.code }" maxLength="20"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.CostFill.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="CostFill.name" ID="CostFill.name" value="${CostFill.name }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.START_VALUE']}</td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.start_value" ID="CostFill.start_value" value="${CostFill.start_value }" maxLength="50"   /></td>
		<td>${msg['label.CostFill.END_VALUE']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="CostFill.end_value" ID="CostFill.end_value" value="${CostFill.end_value }"  maxLength="50"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.VALUE_TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.value_type" ID="CostFill.value_type" value="${CostFill.value_type }"   onblur="valNumber(this)" /></td>
		<td>${msg['label.CostFill.PRICE']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="CostFill.price" ID="CostFill.price" value="${CostFill.price }"     />
		</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.QTY']}</td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.qty" ID="CostFill.qty" value="${CostFill.qty }"    /></td>
		<td>${msg['label.CostFill.AMT']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="CostFill.amt" ID="CostFill.amt" value="${CostFill.amt }"     />
		</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.UNIT']}</td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.unit" ID="CostFill.unit" value="${CostFill.unit }" maxLength="50"   /></td>
		<td>${msg['label.CostFill.TYPE']}<font color="red">*</font></td></td>
		<td>
				<INPUT TYPE="TEXT" NAME="CostFill.type" ID="CostFill.type" value="${CostFill.type }"  maxLength="50"   valNullable="N" valMsg="Input Something here,please"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.STATUS']}</td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.status" ID="CostFill.status" value="${CostFill.status }"   onblur="valNumber(this)" /></td>
	</tr><tr>
		<td >${msg['label.CostFill.REMARK']}</td>
		<td colspan="3">
		<textarea rows="3" cols="50" NAME="CostFill.remark" ID="CostFill.remark" style="width:85%">${CostFill.remark }</textarea>
		</td>
	<tr>
		<td>${msg['label.CostFill.FILL_DATE']}<font color="red">*</font></td></td>
		<td>
		<div class="control-group">
			<div class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
			<input size="16" type="text"  NAME="CostFill.fill_date" ID="CostFill.fill_date" 
			value="${CostFill.fill_date}" readonly="readonly">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
			</div>
			<input type="hidden" id="dtp_input1" value="" />
		</div>
		</td>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/CostFill/list?'">
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
