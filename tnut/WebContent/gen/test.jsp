<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="<%=path%>/cose/save?" method="post">
<table class="table table-bordered">
	<tr>
		<td>tb_cost_type.id</td>
		<td><INPUT TYPE="TEXT" NAME="tb_cost_type.code"
			value="${tb_cost_type.code }" /></td>
		<td>tb_cost_type.name</td>
		<td><INPUT TYPE="TEXT" NAME="tb_cost_type.startValue"
			value="${tb_cost_type.startValue }" /></td>
	</tr>
	<tr>
		<td>tb_cost_type.endValue</td>
		<td><INPUT TYPE="TEXT" NAME="tb_cost_type.valueType"
			value="${tb_cost_type.valueType }" /></td>
		<td>tb_cost_type.price</td>
		<td><INPUT TYPE="TEXT" NAME="tb_cost_type.qty"
			value="${tb_cost_type.qty }" /></td>
	</tr>
	<tr>
		<td>tb_cost_type.amt</td>
		<td><INPUT TYPE="TEXT" NAME="tb_cost_type.unit"
			value="${tb_cost_type.unit }" /></td>
		<td>tb_cost_type.type</td>
		<td><INPUT TYPE="TEXT" NAME="tb_cost_type.status"
			value="${tb_cost_type.status }" /></td>
	</tr>
	<tr>
		<td>tb_cost_type.createBy</td>
		<td><INPUT TYPE="TEXT" NAME="tb_cost_type.createDate"
			value="${tb_cost_type.createDate }" /></td>
		<td>tb_cost_type.updateBy</td>
		<td><INPUT TYPE="TEXT" NAME="tb_cost_type.updateTime"
			value="${tb_cost_type.updateTime }" /></td>
	</tr>
	<tr>
		<td>tb_cost_type.remark</td>
	</tr>
</table>
</form>

</body>
</html>