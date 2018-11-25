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
				</div>
				<div class="list">
				<table cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
					<thead>
						<tr>
				         <td style="width: 3%" >序号</td>
				         <td style="width: 8%" >创建人</td>
				         <td style="width: 8%" >部门</td>
				         <td style="width: 8%" >报修日期</td>
				         <td style="width: 10%">维修人</td>
				         <td style="width: 10%">费用</td>
				         <td style="width: 8%" >维修日期</td>
				         <td style="width: 5%">状态</td>
				         <td style="width: 12%">操作</td> 
				        </tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="d" varStatus="g">
						<tr>
							<td>${g.count+(info.pageNum-1)*info.pageSize}</td>
							<td>${d.createUser.name}</td>
							<td>${d.dept.name}</td>
							<td>${d.rq1}</td>
							<td>${d.fixUser.name}</td>
							<td>${d.totalCost}</td>
							<td>${d.rq2}</td>
							<td>
								<c:forEach var="s" items="${stateMap}">
									<c:if test="${s.key==d.state}">${s.value}</c:if>
								</c:forEach>
							</td>
							<td>
								<a href="/cyx/dealTrouble/check?id=${d.id}" >
									<img src="<%=request.getContextPath() %>/noCompile/img/check.png"  >
								</a>
								<c:if test="${user.dept.type==1}">
									<a href="/cyx/dealTrouble/delete?id=${d.id}" title="删除" 
										onclick="javascript:if(confirm('确定删除？')){return true;}return false;">
		       			 				<img src="<%=request.getContextPath() %>/noCompile/img/delete.png"  >
		       			 			</a>
	       			 			</c:if>
								<%-- <a href="/cyx/device/edit?id=${d.id}" title="修改" >
									<img src="<%=request.getContextPath() %>/noCompile/img/edit.png"  >
								</a> --%>
								<a href="/cyx/dealTrouble/deal?id=${d.id}" title="处理" >
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
	</tbody>
</table>
</form>
</body>
  <script type="text/javascript">
  	$("#add").click(function(){
 		$("#form").attr("action","/cyx/dealTrouble/add");
		$("#form").submit(); 
  	});
  	
  </script>
</html>