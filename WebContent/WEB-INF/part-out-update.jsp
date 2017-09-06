<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>领料出库</title>
</head>
<body>
	<!--_header 作为公共模版分离出去-->
	<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl">
		<span class="logo navbar-slogan f-l mr-10 hidden-xs"><img alt="车标" src="image/das.jpg" style="width: 50px"></span>
		
			<span class="logo navbar-logo f-l mr-10 hidden-xs">售后管理系统</span> 
			<nav class="nav navbar-nav"> <nav id="Hui-userbar"
				class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>超级管理员</li>
				<li class="dropDown dropDown_hover"><a href="#"
					class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="#">退出</a></li>
					</ul></li>

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
			<dt>
				<i class="Hui-iconfont">&#xe616;</i> 维修业务<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="#" title="预约">预约</a></li>
					<li><a href="#" title="维修估价">维修估价</a></li>
					<li><a href="javascript:;"  onclick="powerJump('${pageContext.request.contextPath }/order.do')" title="维修业务开单">维修业务开单</a></li>
					<li><a href="#" title="完工">完工</a></li>
					<li><a href="#" title="维修业务查询">维修业务查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-picture">
			<dt class="selected">
				<i class="Hui-iconfont">&#xe613;</i> 库房管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd style="display: block;">
				<ul>
					<li class="current"><a href="${pageContext.request.contextPath }/partout.do" title="领料出库">领料出库</a></li>
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
					<li><a href="#" title="取消完工">取消完工</a></li>
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
					<li><a
						href="${pageContext.request.contextPath }/employeelist"
						title="员工管理">员工管理</a></li>
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
					<li><a
						href="${pageContext.request.contextPath }/WorkHourListServlet"
						title="工时工位管理">工时工位管理</a></li>
					<li><a
						href="${pageContext.request.contextPath }/PartListServlet"
						title="材料目录管理">材料目录管理</a></li>
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

	<section class="Hui-article-box"> <nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
	库房管理 <span class="c-gray en">&gt;</span> 领料出库 <a
		class="btn btn-success radius r"
		style="line-height: 1.6em; margin-top: 3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a></nav>
	<c:forEach items="${allOrders }" var="order" varStatus="varSta">
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l"><a class="btn btn-primary radius"
					onclick="cartype_edit('添加零件','part-show-insert.do?orderId=${order.orderId}')"
					href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加零件</a>
				</span> <input type="hidden" name="act"> <span class="r">共有数据：<strong>${fn:length(list2)}</strong>条
				</span>
			</div>
			<div class="mt-10">
				<table class="table table-border table-bordered table-bg table-sort">
					<thead>
					<tr class="text-c">
						<th>维修单号</th>
						<th>车牌号</th>
						<th>维修类型</th>
						<th>服务顾问</th>
						<th>开单时间</th>
					</tr>
				</thead>
						
						<tr class="text-c">
							<td>${order.orderId }</td>
							<td>${order.customerCarInfo.plateNumber}</td>
							<td>
							<c:forEach items="${repairType }" var="type">
								<c:if test="${type.repairTypeId == order.repairId}">
									${type.repairType }
								</c:if>
							</c:forEach>
							</td>
							<td><c:forEach items="${sa}" var="employee" varStatus="va">
								<c:if test="${employee.employeeId == order.SA}">
									${employee.employeeName }
								</c:if>
							</c:forEach>
							</td>
							<td>${order.date }</td>
						</tr>
						
					</table>
					<br>
					<br>
					<table class="table table-border table-bordered table-bg table-sort">	
						<tr class="text-c">
							<th>零件</th>
							<th>配件编号</th>
							<th>进价</th>
							<th>售价</th>
							<th>型号</th>
							<th>领料人</th>
							<th>操作</th>
						</tr>
						
						<c:forEach items="${parts}" var="part" varStatus="va">
						<c:forEach items="${allOrders }" var="order" varStatus="varSta">
						<tr class="text-c">
							<td>${part.partName}</td>
							<td>${part.partNo}</td>
							<td>${part.buyingPrice}</td>
							<td>${part.sellingPrice}</td>
							<td>${part.model}</td>
							<td>
							
							<select onchange="selectOnchang(this,Id=${part.id},orderId=${order.orderId})" name="picker">
								<option value="0">未选择</option>
							<c:forEach items="${employees2}" var="employee" varStatus="va">
								<option value="${employee.employeeId}"  ${part.picker==employee.employeeId? "selected":"" } >${employee.employeeName}</option>
							</c:forEach>
							</select>
							
							</td>
							<td><a style="text-decoration: none" class="ml-5" href="javascript:;"
							onclick="cartype_del(this,${part.id},${order.orderId})" title="删除"><i
								class="Hui-iconfont">&#xe6e2;</i></a></td>
							</tr>
							</c:forEach>
						</c:forEach>
				</table>
	</div>
	</c:forEach>
	</section>

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
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
	
	function selectOnchang(obj,Id,orderId){ 
		var picker = obj.options[obj.selectedIndex].value;
		var tmp = document.createElement("form"); 
	     var action = "part-out-update.do?Id=" + Id + "&picker=" + picker + "&orderId=" + orderId; 
	     tmp.action = action; 
	     tmp.method = "post"; 
	     document.body.appendChild(tmp); 
	     tmp.submit(); 
	     
		parent.layer.msg('领料人已变更!',{icon:6,time:1500});	
		}
		function cartype_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		function datadel() {
			layer
					.confirm(
							'确认要批量删除吗？',
							function(index) {
								var checkIds = '';
								$('input[name="selectemployee"]:checked').each(
										function() {
											checkIds += $(this).val() + ","
										})
								checkIds = checkIds.substring(0,
										checkIds.length - 1);

								$
										.ajax({
											type : 'POST',
											url : '${pageContext.request.contextPath }/empCheckedDeleteServlet',
											data : "employeeids=" + checkIds,
											//dataType: 'json',
											success : function(data) {
												$(
														'input[name="selectemployee"]:checked')
														.each(
																function() {
																	$(this)
																			.parents(
																					"tr")
																			.remove();
																})
												layer.msg(data, {
													icon : 1,
													time : 1000
												});
											},
											error : function(data) {
												console.log(data.msg);
											},
										});
							});

		}

		function cartype_del(obj, id,orderId) {
			layer.confirm('确认要删除此零件吗？', function(index) {
				//此处请求后台程序，下方是成功后的前台处理……
				$.ajax({
					url : "part-out-delet.do?Id=" + id + "&orderId=" + orderId
				});
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});
		}
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>