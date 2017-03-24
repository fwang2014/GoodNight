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
	<li><a href="<%=path%>/Dothing/list?" class="label label-info">${msg['display.label.nav.customer']}</a>
	<span class="divider">/</span></li>
	<li class="active">${msg['label.Dothing.TABLE_CN']}${msg['display.label.detail']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li><a href="<%=path%>/Dothing/list?">${msg['label.Dothing.TABLE_CN']}${msg['display.label.list']}</a></li>
	<li class="active"><a href="<%=path%>/Dothing/add?">${msg['label.Dothing.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Dothing/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="Dothing.id" value="${Dothing.id }"/>
<table class="table table-bordered">
	<tr>
		<!--
		<td>${msg['label.Dothing.CUSTOMER_ID']}</td>
		<td><INPUT TYPE="TEXT" NAME="Dothing.customer_id" ID="Dothing.customer_id"
		 value="${Dothing.customer_id }"   onblur="valNumber(this)" readonly="readonly"/>
		 	<a href="#myModal" role="button" class="btn" data-toggle="modal">
			 <i	class="icon-user"></i></a>
		 </td>
		-->
		<td>${msg['label.Customer.CODE']}</td>
		<td colspan="1">
			<INPUT TYPE="hidden" NAME="Dothing.customer_id" ID="Dothing.customer_id" value="${Dothing.customer_id }" />
			<INPUT TYPE="TEXT" NAME="Customer.code" ID="Customer.code" maxLength="20" readonly="readonly" value="" />
			<a href="#myModal" role="button" class="btn" data-toggle="modal">
			<i	class="icon-user"></i></a>
		</td>
		<td>${msg['label.Dothing.CUSTOMER_NAME']}</td>
		<td colspan="1">
			<INPUT TYPE="TEXT" NAME="Dothing.customer_name" ID="Dothing.customer_name" value="${Dothing.customer_name }" 
			valNullable="N" readonly="readonly"  maxLength="20"   />
		</td>
	</tr>
	<tr>
		<td>${msg['label.Dothing.CODE']}<font color="red">*</font></td></td>
		<td><INPUT TYPE="TEXT" NAME="Dothing.code" ID="Dothing.code" value="${Dothing.code }" maxLength="20"   valNullable="N" valMsg="Input Something here,please"/></td>
		<td>${msg['label.Dothing.NAME']}<font color="red">*</font></td></td>
		<td>
			<INPUT TYPE="TEXT" NAME="Dothing.name"
			 ID="Dothing.start_time" value="${Dothing.name }"  maxLength="50"   valNullable="N" valMsg="Input Something here,please"/>
		</td>
	</tr>

	<tr>
		<!--  
		<td>${msg['label.Dothing.START_TIME']}</td>
		<td>
			<div id="div_dtp_input1" class="controls input-append date form_datetime" data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
			<input size="16" type="text"  NAME="Dothing.start_time" ID="Dothing.start_time" value="${Dothing.start_time}" readonly="readonly">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
			</div>
			<input type="hidden" id="dtp_input1" value="" />			
		</td>
		-->
		<td>${msg['label.Dothing.END_TIME']}</td>
		<td colspan="3">
			<div  id="div_dtp_input3" class="controls input-append date form_date" data-date="2013-10-06" data-date-format="yyyy-mm-dd" data-link-field="dtp_input3">
			<input size="16" type="text"  NAME="Dothing.start_time" ID="Dothing.start_time" value="${Dothing.start_time}" readonly="readonly">
			<input type="hidden"  NAME="Dothing.end_time" ID="Dothing.end_time" value="${Dothing.start_time}">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
			</div>
			<input type="hidden" id="dtp_input3" value="" />
			&nbsp;
			从
			<mytag:select dictCode="TIME_HOUR" id="hour1" style="width:80px" value="9"></mytag:select>
			<mytag:select dictCode="TIME_MIN" id="min1" style="width:80px" value="00"></mytag:select>
			到
			<mytag:select dictCode="TIME_HOUR" id="hour2" style="width:80px" value="18"></mytag:select>
			<mytag:select dictCode="TIME_MIN" id="min2" style="width:80px" value="00"></mytag:select>
		</td>
	</tr>
	<tr>
		
		<td>${msg['label.Dothing.DO_TYPE']}</td>
		<td>
			<mytag:select dictCode="DOTHING_TYPE" id="Dothing.do_type" value="${Dothing.do_type }"></mytag:select>
			
		</td>
		<td>${msg['label.Dothing.DO_STATUS']}</td>
		<td>
			<mytag:select dictCode="DOTHING_STATUS" id="Dothing.do_status" value="${Dothing.do_status }"></mytag:select>
		</td>
	</tr>
	<tr>	
		<td>${msg['label.Dothing.RE_PERSONS']}</td>
		<td colspan="3">
				<INPUT TYPE="TEXT" NAME="Dothing.re_persons" ID="Dothing.re_persons" value="${Dothing.re_persons }" 
				style="width:85%" maxLength="50"   />
		</td>
	</tr>
		<tr>
		<td>${msg['label.Dothing.TYPE']}</td>
		<td>
			<mytag:input dictCode="DATA_TYPE" id="Dothing.type" read="Y" value="${Dothing.type }"></mytag:input>
		</td>
		<td>${msg['label.Dothing.STATUS']}</td>
		<td>
			<mytag:input dictCode="DATA_STATUS" id="Dothing.status" read="Y" value="${Dothing.status }"></mytag:input>
				
		</td>
	</tr>
	<tr>
		<td>${msg['label.Dothing.REMARK']}</td>
		<td colspan="3">
			<textarea rows="3" cols="50" style="width:85%" NAME="Dothing.remark" ID="Dothing.remark" value="${Dothing.remark }"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="${msg['operate.save']}"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="${msg['operate.reset']}"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="${msg['operate.cancel']}" onclick="window.location='<%=path %>/Dothing/list?'">
		</td>
	</tr>
</table>
</form>


</div>


</div>
<!--/span--></div>
<!--/row-->

<!-- Modal start -->
<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal"	aria-hidden="true">×</button>
<h3 id="myModalLabel">客户选择列表</h3>
</div>
<div class="modal-body">
<p>
<table class="table table-bordered">
	<thead>
		<tr>
			<th><input type="checkbox" name="all" onclick="selectAll('ids')"></th>
			<th>#</th>
			<th>${msg['label.Customer.CODE']}</th>
			<th>${msg['label.Customer.NAME']}</th>
			<th>${msg['label.Customer.SEX']}</th>

			<th>${msg['label.Customer.AGE']}</th>
			<th>${msg['label.Customer.EDU_LEVEL']}</th>
			<th>${msg['label.Customer.WORK_STATUS']}</th>

		</tr>
	</thead>
	<tbody>

		<c:forEach items="${list}" var="tag" varStatus="id">
			<tr class="tr_data">
				<td nowrap>
					<input type="radio" name="ids" id="ids${id.count }" value="${tag.id}" title="${id.count }"
						onclick="setValues2('ids${id.count}','Dothing.customer_id','code${id.count}','Customer.code','name${id.count}','Dothing.customer_name')"/>
						<input type="hidden" name="code" id="code${id.count }" value="${tag.code}" />
						<input type="hidden" name="name" id="name${id.count }" value="${tag.name}" />
				</td>
				<td nowrap>${id.count}</td>
				<td nowrap>${tag.code}</td>
				<td nowrap title="${tag.remark}">${tag.name}</td>
				<td nowrap>${tag.sex}</td>
				<td nowrap>${tag.age}</td>
				<td nowrap>${tag.edu_level}</td>
				<td nowrap>${tag.work_status}</td>

			</tr>
		</c:forEach>

	</tbody>
</table>
</p>
</div>
<div class="modal-footer">
<button class="btn btn-primary">更多数据请点击这里查询</button>
<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">关闭</button>
<button class="btn btn-primary" onclick="setValues('list.ids','Consult.id','list.code','Consult.code','list.name','Consult.name')">保存选择</button>
</div>
</div>
</div>
<!-- Modal end -->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" />
<jsp:include page="/include/js.jsp" flush="true" />
</div>
<!--/.fluid-container-->



<script type="text/javascript">
<!--

function setValues(id,tid,code,tcode,name,tname){
	var ids = document.getElementsByName(id);
	var index;
	for(var i=0;i<ids.length;i++){
		var el = ids[i];
		if(el.checked){
			index = i;
		}
	}
	var idV = document.getElementsByName(id)[index].value;
	var codeV = document.getElementsByName(code)[index].value;
	var nameV = document.getElementsByName(name)[index].value;
	//alert(idV+"|"+codeV.value+"|"+nameV.value);
	document.getElementById(tid).value=idV;
	document.getElementById(tcode).value=codeV;
	document.getElementById(tname).value=nameV;
}

function setValues2(id,tid,code,tcode,name,tname){
	var idV = document.getElementById(id).value;
	var codeV = document.getElementById(code).value;
	var nameV = document.getElementById(name).value;
	document.getElementById(tid).value=idV;

	document.getElementById(tcode).value=codeV;
	document.getElementById(tname).value=nameV;
}
-->
</script>

<script type="text/javascript">
$('#div_dtp_input1').datetimepicker({
    //language:  'fr',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	forceParse: 0,
    showMeridian: 1
});
$('#div_dtp_input3').datetimepicker({
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
