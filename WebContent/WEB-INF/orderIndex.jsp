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

    <title>维修业务开单</title>
	


</head>
<body>
<!--_header 作为公共模版分离出去-->
	<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl">
		<span class="logo navbar-slogan f-l mr-10 hidden-xs"><img alt="车标" src="image/das.jpg" style="width: 50px"></span>
		
			<span class="logo navbar-logo f-l mr-10 hidden-xs">售后管理系统</span>
			<nav class="nav navbar-nav">
						<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li class="dropDown dropDown_hover">
					${userName }<i class="Hui-iconfont">&#xe6d5;</i>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" onclick="changePassword()">修改密码</a></li>	
						<li><a href="${pageContext.request.contextPath }/logout.do">退出</a></li>
					</ul>
				</li>
				
				<li id="Hui-skin" class="dropDown right dropDown_hover"><a
					href="javascript:;" class="dropDown_A" title="换肤"><i
						class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul></li>
			</ul>
			</nav>
		</div>
	</div>
	</header>
	<!--/_header 作为公共模版分离出去-->

	<!--_menu 作为公共模版分离出去-->
	<aside class="Hui-aside">

	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt class="selected">
				<i class="Hui-iconfont">&#xe616;</i> 维修业务<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd style="display: block;">
				<ul>
					<li><a href="#" title="预约">预约</a></li>
					<li><a href="#" title="维修估价">维修估价</a></li>
					<li><a href="javascript:;"  onclick="powerJump('${pageContext.request.contextPath }/order.do')" title="维修业务开单">维修业务开单</a></li>
					<li><a href="javascript:;" onclick="complete()" title="完工">完工</a></li>
					<li><a href="#" title="维修业务查询">维修业务查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-picture">
			<dt>
				<i class="Hui-iconfont">&#xe613;</i> 库房管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="${pageContext.request.contextPath }/partout.do" title="领料出库">领料出库</a></li>
					<li><a href="#" title="销货出库">销货出库出库</a></li>
					<li><a href="#" title="退货出库">退货出库</a></li>
					<li><a href="#" title="移库出库">移库出库</a></li>
					<li><a href="#" title="采购入库">采购入库</a></li>
					<li><a href="#" title="客户退货入库">客户退货入库</a></li>
					<li><a href="#" title="移库入库">移库入库</a></li>
					<li><a href="#" title="领料返还入库">领料返还入库</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-product">
			<dt>
				<i class="Hui-iconfont">&#xe620;</i> 财务管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="${pageContext.request.contextPath }/settlement.do" title="结算">结算</a></li>
					<li><a href="#" title="取消结算">取消结算</a></li>
					<li><a href="${pageContext.request.contextPath }/workout-list.do" title="取消完工">取消完工</a></li>
					<li><a href="#" title="材料进货管理">材料进货管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-comments">
			<dt>
				<i class="Hui-iconfont">&#xe622;</i> 客户关怀回访<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="#" title="客户回访">客户回访</a></li>
					<li><a href="#" title="意见反馈">意见反馈</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-member">
			<dt>
				<i class="Hui-iconfont">&#xe60d;</i> 员工管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="${pageContext.request.contextPath }/employeelist" title="员工管理">员工管理</a></li>
					<li><a href="#" title="操作员管理">操作员管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-admin">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i> 档案信息管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="${pageContext.request.contextPath }/carinfo.do" title="客户车辆信息">客户车辆信息</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-tongji">
			<dt>
				<i class="Hui-iconfont">&#xe61a;</i> 基础信息管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="${pageContext.request.contextPath }/WorkHourListServlet" title="工时工位管理">工时工位管理</a></li>
					<li><a href="${pageContext.request.contextPath }/GetCarTypeServlet" title="材料目录管理">材料目录管理</a></li>
					<li><a href="javascript:;"  onclick="powerJump('${pageContext.request.contextPath }/CarTypeListServlet')" title="厂家车型管理">厂家车型管理</a></li>
				
				</ul>
			</dd>
		</dl>
	</div>
	</aside>
	<div class="dislpayArrow hidden-xs">
		<a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"></a>
	</div>
	<!--/_menu 作为公共模版分离出去-->



