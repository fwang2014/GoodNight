<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welocme to ffms</title>

<link href="assets/css/bootstrap.css" rel="stylesheet">

</head>
<body>

    <div class="container">

		<div class="bs-docs-example" style="background-color: #f5f5f5;">
            <div class="modal" style="position: relative; top: auto; left: auto; right: auto; margin: 0 auto 20px; z-index: 1; max-width: 100%;">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3>${msg['error.title.modal.header']}</</h3>
              </div>
              <div class="modal-body">
                <p>${msg['info.welcome.to.my.system']}&hellip;</p>
              </div>
              <div class="modal-footer">
              	<a href="#" onclick="doHistoryBack()" class="btn">Contiune&hellip;</a> 
              </div>
            </div>
          </div>

    </div> <!-- /container -->



<script type="text/javascript">
		function initPage(path){
			//window.location = path+"/initPage?";
			window.location = path+"/toLogin?";
		}

		var path ="<%=request.getContextPath()%>";
		initPage(path);
</script>

</body>
</html>