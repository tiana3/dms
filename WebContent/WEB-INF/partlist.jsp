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

    <title>材料目录管理</title>
    <meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
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
					<li><a href="${pageContext.request.contextPath }/cancelSettlement.do" title="取消结算">取消结算</a></li>
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
					<li><a href="${pageContext.request.contextPath }/carinfo.do" title="客户车辆信息">客户车辆信息</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-tongji">
			<dt class="selected">
				<i class="Hui-iconfont">&#xe61a;</i> 基础信息管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd style="display: block;">
				<ul>
					<li><a href="${pageContext.request.contextPath }/WorkHourListServlet" title="工时工位管理">工时工位管理</a></li>
					<li class="current"><a href="${pageContext.request.contextPath }/GetCarTypeServlet" title="材料目录管理">材料目录管理</a></li>
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
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
       基础信息管理
        <span class="c-gray en">&gt;</span>
        材料目录管理
        <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">
			<form action="PartListServlet" method="post" >
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
		
               <button  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button> 
              
            </div>
            <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
				<a class="btn btn-primary radius" data-title="添加信息"  onclick="part_add('添加材料信息','GetCarTypeServlet?act=add')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加信息</a>
				</span>
				<input type="hidden" name="act">
                <span class="r">共有数据：<strong>${fn:length(partlist)}</strong>条</span>
            </div>
            <div class="mt-20">     
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="25"><input type="checkbox" name="" value=""></th>
                        <th width="80">序号</th>                       
                        <th width="80">配件名</th>
                        <th width="80">配件号</th>
                        <th width="80">适用车型</th>
                        <th width="120">进货成本</th>
                        <th width="75">销售价</th>
                        <th width="120">操作</th>
                    </tr>
                    </thead>
                    <tbody>
          <c:forEach items="${partlist}" var="part" varStatus="varSta">
                    <tr class="text-c">                  		
                        <td><input type="checkbox" value="${part.partId}" name="selectPart"></td>
                        <td>${varSta.count }</td>                       
                        <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','part-look.jsp?partId=${part.partId}&partName=${part.partName}&partNo=${part.partNo}&modelId=${part.modelId}&buyingPrice=${part.buyingPrice}&sellingPrice=${part.sellingPrice}','10001')" title="查看">${part.partName}</u></td>
                        <td>${part.partNo}</td>
                        <td>${part.model}</td>
                        <td>${part.buyingPrice}</td>
                        <td>${part.sellingPrice}</td>                                   
                        <td class="f-14 td-manage">
                        <a style="text-decoration:none" class="ml-5" onClick="part_edit('编辑资料','${pageContext.request.contextPath }/GetCarTypeServlet?partId=${part.partId}&act=update','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
                            <a style="text-decoration:none" class="ml-5" onClick="part_del(this,${part.partId})" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
                    </tr>
           </c:forEach>
                    </tbody>
                </table>
                </div>
                </form>
            </div>
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

    /*资讯-添加*/
    function part_add(title,url,w,h){
/*      	var index = layer.open({
            type: 2,
           title: title,
            content: url,
       });
       layer.full(index); */
        layer_show(title,url,w,h);
    }
    /*资讯-编辑*/
    function part_edit(title,url,id,w,h){
       /*  var index = layer.open({
            type: 2,
            title: title,
            content: url
        }); */
    	layer_show(title,url,w,h);
    }
    /*资讯-删除*/
    
   	function datadel() {
        layer.confirm('确认要批量删除吗？',function(index){
        	var checkIds = '';
        	$('input[name="selectPart"]:checked').each(function(){
        		checkIds += $(this).val()+","
        	})
        	checkIds = checkIds.substring(0,checkIds.length-1);
           
        	$.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath }/CheckedPartDeleteServlet',
                data: "partIds=" + checkIds ,
                //dataType: 'json',
                success: function(data){
                	$('input[name="selectPart"]:checked').each(function(){
                		$(this).parents("tr").remove();
                	})
                   layer.msg(data,{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    	
  	}
    
    
    function part_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath }/PartDeleteServlet',
                data: "partid=" + id ,
                //dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").remove();
                    layer.msg(data,{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

    
    
  //点击功能后权限验证的方法  
    function powerJump(url){
    	$.post(url,function(data){
    		var json = JSON.parse(data);
    		var power = json.valid;
    		if(0==power) {
    			var msg = json.message;
    			layer.msg(msg,{icon:4,time:1500});
    		}else if(1==power){
                var url = json.url;
    			location.replace(url);
    		}
    	})
    }
  
  
    function changePassword(title,url,w,h){
        layer_show("修改密码","${pageContext.request.contextPath }/password.do",500,300);
    }
   
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>