<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui" />		
		<title>支付宝转账</title>
</head>
<body>
<a href="alipays://platformapi/startapp?appId=09999988&actionType=toCard&sourceId=bill&cardNo=${cardNo}&bankAccount=${bankAccount}&money=${money}&amount=${amount}&bankMark=${bankMark}&bankName=${bankName}">测试按钮</a>
<a href='alipays://platformapi/startapp?appId=20000067&url=${jumpUrl}'>页面跳转</a>
</body>
</html>