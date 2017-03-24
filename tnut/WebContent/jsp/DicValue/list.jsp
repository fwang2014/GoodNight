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
<div class="row-fluid"><jsp:include page="/include/menu_sys.jsp"
	flush="true" />

<div class="span9">

<div>
<ul class="breadcrumb">
	<li><a href="<%=path%>/welcome?" class="label label-info">Home</a>
	<span class="divider">/</span></li>
	<li><a href="<%=path%>/sys?" class="label label-info">系统管理</a> <span
		class="divider">/</span></li>
	<li class="active">数据字典<span class="divider">/</span></li>
	<li class="active">类型值</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li><a href="<%=path%>/sys?">用户管理</a></li>
	<li><a href="<%=path%>/role?">角色管理</a></li>
	<li><a href="<%=path%>/function?">功能管理</a></li>
	<li><a href="<%=path%>/right?">权限管理</a></li>
	<li><a href="<%=path%>/log?">日志管理</a></li>
	<li class="active"><a href="<%=path%>/datadic?">数据字典</a></li>
</ul>
</div>
</div>
</div>

<div class="bs-docs-example">
<div class="btn-group">
<div class="btn-group" style="display: block;">
<button class="btn dropdown-toggle" data-toggle="dropdown">相关操作
<span class="caret"></span></button>
<ul class="dropdown-menu">
	<li><a href="#" onclick="doAdd('listForm')"><i class="icon-pencil"></i>新增</a></li>
	<li><a href="#" onclick="delIds('listForm','ids')"><i
		class="icon-remove"></i>删除</a></li>
	<li><a href="<%=path%>/DicType/list?"><i
		class="icon-remove"></i>返回上层</a></li>
	<li class="divider"></li>
	<li><a href="#" onclick="doCheck('listForm','ids')"><i class="icon-ok"></i>审核</a></li>
</ul>
</div>
<!-- /btn-group --></div>

<form action="<%=path%>/DicValue/list?" method="post" id="listForm"
	name="listForm">
	<input type="hidden" name="DicValue.type_id" id="DicValue.type_id" value="${DicType.id }">
	<span class="label">${DicType.value_type }</span>
<table class="table table-bordered">
	<thead>
		<tr>
			<th><input type="checkbox" name="all" onclick="selectAll('ids')"/></th>
			<th>${msg['label.DicValue.VALUE']}</th>
			<th>${msg['label.DicValue.REMARK']}</th>
			<th>${msg['label.DicValue.TYPE']}</th>
			<th>${msg['label.DicValue.STATUS']}</th>

			<th>${msg['label.DicValue.UPDATE_BY']}</th>
			<th>${msg['label.DicValue.UPDATE_TIME']}</th>
			
			<th>${msg['label.OPERATION']}</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${list}" var="tag" varStatus="id">
			<tr class="tr_data">
				<td nowrap>
					<c:if test="${tag.status =='0'}">
					<input type="checkbox" name="ids" value="${tag.id}"/>
					</c:if>
				</td>
				<td nowrap>				
					<span class="tooltip-demo" >
						<a href="<%=path%>/DicValue/view?id=${tag.id}" data-toggle="tooltip" data-placement="top" title="${tag.remark}">
						${tag.value}</a>
					</span>				
				</td>
				<td nowrap>${tag.remark}</td>
				<td nowrap>${tag.type}</td>
				<td nowrap>
					<c:if test="${tag.status =='0'}">
						${msg['label.INFO.DATA.UNCHECKED']}
					</c:if>
					<c:if test="${tag.status =='1'}">
						${msg['label.INFO.DATA.CHECKED']}
					</c:if>
				</td>
				<td nowrap>${tag.update_by}</td>
				<td nowrap>${tag.update_time}</td>
				
				<td nowrap>
				<a href="<%=path%>/DicValue/view?id=${tag.id}" />${msg['label.OPERATION.VIEW']}</a>
				<span class="divider">|</span>
				<a href="<%=path%>/DicValue/edit?id=${tag.id}" /><i class="icon-edit"></i></a>
				</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
</form>

</div>


</div>
<!--/span--></div>
<!--/row-->

<hr>

<jsp:include page="/include/foot.jsp" flush="true" /></div>
<!--/.fluid-container-->

<!-- Le javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%=path%>/assets/js/jquery.js"></script>
<script src="<%=path%>/assets/js/bootstrap-transition.js"></script>
<script src="<%=path%>/assets/js/bootstrap-alert.js"></script>
<script src="<%=path%>/assets/js/bootstrap-modal.js"></script>
<script src="<%=path%>/assets/js/bootstrap-dropdown.js"></script>
<script src="<%=path%>/assets/js/bootstrap-scrollspy.js"></script>
<script src="<%=path%>/assets/js/bootstrap-tab.js"></script>
<script src="<%=path%>/assets/js/bootstrap-tooltip.js"></script>
<script src="<%=path%>/assets/js/bootstrap-popover.js"></script>
<script src="<%=path%>/assets/js/bootstrap-button.js"></script>
<script src="<%=path%>/assets/js/bootstrap-collapse.js"></script>
<script src="<%=path%>/assets/js/bootstrap-carousel.js"></script>
<script src="<%=path%>/assets/js/bootstrap-typeahead.js"></script>

 <script src="<%=path %>/assets/js/application.js"></script>

<script language="javascript">
		<!--
			function delIds(form,ids){
			var form = document.getElementById(form);
			var ids = document.getElementsByName(ids);
				//var len = ids.length;				
				
				var count = 0;
				//alert(ids+"||"+typeof(ids)+"||"+ids.length);
				var bool = false;
				if(ids){
					for(var i=0;i<ids.length;i++){
						var checkbox = ids[i];
						if(checkbox.checked){
							//alert(checkbox.value);
							bool =true;
							//break;
							count++;
						}
					}
				}

				if(!confirm("确认要删除这"+count+"条记录吗？")){
					return;
				}

				if(count > 0){
					form.action = "<%=path%>/DicValue/dels?";
					form.submit();
				}else{
					alert("请选择记录！");
				}
			}

			function doAdd(form){
				var form = document.getElementById(form);
				form.action = "<%=path%>/DicValue/add?";
				form.submit();
			}

			//审核多条记录
			function doCheck(form,ids){
				var form = document.getElementById(form);
				var ids = document.getElementsByName(ids);
				var count = 0;
				var bool = false;
				if(ids){
					for(var i=0;i<ids.length;i++){
						var checkbox = ids[i];
						if(checkbox.checked){
							bool =true;
							count++;
						}
					}
				}

				if(!confirm("确认要审核这"+count+"条记录吗？")){
					return;
				}

				if(count > 0){
					form.action = "<%=path%>/DicValue/check?";
					form.submit();
				}else{
					alert("请选择记录！");
				}
			}

			function selectAll(id){
				var els = document.getElementsByName(id);
				var checked = false;
				//alert(els.length);
				if(els ){
					var len = els.length;
					for(var i=0;i<els.length;i++){
						var el = els[i];
						if(i==0){
							checked = el.checked;
						}
						if(checked == true){
							el.checked = false;
						}else{
							el.checked=true;
						}
						
					}
				}
			}
		
		-->
    </script>

</body>
</html>
