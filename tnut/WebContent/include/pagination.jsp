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
<a href="<%=path%>/${tab }/list?cp=1&pid=${parent==null?0:parent.id }"
	class="label label-success">${msg['display.label.pagination.first']
} </a>
&nbsp;|&nbsp;
<a href="<%=path%>/${tab }/list?cp=${page.nextPage }&pid=${parent==null?0:parent.id }"
	class="label label-success">${msg['display.label.pagination.next']
} </a>
&nbsp;|&nbsp;
<a href="<%=path%>/${tab }/list?cp=${page.prePage }&pid=${parent==null?0:parent.id }"
	class="label label-success">${msg['display.label.pagination.pre'] }</a>
&nbsp;|&nbsp;
<a href="<%=path%>/${tab }/list?cp=${page.totalPage }&pid=${parent==null?0:parent.id }"
	class="label label-success">${msg['display.label.pagination.last']
} </a>

