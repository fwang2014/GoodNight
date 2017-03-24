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
	<li><a href="<%=path%>/SmCost/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.SmCost.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li><a href="<%=path%>/SmCost/list?">${msg['label.SmCost.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li class="active"><a href="<%=path%>/SmCost/add?">${msg['label.SmCost.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path%>/SmCost/save?" method="post" id="addForm"
	name="addForm" onsubmit="return valForm(this);"><INPUT
	TYPE="hidden" NAME="SmCost.id" value="${SmCost.id }" /> <INPUT
	TYPE="hidden" NAME="TOKEN" value="${TOKEN }" />
<table class="table table-bordered">
	<tr>
		<td>${msg['label.SmCost.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="SmCost.code" ID="SmCost.code"
			value="${SmCost.code }" maxLength="50" /></td>
		<td>${msg['label.SmCost.NAME']}<font color="red">*</font></td>
		</td>
		<td><INPUT TYPE="TEXT" NAME="SmCost.name" ID="SmCost.name"
			value="${SmCost.name }" maxLength="50" valNullable="N"
			valMsg="Input Something here,please" /></td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.TYPE']}</td>
		<td><INPUT TYPE="TEXT" NAME="SmCost.type" ID="SmCost.type"
			value="${SmCost.type }" maxLength="20" /></td>
		<td>${msg['label.SmCost.HAPPENDATE']}<font color="red">*</font></td>
		</td>
		<td>
		<div class="control-group">
		<div class="controls input-append date form_date"
			data-date="2013-10-06" data-date-format="yyyy-mm-dd"
			data-link-field="dtp_input1"><input size="16" type="text"
			NAME="SmCost.happendate" ID="SmCost.happendate"
			value="${SmCost.happendate}" readonly="readonly"> <span
			class="add-on"><i class="icon-remove"></i></span> <span
			class="add-on"><i class="icon-th"></i></span></div>
		<input type="hidden" id="dtp_input1" value="" /></div>
		</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.FILLDATE']}</td>
		<td>
		<div class="control-group">
		<div class="controls input-append date form_date"
			data-date="2013-10-06" data-date-format="yyyy-mm-dd"
			data-link-field="dtp_input1"><input size="16" type="text"
			NAME="SmCost.filldate" ID="SmCost.filldate"
			value="${SmCost.filldate}" readonly="readonly"> <span
			class="add-on"><i class="icon-remove"></i></span> <span
			class="add-on"><i class="icon-th"></i></span></div>
		<input type="hidden" id="dtp_input1" value="" /></div>
		</td>
		<td>${msg['label.SmCost.FILLUSER']}</td>
		<td><INPUT TYPE="TEXT" NAME="SmCost.filluser"
			ID="SmCost.filluser" value="${SmCost.filluser }" maxLength="20" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.PRICE']}</td>
		<td><INPUT TYPE="TEXT" NAME="SmCost.price" ID="SmCost.price"
			value="${SmCost.price }" /></td>
		<td>${msg['label.SmCost.QTY']}</td>
		<td><INPUT TYPE="TEXT" NAME="SmCost.qty" ID="SmCost.qty"
			value="${SmCost.qty }" /></td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.AMOUNT']}</td>
		<td><INPUT TYPE="TEXT" NAME="SmCost.amount" ID="SmCost.amount"
			value="${SmCost.amount }" /></td>
	</tr>
	<tr>
		<td>${msg['label.SmCost.REMARK']}</td>
		<td colspan="3"><textarea rows="3" cols="50" NAME="SmCost.remark"
			ID="SmCost.remark" style="width: 85%">${SmCost.remark }</textarea></td>
	<tr>
		<td>${msg['label.SmCost.UNIT']}<font color="red">*</font></td>
		</td>
		<td><INPUT TYPE="TEXT" NAME="SmCost.unit" ID="SmCost.unit"
			value="${SmCost.unit }" maxLength="45" valNullable="N"
			valMsg="Input Something here,please" /></td>
		<td>${msg['label.SmCost.STATUS']}<font color="red">*</font></td>
		</td>
		<td><INPUT TYPE="TEXT" NAME="SmCost.status" ID="SmCost.status"
			value="${SmCost.status }" onblur="valNumber(this)" valNullable="N"
			valMsg="Input Something here,please" /></td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type="submit"
			name="btn_save" class="btn btn-info" value="${msg['operate.save']}">
		<input type="reset" name="btn_reset" class="btn btn-info"
			value="${msg['operate.reset']}"> <input type="button"
			name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}"
			onclick="window.location='<%=path%>/SmCost/list?'"></td>
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
