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
<form action="/cyx/device/update" method="post" id="form" >
<input type="hidden" name="id" value="${device.id}">
<input type="hidden" name="ifdelete" value="${device.ifdelete}">

<table>
	<tbody>
		<tr>
			<th>创建人</th>
			<td>
				<input type="text" value="${device.createUser.name}" readonly="readonly">
				<input type="hidden" name="userId" value="${device.createUser.id}">
			</td>
			<th>类型</th>
			<td>
				<input type="text" value="${device.deviceType.name}" readonly="readonly">
				<input type="hidden" name="typeId" value="${device.deviceType.id}">
			</td>
		</tr>
		<tr>
			<th>名称</th>
			<td>
				<input type="text" name="name" value="${device.name}"/>
			</td>
			<th>单价	</th>
			<td>
				<input type="text" name="price" value="${device.price}" onkeyup="javascript:check(this);"/>
			</td>
		</tr>
		<tr>
			<th>排序</th>
			<td>
				<input type="text" name="sort" value="${device.sort}"/>
			</td>
			<td colspan="2"></td>
		</tr>
		<tr>
			<th>备注</th>
			<td colspan="3">
				<textarea name="remark">${device.remark}</textarea>
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