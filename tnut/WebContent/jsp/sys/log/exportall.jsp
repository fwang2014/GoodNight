<%@ page language="java" import="java.util.*" pageEncoding="gb2312" contentType="text/html; charset=gb2312" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String tab = (String)request.getAttribute("tab");
%>

<!DOCTYPE html>
<html lang="en">
<head>

<script type="text/javascript">
	var url = "<%=path%>/<%=tab%>/list?";
	var win = "exportAllWin"
		alert("exportAll");
	window.open(url,win);
</script>

	<%
		//response.setCharacterEncoding("GBK");
		response.reset();//清空response的buffer
		response.setContentType("application/vnd.ms-excel;charset=gb2312");//设置正确的输出类型
		response.setHeader("Content-disposition","inline; filename=excelAll"+tab+".xls");
	%>
<meta content="text/html;charset=GBK" http-equiv="ContentType">
</head>

<body>


<table class="table table-bordered" border="1">
	<thead>
		<tr>
			<th>#</th>
			<th>${msg['label.Log.CODE']}</th>
			<th>${msg['label.Log.NAME']}</th>
			<th>${msg['label.Log.CREATE_BY']}</th>
			<th>${msg['label.Log.STATUS']}</th>
			<th>${msg['label.Log.REQ_IP']}</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${page.list}" var="tag" varStatus="id">
			<tr class="tr_data">

				<td nowrap>${id.count}</td>
				<td nowrap>${tag.code}</td>
				<td nowrap title="${tag.remark}"><a
					href="<%=path%>/Log/view?id=${tag.id}">${tag.name}</a></td>
				<td nowrap>${tag.create_by}</td>
				<td nowrap>${tag.status}</td>
				<td nowrap>${tag.req_ip}</td>

			</tr>
		</c:forEach>
	</tbody>
</table>



</body>
</html>
