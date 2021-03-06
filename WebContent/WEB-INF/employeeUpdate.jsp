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
</head>
<body>
	<div class="page-container">
		<form action="employeeUpdate" id="form-update-add" method="POST"
			class="form form-horizontal">


			<input type="hidden" name="employeeid"
				value="${employee.employeeId}">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">姓名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text"
						value="${employee.employeeName}" placeholder="" id="" name="name">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">性别：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${employee.gender}"
						placeholder="" id="gender" name="gender">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">电话号码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${employee.phone}"
						placeholder="" id="phone" name="phone">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">身份证号：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${employee.idCard}"
						placeholder="" id="idcard" name="idcard">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">职务：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<select name="jobid">
					<c:forEach items="${list1}" var="employee" varStatus="vasta">
					<option value="${employee.jobId}">${employee.jobName}</option>
					</c:forEach>	
					</select>
				</div>
			</div>

			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<button class="btn btn-primary radius" type="submit">
						<i class="Hui-iconfont">&#xe632;</i> 确定保存
					</button>
				</div>
			</div>
		</form>
	</div>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
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
		$("#form-update-add").validate({

			rules : {
				name:{
					required:true,
				},
				gender:{
					required:true,
				},
				idcard:{
					required:true,

				},
				phone:{
					required:true,

				},
				jobid:{
					required:true,

				},
				
			},
            messages:{
                	name:{
                         required:"请输入员工姓名 ",
                     },
                     gender:{
                         required:"员工性别不能为空",
                     },
                     idcard:{
                         required: "请填写员工身份证号 ",
                     },
                     phone:{
                         required:"请填写员工联系电话 ",
                     },
			},
			//onkeyup:false,
			focusCleanup : true,
			success : "valid",
			submitHandler:function(form) {
				$(form).ajaxSubmit({
					success : function() {

						parent.layer.msg('修改成功!', {icon:6,time:1000});
						layer_close();
						parent.location.reload();
						

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