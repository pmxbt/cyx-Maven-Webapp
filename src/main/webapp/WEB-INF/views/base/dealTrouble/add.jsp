<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/noCompile/My97DatePicker/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/noCompile/css/add.css" />
<title></title>
</head>
<body>
<form action="/cyx/dealTrouble/save" method="post" id="form" >
<table>
	<tbody>
		<tr>
			<th>部门名称</th>
			<td>
				<input type="hidden" name="deptId" value="${user.dept.id}" >
				<input type="text" value="${user.dept.name}" readonly="readonly"/>
			</td>
			<th>创建人</th>
			<td>
				<input type="hidden" name="createUserId" value="${user.id}">
				<input type="text" value="${user.name}" readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>故障时间</th>
			<td colspan="3">
				<input class="Wdate" type="text" name="rq1"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			</td>
		</tr>
		<tr>
			<th>故障描述</th>
			<td colspan="3">
				<textarea  name="remark"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4"
				style="height:30px;line-height:30px;text-align: center;vertical-align: middle">
				<input type="submit" class="btn" value="提交" style="width: 80px" />
				<input type="button" class="btn" value="返回" style="width: 80px"
				onclick="javascript:history.go(-1);" />
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
  <script type="text/javascript">
  </script>
</html>