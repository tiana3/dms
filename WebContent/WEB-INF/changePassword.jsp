<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>	
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico">
<link rel="Shortcut Icon" href="favicon.ico" />
<!--[if lt IE 9]>
                <script type="text/javascript" src="lib/html5.js"></script>
                <script type="text/javascript" src="lib/respond.min.js"></script>
                <![endif]-->
<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
                <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
                <script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->

<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet"
	type="text/css" />

<title>更改密码</title>
</head>
<body>
<article class="page-container">
	<form action="${pageContext.request.contextPath }/changePassword.do" method="post"
			class="form form-horizontal" id="form-password-change">
		<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">账号：</label>
				<div class="formControls col-xs-8 col-sm-9">
					${adminName }
				</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">当前密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input class="input-text" type="password" name="oldPassword">
			</div>
		</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">新密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" id="password" class="input-text" name="newPassword">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">重复密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" name="repeatPassword">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<button  class="btn btn-secondary radius" type="submit">
						<i class="Hui-iconfont">&#xe632;</i> 确定</button>
					
					<button onClick="layer_close()" class="btn btn-default radius"
						type="button">取消</button>
				</div>
			</div>
		</form>
</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/additional-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript"
		src="lib/webuploader/0.1.5/webuploader.min.js"></script>
	<script type="text/javascript"
		src="lib/ueditor/1.4.3/ueditor.config.js"></script>
	<script type="text/javascript"
		src="lib/ueditor/1.4.3/ueditor.all.min.js">
		
	</script>
	<script type="text/javascript"
		src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
		$("#form-password-change").validate({
			rules:{
				newPassword:{
					required:true,
					minlength:4,  
				},
				oldPassword:{
					required:true,
				},
				repeatPassword:{
					required:true,
					equalTo:"#password"
				},				
	
			},
			
            messages:{
				newPassword:{
					required:"没有输入新密码",
					minlength:"密码长度要大于等于4位",  
				},
				oldPassword:{
					required:"当前密码没有输入",
				},
				repeatPassword:{
					required:"需要再次输入密码",
					equalTo:"两次密码输入不一致"
				},		
            },
			
			focusCleanup:true,
			success:"valid",
			submitHandler:function(form){
				$(form).ajaxSubmit({
					success: function(data) { 
						if(data=="true"){
							parent.layer.msg('密码修改成功',{icon:6,time:1500});	
							layer_close();
						}else if(data=="false"){
							parent.layer.msg('密码输入错误',{icon:2,time:1500});	
						}
						//parent.location.reload();
						//var index = parent.layer.getFrameIndex(window.name);
						//parent.layer.close(index);
					}
				
				})
			}
		});
	</script>
</body>
</html>