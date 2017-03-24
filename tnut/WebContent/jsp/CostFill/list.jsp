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
	<li><a href="<%=path%>/CostFill/list?" class="label label-info">成本管理</a> <span
		class="divider">/</span></li>
	<li class="active">成本查询</li>
</ul>
</div>

<div class="bs-docs-example" style="margin-top: 2px;">
<div class="navbar">
<div class="navbar-inner">
<ul class="nav">
	<li class="active"><a href="<%=path%>/CostFill/list?">成本查询</a></li>
	<li><a href="<%=path%>/CostFill/add?">成本填报</a></li>
	<li><a href="<%=path%>/CostFill/batch_add?">批量填报</a></li>
	<li><a href="<%=path%>/CostFill/rent_add?">房租填报</a></li>
	<li><a href="<%=path%>/CostFill/stat?">成本统计</a></li>
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
	<li><a href="<%=path%>/CostFill/add?"><i class="icon-pencil"></i>新增</a></li>
	<li><a href="#" onclick="delIds('listForm','ids')"><i
		class="icon-remove"></i>删除</a></li>
	<li class="divider"></li>
	<li><a href="#" onclick="doCheck('listForm','ids')"><i
		class="icon-ok"></i>审核</a></li>
</ul>
</div>
<!-- /btn-group --></div>

<div class="bs-docs-example">
<form action="<%=path%>/CostFill/list?" method="post" id="listForm"
	name="listForm">
<table class="table table-bordered">
	<thead>
		<tr>
			<th><input type="checkbox" name="all" /></th>
			<th>${msg['label.CostFill.FILL_DATE']}</th>
			<th>${msg['label.CostFill.NAME']}</th>			
			<th>${msg['label.CostFill.TYPE']}</th>
			<th>${msg['label.CostFill.PRICE']}</th>
			<th>${msg['label.CostFill.QTY']}</th>
			<th>${msg['label.CostFill.AMT']}</th>
			<th>${msg['label.CostFill.UNIT']}</th>
			<th>${msg['label.CostFill.START_VALUE']}</th>
			<th>${msg['label.OPERATION']}</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${list}" var="tag" varStatus="id">
			<tr class="tr_data">
				<td nowrap>
					<c:if test="${tag.status =='0'}">
						<input type="checkbox" name="ids" value="${tag.id}" />
					</c:if>
				</td>
				<td nowrap>${tag.fill_date}</td>
				<td nowrap>
					<span class="tooltip-demo">
					<a href="<%=path%>/CostFill/view?id=${tag.id}"  data-toggle="tooltip"
					data-placement="top" title="${tag.remark}">${tag.name}</a>
					</span>
				</td>
				<td nowrap>${tag.type_name}</td>
				<td nowrap>${tag.price}</td>
				<td nowrap>${tag.qty}</td>
				<td nowrap>${tag.amt}</td>
				<td nowrap>${tag.unit_name}</td>
				<td nowrap>${tag.start_value}~${tag.end_value }</td>
				<td nowrap><a href="<%=path%>/CostFill/list?typeId=${tag.id}" />${msg['label.OPERATION.VIEW']}</a>
				<span class="divider">|</span>
				<a href="<%=path%>/CostFill/edit?id=${tag.id}" /><i
					class="icon-edit"></i></a>
				</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
</form>
</div>

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

<script src="<%=path%>/assets/js/application.js"></script>

<script language="javascript">
		<!--
			//删除多条记录
			function delIds(form,ids){
				var form = document.getElementById(form);
				var ids = document.getElementsByName(ids);

				var count = 0;
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
					form.action = "<%=path%>/CostFill/dels?";
					form.submit();
				}else{
					alert("请选择记录！");
				}
			}

		//新增子层记录
		function doAdd(id){
			var form = document.getElementById(id);
			form.action = "<%=path%>/CostFill/add?";
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
				form.action = "<%=path%>/CostFill/check?";
				form.submit();
			}else{
				alert("请选择记录！");
			}
		}
		-->
    </script>

</body>
</html>
