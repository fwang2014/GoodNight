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
    <meta charset="utf-8">
    <title>家庭财务管理系统[Family Finance Manage System],J2EE实现 </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <!-- Le styles -->
    <link href="<%=path%>/assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
    <link href="<%=path%>/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="<%=path%>/assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path%>/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path%>/assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path%>/assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="<%=path%>/assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="<%=path%>/assets/ico/favicon.png">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">家庭财务管理系统[FFMS]</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              	当前用户： <a href="#" class="navbar-link">pip</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="<%=path %>/fm/daily/index?">首页</a></li>
              <li><a href="#about">关于</a></li>
              <li><a href="#contact">联系我们</a></li>
              <li><a href="<%=path %>/sas/logoff2?">安全退出</a></li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">快捷通道 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="fm/daily/index?"><i class="icon-asterisk"></i>每日收支</a></li>
                  <li><a href="#"><i class="icon-fire"></i>统计查询</a></li>
                  <li><a href="#"><i class="icon-tint"></i>账户管理</a></li>
                  <li class="divider"></li>
                  <li class="nav-header"><i class="icon-plus"></i>系统管理</li>
                  <li><a href="#"><i class="icon-certificate"></i>辅助工具</a></li>
                  <li><a href="<%=path %>/fm/cost/index?"><i class="icon-wrench"></i>原始版本</a></li>
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">我的业务</li>
              <li ><a href="<%=path %>/fm/daily/index?"><i class="icon-home"></i>首页</a></li>
              <li class="active"><a href="<%=path %>/fm/daily/daily?"><i class="icon-eye-open"></i>每日收支</a></li>
              <li><a href="#"><i class="icon-plane"></i>统计查询</a></li>
              <li><a href="#"><i class="icon-comment"></i>账户管理</a></li>
              <li class="nav-header"><a href="#"  class="btn btn-small"><i class="icon-plus"></i>系统管理</a></li>
              <li><a href="#"><i class="icon-folder-close"></i>数据字典</a></li>
              <li><a href="#"><i class="icon-thumbs-up"></i>用户管理</a></li>
              <li><a href="#"><i class="icon-shopping-cart"></i>角色管理</a></li>
              <li><a href="#"><i class="icon-question-sign"></i>日志管理</a></li>
              <li><a href="#"><i class="icon-picture"></i>新闻管理</a></li>
              <li><a href="#"><i class="icon-tint"></i>接口管理</a></li>
              <li class="nav-header"><a href="#"  class="btn btn-small"><i class="icon-plus"></i>数据管理</a></li>
              <li><a href="#"><i class="icon-headphones"></i>表管理</a></li>
              <li><a href="#"><i class="icon-music"></i>表维护</a></li>
              <li><a href="#"><i class="icon-envelope"></i>性能优化</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        
        
        <div class="span9">
        
    
	<ul class="breadcrumb">
		<li><a href="<%=path %>/fm/daily/index?" class="label label-info">Home</a> <span class="divider">/</span></li>
		<li><a href="<%=path %>/fm/daily/daily?"  class="label label-info">每日收支</a> <span class="divider">/</span></li>
		<li class="active">数据</li>
	</ul>        
        
    <ul class="nav nav-tabs">
			  <li>
			    <a href="<%=path %>/fm/daily/daily?" class="badge2">当月收支</a>
			  </li>
			  <li><a href="<%=path %>/fm/daily/dailyThisYear?" class="badge2">本年收支</a></li>
			  <li  class="active"><a href="<%=path %>/fm/daily/dailyAll?" class="badge2">全部收支</a></li>
			  <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">相关数据<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="#">支出类型</a></li>
                  <li><a href="#">统计期间</a></li>
                  <li class="divider"></li>
                  <li><a href="#">用户统计</a></li>
                </ul>
              </li>
			  
	</ul>
	
		
		 
            <div class="input-append">
              <input class="span9" id="appendedDropdownButton" type="text" placeholder="请输入查询条件" width="100" value="">
              <div class="btn-group">
                <button class="btn dropdown-toggle" data-toggle="dropdown">操作 <span class="caret"></span></button>
                <ul class="dropdown-menu">
                  <li><a href="#"><i class="icon-search"></i>查询</a></li>
                  <li><a href="<%=path %>/fm/daily/dailyAdd?"><i class="icon-pencil"></i>新增</a></li>
                  <li><a href="<%=path %>/fm/daily/dailyBatchAdd?"><i class="icon-pencil"></i>批量增加</a></li>
                  <li><a href="#"><i class="icon-remove"></i>删除</a></li>
                  <li class="divider"></li>
                  <li><a href="#"><i class="icon-ok"></i>审核</a></li>
                </ul>
              </div><!-- /btn-group -->
            </div><!-- /input-append -->
         
        <p/>
		
		<div class="btn-group">
		  <span class="label label-info">数据结果</span> 
		  
		</div>
        
		<div class="bs-docs-example">
		
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
              
              <!-- 
                <tr>
                  <td rowspan="2">1</td>
                  <td>Mark</td>
                  <td>Otto</td>
                  <td>@mdo</td>
                  <td>Otto</td>
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
                  <td>
					<button class="btn btn-mini btn-info" type="button">修改</button>
				  </td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Jacob</td>
                  <td>Thornton</td>
                  <td>@fat</td>
                  <td>Jacob</td>
                  <td>Thornton</td>
                  <td>
					<button class="btn btn-mini btn-success" type="button">审核</button>
				  </td>
                </tr>
                <tr>
                  <td>3</td>
                  <td colspan="2">Larry the Bird</td>
                  <td>@twitter</td>
                  <td>Jacob</td>
                  <td>Thornton</td>
                  <td>
					<button class="btn btn-mini btn-warning" type="button">warning</button>
				  </td>
                </tr>
				<tr>
                  <td>3</td>
                  <td colspan="2">Larry the Bird</td>
                  <td>@twitter</td>
                  <td>Jacob</td>
                  <td>Thornton</td>
                  <td>
					<button class="btn btn-mini btn-danger" type="button">danger</button>
				  </td>
                </tr>
				<tr>
                  <td>3</td>
                  <td colspan="2">Larry the Bird</td>
                  <td>@twitter</td>
                  <td>Jacob</td>
                  <td>Thornton</td>
                  <td>
					<button class="btn btn-mini btn-inverse" type="button">inverse</button>
				  </td>
                </tr>
				<tr>
                  <td>3</td>
                  <td colspan="2">Larry the Bird</td>
                  <td>@twitter</td>
                  <td>Jacob</td>
                  <td>Thornton</td>
                  <td>
					<button class="btn btn-mini btn-link" type="button">link</button>
				  </td>
                </tr>
                 -->
                 
              </tbody>
            </table>
            
            <div>
		 		<jsp:include page="/include/pager2.jsp"	flush="true" />
		 	</div>        
		</form>
            
          </div>
          
   	


      <hr>

      <footer>
        <p>&copy; Company 2013</p>
      </footer>

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
