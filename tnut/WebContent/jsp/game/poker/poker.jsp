<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String tab = (String)request.getAttribute("tab");
%>

<style>
	.redCard{
		color:red;
		font_size:18px;
		margin_top:2px;
		padding-top:5px;
	}
	.defaultCard{
		color:white;
		font_size:12px;
	}
	.cardStyle{
		width:50px;
		height:80px;
		border:1px solid red;
		margin:2 auto;
	}
</style>

<script language="javascript">
	function startIt2(){
		alert("i like you!");
	}

  	//游戏开始
  	//隐藏54张扑克显示信息
	function startIt(){
		//alert("aaa");
		for(var i=0;i<=54;i++){
			
			//$("#poker"+i).removeClass("redCard");
			var html = $("#poker"+i).html();
			$("#poker"+i).attr("html",html);
			$("#poker"+i).html("?");
			$("#poker"+i).css("fontSize","20px");

			var info = "请先选择一张参考牌，再选择一张相同记忆牌，如成功，依次完成5张即可胜利！";
		    $("#span_info").html(info);
		    $("#btn_start").css("display","none");
		    $("#btn_match").css("display","block");
		}
  	}

  	var pok,match;
	function matchIt(){
		alert("match start the two card!");
  	}
	
</script>

<div id="div_operate" class="span12">
	<input type="button" class="btn btn-info" name="btn1" id="btn1" value="检查扑克" onclick="window.location='<%=path %>/Game/Poker/index?'">
	<input type="button" class="btn btn-info" name="btn2" id="btn2" value="洗牌"  onclick="window.location='<%=path %>/Game/Poker/shuffle?'">
	<input type="button" class="btn btn-info" name="btn3" id="btn3" value="发牌">
	<input type="button" class="btn btn-info" name="btn4" id="btn4" value="当地主">
	<input type="button" class="btn btn-info" name="btn5" id="btn5" value="记忆扑克" title="随机猜扑克游戏">
	<input type='button' name='btn_start' id="btn_start" class='btn btn-warning' value='开始'  onclick='javascript:startIt()' style="display:none;">
	<input type='button' name='btn_match' id="btn_match" class='btn btn-warning' value='完成匹配'  onclick='javascript:matchIt()' style="display:none;">
</div>
<hr>
<div id="div_selected" title="已选牌"  class="span12">
	<a href="#">
	<span id="pok1" class="badge badge-success" style="width:50px;height:80px;border:3px outset yellow;margin-bottom:2px;">
		?1
	</span>
	</a>
	
	<a href="#">
	<span  id="pok2" class="badge badge-success" style="width:50px;height:80px;border:3px inset yellow;margin:2 auto;">
		?2
	</span>
	</a>
	
	<a href="#">
	<span  id="pok3" class="badge badge-success" style="width:50px;height:80px;border:3px ridge yellow;margin:2 auto;">
		?3
	</span>
	</a>
	
	<a href="#">
	<span  id="pok4" class="badge badge-success" style="width:50px;height:80px;border:3px groove yellow;margin:2 auto;">
		?4
	</span>
	</a>
	
	<a href="#">
	<span  id="pok5" class="badge badge-success" style="width:50px;height:80px;border:3px window-inset yellow;margin:2 auto;">
		?5
	</span>
	</a>
	<span id="span_info" class="well well-small muted">
		这是好玩扑克游戏！
	</span>
</div>
<div id="div_display"  class="span12">
	<c:forEach items="${list}" var="tag" varStatus="id">
		<c:choose>
			<c:when test="${id.count%10==0}">
				<a href="#">
				<span id="poker${tag.index }" class="badge badge-success cardStyle">
							${tag.name }
				</span>
				</a>
				<br>	
			</c:when>
			<c:otherwise>
				<a href="#">
				<span id="poker${tag.index }" class="badge badge-success cardStyle">
							${tag.name }
				</span>
				</a>
				&nbsp;	
			</c:otherwise>
		</c:choose>

	</c:forEach>
</div>

<script src="<%=path %>/assets/js/jquery.js"></script>



<script language="javascript">
<!--
	jQuery(function($) {
	  // 你可以在这里继续使用$作为别名...
	  
	 	 //这个必须放在前面
		function clearAllCardStyle(){
			for(var i=1;i<=54;i++){
				//$("#poker"+i).removeClass("redCard");
				$("#poker"+i).css("color","white");
				$("#poker"+i).css("fontSize","12px");
			}
		}

	  var url = "<%=path%>/Json/Poker/rand?";
	  //随机猜扑克游戏
	  $("#btn5").click( 
			function () { 
				//alert("start");
				//$(this).hide(); 
				
				$.get("<%=path%>/Json/test?", function(data){
					//alert("JSON Data: " + data);
					  //alert("Data[2]: " + data.length);
					  
					  var json = eval("("+data+")"); 
					 //alert(json);
					 
					 clearAllCardStyle();
					  
					  var ii = 0;
					  for(var key in json){ 
						  //alert(json[key]); 
						  var index = json[key];
						  var id = "poker"+index;
						  $("#"+id).css("color","red");
						  $("#"+id).css("fontSize","18px");
						  $("#"+id).css("marginTop","5px");

						  if(ii > 5){
							continue;
						  }
						  
						  ii++;
						  var value = $("#"+id).html();
						  //alert($("#pok"+ii).html());
						  $("#pok"+ii).html(value);
						  $("#pok"+ii).css("color","yellow");
						  $("#pok"+ii).css("fontSize","16px");

						  var info = "记忆扑克已经开始了，请准备好记住随机10张牌。。。";
							  //info += "<input type='button' name='btn_start' class='btn btn-warning' value='开始'";
								  //info += " onclick='javascript:startIt2()'/>";
						  $("#span_info").html(info);
						  $("#btn_start").css("display","block");
					  } 

						 
				}); 
				//alert("end");
			}
		);

	  
	}); 

	
-->	
</script>

