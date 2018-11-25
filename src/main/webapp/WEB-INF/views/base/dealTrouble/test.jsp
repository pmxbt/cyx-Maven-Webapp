<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/noCompile/My97DatePicker/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/noCompile/css/add.css" />
<title>部门增加</title>
</head>
<body>
<form action="/cyx/dealTrouble/save" method="post" id="form" >
<table>
	<tbody>
		<tr>
			<th><input type="text" name="dealId" ></th>
			<td>
				<input type="text" name="deviceId" >
			</td>
			<th><input type="text" name="totalCost"></th>
			<td>
				<input type="text" name="count">
			</td>
		</tr>
		<tr>
			<th><input type="text" name="dealId" ></th>
			<td>
				<input type="text" name="deviceId" >
			</td>
			<th><input type="text" name="totalCost"></th>
			<td>
				<input type="text" name="count">
			</td>
		</tr>
	  <tr>
   		<td colspan="4" style="height:30px;line-height:30px;text-align: center;vertical-align: middle">
	   		<input type="button"  class="btn" value="提交" style="width: 80px" onclick="on()"/>
	    	<input type="button" class="btn" value="返回" style="width: 80px" onclick="javascript:history.go(-1);"/>
   		</td>
   </tr>
	</tbody>
</table>
</form>
</body>
  <script type="text/javascript">
  	function on(){
  		var ddcs = [];
  		var dealIds =[];var deviceIds =[];var totalCosts =[];var counts =[];
        $("input[name='dealId']").each(function(){
        	dealIds.push($(this).val());
        })
        $("input[name='deviceId']").each(function(){
        	deviceIds.push($(this).val());
        })
        $("input[name='totalCost']").each(function(){
        	totalCosts.push($(this).val());
        })
        $("input[name='count']").each(function(){
        	counts.push($(this).val());
        })
  		for(var i=0;i < dealIds.length;i++){
  			alert(dealIds[i]);
  			var data = {dealId:dealIds[i],deviceId:deviceIds[i],totalCost:totalCosts[i],count:counts[i]};
  			ddcs.push(data);
  		}
  		
  		 $.ajax({
  	        type:"POST",
  	        url: "/cyx/dealTrouble/save",
  	        dataType:"json",
  	        contentType:"application/json", // 指定这个协议很重要
  	        data:JSON.stringify(ddcs), //只有这一个参数，json格式，后台解析为实体，后台可以直接用
  	        success:function(data){
  	        }
  	    });
  		
  	}
  </script>
</html>