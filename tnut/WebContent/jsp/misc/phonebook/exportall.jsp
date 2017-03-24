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
		response.reset();//���response��buffer
		response.setContentType("application/vnd.ms-excel;charset=gb2312");//������ȷ���������
		response.setHeader("Content-disposition","inline; filename=excelAll"+tab+".xls");
	%>
<meta content="text/html;charset=GBK" http-equiv="ContentType">
</head>

<body>


<table border="1">
	<thead>
		<tr>
			<th>#</th>
			<th>${msg['label.Phonebook.CODE']}</th>
			<th>${msg['label.Phonebook.NAME']}</th>
			<th>${msg['label.Phonebook.TYPE']}</th>
			<th>${msg['label.Phonebook.STATUS']}</th>
			<th>${msg['label.Phonebook.PHONE']}</th>
			<th>${msg['label.Phonebook.AREA_CODE']}</th>

		</tr>
	</thead>
	<tbody>

		<c:forEach items="${page.list}" var="tag" varStatus="id">
			<tr class="tr_data">

				<td nowrap>${id.count}</td>
				<td nowrap>${tag.code}</td>
				<td nowrap >${tag.name}</a></td>
				<td nowrap>${tag.type}</td>
				<td nowrap><c:if test="${tag.status =='0'}">
					<span class="label">${msg['status.default']}</span>
				</c:if> <c:if test="${tag.status =='1'}">
					<span class="label label-success">${msg['status.checked']}</span>
				</c:if> <c:if test="${tag.status =='2'}">
					<span class="label label-important">${msg['status.edited']}</span>
				</c:if> <c:if test="${tag.status =='-1'}">
					<span class="label label-warning">${msg['status.deleted']}</span>
				</c:if></td>
				<td nowrap>${tag.phone}</td>
				<td nowrap>${tag.area_code}</td>
			</tr>
		</c:forEach>

	</tbody>
</table>



</body>
</html>
