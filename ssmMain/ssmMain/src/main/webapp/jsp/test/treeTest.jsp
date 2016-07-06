<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="${ctx }res/js/jquery-1.7.1.js"></script>
    <title>测试树demo</title>
    
    
   <SCRIPT type="text/javascript">
		var setting = {
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};

		var zNodes =[
			{id:1, pId:0, title:"hdasjdhasjhd", name:"北京"},
			{id:2, pId:0, title:"hdasjdhasjhd", name:"天津"},
			{id:3, pId:0, title:"hdasjdhasjhd", name:"上海"},
			{id:6, pId:0, title:"hdasjdhasjhd", name:"重庆"},
			{id:4, pId:0, title:"hdasjdhasjhd", name:"河北省", open:true},
			{id:41, pId:4, title:"hdasjdhasjhd", name:"石家庄"},
			{id:42, pId:4, title:"hdasjdhasjhd", name:"保定"},
			{id:43, pId:4, title:"hdasjdhasjhd", name:"邯郸"},
			{id:44, pId:4, title:"hdasjdhasjhd", name:"承德"},
			{id:5, pId:0, title:"hdasjdhasjhd", name:"广东省", open:true},
			{id:51, pId:5, title:"hdasjdhasjhd", name:"广州"},
			{id:52, pId:5, title:"hdasjdhasjhd", name:"深圳"},
			{id:53, pId:5, title:"hdasjdhasjhd", name:"东莞"},
			{id:54, pId:5, title:"hdasjdhasjhd", name:"佛山"},
			{id:6, pId:0, name:"福建省", open:true},
			{id:61, pId:6, name:"福州"},
			{id:62, pId:6, name:"厦门"},
			{id:63, pId:6, name:"泉州"},
			{id:64, pId:6, name:"三明"}
		 ];

		function beforeClick(treeId, treeNode) {
			var check = (treeNode && !treeNode.isParent);
			if (!check) alert("只能选择子节点...");
			return check;
		}
		
		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			v = "";
			//nodes.sort(function compare(a,b){return a.id-b.id;});  //  控制选择子节点时，按下 Ctrl 或 Cmd 键可以进行多选
			for (var i=0, l=nodes.length; i<l; i++) {
				v += nodes[i].name + ",";
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			var cityObj = $("#citySel");
			cityObj.attr("value", v);	
			
		}

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
	</SCRIPT>
	
    
  </head>
  
  <body>
	<!-- ###################    tree  begin ################################# -->
	<div>
			<h1>下拉菜单</h1>
			<!--tree 容器-->
			<div id="menuContent" class="menuContent" style="display:display; position: absolute;">
				<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
			</div>
	</div>
	<!-- ###################    tree  end ################################# -->
		
  </body>
</html>
