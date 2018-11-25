<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/noCompile/My97DatePicker/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/noCompile/css/form.css" />
<title>部门</title>
</head>
<body>
<form action="#" method="post" id="form" >
<table>
	<tbody class="mb">
		<tr>
			<td>
				<div id="find">
					<lable>部门</lable>
					<select name="dept_id">
						<option></option>
						<c:forEach items="${deptList}" var="d">
							<option value="${d.id}" ${d.id==dept_id?'selected="selected"':''} >${d.name}</option>
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
				         <td style="width: 4%" >名称</td>
				         <td style="width: 4%" >部门</td>
				         <td style="width: 10%">排序</td>
				         <td style="width: 12%">操作</td> 
				        </tr>
					</thead>
					<tbody>
						<c:forEach items="${info.list}" var="d" varStatus="g">
						<tr>
							<td>${g.count+(info.pageNum-1)*info.pageSize}</td>
							<td>${d.name}</td>
							<td>${d.dept.name}</td>
							<td>${d.sort}</td>
							<td>
								<a href="/cyx/user/delete?id=${d.id}" title="删除" 
									onclick="javascript:if(confirm('确定删除？')){return true;}return false;">
	       			 				<img src="<%=request.getContextPath() %>/noCompile/img/delete.png"  >
	       			 			</a>
								<a href="/cyx/user/edit?id=${d.id}" >
									<img src="<%=request.getContextPath() %>/noCompile/img/edit.png"  >
								</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
					<tr>
						<td colspan="5" style="text-align: right;">
							<jsp:include page="../../other/page.jsp"></jsp:include>
						</td>
					</tr>
					</tfoot>
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
 		$("#form").attr("action","/cyx/user/add");
		$("#form").submit(); 
  	});
  	
  </script>
</html>