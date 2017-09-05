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
<div class="mt-10">
<form class="form form-horizontal" id="form-carinfo-add" action="" method="post">
<table class="table table-border table-bordered table-bg table-sort">
		
		<tr class="text-c">						
				<td>订&nbsp;单&nbsp;号:</td><td><input type="text" name="customerName" value="${order.customerName}" class="input-text" style="width:200px;"></td>
				<td>车&nbsp;牌&nbsp;号:</td><td><input type="text" name="plateNumber" value="${order.customerCarInfo.plateNumber}" class="input-text" style="width:200px;"></td>
		</tr>
				
		
		<tr class="text-c">						
				<td>服务顾问:</td><td><input type="text" name="VIN" value="${carType.VIN}" class="input-text" style="width:200px;"></td>
				<td>工时费:</td><td><input type="text" name="gender" value="${carType.gender}" class="input-text" style="width:200px;"></td>
		</tr>
	
		
		<tr class="text-c">						
				<td>折&nbsp;&nbsp;&nbsp;扣:</td><td><input type="text" name="address" value="" class="input-text" style="width:200px;"></td>
				<td>材料费:</td><td><input type="text" name="engineNumber" value="" class="input-text" style="width:200px;"></td>
		</tr>
		
		
		<tr class="text-c">						
				<td>折后金额:</td><td><input type="text" name="phone" value="" class="input-text" style="width:200px;"></td>
				<td>应付:</td><td><input type="text" name="color" value="" class="input-text" style="width:200px;"></td>
		</tr>
		
		
		<tr class="text-c">						
				<td>优惠:</td><td><input type="text" name="idCard" value="" class="input-text" style="width:200px;"></td>
				<td>实付:</td><td><input type="text" name="gearBox" value="" class="input-text" style="width:200px;"></td>
		</tr>
		
	
		<tr class="text-c">						
				<td colspan="4"><button onClick="article_save_submit()" class="btn btn-secondary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 结算</button>
				<buttin class="btn btn-default radius" type="submit">取消结算</buttin>
				<buttin class="btn btn-default radius" type="submit">打印结算单</buttin>
		</tr>
	
	</table>
	
		</form>
	</div>
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
$("#form-carinfo-add").validate({

	rules:{
		customerName:{
			required:true,
		},
		phone:{
			required:true,
		},
		VIN:{
			required:true,
		},
		engineNumber:{
			required:true,
		},
	},
	//onkeyup:false,
	focusCleanup:true,
	success:"valid",
submitHandler:function(form){
	$(form).ajaxSubmit({
		success: function() { 
			parent.layer.msg('已添加,可以继续添加!',{icon:6,time:1500});	
			location.reload();
			
			//var index = parent.layer.getFrameIndex(window.name);
			//parent.layer.close(index);
		}
		
	})
		
	
}
});


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>