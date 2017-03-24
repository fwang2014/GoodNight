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
	<li><a href="<%=path%>/CostFill/list?" class="label label-info">成本管理</a> <span
		class="divider">/</span></li>
	<li class="active">成本填报</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li><a href="<%=path%>/CostFill/list?">成本查询</a></li>
	<li class="active"><a href="<%=path%>/CostFill/add?">成本填报</a></li>
	<li><a href="<%=path%>/CostFill/batch_add?">批量填报</a></li>
	<li><a href="<%=path%>/CostFill/rent_add?">房租填报</a></li>
	<li><a href="<%=path%>/CostFill/stat?">成本统计</a></li>
</ul>
</div>
</div>
</div>


<div class="bs-docs-example">

<form action="<%=path%>/CostFill/save?" method="post" id="addForm" onsubmit="return validateForm(this);"
	name="addForm"><INPUT TYPE="hidden" NAME="CostFill.id"
	value="${CostFill.id }" />
<table class="table table-bordered">
	<tr>
		<td>${msg['label.CostFill.FILL_DATE']}<font color="red">*</font></td>
		<td>		
			
			<div class="control-group">
                <div class="controls input-append date form_date" data-date="2013-08-16" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
                    <input size="16" type="text"  NAME="CostFill.fill_date" ID="CostFill.fill_date"   value="${CostFill.fill_date }" readonly="readonly">
                    <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
                </div>
				<input type="hidden" id="dtp_input1" value="" /><br/>
            </div>
		</td>
			
		<td  style="cursor:hand;">${msg['label.CostFill.TYPE']}<font color="red">*</font></td>
		<td>
			<select name="CostFill.type" id="CostFill.type">
				<option value="">--请选择--</option>
				<c:forEach items="${typeList}" var="tag" varStatus="id">	
					<c:choose>		
						<c:when test="${CostFill.type == tag.id}">
							<option value="${tag.id }" selected>${tag.remark }</option>
						</c:when>
						<c:otherwise>
							<option value="${tag.id }">${tag.remark }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>

	</tr>
	<tr>
		<td>${msg['label.CostFill.NAME']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.name" id="CostFill.name"
			value="${CostFill.name }" /></td>
		<td>${msg['label.CostFill.PRICE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.price" ID="CostFill.price"
			value="${CostFill.price }" onchange="calAmt('CostFill.price','CostFill.qty','CostFill.amt')"/></td>
	</tr>
	
	<tr>
		<td>${msg['label.CostFill.QTY']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.qty" ID="CostFill.qty"
			value="${CostFill.qty }"  onchange="calAmt('CostFill.price','CostFill.qty','CostFill.amt')"/></td>
		<td>${msg['label.CostFill.AMT']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.amt" ID="CostFill.amt"
			value="${CostFill.amt }"  onchange="inputAmt('CostFill.price','CostFill.qty','CostFill.amt')"/></td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.UNIT']}<font color="red">*</font></td>
		<td>
			<select name="CostFill.unit" id="CostFill.unit">
				<option value="">--请选择--</option>
				<c:forEach items="${unitList}" var="tag" varStatus="id">
					<option value="${tag.id }">${tag.remark }</option>
				</c:forEach>
			</select>
		</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>${msg['label.CostFill.START_VALUE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.start_value"
			value="${CostFill.start_value }" /></td>
		<td>${msg['label.CostFill.END_VALUE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.end_value"
			value="${CostFill.end_value }" /></td>
	</tr>
	<tr >
		<td>${msg['label.CostFill.REMARK']}<font color="red">*</font></td>
		<td colspan="3"><INPUT TYPE="TEXT" NAME="CostFill.remark"
			value="${CostFill.remark }" style="width:85%"/></td>
	</tr>
	
	<tr style="display: none;">
		<td>${msg['label.CostFill.CODE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.code"
			value="${CostFill.code }" /></td>
		<td>${msg['label.CostFill.VALUE_TYPE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.value_type"
			value="${CostFill.value_type }" /></td>
	</tr>

	<tr style="display: none;">
		<td>${msg['label.CostFill.STATUS']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.status"
			value="${CostFill.status }" /></td>
		<td>${msg['label.CostFill.CREATE_BY']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.create_by"
			value="${CostFill.create_by }" /></td>
	</tr>
	<tr style="display: none;">
		<td>${msg['label.CostFill.CREATE_DATE']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.create_date"
			value="${CostFill.create_date }" /></td>
		<td>${msg['label.CostFill.UPDATE_BY']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.update_by"
			value="${CostFill.update_by }" /></td>
	</tr>
	<tr style="display: none;">
		<td>${msg['label.CostFill.UPDATE_TIME']}<font color="red">*</font></td>
		<td><INPUT TYPE="TEXT" NAME="CostFill.update_time"
			value="${CostFill.update_time }" /></td>
	</tr>		
	<tr>
		<td colspan="4" align="center"><input type="submit"
			name="btn_save" class="btn btn-info" value="保存"> <input
			type="reset" name="btn_reset" class="btn btn-info" value="重置">
		<input type="button" name="btn_back" class="btn btn-info" value="取消"
			onclick="window.location='<%=path%>/CostFill/list?'"></td>
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
</div>
<!--/.fluid-container-->

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

	function validateForm(form){
    	//alert("validateForm");
    	var type = document.getElementById("CostFill.type");
    	if(type.value == ""){
			alert("请选择类型");
			type.focus();
			return false;
    	}
    	var name = document.getElementById("CostFill.name");
    	if(name.value == ""){
    		alert("请输入名称");
    		name.focus();
			return false;
    	}
    	var unit = document.getElementById("CostFill.unit");
    	if(unit.value == ""){
    		alert("请选择单位");
    		unit.focus();
			return false;
    	}
    	
    	var amt = document.getElementById("CostFill.amt");
    	if(amt.value == ""){
    		alert("请输入金额");
    		amt.focus();
			return false;
    	}
    	if(isNaN(amt.value)){
    		alert("金额必须为数字");
    		amt.value = 0;
    		amt.focus();
    		return false;
    	}
    	var f_amt = parseFloat(amt.value);
    	if(f_amt <= 0){
    		alert("金额必须大于0");
    		amt.focus();
    		return false;
    	}
    	
    	var price = document.getElementById("CostFill.price");
    	if(price.value == ""){
    		alert("请输入单价");
    		price.focus();
			return false;
    	}
    	if(isNaN(price.value)){
    		alert("单价必须为数字");
    		price.value = 0;
    		price.focus();
    		return false;
    	}
    	
    	var qty = document.getElementById("CostFill.qty");
    	if(qty.value == ""){
    		alert("请输入数量");
    		qty.focus();
			return false;
    	}
    	if(isNaN(qty.value)){
    		alert("数量必须为数字");
    		qty.value = 1;
    		qty.focus();
    		return false;
    	}   	
		return true;
    }

    //计算单价，数量和金额
    function calAmt(price,qty,amt){
    	var price1 = document.getElementById(price);
    	var qty1 = document.getElementById(qty);
    	var amt1 = document.getElementById(amt);
			amt1.value = price1.value * qty1.value;
    }

    //输入总金额，则数量默认为1，单价等于金额
    function inputAmt(price,qty,amt){
    	var price1 = document.getElementById(price);
    	var qty1 = document.getElementById(qty);
    	var amt1 = document.getElementById(amt);
    	qty1.value = 1;
    	price1.value = amt1.value;
    }

    //初始胡成本单位为第一下来选项
    function initSelectValue(){
    	var unit = document.getElementById("CostFill.unit");
    	//alert(unit.options.length);
    	if(unit.options.length>1){
			unit.options[1].selected = "selected";
    	}
    	
    	var type = document.getElementById("CostFill.type");
    	//alert(unit.options.length);
    	if(type.options.length>1){
    		type.options[1].selected = "selected";
    	}
    }

    initSelectValue();
    
</script>

</body>
</html>
