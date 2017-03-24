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
<link href="<%=path%>/assets/css/datetimepicker.css" rel="stylesheet">

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
	<li><a href="<%=path%>/CostFill/list?" class="label label-info">成本管理</a>
	<span class="divider">/</span></li>
	<li class="active">成本填报</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">

	<li><a href="<%=path%>/CostFill/list?">成本查询</a></li>
	<li><a href="<%=path%>/CostFill/add?">成本填报</a></li>
	<li><a href="<%=path%>/CostFill/batch_add?">批量填报</a></li>
	<li class="active"><a href="<%=path%>/CostFill/rent_add?">房租填报</a></li>
	<li><a href="<%=path%>/CostFill/stat?">成本统计</a></li>
</ul>
</div>
</div>
</div>


<div class="bs-docs-example">

<form action="<%=path%>/CostFill/batch_save?" method="post" id="addForm"
	onsubmit="return validateForm(this);" name="addForm"><INPUT
	TYPE="hidden" NAME="CostFill.id" value="${CostFill.id }" /> <input
	type="hidden" id="dtp_input1" value="" />

<div class="control-group">
<div class="controls input-append date form_date" data-date="2013-08-16"
	data-date-format="yyyy-mm-dd" data-link-field="dtp_input1"><span
	class="add-on">${msg['label.CostFill.FILL_DATE']}</span> <input
	size="16" type="text" NAME="CostFill.fill_date" ID="CostFill.fill_date"
	value="${CostFill.fill_date }" readonly="readonly"> <span
	class="add-on"><i class="icon-remove"></i></span> <span class="add-on"><i
	class="icon-th"></i></span></div>
</div>

<table class="table table-bordered">
	<thead>
		<tr>
			<th width="20%">${msg['label.CostFill.TYPE']}</th>
			<th width="20%">${msg['label.CostFill.START_VALUE']}</th>
			<th width="20%">${msg['label.CostFill.END_VALUE']}</th>
			<th width="20%">${msg['label.CostFill.QTY']}</th>
			<th width="20%">${msg['label.CostFill.AMT']}</th>
			<th width="20%">${msg['label.CostFill.UNIT']}</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${typeList}" var="tag" varStatus="id">
			<tr>
				<td nowrap><input type="hidden" name="type" id="type"
					value="${tag.id }"> <input type="text" name="type2"
					id="type2" value="${tag.remark }" readonly class="input-small"></td>
				<td nowrap><input type="text" name="start_value" id="start_value"
					value="" class="input-mini"></td>
				<td nowrap><input type="text" name="end_value" id="end_value"
					value="" class="input-mini"></td>
					<td nowrap><input type="text" name="qty" id="qty"
					class="input-mini" value="1"></td>
				<td nowrap><input type="text" name="amt" id="amt" value="" class="input-small"></td>
				<td nowrap><input type="text" name="unit" id="unit" value="" class="input-small"></td>
			</tr>
		</c:forEach>


		<TR>
			<td>${msg['label.CostFill.REMARK']}</td>
			<td colspan="4"><INPUT TYPE="TEXT" NAME="CostFill.remark"
				ID="CostFill.remark" value="${CostFill.remark }" style="width: 85%" /></td>
		</TR>
		<TR>
			<td colspan="5"><input type="submit" name="btn_save"
				class="btn btn-info" value="保存"> <input type="reset"
				name="btn_reset" class="btn btn-info" value="重置"> <input
				type="button" name="btn_back" class="btn btn-info" value="取消"
				onclick="window.location='<%=path%>/CostFill/list?'"></td>
		</TR>
	</tbody>
</table>

</form>

</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" /> <jsp:include
	page="/include/js.jsp" flush="true" /></div>
<!--/.fluid-container-->

<script type="text/javascript">
	$('.form_date').datetimepicker( {
		language : 'cs',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});

	/*$('.form_datetime').datetimepicker({
	    //language:  'fr',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
	    showMeridian: 1
	});
	$('.form_date').datetimepicker({
	    language:  'fr',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
	});
	$('.form_time').datetimepicker({
	    language:  'fr',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 0,
		maxView: 1,
		forceParse: 0
	});*/

	function validateForm(form) {

		return true;
	}

	//计算单价，数量和金额
	function calAmt(price, qty, amt) {
		var price1 = document.getElementById(price);
		var qty1 = document.getElementById(qty);
		var amt1 = document.getElementById(amt);
		amt1.value = price1.value * qty1.value;
	}

	//输入总金额，则数量默认为1，单价等于金额
	function inputAmt(price, qty, amt) {
		var price1 = document.getElementById(price);
		var qty1 = document.getElementById(qty);
		var amt1 = document.getElementById(amt);
		qty1.value = 1;
		price1.value = amt1.value;
	}

	//初始胡成本单位为第一下来选项
	function initSelectValue() {
		var unit = document.getElementById("CostFill.unit");
		//alert(unit.options.length);
		if (unit.options.length > 1) {
			unit.options[1].selected = "selected";
		}

		var type = document.getElementById("CostFill.type");
		//alert(unit.options.length);
		if (type.options.length > 1) {
			type.options[1].selected = "selected";
		}
	}

	initSelectValue();
</script>

</body>
</html>
