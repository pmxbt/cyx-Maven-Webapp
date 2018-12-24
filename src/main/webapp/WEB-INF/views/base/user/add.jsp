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
<form action="/cyx/user/save" method="post" id="form" >
<table>
	<tbody>
		<tr>
			<th>账户</th>
			<td>
				<input type="text" name="userName" id="userName">
			</td>
			<th>密码</th>
			<td>
				<input type="text" name="password">
			</td>
		</tr>
		<tr>
			<th>部门</th>
			<td>
				<select name="dept.id">
					<option></option>
					<c:forEach items="${deptList}" var="d">
						<option value="${d.id}">${d.name}</option>
					</c:forEach>
				</select>
			</td>
			<th>排序</th>
			<td>
				<input type="text" name="sort">
			</td>
		</tr>
		<tr>
			<th>姓名</th>
			<td >
				<input type="text" name="name">
			</td>
			<th>电话</th>
			<td >
				<input type="text" name="telephone">
			</td>
		</tr>
		<c:if test="${user.regionId==1}">
			<tr>
				<th>地区</th>
				<td >
					<select name="regionId">
						<option></option>
						<c:forEach var= "d" items="${regionList}">
							<option value="${d.id}">${d.name}</option>
						</c:forEach>
					</select>
				</td>
				<td colspan="2"></td>
			</tr>
		</c:if>
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
  		$.post("addCheckUser",{'userName':$("#userName").val()},
  			function(msg){
  				if(msg =="yes"){
					$("#form").submit();
				}else{
					alert("用户名重复！");	
				}
  		}		
  		);
  	}
  
  </script>
</html>