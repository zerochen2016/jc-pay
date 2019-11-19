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
				margin-top: 8%;		
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
		</style>
</head>
<body>
	<p class="header">扫码支付</p>
	<div class="maindiv">
		<img  src="${qrCode}" >
		<p>
		1.该二维码过期时间为：<span style="color: red">${expireTime}</span><br/>
		2.请在有效时间内支付：<span style="color: red;font-size: 20px;font-weight: bold;">${money}元，不多不少，否则无法到账。</span><br/>
		3.长按保存二维码或截屏，打开支付宝或微信扫码支付
		</p>		
	</div>
	<#if payButtonType == 1>
		<a class="maindiva1" href="${jumpUrlAlipay}" >打开支付宝</a>	
	<#elseif payButtonType == 2>
		<a class="maindiva2" href="${jumpUrlWechat}" >打开微信</a>	
	<#else>
		<a class="maindiva1" href="${jumpUrlAlipay}" >打开支付宝</a>
		<a class="maindiva2" href="${jumpUrlWechat}" >打开微信</a>	
	</#if>

</body>
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript">
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