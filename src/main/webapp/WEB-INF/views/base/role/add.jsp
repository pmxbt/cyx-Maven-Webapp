<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/noCompile/My97DatePicker/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/noCompile/css/add.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/noCompile/css/zTreeStyle.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/noCompile/js/jquery.ztree.all.js"></script>
<title></title>
<script type="text/javascript">
var zTreeObj;

var setting = {
		check : {
			enable: true,
			autoCheckTrigger:true,
			chkStyle:"checkbox",
			chkboxType : {"Y": "ps", "N": "ps"},
		},
		data:{
			simpleData :{
				enable:true,	
				idKey: "id",
				pIdKey: "pid",
				rootPId: 0
			}
		},
		callback:{
			onCheck:onCheck,
		},
		view:{
			showIcon:false,
		}
};

var zNodes = ${catalog_list};
$(document).ready(function(){
   zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
});

function onCheck(event, treeId, treeNode){
	alert(event);
	alert(treeId);
	alert(treeNode);
	
}



</script>
</head>
<body>
<form action="/cyx/role/save" method="post" id="form" >
<table>
	<tbody>
		<tr>
		<tr>
			<th>名称</th>
			<td>
				<input type="text" name="name"/>
			</td>
			<th>创建人</th>
			<td>
				<input type="hidden" value="${user.id}" name="createUserId">
				<input type="text" value="${user.name}" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td colspan="4" style="height: 300px;">
				<ul id="treeDemo" class="ztree" style="width: 100%;background-color: #f1f1f1;height: 90%;overflow: auto;"></ul>		
			</td>
		</tr>
		
		
	  <tr>
  	 	<td colspan="4" style="height:30px;line-height:30px;text-align: center;vertical-align: middle">
	   		<input type="submit"  class="btn" value="提交" style="width: 80px"/>
	    	<input type="button" class="btn" value="返回" style="width: 80px" onclick="javascript:history.go(-1);"/>
	    </td>
      </tr>
	</tbody>
</table>
</form>
</body>
  <script type="text/javascript">
	function check(obj){
		if('' !=obj.value.replace(/\d{1,}\.{0,1}\d{0,1}/,'')){
	          obj.value = obj.value.match(/\d{1,}\.{0,1}\d{0,1}/) == null ? '':obj.value.match(/\d{1,}\.{0,1}\d{0,1}/);      
	    }
	}
	
  </script>
</html>