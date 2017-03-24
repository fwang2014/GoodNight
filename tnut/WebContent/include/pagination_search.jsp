<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String pid = (String) request.getAttribute("pid");
%>

<span class="label label-info">${page.pageNo }/${page.totalPage }</span>
&nbsp;&nbsp;&nbsp;
<span class="badge">${msg['display.label.pagination.totalCount']
}${page.totalCount }</span>
&nbsp;&nbsp;&nbsp;
<a href="#" onclick="searchPage('1','${parent==null?0:parent.id }')"
	class="label label-success">${msg['display.label.pagination.first']
} </a>
&nbsp;|&nbsp;
<a href="#"	onclick="searchPage('${page.nextPage }','${parent==null?0:parent.id }')"
	class="label label-success">${msg['display.label.pagination.next']
} </a>
&nbsp;|&nbsp;
<a href="#"	onclick="searchPage('${page.prePage }','${parent==null?0:parent.id }')"
	class="label label-success">${msg['display.label.pagination.pre'] }</a>
&nbsp;|&nbsp;
<a href="#"	onclick="searchPage('${page.totalPage }','${parent==null?0:parent.id }')"
	class="label label-success">${msg['display.label.pagination.last']
} </a>

<script language="javascript">
<!--
	var formId = "searchForm";
	var action = "<%=path%>/${tab }/search?";
	function searchPage(cp,pid){
		var form = document.getElementById(formId);
		action = action + "cp="+cp+"&pid="+pid;
		form.action = action;
		form.submit();
	}
	
-->
</script>