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
	page="/include/menu_sys.jsp" flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
<span class="divider">/</span></li>
<li><a href="<%=path%>/Menu/list?" class="label label-info">${msg['display.label.nav.sys']}</a>
<span class="divider">/</span></li>
<li class="active">${msg['label.Menu.TABLE_CN']}${msg['display.label.list']}</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
<li class="active"><a href="<%=path%>/Menu/list?">${msg['label.Menu.TABLE_CN']}${msg['display.label.list']}</a></li>
<li><a href="<%=path%>/Menu/add?">${msg['label.Menu.TABLE_CN']}${msg['display.label.add']}</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">

<form action="<%=path %>/Menu/save?" method="post"  id="addForm" name="addForm" onsubmit="return valForm(this);">
<INPUT TYPE="hidden" NAME="Menu.id" value="${Menu.id }"/>
<table class="table table-bordered">
	<tr>
		<td>${msg['label.Menu.CODE']}</td>
		<td><INPUT TYPE="TEXT" NAME="Menu.code" ID="Menu.code" value="${Menu.code }" maxLength="20"  style="margin:0px auto;" valNullable="N" /></td>
		<td>${msg['label.Menu.NAME']}</td>
		<td>
				<INPUT TYPE="TEXT" NAME="Menu.name" ID="Menu.name" value="${Menu.name }"  maxLength="50"   style="margin:0px auto;" valNullable="N"/>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Menu.TYPE']}</td>
		<td>
			<input TYPE="radio" NAME="Menu.type" ID="Menu.type" value="0"/>系统
			<input TYPE="radio" NAME="Menu.type" ID="Menu.type" value="1"/>模块
			<input TYPE="radio" NAME="Menu.type" ID="Menu.type" value="2" checked="checked"/>功能
			<input TYPE="radio" NAME="Menu.type" ID="Menu.type" value="3"/>子功能
		</td>
		<td>${msg['label.Menu.IS_ROOT']}</td>
		<td>
			<input TYPE="checkbox" NAME="Menu.is_root" ID="Menu.is_root" value="${Menu.is_root }" value="0"  style="margin:0px auto;"> 
		</td>
		
	</tr>

	<tr>
		<td>${msg['label.Menu.URL']}</td>
		<td colspan="3"><INPUT TYPE="TEXT" NAME="Menu.url" ID="Menu.url" value="${Menu.url }" maxLength="200"  valNullable="N" style="width:85%;margin:0px auto;" /></td>
	</tr>
	<tr>
		
		<td>${msg['label.Menu.ORDER_INDEX']}</td>
		<td>
			<INPUT TYPE="TEXT" NAME="Menu.order_index" ID="Menu.order_index" value="${Menu.order_index }"   style="margin:0px auto;"  onblur="valNumber(this)" />
		</td>
		<td>${msg['label.Menu.STATUS']}</td>
		<td>
			<mytag:input dictCode="DATA_STATUS" id="Menu.status" value="${Menu.status}" read="Y"  style="margin:0px auto;"></mytag:input>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Menu.MENU_ICON']}</td>
		<td colspan="3">
			<INPUT TYPE="TEXT" NAME="Menu.menu_icon" ID="Menu.menu_icon" value="${Menu.menu_icon }"  maxLength="200"   style="margin:0px auto;" />
			<a href="#" title="请选择菜单图标"><i class="icon icon-tag"></i></a>
		</td>
	</tr>
	<tr>
		<td>${msg['label.Menu.REMARK']}</td>
		<td colspan="3">
			<textarea rows="3" cols="50" NAME="Menu.remark" ID="Menu.remark"  style="width:85%;margin:0px auto;">${Menu.remark }</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" name="btn_save" class="btn btn-info" value="保存"> 
			<input type="reset" name="btn_reset" class="btn btn-info" value="重置"> 
			<input	type="button" name="btn_back" class="btn btn-info" value="取消" onclick="window.location='<%=path %>/Menu/list?'">
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
