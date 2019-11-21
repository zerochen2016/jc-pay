
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>${name}-修改密码</title>
	<link href="/static/res/jquery-ui/jquery-ui.min.css?v=5" rel="stylesheet" type="text/css">
	<link href="/static/res/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="/static/res/style/common.css?v=5" rel="stylesheet" type="text/css">
	<link href="/static/res/style/index.css?v=5" rel="stylesheet" type="text/css">
	
</head>

<body>
	<style type="text/css">
		.search-bar {margin-bottom: 0}
	</style>
	<div class="col-main">
		<div class="crumbs"><h2>用户管理<i class="fa fa-angle-right"></i> <span>修改密码</span></h2></div>
		<div class="main-content">
			<div class="search-bar">
				密码：<input type="text" id="password" name="password" value="" ><br/><br/>								
				<a class="btn btn-primary" id="add">确定</a>
			</div>
		</div>
	</div>
	<script src="/static/js/jquery.min.js"></script>
	<script src="/static/js/jquery.pager.min.js"></script>
	<script src="/static/js/jquery.date.js"></script>
	<script src="/static/js/utils.js"></script>
	<script>
	$('#add').click(function(){
		var password = $('input[name="password"]').val();
		var data = {
		};
		var url = "/admin/operator/updatePassword/${account}/"+password;
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
				}
			}
		});	
	});	

	</script>
</body>
</html>