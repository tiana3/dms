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

    <title>选择材料配件</title>
</head>
<body>

   <article class="cl pd-20">
        <form name="shousuo" action="${pageContext.request.contextPath }/part-out-insert.do" method="post" >
            <div class="text-c">
              	 配件名：
                <input type="text"  name="partname" id="logmin" class="input-text " style="width:120px;">&nbsp;&nbsp;&nbsp;
          	      配件号：
                <input type="text"  name="partno" id="logmax" class="input-text" style="width:120px;">&nbsp;&nbsp;&nbsp;
          	      车型：             
				<select name="modelid" class="" style="width:120px ; height:30px;">
					<option value="0" >全部</option>
					<c:forEach items="${carTypes }" var="carType">
					<option value="${carType.modelId }" >${carType.model }</option>
					</c:forEach>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="orderId" value="${orderId}" class="hidden">
               <button  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button> 
            </div>
       </form>
            <div class="cl pd-5 bg-1 bk-gray mt-20">
                <span class="r">共有数据：<strong>${fn:length(partlist)}</strong>条</span>
            </div>
            <div class="mt-20">  
            

                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="80">配件名</th>
                        <th width="80">配件号</th>
                        <th width="75">金额</th>
                        <th width="80">适用车型</th>
                        <th>领料人</th>
                        <th width="120">操作</th>
                    </tr>
                    </thead>
                    <tbody>
          <c:forEach items="${partlist}" var="part" varStatus="varSta">
                    <tr class="text-c">                  		
                        <td><input type="hidden" name="partId" value="${part.partId }">${part.partName}</td>
                        <td>${part.partNo}</td>
                        <td>${part.sellingPrice}</td>                                   
                        <td><input type="text" name="orderId" value="${orderId}" class="hidden">${part.model}</td>
                        <td>
                        <select name="picker">
                        <option value="0">请选择领料人</option>
                        <c:forEach items="${employees2}" var="employee" varStatus="va">
                       	 	<option value="${employee.employeeId}">${employee.employeeName}</option>
                       	 	
                        </c:forEach>
                        </select>
                        </td>
                        <td class="f-14 td-manage">
                    		<button  class="btn btn-secondary  radius" type="button" onClick="add_part(this,${part.partId },${orderId})"> 添加</button>
                    	</td>
                    </tr>
           </c:forEach>
                    </tbody>
                </table>

                </div>

        </article>
        

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
   
function add_part(obj,partId,orderId) {
	var tr = $(obj).parents("tr");
	var picker = tr.children('td').eq(4).find("select").val();
	location.replace("part-out-add.do?partId=" + partId + "&orderId=" + orderId + "&picker=" + picker);
	parent.location.reload();
	//<a href="part-out-add.do?orderId=${orderId}&partId=${part.partId}&picker=${employee.employeeId}">
} 

    
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>