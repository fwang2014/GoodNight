<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String tab = (String)request.getAttribute("tab");			
%>

<script language="javascript">
		<!--
			//软删除多条记录
			function delIds(form,ids){
				var form = document.getElementById(form);
				var ids = document.getElementsByName(ids);

				var count = 0;
				var bool = false;
				if(ids){
					for(var i=0;i<ids.length;i++){
						var checkbox = ids[i];
						if(checkbox.checked){
							//alert(checkbox.value);
							bool =true;
							//break;
							count++;
						}
					}
				}

				if(count >0 && !confirm("确认要删除这"+count+"条记录吗？")){
					return;
				}

				if(count > 0){
					form.action = "<%=path%>/<%=tab%>/dels?";
					form.submit();
				}else{
					alert("请先选择记录！");
				}
			}

		//彻底删除多条记录
		function delIdss(form,ids){
			var form = document.getElementById(form);
			var ids = document.getElementsByName(ids);

			var count = 0;
			var bool = false;
			if(ids){
				for(var i=0;i<ids.length;i++){
					var checkbox = ids[i];
					if(checkbox.checked){
						//alert(checkbox.value);
						bool =true;
						//break;
						count++;
					}
				}
			}

			if(count >0 && !confirm("确认要删除这"+count+"条记录吗？")){
				return;
			}

			if(count > 0){
				form.action = "<%=path%>/<%=tab%>/delss?";
				form.submit();
			}else{
				alert("请先选择记录！");
			}
		}

		//新增子层记录
		function doAdd(id){
			var form = document.getElementById(id);
			form.action = "<%=path%>/<%=tab%>/add?";
			form.submit();
		}

		//审核多条记录
		function doCheck(form,ids){
			var form = document.getElementById(form);
			var ids = document.getElementsByName(ids);
			var count = 0;
			var bool = false;
			if(ids){
				for(var i=0;i<ids.length;i++){
					var checkbox = ids[i];
					if(checkbox.checked){
						bool =true;
						count++;
					}
				}
			}

			if(count >0 && !confirm("确认要审核这"+count+"条记录吗？")){
				return;
			}

			if(count > 0){
				form.action = "<%=path%>/<%=tab%>/check?";
				form.submit();
			}else{
				alert("请先选择记录！");
			}

		}

		//导出全部查询记录
		function exportExcelAll(form,ids){
			var form = document.getElementById(form);
			var ids = document.getElementsByName(ids);
			var count = 0;
			var bool = false;

			var codeV = document.getElementById("search.code").value;
			var nameV = document.getElementById("search.name").value;
			var typeV = document.getElementById("search.type").value;
			var statusV = document.getElementById("search.status").value;
			var startDateV = document.getElementById("search.startDate").value;
			var endDateV = document.getElementById("search.endDate").value;
			
			if(ids){
				for(var i=0;i<ids.length;i++){
					var checkbox = ids[i];
					if(checkbox.checked){
						bool =true;
						count++;
					}
				}
			}

			//if(count >0 && !confirm("确认要导出这"+count+"条记录吗？")){
			if(count >0 && !confirm("确认要导出全部查询记录吗？")){
				return;
			}

			if(count > 0){
				var action = "<%=path%>/<%=tab%>/exportAll?";
				//alert(count);
				//form.submit();
				action += "search.code="+codeV;
				action += "&search.name="+nameV;
				action += "&search.type="+typeV;
				action += "&search.status="+statusV;
				action += "&search.startDate="+startDateV;
				action += "&search.endDate="+endDateV;
				//alert(action);
				window.open(action,"exportExcelWin");
			}else{
				alert("请先选择记录！");
			}

		}

		function selectAll(id){
			var els = document.getElementsByName(id);
			var checked = false;
			//alert(els.length);
			if(els ){
				var len = els.length;
				for(var i=0;i<els.length;i++){
					var el = els[i];
					if(i==0){
						checked = el.checked;
					}
					if(checked == true){
						el.checked = false;
					}else{
						el.checked=true;
					}
					
				}
			}
		}
		
		-->
    </script>

