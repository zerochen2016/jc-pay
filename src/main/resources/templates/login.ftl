
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="robots" content="noindex" />
	<meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>${name}-登录</title>
    <!-- <link rel="icon" type="image/x-icon" href="/static/image/blank.jpg"> -->
    <link rel="icon" type="image/x-icon" href="${iconUrl}">
    <link href="/static/res/jquery-ui/jquery-ui.min.css?v=6" rel="stylesheet" type="text/css">
    <link href="/static/res/style/common.css?v=6" rel="stylesheet" type="text/css">
    <link href="/static/res/style/login.css?v=6" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="/static/css/mask.css">
	<style>
	.ui-header .logo{width:150px;height:100px;float:left;background:url(${iconUrl}) center no-repeat}
	</style>    
</head>
<body>
  	<#if mask?? && mask == 1>
		<div style="position:fixed;width:100vw;height:100vh;background:rgba(0,0,0,0.4);z-index:3"></div>
		<div class="wechat_tip_content"><div class="wechat_tip" style="z-index:9"><i class="triangle-up"></i>请点击右上角<br>在浏览器打开</div></div>	
	</#if>
    <div class="ui-header">
        <div class="container">
            <div class="logo"></div>
        </div>
    </div>
    
    <div class="container ui-login-box">
        <div class="title-bar">
            <h2>${name}-登录</h2>
        </div>
        
        <div class="login-content">
            
            <div class="login-form">
                <dl>
                    <dt><label for="username">帐号</label></dt>
                    <dd><input type="text" class="username" name="userAccount" id="userAccount" placeholder="请填写账号"/></dd>
                </dl>
                <dl>
                    <dt><label for="password">密码</label></dt>
                    <dd><input type="password" id="password" name="password" class="password" placeholder="请填写密码"/>
                    </dd>
                </dl>
                <dl>
                <dt><label>验证码</label></dt>
                <dd>
                    <div>
                        <input type="text" class="captcha" name="verifyCode" id="verifyCode" placeholder="验证码不区分大小写"/>
                        <a href="javascript:void(0)" onclick="rewriteQrcode()" class="captcha-refresh">看不清？换一张</a>
                    </div>
                    <img src="/login/getVerifyPicture" class="captcha-img" id="verifyCodeImg"/>
                </dd>
               </dl>
                
                <dl>
                    <dd class="login-btn-box">
                        <input type="button" value="登录" id="login" class="btn btn-primary" />
                    </dd>
                </dl>
            </div>            
        </div>
    </div>
    
    

	<script src="/static/js/jquery.min.js"></script>
    <script>
    
		function rewriteQrcode(){
			var img = document.getElementById("verifyCodeImg");  
        	img.src = "/login/getVerifyPicture?number="+Math.random();
		}
		$('#login').click(function(){
			var userAccount = $('input[name="userAccount"]').val();
			var password = $('input[name="password"]').val();
			var verifyCode = $('input[name="verifyCode"]').val();
			var data = {
				account: userAccount,
				password: password,
				verifyCode: verifyCode
				
			};
			var url = "/login/login";
			$.ajax({
				type: "POST",
				url: url,
				data: data,
				dataType: "json",
				success:function(result){
					if(result.code==0){
						location.href="/admin/home";
					}else{
						alert(result.msg);
						location.reload();
					}
				}
			});	
		});	
			$(document).keyup(function(event){
				  if(event.keyCode ==13){
				    $("#login").trigger("click");
				  }
				});			
    </script>
</body>
</html>