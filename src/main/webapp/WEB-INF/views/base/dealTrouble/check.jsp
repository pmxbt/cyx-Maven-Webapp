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
<form action="/cyx/dealTrouble/update" method="post" id="form" >
<input type="hidden" id="dealId" name="id" value="${dt.id}">
<input type="hidden" name="createTime" value="${dt.createTime}">
<input type="hidden" id="state" name="state" value="${dt.state}">

<table>
	<tbody>
		<tr>
			<th>部门名称</th>
			<td>
				<input type="hidden" name="deptId" value="${dt.dept.id}" >
				<input type="text" value="${dt.dept.name}" readonly="readonly"/>
			</td>
			<th>创建人</th>
			<td>
				<input type="hidden" name="createUserId" value="${dt.createUserId}">
				<input type="text" value="${dt.createUser.name}" readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>故障时间</th>
			<td colspan="3">
				<input  type="text" name="rq1"  value="${dt.rq1}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<th>故障描述</th>
			<td colspan="3">
				<textarea  name="remark" readonly="readonly">${dt.remark}</textarea>
			</td>
		</tr>
		<tr>
			<th>委派维修人员</th>
			<td>
				<input type="hidden" name="fixUserId" value="${dt.fixUserId}">
				<input type="text" value="${dt.fixUser.name}" readonly="readonly">
			</td>
			<th>维修日期</th>
			<td>
				<input type="text" name="rq2" value="${dt.rq2}" readonly="readonly">
			</td>
		</tr>
		<tr>
			<th>故障原因</th>
			<td colspan="3">
				<textarea id="reason" name="reason" readonly="readonly">${dt.reason}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<table>
					<thead>
						<tr>
							<th>耗材类型</th>
							<th>耗材(单价)</th>
							<th>数量</th>
							<th>总计</th>
						</tr>
					</thead>
					<tbody id="tbody">
						<c:forEach var="d" items="${dt.deviceCost}">
							<tr>
								<td><input type="text" value="${d.device.deviceType.name}" readonly="readonly"></td>
								<td><input type="text" value="${d.device.name}" readonly="readonly"></td>
								<td><input type="text" value="${d.count}" readonly="readonly"></td>
								<td><input type="text" value="${d.totalCost}" readonly="readonly"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<th>共计</th>
			<td colspan="3"><input type="text" value="${dt.totalCost}" name="totalCost" readonly="readonly"></td>
		</tr>
		<tr>
			<th>回访</th>
			<td colspan="3">
				<textarea name="visitRemark" readonly="readonly">${dt.visitRemark}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4"style="height:30px;line-height:30px;text-align: center;vertical-align: middle">
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