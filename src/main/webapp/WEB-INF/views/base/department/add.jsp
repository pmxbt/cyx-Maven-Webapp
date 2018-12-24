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
<form action="/cyx/department/save" method="post" id="form" >
<table>
	<tbody>
		<tr>
			<th>部门名称</th>
			<td>
				<input type="text" name="name" >
			</td>
			<th>排序</th>
			<td>
				<input type="text" name="sort">
			</td>
		</tr>
		<tr>
			<th>类型</th>
			<td colspan="3">
				<select name="mold" id="mold">
					<option></option>
					<c:forEach items="${moldMap}" var="d">
						<option value="${d.key}">${d.value}</option>
					</c:forEach>
				</select>
				
			</td>
		</tr>
		  <tr>
   	<td colspan="4" style="height:30px;line-height:30px;text-align: center;vertical-align: middle">
   		<input type="button"  class="btn" value="提交" style="width: 80px" onclick="sub()"/>
    	<input type="button" class="btn" value="返回" style="width: 80px" onclick="javascript:history.go(-1);"/>
    </td>
   </tr>
	</tbody>
</table>
</form>
</body>
  <script type="text/javascript">
  	function sub(){
  		if($("#mold").val()==""||$("#mold").val()==null){
  			alert("请选择类型");
  		}else{
  			$.post("/cyx/department/addCheckDept",{'mold':$("#mold").val()},
  		  			function(msg){
  		  				if(msg =="yes"){
  							$("#form").submit();
  						}else{
  							alert("本地区已有相同类型部门！");	
  						}
  		  		});
  		}
  	}
  
  </script>
</html>