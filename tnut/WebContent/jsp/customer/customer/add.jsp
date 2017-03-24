<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mytag" uri="http://java.sun.com/jsp/mytag"%>
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
	<li><a href="<%=path%>/Customer/list?" class="label label-info">${msg['label.Customer.TABLE_CN']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Customer.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li><a href="<%=path%>/Customer/list?">${msg['label.Customer.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li class="active"><a href="<%=path%>/Customer/add?">${msg['label.Customer.TABLE_CN']}${msg['display.label.detail']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Customer/saveAll?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);" enctype="multipart/form-data">
<INPUT TYPE="hidden" NAME="Customer.id" value="${Customer.id }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.Customer.CODE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="Customer.code" ID="Customer.code" value="${Customer.code }" maxLength="20" 
		  valNullable="N" valMsg="Input Something here,please" style="margin: 0 auto;"/></td>
		<td>${msg['label.Customer.NAME']}<font color="red">*</font></td></td>
		<td>
				<INPUT TYPE="TEXT" NAME="Customer.name" ID="Customer.name" value="${Customer.name }"
				  maxLength="50"   valNullable="N" valMsg="Input Something here,please" style="margin: 0 auto;"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.TYPE']}</td>
		<td>
			<mytag:input dictCode="DATA_TYPE" id="Customer.type" value="${Customer.type }" read="y" style="margin: 0 auto;"></mytag:input>			
		</td>
		<td>${msg['label.Customer.STATUS']}</td>
		<td>
			<mytag:input dictCode="DATA_STATUS" id="Customer.status" value="${Customer.status }" read="y" style="margin: 0 auto;"></mytag:input>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.TITLE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Customer.title" ID="Customer.title" value="${Customer.title }" maxLength="20"  style="margin: 0 auto;" /></td>
		
		<td>${msg['label.Customer.SEX']}</td>
		<td>
			<mytag:select dictCode="SEX" id="Customer.sex" value="${Customer.sex}" style="margin: 0 auto;"></mytag:select>
				
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.BIRTHDAY_DATE']}</td>
		<td>
		<div class="control-group" style="margin: 0 auto;">
			<div class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" 
			 data-link-field="dtp_input1" style="margin: 0 auto;">
			<input size="16" type="text"  NAME="Customer.birthday_date" ID="Customer.birthday_date" 
			value="${Customer.birthday_date}" readonly="readonly" style="margin: 0 auto;">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
			</div>
			<input type="hidden" id="dtp_input1" value="" />
		</div>
		</td>
		<td>${msg['label.Customer.AGE']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Customer.age" ID="Customer.age" value="${Customer.age }"  style="margin: 0 auto;"  onblur="valNumber(this)" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.EDU_LEVEL']}</td>
		<td>
			<mytag:select dictCode="STUDY_LEVEL" id="Customer.edu_level" value="${Customer.edu_level }" style="margin: 0 auto;"></mytag:select>
		</td>
		<td>${msg['label.Customer.WORK_STATUS']}</td>
		<td>
			<mytag:select dictCode="WORK_STATUS" id="Customer.work_status" value="${Customer.work_status }" style="margin: 0 auto;"></mytag:select>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.MOBILE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Customer.mobile" ID="Customer.mobile" value="${Customer.mobile }" maxLength="20"  style="margin: 0 auto;" /></td>
		<td>${msg['label.Customer.TEL']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Customer.tel" ID="Customer.tel" value="${Customer.tel }"  maxLength="20"  style="margin: 0 auto;" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.PHONE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Customer.phone" ID="Customer.phone" value="${Customer.phone }" maxLength="20"  style="margin: 0 auto;" /></td>
		<td>${msg['label.Customer.HOUSE']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Customer.house" ID="Customer.house" value="${Customer.house }"  maxLength="200"   style="margin: 0 auto;"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.EMAIL']}</td>
		<td><INPUT TYPE="TEXT" NAME="Customer.email" ID="Customer.email" value="${Customer.email }" maxLength="200"  style="margin: 0 auto;" /></td>
		<td>${msg['label.Customer.QQ']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Customer.qq" ID="Customer.qq" value="${Customer.qq }"  maxLength="20"  style="margin: 0 auto;" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.MSN']}</td>
		<td><INPUT TYPE="TEXT" NAME="Customer.msn" ID="Customer.msn" value="${Customer.msn }" maxLength="20"  style="margin: 0 auto;" /></td>
		<td>${msg['label.Customer.ALIWW']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Customer.aliww" ID="Customer.aliww" value="${Customer.aliww }"  maxLength="20"  style="margin: 0 auto;" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.WEBSITE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Customer.website" ID="Customer.website" value="${Customer.website }" maxLength="200"  style="margin: 0 auto;" /></td>
		<td>${msg['label.Customer.ID_NO']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Customer.id_no" ID="Customer.id_no" value="${Customer.id_no }"  maxLength="20"  style="margin: 0 auto;" />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.BANK_CARD']}</td>
		<td><INPUT TYPE="TEXT" NAME="Customer.bank_card" ID="Customer.bank_card" value="${Customer.bank_card }" maxLength="20"   style="margin: 0 auto;"/></td>
		<td>${msg['label.Customer.DUTIES']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Customer.duties" ID="Customer.duties" value="${Customer.duties }"  maxLength="20"   style="margin: 0 auto;"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Customer.REMARK']}</td>
		<td colspan="3">
			<textarea rows="3" cols="50" style="width:85%" NAME="Customer.remark" ID="Customer.remark" maxLength="500" style="margin: 0 auto;">${Customer.remark }</textarea>
		
		</td>
	</tr>
	<tr>
		<td colspan="4">
			<jsp:include page="upload.jsp" flush="true" />
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/Customer/list?'">
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
