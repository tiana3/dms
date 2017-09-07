<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--_meta 作为公共模版分离出去-->
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico" >
<link rel="Shortcut Icon" href="favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>结算管理</title>
</head>
<body>
<form class="form form-horizontal" id="form-carinfo-add" action="" method="post">
<div class="mt-10">
				<table class="table table-border table-bordered table-bg table-sort">
					<thead>
					<tr class="text-c">
						<th>维修单号</th>
						<th>车牌号</th>
						<th>服务顾问</th>
						
					</tr>
				</thead>						
						<tr class="text-c">
							<td width="120px">${order.orderId}</td>
							<td width="120px">${order.customerCarInfo.plateNumber}</td>
							<td width="120px">${order.SA}</td>
							
						</tr>
					</table>
					<br>
					<br>
					<table class="table table-border table-bordered table-bg table-sort">	
						<thead>
					<tr class="text-c">
						<th width="150px">材料费</th>
						<th width="150px">折扣金额</th>
							<th width="150px">工时费</th>
						<th width="150px">应付</th>
						<th width="150px">实付</th>
						<th width="150px">优惠</th>					
						<th width="150px">折扣</th>
					</tr>
				</thead>						
						<tr class="text-c">
							<td>
							<input value="${order.partPrice}" name="partPrice"></td>
							<td>
							<input value="${order.discountPrice}" name="discountPrice"></td>
							<td><input value="${order.workPrice}" name="workPrice"></td>
							<td>
							<input value="" name="Price"></td>
							<td>
							<input value="" name="Price"></td>
							<td>
							<input value="" name="Price"></td>		
							<td><input value="" name=""></td>
						</tr>
						<tr class="text-c">
					<td colspan="7"><button onClick="article_save_submit()" class="btn btn-secondary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 结算</button>
					<buttin class="btn btn-default radius" type="submit">取消结算</buttin>
					<buttin class="btn btn-default radius" type="submit">打印结算单</buttin>	
					</td>	
					</tr>		
				</table>

	</div>	

	
		</form>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.page.js"></script> 
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>   
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

	
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>