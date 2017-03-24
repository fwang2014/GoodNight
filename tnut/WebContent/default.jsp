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
    <link href="<%=path %>/assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <link href="<%=path %>/assets/css/bootstrap-responsive.css" rel="stylesheet">
    
     <Script language="Javascript"	src="js/date.js"></Script>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="<%=path %>/assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path %>/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path %>/assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path %>/assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="<%=path %>/assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="<%=path %>/assets/ico/favicon.png">
                                   
     <style type="text/css">
		#main{background:url(<%=path%>/images/bg_hh6.jpg) no-repeat 0 0;height:450px}
		#login_form{position:absolute; right:180px;top:80px;}
     </style>
                                   
  </head><!--
  
  <mytag:mytag elementType="Select" dictCode="DATE_STATUS" value="1" id="myid"></mytag:mytag>

  --><body onload="document.getElementById('username').focus();">
  

	<jsp:include page="/include/top.jsp"	flush="true" />

	<div id="main"  class="container-fluid"> 
	  <div id="login_form">
      <form class="form-signin" action="<%=path %>/user/login?" onsubmit="return checkLogin()">
      
      <%
      	String error = request.getAttribute("error")==null?null:request.getAttribute("error").toString();
      	if(error!=null && error.length()>0){
      %>
      <div class="alert alert-error" align="center">
		  <button type="button" class="close" data-dismiss="alert">&times;</button>
		  <strong>Warning!</strong> ${error }
		</div>
      	<%
      	}
      	%>
      	     
        <h2 class="form-signin-heading">请登陆</h2>
        <label><i class="icon-user"></i>用户名:
        <input type="text" class="input-block-level" placeholder="用户名" name="form.user_name" id="username"   default_txt="通行证号/手机号码/别名">
        </label>
        
        <label><i class="icon-certificate"></i>密码:
        <input type="password" class="input-block-level" placeholder="密码" name="form.password" id="password"  >
        </label>
        
        <label><i class="icon-info-sign"></i>验证码：
        	<INPUT type="text" id="rand" class="span1" maxlength="4"
			name="form.rand" value="" size="4"   /> <IMG
			src="<%=path%>/webvalidateimg.do?"/>&nbsp;<a href="defaul.jsp"
			style="font-size:12px;" tabindex="8">看不清楚!</a>
        </label>
        
        <label class="checkbox">
             <input type="checkbox" value="remember-me" tabindex="9"> 记住我
        </label>
        <button class="btn btn-large btn-primary" type="submit" >进入</button>
        <a class="btn btn-mini btn-info" type="button" tabindex="8" 
        data-toggle="popover" data-placement="right" data-content="用户必须遵守系统安全规则和业务流程规范填报真实数据！"
         title="用户细则">用户细则</a>
      
		<span class="tooltip-demo label label-warning" >
	      		<a href="#" data-toggle="tooltip" data-placement="top" 
	      		tabindex="18"  title="忘记密码请详细阅读用户细则">忘记密码</a>
	    </span>
      </form>
      
     <div align="center">
		 [<span class="tooltip-demo">
		 <a href="#" tabindex="28" data-toggle="tooltip" data-placement="top" title="系统访问地址"><%=path %></a></span>/
		<a href="<%=basePath %>"  tabindex="38"><span class="label label-info">basePath=<%=basePath %></span></a>] 
		<br>
		[<a class="badge" style="cursor:hand;" onclick="changeBg('1')">春</a>]
		[<a class="badge badge-success" onclick="changeBg('2')">夏</a>]
		[<a class="badge badge-info" onclick="changeBg('3')">秋</a>]
		[<a class="badge badge-warning" onclick="changeBg('4')">冬</a>]
		<Br>
		<div id="div_time">2013-09-24</div>
    </div>
    
    </div>	<!-- /login_form -->
	</div>	 <!-- /main -->
	
	<jsp:include page="/include/foot.jsp"	flush="true" />

    </div> <!-- /container -->
    

    

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=path %>/assets/js/jquery.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-transition.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-alert.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-modal.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-dropdown.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-scrollspy.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-tab.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-tooltip.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-popover.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-button.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-collapse.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-carousel.js"></script>
    <script src="<%=path %>/assets/js/bootstrap-typeahead.js"></script>    
    <script src="<%=path %>/assets/js/application.js"></script>
    
    <script src="<%=path %>/js/mydate.js"></script>
    
    <script type="text/javascript">
    	function checkLogin(){
			var u = document.getElementById("username");
			var p = document.getElementById("password");
			var r = document.getElementById("rand");

			if(u.value ==""){
				alert("请输入用户名！");
				u.focus();
				return false;
			}
			if(p.value ==""){
				alert("请输入密码！");
				p.focus();
				return false;
			}
			if(r.value ==""){
				alert("请输入验证码！");
				r.focus();
				return false;
			}
			if(isNaN(r.value)){
				alert("请输入正确的验证码！");
				r.focus();
				r.value = "";
				return false;
			}
			return true;
    	}

		function changeBg(flag){
			//alert(flag);
			var main = document.getElementById("main");
			//alert(main);
			if('1'==flag){
				main.style.background = 'url(<%=path%>/images/bg/spring.jpg) no-repeat 0 0';
				document.getElementById("div_time").innerHTML ="春天到万物复苏，天道酬勤财自来";
			}else if('2'==flag){
				main.style.background = 'url(<%=path%>/images/bg/summer.jpg) no-repeat 0 0';
				document.getElementById("div_time").innerHTML ="夏天到，炎炎日照";
			}else if('3'==flag){
				main.style.background = 'url(<%=path%>/images/bg/autumn.jpg) no-repeat 0 0';
				document.getElementById("div_time").innerHTML ="秋风吹，硕果累累";
			}else if('4'==flag){
				main.style.background = 'url(<%=path%>/images/bg/winter.jpg) no-repeat 0 0';
				document.getElementById("div_time").innerHTML ="冬日寒风，银装素裹，悄悄潜藏，来年萌发";
			}
		}

		timeChangeBg();

		//var dtime = new Date();
		//document.getElementById("div_time").innerHtml = dtime;
    	
    </script>

  </body>
</html>
