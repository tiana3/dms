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
    <meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<!--_header 作为公共模版分离出去-->
	<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl">
			<a class="logo navbar-logo f-l mr-10 hidden-xs"
				href="#">售后管理系统</a> <a
				class="logo navbar-logo-m f-l mr-10 visible-xs"
				href="/aboutHui.shtml">H</a> <span
				class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span> 
			<nav class="nav navbar-nav">
						<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
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
			<dt class="selected">
				<i class="Hui-iconfont">&#xe616;</i> 维修业务<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd style="display: block;">
				<ul>
					<li><a href="#" title="预约">预约</a></li>
					<li><a href="#" title="维修估价">维修估价</a></li>
					<li class="current"><a href="${pageContext.request.contextPath }/OrderServlet" title="维修业务开单">维修业务开单</a></li>
					<li><a href="#" title="完工">完工</a></li>
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
					<li><a href="#" title="领料出库">领料出库</a></li>
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
					<li><a href="#" title="结算">结算</a></li>
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
					<li><a href="#" title="客户车辆信息">客户车辆信息</a></li>
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
					<li><a href="${pageContext.request.contextPath }/CarTypeListServlet" title="厂家车型管理">厂家车型管理</a></li>
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
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
       维修业务
        <span class="c-gray en">&gt;</span>
        维修业务开单
        <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
	 </nav> 
      <div class="Hui-article">
      	<article class="cl pd-20">    
	      	 <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
					<a href="javascript:;" onclick="TheMaintenanceServlet" class="btn btn-primary radius">在修业务</a>
					<a class="btn btn-primary radius" onclick="part_add('添加材料信息','GetCarTypeServlet?act=add')" href="javascript:;"> 质检</a>
					<a href="javascript:;" onclick="" class="btn btn-primary radius">完工</a>
				</span>
	            <span class="r">
	            	<a href="javascript:;" onclick="" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe632;</i>保存</a>
					<a href="javascript:;" onclick="" class="btn btn-primary radius">打印维修委托书</a>
					<a href="javascript:;" onclick="" class="btn btn-primary radius">打印派工单</a>
	            </span>
      	  	</div>
	      
 


			
			<p><span class="l">维修单号：${order.orderId }</span><span id="time1" class="r"></span></p>
        
		<form id="form1" action="${pageContext.request.contextPath }/getCustomer.do" method="post">
						<input type="hidden"  name="customerCraInfoId"  value="">
						
			<table class="table table-border table-bordered table-bg">
				<tbody>
					<tr>
						<td>车牌</td>                                                     
						<td>
						<input type="text" class="input-text" name="plateNumber"  value="${carInfo.plateNumber }" onkeydown='if(event.keyCode==13) {submit()}'>
						 <!--   <button  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查找</button>  -->

						</td>
						<td>预估完工时间</td>
						<td>
							<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',skin:'whyGreen',minDate:'%y-%M-%d %H:%m'})"  class="input-text Wdate">
						</td>
						
						<td>车主姓名</td>
						<td><input type="text" class="input-text"  name=""  value="${carInfo.customerName }"></td>
					</tr>
					<tr>
						<td>车架号</td>
						<td><input type="text" class="input-text"  name="VIN"  value="${carInfo.VIN }" onkeydown='if(event.keyCode==13) {submit()}'></td>
					
						<td>维修类别</td>
						<td>
							<select class="select">
							<c:forEach items="${repairType }" var="type">
								<option value="${type.repairTypeId }">${type.repairType } </option>
							</c:forEach>
							</select>
						</td>
						<td>车主地址</td>
						<td><input type="text" class="input-text"  name=""  value="${carInfo.address }"></td>

					</tr>
					<tr>
						<td>发动机号</td>
						<td><input type="text" class="input-text"  name=""  value="${carInfo.engineNumber }"></td>
						<td>购车日期</td>
						<td>
							<input type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"  class="input-text Wdate">
						</td>
												<td>车主电话</td>
						<td><input type="text" class="input-text"  name=""  value="${carInfo.phone }"></td>
						


					</tr>
					<tr>
						<td>车辆颜色</td>
						<td><input type="text" class="input-text"  name=""  value="${carInfo.color }"></td>
						<td>保险到期日期</td>
						<td>
							<input type="text"  onfocus="WdatePicker({skin:'whyGreen',maxDate:'{%y+1}-%M-%d'})"  class="input-text Wdate">
						</td>
						<td>送修人</td>
						<td><input type="text" class="input-text"  name=""  value=""></td>


					</tr>
					<tr>
						<td>变速箱</td>
						<td>								
								<div class="radio-box">
								<input name="变速箱" type="radio"  checked>
								<label>手动</label>
								</div>
								<div class="radio-box">
								<input type="radio"  name="变速箱">
								<label>自动</label>
								</div>
						</td>
						<td>当前里程</td>
						<td><input type="text" class="input-text"  name=""  value=""></td>
						
						<td>送修人电话</td>
						<td><input type="text" class="input-text"  name=""  value=""></td>
						
						
					</tr>
				<tr>
					<td>服务顾问</td>
					<td>
						<select class="select">
							<option></option>
						</select>

					</td>
					<td>备注</td>
					<td colspan="3"><input type="text" class="input-text"  name=""  value=""></td>
					
				</tr>
				
				<tr>
					<td>外观内饰备注</td>
					<td colspan="5"><input type="text" class="input-text"  name=""  value=""></td>
				</tr>
		</tbody>
	</table>
	</form>
	
			<table class="table table-border table-bordered table-bg mt-20">
				<thead>
					<tr>
						<th colspan="2" scope="col">服务器信息</th>
			</tr>
		</thead>
				<tbody>
					<tr>
						<th width="30%">服务器计算机名</th>
						<td><span id="lbServerName">http://127.0.0.1/</span></td>
			</tr>
					<tr>
						<td>服务器IP地址</td>
						<td>192.168.1.1</td>
			</tr>
					<tr>
						<td>服务器域名</td>
						<td>www.h-ui.net</td>
			</tr>
					<tr>
						<td>服务器端口 </td>
						<td>80</td>
			</tr>
					<tr>
						<td>服务器IIS版本 </td>
						<td>Microsoft-IIS/6.0</td>
			</tr>
					<tr>
						<td>本文件所在文件夹 </td>
						<td>D:\WebSite\HanXiPuTai.com\XinYiCMS.Web\</td>
			</tr>
					<tr>
						<td>服务器操作系统 </td>
						<td>Microsoft Windows NT 5.2.3790 Service Pack 2</td>
			</tr>
					<tr>
						<td>系统所在文件夹 </td>
						<td>C:\WINDOWS\system32</td>
			</tr>
					<tr>
						<td>服务器脚本超时时间 </td>
						<td>30000秒</td>
			</tr>
					<tr>
						<td>服务器的语言种类 </td>
						<td>Chinese (People's Republic of China)</td>
			</tr>
					<tr>
						<td>.NET Framework 版本 </td>
						<td>2.050727.3655</td>
			</tr>
					<tr>
						<td>服务器当前时间 </td>
						<td>2014-6-14 12:06:23</td>
			</tr>
					<tr>
						<td>服务器IE版本 </td>
						<td>6.0000</td>
			</tr>
					<tr>
						<td>服务器上次启动到现在已运行 </td>
						<td>7210分钟</td>
			</tr>
					<tr>
						<td>逻辑驱动器 </td>
						<td>C:\D:\</td>
			</tr>
					<tr>
						<td>CPU 总数 </td>
						<td>4</td>
			</tr>
					<tr>
						<td>CPU 类型 </td>
						<td>x86 Family 6 Model 42 Stepping 1, GenuineIntel</td>
			</tr>
					<tr>
						<td>虚拟内存 </td>
						<td>52480M</td>
			</tr>
					<tr>
						<td>当前程序占用内存 </td>
						<td>3.29M</td>
			</tr>
					<tr>
						<td>Asp.net所占内存 </td>
						<td>51.46M</td>
			</tr>
					<tr>
						<td>当前Session数量 </td>
						<td>8</td>
			</tr>
					<tr>
						<td>当前SessionID </td>
						<td>gznhpwmp34004345jz2q3l45</td>
			</tr>
					<tr>
						<td>当前系统用户名 </td>
						<td>NETWORK SERVICE</td>
			</tr>
		</tbody>
	</table>
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
<script type="text/javascript">
	setInterval("document.getElementById('time1').innerHTML='当前时间：' + new Date().toLocaleString()",1000); 

   
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>