<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<title>系统登录</title>
</head>
<body>
<video autoplay muted controls="controls" loop id="bgvid" style="position: fixed; right: 0; bottom: 0; min-width: 100%; min-height: 100%; width: auto; height: auto;  z-index: -100;" src="video/carmvp.mp4">
 </video>
<div class="header"></div>
<div class="loginWraper" style="height: auto">
	<div id="loginform" class="loginBox" >

		<img alt="车标" src="image/das.jpg" style="width: 12%; margin-bottom:5%; margin-top:2%; margin-left:2%"><span><font size="20" >售后维修系统</font></span>
		<form id="login" class="form form-horizontal" action="${pageContext.request.contextPath }/login.do" method="post" style="margin-left: 20%;">
			<div class="row cl">
				<label class="form-label col-xs-3" style="color: #0000ff"></label>
				<div class="formControls col-xs-8">
					<input id="" name="user" type="text" placeholder="账户" class="input-text" style="width: 40%;border-radius: 3px">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-3"></label>
				<div class="formControls col-xs-8">
					<input id="" name="password" type="password" placeholder="密码" class="input-text" style="width: 40%;border-radius: 3px">
				</div>
			</div>
	

			<div class="row cl">
				<div class="formControls col-xs-8 col-xs-offset-3">
					<input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
				</div>
			</div>
		</form>
	</div>
<div class="footer" style="margin-top: 15%;">Copyright 你的公司名称 by dms</div>
</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.page.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>   
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script> 
<script>

$("#login").validate({
	rules:{
		user:{
			required:true,
		},
		password:{
			required:true,
		},
	 },
		
     messages:{
    	 user:{
             required:"账户未填",
         },
         password:{
             required:"密码未填 ",
         },
	},
	//这是自定义错误信息的显示 ，  error是错误信息对象，element是当前验证的对象
	errorPlacement : function(error, element) { 
		//给element增加一个属性，是在文本里有提示信息
		$(element).attr("placeholder",error.html());
	}, 
	
	onkeyup:false,
	focusCleanup:true,
	
	onfocusout:false,
	success:"valid",
	
	submitHandler:function(form){

		$(form).ajaxSubmit({
			success: function(data) { 
				var json = JSON.parse(data);
				var msg = json.valid;
				if("0"==msg) {
					layer.msg("账户或密码错误",{icon:2,time:1500});
				}else if("1"==msg){
	                var url = json.url;
					location.replace(url);
				}
			}
		
		})
		
	} 
});




</script>
</body>
</html>