<section class="Hui-article-box">
    <nav class="breadcrumb">
    
    <i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
       维修业务
        <span class="c-gray en">&gt;</span>
        维修业务开单
        <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="${pageContext.request.contextPath }/orderIndex.do" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
	 </nav> 
      <div class="Hui-article">
      	<article class="cl pd-20">    
			<span id="error" style="color: red;"></span>
			<form id="form-order-save" action="${pageContext.request.contextPath }/orderInfo.do" method="post">
	
	      	 <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				    <a class="btn btn-primary radius"  href="${pageContext.request.contextPath }/orderIndex.do">新开单</a>
					<a href="theMaintenance.do" onclick="" class="btn btn-primary radius">在修业务</a>
					<a href="javascript:;" onclick="" class="btn btn-primary radius">完工</a>
					质检<select class="select" name="inspector" style="display: inline; width: 140px;">
							<option value="0">&nbsp; </option>
							<c:forEach items="${inspectors }" var="inspector">
								<option value="${inspector.employeeId }">${inspector.jobName }-${inspector.employeeName } </option>
							</c:forEach>
						</select>
				</span>
	            <span class="r">  
   					<a class="btn btn-danger  radius" onclick="deleteOrder()" href="javascript:;"> <i class="Hui-iconfont">&#xe6e2;</i>作废</a>                                  
					<button class="btn btn-primary radius" id="saveButton"  type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
					<a href="javascript:;" onclick="" class="btn btn-primary radius">打印维修委托书</a>
					<a href="javascript:;" onclick="" class="btn btn-primary radius">打印派工单</a>
	            </span>
      	  	</div>

			<p><span id="showOrderId" class="l">维修单号:${order.orderId }</span><span id="time1" class="r" style="margin-right: 120px">开单时间:${order.date }</span></p>
        	<input type="hidden" id="hiddenDate" name="Date"  value="${order.date }">
			<input type="hidden" id="hiddenCustomerCarInfoId"  name="customerCarInfo.customerCarInfoId"  value="${carInfo.customerCarInfoId }">
			<input type="hidden" id="hiddenOrderId" name="orderId"  value="${order.orderId }">			
			<table class="table table-border table-bordered table-bg">
				<tbody>
					<tr>
						<td>车牌</td>                                                     
						<td>
						<input id="plate" type="text" class="input-text" name="plateNumber"  value="${carInfo.plateNumber }" onkeydown='if(event.keyCode==13) {submit()}'>
						 <!--   <button  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查找</button>  -->
						</td>
						<td>预估完工时间</td>
						<td>
							<input type="text" value="${order.expectDate }" name="expectDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',skin:'whyGreen',minDate:'%y-%M-%d %H:%m'})"  class="input-text Wdate">
						</td>
						
						<td>车主姓名</td>
						<td>${carInfo.customerName }</td>
					</tr>
					<tr>
						<td>车架号</td>
						<td><input id="vin" type="text" class="input-text"  name="VIN"  value="${carInfo.VIN }" onkeydown='if(event.keyCode==13) {submit()}'></td>
					
						<td>维修类别</td>
						<td>
							<select class="select" name="repairId">
							<c:forEach items="${repairType }" var="type">
								<option value="${type.repairTypeId }" ${type.repairTypeId==order.repairId? 'selected':'' }>${type.repairType } </option>
							</c:forEach>
							</select>
						</td>
						<td>车主地址</td>
						<td>${carInfo.address }</td>

					</tr>
					<tr>
						<td>车型</td>
						<td>${carInfo.carType.factory} ${carInfo.carType.model}</td>
						<td>购车日期</td>
						<td>
							${carInfo.buyDate }
						</td>
						<td>车主电话</td>
						<td>${carInfo.phone }</td>
						


					</tr>
					<tr>
						<td>车辆颜色</td>
						<td>${carInfo.color }</td>
						<td>保险到期日期</td>
						<td>
							${carInfo.policyDate }
						</td>
						<td>送修人</td>
						<td><input type="text" class="input-text"  name="sender"  value="${lastOrder.sender }"></td>


					</tr>
					<tr>
						<td>变速箱</td>
						<td>								
							${carInfo.gearBox }
						</td>
						<td>当前里程</td>
						<td><input type="text" class="input-text"  name="mileage"  value="${order.mileage }"></td>
						
						<td>送修人电话</td>
						<td><input type="text" class="input-text"  name="senderPhone"  value="${lastOrder.senderPhone }"></td>
						
						
					</tr>
				<tr>
					<td>服务顾问</td>
					<td>
						<select class="select" name="SA">
							<c:forEach items="${sa }" var="s">
								<option value="${s.employeeId }"  ${order.SA == s.employeeId ?'selected' : '' }>${s.employeeName } </option>
							</c:forEach>
						</select>

					</td>
					<td>备注</td>
					<td colspan="3"><input type="text" class="input-text"  name="remark"  value="${order.remark }"></td>
					
				</tr>
				
				<tr>
					<td>外观内饰备注</td>
					<td colspan="5"><input type="text" class="input-text"  name="carRemark"  value="${order.carRemark }"></td>
				</tr>
		</tbody>
	</table>
	
	
	      	 <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<b>工时工位</b>
				</span>
	            <span class="r">
					<a href="javascript:;" onclick="allWork_select('整单派工','${pageContext.request.contextPath }/allWorkSelect.do','300','200')" class="btn btn-secondary  radius">整单派工</a>
					<a href="javascript:;" onclick="add_work('选择预定义工位','${pageContext.request.contextPath }/addWork.do','800','600')" class="btn btn-secondary  radius"><i class="Hui-iconfont">&#xe600;</i>添加预定义工位</a>
					<a class="btn btn-secondary  radius" onclick="custom_add()" href="javascript:;"> <i class="Hui-iconfont">&#xe600;</i>添加自定义工位</a>
					<a class="btn btn-danger  radius" onclick="workplace_delete()" href="javascript:;"> <i class="Hui-iconfont">&#xe6e2;</i>删除工位</a>
	            </span>
      	  	</div>
	
			<table class="table table-border table-bordered table-bg mt-20">
				<thead>
					<tr>
						<th width="60%" scope="col">工位名</th>
						<th width="20%" scope="col">工时费</th>
						<th scope="col">技师</th>
					</tr>
				</thead>
				<tbody id="workhour">
					<c:forEach items="${order.customs }" var="custom" varStatus="num">
						<tr>
							<td><input value="${custom.customName }"  name="customs[${num.count - 1 }].customName" type="text" class="input-text"></td>
							<td><input value="${custom.customPrice }"  name="customs[${num.count - 1 }].customPrice" type="text" class="number input-text "></td>
							<td>
								<select name="customs[${num.count - 1 }].employeeId" class="select">
										<option value="0">&nbsp;&nbsp;</option>
										<c:forEach items="${Ma_Tec }" var="ma">
											<option value="${ma.employeeId }" ${custom.employeeId == ma.employeeId? "selected":"" } >${ma.jobName }-${ma.employeeName }</option>
										</c:forEach>
								</select>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
     		 <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<b>配件材料</b>
				</span>
	            <span class="r">
					<a href="javascript:;" onclick="add_part('添加配件材料','${pageContext.request.contextPath }/addPart.do','800','500')" class="btn btn-secondary  radius"><i class="Hui-iconfont">&#xe600;</i>添加配件材料</a>
	            </span>
      	  	</div>
	
			<table class="table table-border table-bordered table-bg mt-20">
				<thead>
					<tr>
						<th width="20%" scope="col">配件名</th>
						<th width="20%" scope="col">配件号</th>
						<th width="15%" scope="col">金额</th>
						<th width="15%" scope="col">适用车型</th>
						<th width="15%" scope="col">领料人</th>
						<th scope="col">操作</th>
					</tr>
				</thead>
				<tbody id="part">
					<c:forEach items="${order.parts }" var="part" varStatus="num">
						<tr>
							<td>
								<input value="${part.partId }"  name="parts[${num.count - 1 }].partId" type="hidden" >
								${part.partName }
							</td>
							<td>${part.partNo }</td>
							<td>${part.sellingPrice }</td>
							<td>${part.model }</td>
								<td>
							<c:forEach items="${Ma_Tec }" var="ma">
								<c:if test="${part.picker == ma.employeeId}">
									${ma.jobName }-${ma.employeeName }
								</c:if>
							</c:forEach>
								</td>

							<td>
								<a style="text-decoration: none" class="ml-5" href="javascript:;"
								onclick="part_del(this)"
								title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
	
	
	
	
	
	</form>

