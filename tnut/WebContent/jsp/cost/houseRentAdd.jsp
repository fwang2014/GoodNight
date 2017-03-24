<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
	<jsp:include page="/include/head.jsp"	flush="true" />
  </head>

  <body  data-spy="scroll" data-target=".sidebar-nav">

<jsp:include page="/include/top.jsp"	flush="true" />

    <div class="container-fluid">
      <div class="row-fluid">
        <jsp:include page="/include/menu.jsp"	flush="true" />
        
        <div class="span9">
        
        <ul class="breadcrumb">
			<li><a href="<%=path %>/fm/daily/index?" class="label label-info">Home</a> <span class="divider">/</span></li>
			<li><a href="<%=path %>/fm/daily/daily?"  class="label label-info">房租水电管理</a> <span class="divider">/</span></li>
			<li class="active">首页</li>
		</ul>    
	        
		<div class="bs-docs-example">
            <div class="navbar">
              <div class="navbar-inner">
                <ul class="nav">
                  <li ><a href="#">数据查询</a></li>
                  <li class="active"><a href="<%=path%>/cost/index?ma=101">费用类别定义</a></li>
                  <li><a href="#">数据审核</a></li>
                </ul>
              </div>
            </div>
          </div>	
          
        <div class="bs-docs-example">
		<div class="btn-group">
		  <span class="label label-info">数据结果</span> 
		  <span class="label label-important">${LIST_INFO }</span>

          <div class="btn-group">
		             <button class="btn dropdown-toggle" data-toggle="dropdown">相关操作 <span class="caret"></span></button>
		                <ul class="dropdown-menu">
		                  <li><a href="#"><i class="icon-search"></i>查询</a></li>
		                  <li><a href="#"><i class="icon-pencil"></i>新增</a></li>
		                  <li><a href="#"><i class="icon-remove"></i>删除</a></li>
		                  <li class="divider"></li>
		                  <li><a href="#"><i class="icon-ok"></i>审核</a></li>
		                </ul>
		   </div><!-- /btn-group -->
		</div>
		
		<form action="<%=path %>/cose/save?" method="post">
            <table class="table table-bordered">
			
			 <tr>
                  <td>CostType.id</td>
                  <td><INPUT TYPE="TEXT" NAME="CostType.id" value="${CostType.id }"/></td>
                  <td>CostType.code </td>
                  <td><INPUT TYPE="TEXT" NAME="CostType.code "  value="${CostType.code }"/></td>
             </tr>
			 <tr>
                  <td>NAME</td>
                  <td><INPUT TYPE="TEXT" NAME="form.name"  value="${CostType.code }"/></td>
                  <td>STARTVALUE</td>
                  <td><INPUT TYPE="TEXT" NAME="form.startValue"  value="${CostType.code }"/></td>
             </tr>
              <tr>
                  <td>endValue</td>
                  <td><INPUT TYPE="TEXT" NAME="form.endValue"  value="${CostType.code }"/></td>
                  <td>valueType</td>
                  <td><INPUT TYPE="TEXT" NAME="form.valueType"  value="${CostType.code }"/></td>
             </tr>
             
              <tr>
                  <td>price</td>
                  <td><INPUT TYPE="TEXT" NAME="form.price"  value="${CostType.code }"/></td>
                  <td>qty</td>
                  <td><INPUT TYPE="TEXT" NAME="form.qty"  value="${CostType.code }"/></td>
             </tr>
              <tr>
                  <td>amt</td>
                  <td><INPUT TYPE="TEXT" NAME="form.amt"  value="${CostType.code }"/></td>
                  <td>unit</td>
                  <td><INPUT TYPE="TEXT" NAME="form.unit"  value="${CostType.code }"/></td>
             </tr>
              <tr>
                  <td>type</td>
                  <td><INPUT TYPE="TEXT" NAME="form.type" value="${CostType.code }"/></td>
                  <td>status</td>
                  <td><INPUT TYPE="TEXT" NAME="form.status" value="${CostType.code }"/></td>
             </tr>
             
             <tr>
                  <td>createBy</td>
                  <td><INPUT TYPE="TEXT" NAME="form.createBy" value="${CostType.code }"/></td>
                  <td>createDate</td>
                  <td><INPUT TYPE="TEXT" NAME="form.createDate" value="${CostType.code }"/></td>
             </tr>
             <tr>
                  <td>CostType.pdateBy</td>
                  <td><INPUT TYPE="TEXT" NAME="CostType.pdateBy" value="${CostType.pdateBy }"/></td>
                  <td>CostType.updateTime</td>
                  <td><INPUT TYPE="TEXT" NAME="CostType.updateTime" value="${CostType.updateTime }"/></td>
             </tr>
             <tr>
                  <td>CostType.remark </td>
                  <td colspan="3">
                  	<textarea rows="4" cols="50" name="CostType.remark ">${CostType.remark }</textarea>
                  </td>

             </tr>
             <tr>
                  <td colspan="4" align="center">
                  	<input type="button" name="btn_save" class="btn" value="保存"> 
                  </td>

             </tr>
            </table>      
		</form>
            
          </div>
        
          
        </div><!--/span-->
      </div><!--/row-->

      <hr>

	 <jsp:include page="/include/foot.jsp"	flush="true" />

    </div><!--/.fluid-container-->

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

  </body>
</html>
