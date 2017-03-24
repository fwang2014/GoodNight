//构建行操作层列表对象
function addRowsetDiv() {
	var str_div = "";
	str_div += "<div id='div_win\' style=\"background-color:white;border:double 1 orange;overflow: visible;position:absolute;display:none;width:380;height:250;left:0;top:0;filter:alpha(opacity=100);\">";
	str_div += "<table width=\"100%\" class=\"table\">";
	str_div += "<tr  style=\"cursor:hand;background:navy;font-weight:bolder;color:yellow\" onclick=\"insetNewRow(div_rowset)\"";
	str_div += "onmouseover=\"this.style.background='green';\"	onmouseout=\"this.style.background='blue';\">";
	str_div += "<td  id='td_insert'>[++]Insert Row增加行1</td>";
	str_div += "</tr>";
	str_div += "<tr  style=\"cursor:hand;background:blue;font-weight:bolder;color:yellow\" onclick=\"deleteThisRow(div_rowset)\"";
	str_div += "onmouseover=\"this.style.background='green';\"	onmouseout=\"this.style.background='blue';\">";
	str_div += "<td id='td_delete'>[--]Delete Row删除行2</td>";
	str_div += "</tr>";
	str_div += "<tr  style=\"cursor:hand;background:blue;font-weight:bolder;color:yellow\" onclick=\"winclose(div_rowset)\"";
	str_div += "onmouseover=\"this.style.background='green';\"	onmouseout=\"this.style.background='blue';\">";
	str_div += "<td id='td_cancal'>[!!]Cancal取消3</td>";
	str_div += "</tr>";
	str_div += "</table>";
	str_div += "</div>";
	document.write(str_div);
	document.close();
}

addRowsetDiv();

function showWin(obj) {
	var mydiv = document.getElementById("div_win");
	//alert(mydiv.innerHTML);
	// mydiv.style.display = 'none';

	//var ttop = window.document.body.scrollTop;// tt.offsetTop;
	//var tleft = window.document.body.scrollLeft;// tt.offsetLeft;
	
	
	
	var ttop = obj.offsetTop;
	var tleft = obj.offsetLeft;
	
	//alert(obj.offsetTop+"|"+obj.offsetLeft+"|"+obj.id+"]["); 
	
	//var ttop = obj.offsetTop;
	//var tleft = obj.offsetLeft;

	//while (obj = obj.offsetParent) {
		//ttop += obj.offsetTop;
		//tleft += obj.offsetLeft;
	//}

	// var mypage = "<center>'+name+'</center>";
	// var str_html= ajax.getPage(jsp);
	// var mydiv=document.getElementById("div_win");
	// mydiv.innerHTML = "<div>hello,my div pop win show</div>";
	mydiv.style.top = ttop + 238;
	mydiv.style.left = tleft + 228;
	mydiv.style.display = 'block';
	//alert("acd");
}