</article>
</div>
   
   
 </section>

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
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>   
<script type="text/javascript" src="lib/jquery.validation/1.14.0/additional-methods.js"></script>   
<script type="text/javascript" src="lib/jquery/jquery.metadata.js"></script>   
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="js/myJs.js"></script>
<script type="text/javascript">
	//setInterval("document.getElementById('time1').innerHTML='当前时间：' + new Date().toLocaleString()",1000); 
	
//创建了一个方法，用于下面调用
function save() {
	// 关键在此增加了一个return，返回的是一个validate对象，这个对象有一个form方法，返回的是是否通过验证 true false*/
	return   $("#form-order-save").validate({
 
			
			rules:{
				plateNumber:{
					required:true,
				},
				VIN:{
					required:true,
				},
				expectDate:{
					required:true,
	
				},
				mileage:{
					required:true,
					number:true,
					min:0,
				},
				sender:{
					required:true,
				},
				senderPhone:{
					required:true,
				},
			 },
				
             messages:{
             	plateNumber:{
                     required:"根据车牌查询车辆信息 ",
                 },
                 VIN:{
                     required:"根据车架号查询车辆信息 ",
                 },
                 expectDate:{
                     required: "预完工时间必须选择 ",
                 },
                 mileage:{
 					required:"里程必填且为数字 ",
 					number:"里程必须为数字 ",
 					min:"里程不能小于0",
                 },
 				sender:{
 					required:"送修人必填 ",
 				},
 				senderPhone:{
 					required:"送修人电话必填 ",
 				},
			},
			//这是自定义错误信息的显示 ，  error是错误信息对象，element是当前验证的对象
			errorPlacement : function(error, element) { 
				//给element增加一个属性，是在文本里有提示信息
				$(element).attr("placeholder",error.html());
			}, 
			//onkeyup:false,
/* 			focusCleanup:true,
			success:"valid",
		submitHandler:function(form){
			
			   var length = document.getElementById("part").children.length;
			   for (i = 0; i < length; i++) {
				   document.getElementById("part").getElementsByTagName("tr")[i].getElementsByTagName("input")[0].name="parts["+ i +"].partId";
			   }
			   $("#form-order-save").attr("action","${pageContext.request.contextPath }/orderSave.do");


		   $(form).ajaxSubmit({
				success: function() { 
				}
				
			})
				
			
		} */
	});
}
	//创建点击事件，当点击时会先调用sava()方法， 然后返回一个对象，调用form()方法
	$("#saveButton").click(function(){
		 if(save().form()) {
			
			 if($("#hiddenOrderId").val()==""){
				 //通过表单验证，以下编写自己的代码
				 var length = document.getElementById("part").children.length;
				   for (i = 0; i < length; i++) {
					   document.getElementById("part").getElementsByTagName("tr")[i].getElementsByTagName("input")[0].name="parts["+ i +"].partId";
				   }
				   $("#form-order-save").attr("action","${pageContext.request.contextPath }/orderSave.do");
				  
				   $("#form-order-save").ajaxSubmit({
						success: function(data) { 
							var json = JSON.parse(data);
							layer.msg("维修单新增成功",{icon:1,time:1000});
							$("#hiddenOrderId").val(json.orderId);
							$("#hiddenDate").val(json.date);
							$("#showOrderId").text("维修单号:"+json.orderId);
							$("#time1").text("开单时间:"+json.date);
						}
					})
			 } else {
				 //动态设置配件材料的name属性
				 var length = document.getElementById("part").children.length;
				   for (i = 0; i < length; i++) {
					   document.getElementById("part").getElementsByTagName("tr")[i].getElementsByTagName("input")[0].name="parts["+ i +"].partId";
				   }
				   $("#form-order-save").attr("action","${pageContext.request.contextPath }/orderSave.do");

				   $("#form-order-save").ajaxSubmit({
					   url:"${pageContext.request.contextPath }/updateOrder.do",
					   
					   
					  	success: function() { 
					  		
							layer.msg("已保存",{icon:1,time:1000});
						}
				   })
			 }
			 
		 } else {
		  //校验不通过，什么都不用做，校验信息已经正常显示在表单上
		 }
	});
	
	
	
	
	
	function custom_add() {
		var workhour = document.getElementById("workhour");
		var length = workhour.children.length;
		/*var tr = document.createElement("tr");
		 var td = document.createElement("td");
		var select = document.createElement("select");
		var forEach = document.createElement("c:forEach");
		forEach.setAttribute("items", "${Ma_Tec }");
		forEach.setAttribute("var", "ma");
		var option = document.createElement("option");
		option.setAttribute("value", "${ma.employeeId}"); */
		$("#workhour").append("<tr><td><input name='customs["+length+"].customName' type='text' class='input-text'></td><td><input name='customs["+length+"].customPrice'  type='text' class='input-text number'></td><td><select class='select' name='customs["+ length +"].employeeId'><option value='0'>&nbsp;&nbsp;</option><c:forEach items='${Ma_Tec }' var='ma'><option value='${ma.employeeId}'>${ma.jobName}-${ma.employeeName}</option></c:forEach></select></td></tr>");
	}
	
	function workplace_delete() {
		if($("#workhour tr").length != 0) {
			 $("#workhour tr:last").remove();
			 layer.msg("删除成功",{icon:1,time:1000});
		}else{
			 layer.msg("没有工位",{icon:2,time:1000});
		}
	}

   function allWork_select(title,url,w,h){
       layer_show(title,url,w,h);
   }
   
	function part_del(obj){
			$(obj).parents("tr").remove();
			layer.msg('已删除!',{icon:1,time:1000});
	}

   function add_part(title,url,w,h){
       layer_show(title,url,w,h);
   }
   function add_work(title,url,w,h){
       layer_show(title,url,w,h);
   } 
   
   
   function deleteOrder() {
       var Id = $("#hiddenOrderId").val();
	   if(Id != "" && Id != null) {
	       layer.confirm('确认作废维修单吗？',function(index){
	          var Id = $("#hiddenOrderId").val();
	    	   
	    	   $.ajax({
	               type: 'POST',                            
	               url: '${pageContext.request.contextPath }/orderDelete.do',
	               data: {orderId:Id},
	               //dataType: 'json',
	               success: function(data){
	            	   var json = JSON.parse(data);
	            	   if(json.valid==0) {
	           				layer.msg('对不起,你作废权限',{icon:4,time:1500});
	            	   }else if(json.valid==1){
		                   location.replace("${pageContext.request.contextPath }/orderIndex.do");
	            	   }
	               },
	               error:function() {
	                   console.log();
	               },
	           });
	       });

	   }else{
		   layer.msg("还没有维修单",{icon:2,time:1000});
	   }
   }
   
   $(document).ready(function(){ 
	   if($("#hiddenCustomerCarInfoId").val()!="") {
		   $("#vin").attr("readonly",true);
		   $("#plate").attr("readonly",true);
	   }
   })
   
   //修改密码
   function changePassword(title,url,w,h){
    layer_show("修改密码","${pageContext.request.contextPath }/password.do",500,300);
	}
   
   //完工
   function complete(){
	   
   }
   
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>