
function isSpring(){
	var currentMonth = getCurrentMonth();
	if('2'== currentMonth || '3'==currentMonth || '4'==currentMonth){
		return true;
	}else{
		return false;
	}
}

function isSummer(){
	var currentMonth = getCurrentMonth();
	if('5'== currentMonth || '6'==currentMonth || '7'==currentMonth){
		return true;
	}else{
		return false;
	}
}

function isAutumn(){
	var currentMonth = getCurrentMonth();
	if('8'== currentMonth || '9'==currentMonth || '10'==currentMonth){
		return true;
	}else{
		return false;
	}
}

function isWinter(){
	var currentMonth = getCurrentMonth();
	if('11'== currentMonth || '11'==currentMonth || '12'==currentMonth){
		return true;
	}else{
		return false;
	}
}

function getCurrentMonth(){
	var theDate = new Date();

    //var mytime = new Date();

	//var year = mytime.getYear();
	//var fullyear = mytime.getFullYear();
	//var month = mytime.getMonth();
	//var mydate = mytime.getDate();
	//var myday = mytime.getDay();
	//var hours = mytime.getHours();
	//var minute = mytime.getMinutes();
	//var second = mytime.getSeconds();

	//var Millisecond = mytime.getMilliseconds();
	//var time = mytime.getTime();
	//var gmt = mytime.toGMTString();


	return theDate.getMonth();
}

//设置当前时间的背景
function setCurrentBg(){	
	var month = new Date().getMonth();
	switch(month){
	case 1:
		changeBg('1');
		break;
	case 2:
		changeBg('1');
		break;
	case 3:
		changeBg('1');
		break;
	case 4:
		changeBg('2');
		break;
	case 5:
		changeBg('2');
		break;
	case 6:
		changeBg('2');
		break;
	case 7:
		changeBg('3');
		break;
	case 8:
		changeBg('3');
		break;
	case 9:
		changeBg('3');
		break;
	case 10:
		changeBg('4');
		break;
	case 11:
		changeBg('4');
		break;
	case 12:
		changeBg('4');
		break;
		
	default:
		changeBg('1');
	}
}

//定时更新背景图片
function timeChangeBg(){
	//alert("test assb");
	//setTimeout("setBg()",4500);//间隔时间不宜过短
	setInterval("setBg()",4500);
}

//更新当前背景图片
function setBg(){
	var rand = Math.random();
	var tem = parseInt(rand * 10);
	if(tem<3){
		tem = "1";
	}else if(tem<6){
		tem = "2";
	}else if(tem<9){
		tem = "3";
	}else{
		tem = "4";
	}
	//alert(tem);
	changeBg(tem);
}