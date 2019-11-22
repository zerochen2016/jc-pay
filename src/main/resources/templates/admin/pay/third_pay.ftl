
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>${name}-支付管理</title>
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
		<div class="crumbs"><h2>支付管理<i class="fa fa-angle-right"></i> <span>第三方支付</span></h2></div>
		<div class="main-content">
			<div class="search-bar">
				<form action="${action}" method="post">
				<input type="hidden" id="page" name="page">
				平台标识：<input type="text" id="account" name="account" value="${(record.account)!''}" placeholder="请输入平台标识">
				用户ID：<input type="text" id="userId" name="userId" value="${(record.userId)!''}" placeholder="请输入用户ID">
				手机号码：<input type="text" id="mobile" name="mobile" value="${(record.mobile)!''}" placeholder="请输入手机号码">
				交易订单：<input type="text" id="tradeNo" name="tradeNo" value="${(record.tradeNo)!''}" placeholder="请输入交易订单">
				<a class="btn btn-success" id="search">搜索</a>			
				<input type="hidden" id="page" name="page">
				</form>
			</div>
			<div class="top-tools-bar">
				<div class="left list-info">
					<i class="fa fa-list"></i>
					共<span id="totalCount">${(pageModel.totalCount)?c!0}</span>条数据
				</div>
				<!-- <a class="btn btn-success" id="add" style="float:right;"><i class="fa fa-plus"></i>添加</a> -->
			</div>
			<table class="table table-hover table-bordered table-list">
				<tr>
					<th class="center">平台标识</th>				
					<th class="center">订单号</th>
					<th class="center">用户ID</th>
					<th class="center">手机号码</th>
					<th class="center">交易订单号</th>
					<th class="center">金额</th>
					<th class="center">创建时间</th>
					<th class="center">完成时间</th>
					<th class="center">过期时间</th>
					<th class="center">订单状态</th>
					<th class="center" colspan="3">操作</th> 
				</tr>
				<#if pageModel?? && pageModel.data?? &&(pageModel.data?size>0)>
				
				<#list pageModel.data as record>
				<tr>
					<td class="center">${record.account}</td>				
					<td class="center">${record.orderNo}</td>
					<td class="center">${record.userId}</td>
					<td class="center">${record.mobile}</td>
					<td class="center">${record.tradeNo}</td>
					<td class="center">${record.money}</td>
					<td class="center">${record.createTime?c?number?number_to_datetime?iso_nz("GMT+08")}</td>
					

					<#if record.status == 1>
						<td class="center">--</td>
						<td class="center">${record.expireTime?c?number?number_to_datetime?iso_nz("GMT+08")}</td>					
						<td class="center">未支付</td>
					<#elseif record.status == 2>
						<td class="center">${record.updateTime?c?number?number_to_datetime?iso_nz("GMT+08")}</td>
						<td class="center">--</td>					
						<td class="center">已完成</td>
					</#if>
					<td class="center">
						
					<#if record.status??&&record.status==1>
						<a class="btn btn-success" onclick='notifyNoder("${record.tradeNo}","${record.userId}","${record.account}")' href="javascript:void(0)" >补单</a>
					<#else>
						
					</#if>
					</td>
				</tr>
				</#list>
				<#else>
					<tr><td colspan="100" class="not-data"><i class="fa fa-warning"></i> 暂无数据~！</td></tr>
				</#if>
			</table>
			<input type="file" hidden="hidden" data-id="" id="questions" onchange="doUpload()">
			<div id="pager" class="pager">
				
			</div>
		</div>
	</div>
	<script src="/static/js/jquery.min.js"></script>
	<script src="/static/js/jquery.pager.min.js"></script>
	<script src="/static/js/jquery.date.js"></script>
	<script src="/static/js/utils.js"></script>
	<script>
	
	$.date('#startTime');
	$.date('#endTime');

	var notifyNoder = function(tradeNo, userId, account){
	
		var co = confirm("补单订单：" + tradeNo + "; 补单用户：" + userId);
		if(co){
		$.ajax({  
			url: '/admin/thirdPay/notifyOrder/' + tradeNo + '/' + account,
   			type: 'POST',  
			data: {
			},
			dataType: "json",  
			success: function (result) {  
	   		if(result.code==0){
	   			 	location.href = "/admin/thirdPay/pager";
	   		}else{
					alert(result.message);
	   			}
        	},  
			error: function (result) {
		  
        	}  
   		});			
		
		}				
	}
	
	init(${pageModel.page?c},${pageModel.pageSize?c},${pageModel.totalCount?c});
	
	var pageData = init(${pageModel.page?c},${pageModel.pageSize?c},${pageModel.totalCount?c});

	$(".pages").children().first().click(function(){
		$("#page").val(1);
		$("form").submit(); 	
	});	
		
	$(".pages li").eq(1).click(function(){
		$("#page").val(pageData.page);
		$("form").submit();
	});
	
	$(".pages li").eq(-2).click(function(){
		$("#page").val(pageData.page);
		$("form").submit(); 	
	});
	
	$(".pages").children().last().click(function(){
		$("#page").val(pageData.pageCount);
		$("form").submit(); 
	});
	
	$(".page-number").click(function(){
		$("#page").val($(this).html());
		$("form").submit();
	})		
	$("#search").click(function(){
		$("#page").val(1);
		$("form").submit();
	})	
	</script>
</body>
</html>