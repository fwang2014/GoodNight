
//设置验证后该元素的显示效果
function setValResult(bool,obj,msg){
	if(bool){
		obj.style.color="green";
		obj.style.borderBottom="1px solid #ccc"
	}else{
		obj.style.color="red";
		//obj.style.borderBottom = "1px dotted red";
		obj.style.border = "1px dotted red";
		obj.title=msg;
		obj.focus();
	}
}

//验证数字
function valNumber(obj){
	var len = obj.valLen;
	var msg = obj.valMsg;
	var value = obj.value;

	var bool = !isNaN(value);
	setValResult(bool,obj,msg);
	return bool;
}

//验证字符
function valChar(obj){
	
}

//验证邮箱
function valEmail(obj){
	var msg = obj.valMsg;
	var re=/^\w{1,}@\w{1,}$/;
	var bool = re.test(obj.value);
	setValResult(bool,obj,msg);
	return bool;
}

//验证电话
function valPhone(obj){
	var msg = obj.valMsg;
	var re=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
	var bool = re.test(obj.value);
	setValResult(bool,obj,msg);
	return bool;
}

//验证IP地址
function valIp(obj){
	
}

//验证QQ
function valQQ(obj){
	
}

//验证邮编号码
function valZipCode(obj){
	
}

//身份证号
function valIDCode(obj){
	
}

//表单提交前验证是否有必填字段没有输入
function valForm(obj){
	var form = obj;//document.getElementById(formId);
	var elements = form.getElementsByTagName("INPUT");//form.elements;
	//alert(elements);
	for(var i=0;i<elements.length;i++){
		var element = elements[i];
		//alert(element.id);
		//var type = element.type;
		var id = element.id;
		
		//if("TEXT"!=type){
			//continue;
		//}

		//验证非空字段
		var valNullable = element.getAttribute("valNullable");//element.valNullable;
		var value = element.value;
		var msg =  element.getAttribute("valMsg");//element.valMsg;
		//alert(id+"|"+valNullable+"|"+value+"|"+msg);
		if(valNullable && "N" == valNullable && value == ""){
			//alert(valNullable+" | "+value+" | "+msg);
			if(!msg || msg==null){
				msg = "you must input correct info here!";
			}
			//msg==null?"you must input correct info here!":msg;
			
			setValResult(false,element,msg);
			return false;
		}
	}
	return true;
}