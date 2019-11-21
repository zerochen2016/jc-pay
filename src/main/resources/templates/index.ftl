<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${name}-首页</title>
    <link rel="icon" type="image/x-icon" href="${iconUrl}">
   	<link href="/res/jquery-ui/jquery-ui.min.css?v=5" rel="stylesheet" type="text/css">
    <link href="/res/font-awesome/css/font-awesome.min.css?v=5" rel="stylesheet" type="text/css">
    <link href="/res/style/common.css?v=5" rel="stylesheet" type="text/css">
    <link href="/res/style/admincp.css?v=5" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="/static/css/mask.css">    
</head>
<body>
  	<#if mask?? && mask == 1>
		<div style="position:fixed;width:100vw;height:100vh;background:rgba(0,0,0,0.4);z-index:3"></div>
		<div class="wechat_tip_content"><div class="wechat_tip" style="z-index:9"><i class="triangle-up"></i>请点击右上角<br>在浏览器打开</div></div>	
	</#if>
    <div class="admincp-container">
    	<div class="admincp-menu">
    		<div class="menu-top">
    			<img src="${iconUrl}" class="logo" />
    		</div>
    		<div class="menu-list">
				<#if menus??>
					<#list menus as menu>
						<div class="menu-box">
							<a href="javascript:void(0)" class="parent">
								<i class="icon-menu icon-ticket"></i>
								${menu.name}<span class="notifyNumber" id="menu_notify_1" style="display: none;">0</span>
								<span class="fa fa-angle-down"></span>
							</a>
							<ul class="menu-sub" style="display:none;">
								<#if (menu.subMenus)??>
									<#list menu.subMenus as subMenu>								
										<li>
											<a  data-href="${subMenu.url}"  href="javascript:void(0)" data-code="ticket-summary">
												${subMenu.name}<span class="notifyNumber" id="menu_notify_2" data-pid="1" style="display: none;">0</span>
											</a>
										</li>
									</#list>
								</#if>
							</ul>
						</div>
					</#list>	
				</#if>
			</div>
    	</div>
    	
    	<div class="admincp-main">
    		<div class="admincp-header">
    			<div class="left">
    				<a href="javascript:void(0)" title="展开/收缩菜单" id="navSwitch" class="btn btn-success"><i class="fa fa-bars"></i></a>
    			</div>
    			<div class="right">
    				<div id="welcome" class="admin-user-info"></div>
    				<div class="user-panel">

    					<!-- <a href="javascript:void(0)" id="featureBtn" data-number="0" data-href="/Feature/index.html" class="iframe feature"><i class="fa fa-feature"></i> 产品功能</a> -->
    					<!-- <a href="http://www.baiyujy.com" target="_blank"><i class="fa fa-home"></i> 技术支持</a> -->
    					<!-- <a href="/login/personalCenter"><i class="fa fa-key"></i> 个人中心</a> -->
    					<a href="/admin/operator/password"><i class="fa fa-key"></i> 修改密码</a>
						<a href="/admin/exit"><i class="fa fa-sign-in"></i> 退出系统</a>
    				</div>
    			</div>
			</div>
   		
    		<iframe id="iframeMain" style="overflow:visible;" src="" frameborder="0" width="100%" height="94%" scrolling="yes"></iframe>
    	</div>
    </div>
	<script src="/static/js/jquery.min.js"></script>
	<script src="/static/js/jquery.slimscroll.min.js"></script>
    <script type="text/javascript">
		
		//菜单滚动条美化
		$('.admincp-menu').slimscroll({
			width: '219px',
			height: '100%'
		});

		//展开菜单
		$('.menu-box .parent').click(function() {
			if($(this).next('ul').is(':hidden')) {
				$('.menu-box .parent i').removeClass('open-arrow').addClass('arrow');
				$(this).children('i').removeClass('arrow').addClass('open-arrow');
				$('.menu-sub').slideUp('fast');
				$(this).next('ul').slideDown('fast');
			} else {
				$(this).children('i').removeClass('open-arrow').addClass('arrow');
				$(this).next('ul').slideUp('fast');
			}
		});
		 //展开和收起菜单
		var navFlag = true;
        $('#navSwitch').click(function() {
            if(navFlag) {
                navFlag = false;
                $('.admincp-menu').animate({width:0}, 'fast');
                $('.admincp-main').animate({left:0}, 'fast');
            } else {
                navFlag = true;
                $('.admincp-menu').animate({width:'219px'}, 'fast');
                $('.admincp-main').animate({left:'219px'}, 'fast');
            }
        });
		//点击链接
		$('.menu-sub a').click(function() {
			$('.menu-sub .current').removeClass('current');
			$(this).parent().addClass('current');
			$('#iframeMain').attr('src', $(this).data('href'));
		});

    </script>
</body>
</html>