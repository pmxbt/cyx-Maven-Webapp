<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/noCompile/My97DatePicker/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/noCompile/css/add.css" />
<title>目录增加</title>
</head>
<body>
<form action="/cyx/catalog/save" method="post" id="form" >
<input type="hidden" name="type" value="${type1}">
<table>
	<tbody>
		<tr>
			<th>上级目录</th>
			<td>
				<c:choose>
					<c:when test="${type1 ==2}">
						<select name="parent_id">
							<option></option>
							<c:forEach items="${list1}" var = "d">
								<option value="${d.id}">${d.name}</option>
							</c:forEach>
						</select>
					</c:when>
					<c:when test="${type1==3 }">
						<input type="text" value="${parent1.name}" readonly="readonly"/>
						<input type="hidden" value="${parent1.id}"  name="parent_id"/>
					</c:when>
				</c:choose>
				
			</td>
			<th>名称</th>
			<td>
				<input type="text" name="name"/>
			</td>
		</tr>
		<tr>
			<th>排序</th>
			<td>
				<input type="text" name="sort"/>
			</td>
			<th>链接</th>
			<td>
				<input type="text" name="url"/>
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
  </script>
</html>