<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,com.dms.entity.Part,com.dms.dao.impl.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--_meta 作为公共模版分离出去-->
<html>
<!-- <head> -->
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
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>选择工时工位</title>
</head>
<body>



	<div class="Hui-article">
		<article class="cl pd-20">
		<form action="${pageContext.request.contextPath }/workList.do" method="post">
			<div class="text-c">
			工位名：&nbsp;&nbsp;
				<input class="input-text" type="text" name="workplaceName" style="width:120px;">&nbsp;&nbsp;&nbsp;
			适用车型：             
				<select name="modelid" class="input-text" style="width:120px ;">
					<option value="0" >全部</option>
					<c:forEach items="${carTypes }" var="carType">
						<option value="${carType.modelId }" >${carType.model }</option>
					</c:forEach>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
					<button class="btn btn-success" type="submit" value="submit">
						<i class="Hui-iconfont">&#xe665;</i> 搜索
					</button>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20">

				<span class="r">共有数据：<strong>${fn:length(work)}</strong> 条</span>
			</div>
				
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th>工位名</th>
						<th>车型</th>
						<th width="17%">工时费(单位：元)</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${work }" var="workhour" varStatus="varSta">
					
						<tr class="text-c">
							<td>${workhour.workplaceName }</td>
							<td>
							<c:forEach items="${carTypes }" var="carType">
								<c:if test="${carType.modelId == workhour.modelId}">
									${carType.model }
								</c:if>
							</c:forEach>
							</td>
							<td>${workhour.workpay }</td>
							<td  class="f-14 td-manage">
							    <button  class="btn btn-secondary  radius" type="button" onClick="add_work(this)"> 选择添加</button>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				
			</table>
		</div>

					</form>
		</article>
	</div>


        

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
   
function add_work(obj) {
	//复制了tr，不然后面删除时，会删除原来的tr
	var tr = $(obj).parents("tr").clone(true);
	
	var workhour = parent.document.getElementById("workhour");
	var length = workhour.children.length;
	
	parent.$("#workhour").append("<tr><td><input value='"+ tr.children('td').eq(0).text() +"' name='customs["+length+"].customName' type='text' class='input-text'></td><td><input value='"+ tr.children('td').eq(2).text() +"' name='customs["+length+"].customPrice'  type='text' class='input-text number'></td><td><select class='select' name='customs["+ length +"].employeeId'><option value='0'>&nbsp;&nbsp;</option><c:forEach items='${Ma_Tec }' var='ma'><option value='${ma.employeeId}'>${ma.jobName}-${ma.employeeName}</option></c:forEach></select></td></tr>");

} 

    
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>