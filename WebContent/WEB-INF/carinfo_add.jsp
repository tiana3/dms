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

<title>新增材料管理</title>
</head>
<body>
<div class="mt-10">
<form class="form form-horizontal" id="form-carinfo-add" action="carinfoadd.do" method="post">
<table class="table table-border table-bordered table-bg table-sort">
		
		<tr class="text-c">						
				<td>客&nbsp;户&nbsp;名:<input type="text" name="customerName" value="${carType.customerName}" class="input-text" style="width:200px;"></td>
				<td>车&nbsp;牌&nbsp;号:<input type="text" name="plateNumber" value="${carType.plateNumber}" class="input-text" style="width:200px;"></td>
		</tr>
		
		
		<tr class="text-c">						
				<td>购买日期:<input type="text" onfocus="WdatePicker({maxDate:'{%y}-%M-%d'})" name="buyDate"  value="${carType.buyDate}" class="input-text Wdate" id="datemin" style="width:200px;"></td>
				<td>保险到期日期:<input type="text" onfocus="WdatePicker({maxDate:'{%y+1}-%M-%d'})" name="policyDate" value="${carType.policyDate}" class="input-text Wdate" id="datemin" style="width:200px;"></td>
			
		</tr>
		
		
		<tr class="text-c">						
				<td>车&nbsp;架&nbsp;号:<input type="text" name="VIN" value="${carType.VIN}" class="input-text" style="width:200px;"></td>
					<td>性&nbsp;&nbsp;&nbsp;&nbsp;别:<input type="text" name="gender" value="${carType.gender}" class="input-text" style="width:200px;"></td>
		</tr>
	
		
		<tr class="text-c">						
				<td>地&nbsp;&nbsp;&nbsp;址&nbsp;:<input type="text" name="address" value="${carType.address}" class="input-text" style="width:200px;"></td>
				<td>发动机号:<input type="text" name="engineNumber" value="${carType.engineNumber}" class="input-text" style="width:200px;"></td>
		</tr>
		
		
		<tr class="text-c">		
				
				<td>车辆型号:<select name="modelid" >
					<c:forEach items="" var="carType">
						<option value="${carType.modelId }" >${carType.model }</option>
					</c:forEach>
				</select></td>
						
				<td>车辆厂家:
				
				<select name="modelid" >
					<c:forEach items="" var="carType">
						<option value="${carType.modelId }" >${carType.model }</option>
					</c:forEach>
				</select></td>
				
		</tr>
		
		<tr class="text-c">						
				<td>电&nbsp;&nbsp;&nbsp;&nbsp;话:<input type="text" name="phone" value="${carType.phone}" class="input-text" style="width:200px;"></td>
				<td>颜&nbsp;&nbsp;&nbsp;&nbsp;色:<input type="text" name="color" value="${carType.color}" class="input-text" style="width:200px;"></td>
		</tr>
		
		
		<tr class="text-c">						
				<td>身&nbsp;份&nbsp;证&nbsp;:<input type="text" name="idCard" value="${carType.idCard}" class="input-text" style="width:200px;"></td>
				<td>变&nbsp;速&nbsp;箱&nbsp;:<input type="text" name="gearBox" value="${carType.VIN}" class="input-text" style="width:200px;"></td>
		</tr>
		
	
		<tr class="text-c">						
				<td><button onClick="article_save_submit()" class="btn btn-secondary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button></td>
				<td><button onClick="layer_close()" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button></td>
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