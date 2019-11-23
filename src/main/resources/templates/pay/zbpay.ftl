<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui" />			
		<title>扫码支付</title>
		<style type="text/css">
			.header{
				width: 100%;
				margin: 0 auto;
				font-size: 25px;
				font-weight: bold;
				text-align: center;	
				color: red;		
			}
			.maindiv{
				width: 90%;
				margin: 0 auto;
				margin-top: 2%;
			}
			.maindiv img{
				width: 100%;
			}
			.maindiv p{
				width: 100%;			
				font-weight: bold;
				font-size: 15px;
				line-height: 25px;
				margin-left: 5%;
			}
			.maindiva1{
				margin: 0 auto;
				margin-top: 30px;
				margin-left: 5%;
				width: 40%;
          		height: 50px;
            	line-height: 50px;
            	background: #1c81d3;
            	border: 1px #1c81d3 solid;
            	border-radius: 10px;            	
            	text-decoration: none;
            	font-size: 20px;
            	display: block;
            	text-align: center;
            	color: white;
            	cursor:pointer;
            	float: left;
			}
			.maindiva2{
				margin: 0 auto;
				margin-top: 30px;
				margin-right: 5%;
				width: 40%;
          		height: 50px;
            	line-height: 50px;
            	background: #95ea68;
            	border: 1px #95ea68 solid;
            	border-radius: 10px;            	
            	text-decoration: none;
            	font-size: 20px;
            	display: block;
            	text-align: center;
            	color: white;
            	cursor:pointer;
            	float: right;
			}		
			.maindiva3{
				margin: 0 auto;
				margin-left: 5%;
				width: 90%;
          		height: 50px;
            	line-height: 50px;
            	background: red;
            	border: 1px red solid;
            	border-radius: 10px;            	
            	text-decoration: none;
            	font-size: 20px;
            	display: block;
            	text-align: center;
            	color: white;
            	cursor:pointer;
            	float: left;
			}			
			.maindiva4{
				margin: 0 auto;
				margin-top: 30px;				
				margin-left: 5%;
				width: 90%;
          		height: 50px;
            	line-height: 50px;
            	background: orange;
            	border: 1px orange solid;
            	border-radius: 10px;            	
            	text-decoration: none;
            	font-size: 20px;
            	display: block;
            	text-align: center;
            	color: white;
            	cursor:pointer;
            	float: left;
			}										
		</style>
</head>
<body>
	<p class="header">扫码支付</p>
	<div class="maindiv">
		<img  src="${qrCode}" >
		<p>
		1.该二维码过期时间为：<span style="color: red">${expireTime}</span><br/>
		2.请在有效时间内支付：<span style="color: red;font-size: 20px;font-weight: bold;">${money}元，不多不少，否则无法到账。</span><br/>
		3.长按保存二维码或截屏，打开<span style="color: red;font-size: 20px;font-weight: bold;">${payTypeString}</span>扫码支付<br>
		4.充值不到账请拿订单号联系在线客服。订单号: ${tradeNo}
		</p>		
	</div>
	<input  class="maindiva3" id="copy" value="点击复制金额" readonly="readonly"/>
	<#if payButtonType == 1>
		<a class="maindiva1" href="${jumpUrlAlipay}" >打开支付宝</a>	
	<#elseif payButtonType == 2>
		<a class="maindiva2" href="${jumpUrlWechat}" >打开微信</a>	
	<#else>
		<a class="maindiva1" href="${jumpUrlAlipay}" >打开支付宝</a>
		<a class="maindiva2" href="${jumpUrlWechat}" >打开微信</a>	
	</#if>
	<input  class="maindiva4" id="tradeNo" value="点击复制订单号" readonly="readonly"/>
</body>
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript">
window.alert = function (name) {
	const iframe = document.createElement('IFRAME');
	iframe.style.display = 'none';
	document.documentElement.appendChild(iframe);
	window.frames[0].window.alert(name);
	iframe.parentNode.removeChild(iframe);
};

$('#tradeNo').click(function(){
    var inputElement =  document.getElementById("tradeNo");
    inputElement.value="${tradeNo}";
    inputElement.select();
    document.execCommand("Copy");
    inputElement.value="点击复制订单号";
    alert("复制成功");
});

$('#copy').click(function(){
    var inputElement =  document.getElementById("copy");
    inputElement.value="${money}";
    inputElement.select();
    document.execCommand("Copy");
    inputElement.value="点击复制金额";
    alert("复制成功，快去支付吧");
});

setInterval(function(){
	$.ajax({  
		url: '/pay/checkPay/${orderNo}',
		type: 'POST',  
		data: {
			"sign": "${sign}",
			"timestamp": "${timestamp}",
			"nonceString": "${nonceString}"
		},
		dataType: "json",  
		success: function (result) {
			//console.info(result);
			if(result.code == 0){
				location.href = "/pay/success?sign=${sign}&timestamp=${timestamp}&nonceString=${nonceString}";
			}
		}  
	});	
},5000); //指定x秒刷新一次
</script>
</html>