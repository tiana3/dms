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

<title>增加工时工位</title>
</head>
<body>
<article class="page-container">
	<form action="WorkHourAddServlet" method="post"
			class="form form-horizontal" id="form-workhour-add">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">工位名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text"
						value="${workhour.workplaceName }" placeholder="" id=""
						name="workplaceName">
				</div>
			</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">适用车型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<select name="modelid" class="select">
					<c:forEach items="${carTypes }" var="carType">
						<option value="${carType.modelId }" >${carType.model }</option>
					</c:forEach>
				</select>
			</div>
		</div>
			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">工时费(单位：元)：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${workhour.workpay }"
						id="" name="workpay">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<button onClick="article_save_submit()" class="btn btn-secondary radius" type="submit">
						<i class="Hui-iconfont">&#xe632;</i> 添加</button>
					
					<button onClick="layer_close()" class="btn btn-default radius"
						type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
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
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
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
		$("#form-workhour-add").validate({
			rules:{
				workplaceName:{
					required:true,
				},
				modelid:{
					required:true,
				},
				workpay:{
					required:true,
				},
			},
            messages:{
             	workplaceName:{
                     required:"请填写工位名 ",
                 },
                 modelid:{
                     required:"请选择车型 ",
                 },
                 workpay:{
                     required: "请填写工时费 ",
                 },
			},
			
			focusCleanup:true,
			success:"valid",
			submitHandler:function(form){
				$(form).ajaxSubmit({
					success: function() { 
						parent.layer.msg('添加成功,可继续添加!点击取消关闭',{icon:6,time:2000});	
						location.reload();
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