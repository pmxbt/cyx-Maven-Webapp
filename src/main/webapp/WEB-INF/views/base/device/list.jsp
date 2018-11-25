<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>目录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/noCompile/My97DatePicker/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/noCompile/css/form.css" />
<style type="text/css">
.list table{
	table-layout: fixed;
}	
.list table td{
	text-overflow:ellipsis;
	overflow:hidden;
}
.list .xxx{
	   text-overflow:ellipsis;overflow:hidden;white-space: nowrap;
}
	
</style>
</head>
<body>
<form action="#" method="post" id="form" >
<table>
	<tbody class="mb">
		<tr>
			<td>
				<div id="find">
					<lable>类别</lable>
					<select name="parent_id">
						<option></option>
						<c:forEach items="${typeList}" var="d">
							<option value="${d.id}" ${d.id==type_id?'selected="selected"':''} >${d.name}</option>
						</c:forEach>
					</select>
					 <button   type="submit" id="getbtn">查 询</button>
					 <button   type="button" id="add">新增</button>
				</div>
				<div class="list">
				<table cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
					<thead>
						<tr>
				         <td style="width: 3%" >序号</td>
				         <td style="width: 8%" >创建人</td>
				         <td style="width: 8%" >名称</td>
				         <td style="width: 10%">类型</td>
				         <td style="width: 10%">单价</td>
				         <td style="width: 5%">排序</td>
				         <td style="width: 20%">备注</td>
				         <td style="width: 12%">操作</td> 
				        </tr>
					</thead>
					<tbody>
						<c:forEach items="${info.list}" var="d" varStatus="g">
						<tr>
							<td>${g.count+(info.pageNum-1)*info.pageSize}</td>
							<td>${d.createUser.name}</td>
							<td>${d.name}</td>
							<td>${d.deviceType.name}</td>
							<td>${d.price}</td>
							<td>${d.sort}</td>
							<td class="xxx">${d.remark}</td>
							<td>
								<a href="/cyx/device/check?id=${d.id}" >
									<img src="<%=request.getContextPath() %>/noCompile/img/check.png"  >
								</a>
								<a href="/cyx/device/delete?id=${d.id}" title="删除" 
									onclick="javascript:if(confirm('确定删除？')){return true;}return false;">
	       			 				<img src="<%=request.getContextPath() %>/noCompile/img/delete.png"  >
	       			 			</a>
								<a href="/cyx/device/edit?id=${d.id}" >
									<img src="<%=request.getContextPath() %>/noCompile/img/edit.png"  >
								</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;">
				<jsp:include page="../../other/page.jsp"></jsp:include>
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
  <script type="text/javascript">
  	$("#add").click(function(){
 		$("#form").attr("action","/cyx/device/add");
		$("#form").submit(); 
  	});
  	
  </script>
</html>