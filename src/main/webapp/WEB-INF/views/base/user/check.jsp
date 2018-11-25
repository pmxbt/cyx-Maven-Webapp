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
<form action="/cyx/user/update" method="post" id="form" >
<input type="hidden" name="id" value="${user.id}">
<table>
	<tbody>
		<tr>
			<th>账户</th>
			<td>
				<input type="text" name="userName" value="${user.userName}"  readonly="readonly">
			</td>
			<th>密码</th>
			<td>
				<input type="text" name="password" value="${user.password}"  readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>部门</th>
			<td>
				<input type="text" value="${user.dept.name}" readonly="readonly">
			</td>
			<th>排序</th>
			<td>
				<input type="text" name="sort" value="${user.sort}"  readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>姓名</th>
			<td >
				<input type="text" name="name" value="${user.name}" readonly="readonly">
			</td>
			<th>电话</th>
			<td>
				<input type="text" name="telephone" value="${user.telephone}"  readonly="readonly">
			</td>
		</tr>
		  <tr>
   	<td colspan="4" style="height:30px;line-height:30px;text-align: center;vertical-align: middle">
    	<input type="button" class="btn" value="返回" style="width: 80px" onclick="javascript:history.go(-1);"/>
    </td>
   </tr>
	</tbody>
</table>
</form>
</body>
  <script type="text/javascript">
  </script>
</html>