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
		                  <li><a href="<%=path%>/cost/add?ma=101"><i class="icon-pencil"></i>新增</a></li>
		                  <li><a href="#"><i class="icon-remove"></i>删除</a></li>
		                  <li class="divider"></li>
		                  <li><a href="#"><i class="icon-ok"></i>审核</a></li>
		                </ul>
		   </div><!-- /btn-group -->
		</div>
		
		<form action="<%=path %>/fm/daily/daily?" method="post">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>#</th>
                  <th>序号</th>
                  <th>日期</th>
                  <th>名称</th>
                  <th>类型</th>
                  <th>金额</th>
                  <th>填报人</th>
                  <th>单位</th>
                </tr>
              </thead>
              <tbody>
              
              <c:forEach items="${list}" var="tag" varStatus="id">
				<tr class="tr_data">
					<td nowrap>
						<c:choose>
								<c:when test="${user.username == tag.filluser}">
									<input type="checkbox" name="ids" value="${tag.id}" />
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="ids" value="${tag.id}" disabled/>
								</c:otherwise>
							</c:choose>	
					</td>
					<td nowrap>${id.count}</td>
					<td nowrap>${tag.happendate}</td>
					<td nowrap><a href="#">${tag.name}</a></td>
					<td nowrap>${tag.type}</td>
					<td nowrap>${tag.amount}</td>
					<td nowrap>${tag.filluser}</td>
					<td nowrap>${tag.unit}</td>
				</tr>
			</c:forEach>
			
			 <tr>
                  <td>1</td>
                  <td>Mark</td>
                  <td>Otto</td>
                  <td>@mdo</td>
                  <td>Otto</td>
                  <td>@mdo</td>
                  <td>@mdo</td>
                  <td>
					<button class="btn btn-mini btn-primary" type="button">查看</button>
				  </td>
                </tr>
                <tr>
                  <td>Mark</td>
                  <td>Otto</td>
                  <td>@TwBootstrap</td>
                  <td>Mark</td>
                  <td>Otto</td>
                  <td>Otto</td>
                  <td>Otto</td>
                  <td>
					<button class="btn btn-mini btn-info" type="button">修改</button>
				  </td>
                </tr>
                   
              </tbody>
            </table>      
		</form>
            
          </div>
        
          <div class="hero-unit" style="display:none;">
            <h1>家庭财务, 你好!</h1>
	        <p>金钱的问题困扰着许多家庭，大多数时候是金钱加重了家庭矛盾。许多家庭由于缺乏资金，或者确切地说，是由于失败地管理家庭资金而陷入困境。我们有一条摆脱家庭金融灾难的出路——长远规划和坚持到底，创造我们的第一桶金。</p>
	        <p><a href="#" class="btn btn-primary btn-large">了解更多 &raquo;</a></p>
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
