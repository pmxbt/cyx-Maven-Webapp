<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/noCompile/My97DatePicker/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/noCompile/css/form.css" />
<title>目录</title>
</head>
<body>
<form action="#" method="post" id="form" >
<table>
	<tbody class="mb">
		<tr>
			<td>
				<div id="find">
					<lable>一级目录</lable>
					<select name="parent_id">
						<option></option>
						<c:forEach items="${list1}" var="d">
							<option value="${d.id}" ${d.id==parent_id?'selected="selected"':''} >${d.name}</option>
						</c:forEach>
					</select>
					 <button   type="submit" id="getbtn">查 询</button>
					 <button   type="button" id="add">新增</button>
				</div>
				<div class="list">
				<table cellspacing="0" cellpadding="0" style="border-collapse: collapse;">
					<thead>
						<tr >
				         <td style="width: 3%" >序号</td>
				         <td style="width: 4%" >二级目录</td>
				         <td style="width: 10%">排序</td>
				         <td style="width: 12%">添加三级菜单</td> 
				         <td style="width: 12%">三级菜单</td> 
				         <td style="width: 12%">链接地址</td> 
				         <td style="width: 12%">操作</td> 
				        </tr>
					</thead>
					<% int i =1; %>
					<tbody>
						<c:forEach items="${list2}" var="d">
						<tr>
							<td><%=i %></td>
							<td>${d.name}</td>
							<td>${d.sort}</td>
							<td><a href="/cyx/catalog/add?type=${d.type}&parent_id=${d.id}">添加三级菜单</a></td>
							<td colspan="3">
								<table  cellspacing="0" cellpadding="0" style="border-collapse: collapse;border-width:0px; border-style:hidden;">
									<tbody>
										<c:forEach items="${d.list}" var = "s">
										<tr>
											<td style="width: 33%">${s.name}</td>
											<td style="width: 33%">${s.url}</td>
											<td style="width: 33%">
												<a href="/cyx/catalog/delete?id=${s.id}" title="删除" 
													onclick="javascript:if(confirm('确定删除？')){return true;}return false;">
					       			 				<img src="<%=request.getContextPath() %>/noCompile/img/delete.png"  >
					       			 			</a>
												<a href="/cyx/catalog/edit?id=${s.id}" >
													<img src="<%=request.getContextPath() %>/noCompile/img/edit.png"  >
												</a>
											</td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</td>
							<% i++; %>
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
 		$("#form").attr("action","/cyx/catalog/add?type=1");
		$("#form").submit(); 
  	});
  	
  </script>
</html>