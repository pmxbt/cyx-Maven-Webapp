<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/noCompile/My97DatePicker/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/noCompile/css/form.css" />
<title>分页</title>
</head>
<body>
	<div style="width: 100%;height:40px;line-height:40px;float: right;background-image: url(<%=request.getContextPath() %>/noCompile/img/pageBackColor.png );" >
		<input type="hidden" id="pageNo" name="pageNo">
		共[${info.total}]条  第[${info.pageNum}/${info.pages}]页   
		<a onclick="tz(${info.navigateFirstPage})">首页</a>
		<c:choose>
			<c:when test="${info.hasPreviousPage}">
				<a onclick="tz(${info.prePage})">上一页</a>
			</c:when>
			<c:otherwise>
				上一页
			</c:otherwise>
		</c:choose>
		<c:forEach items="${info.navigatepageNums}" var="d">
			<c:choose>
				<c:when test="${info.pageNum==d}">
					<a onclick="tz(${d})" style="text-decoration: underline;">${d}</a>
				</c:when>
				<c:otherwise>
					<a onclick="tz(${d})">${d}</a>
				</c:otherwise>
			</c:choose>
			
		</c:forEach>
		<c:choose>
			<c:when test="${info.hasNextPage}">
				<a onclick="tz(${info.nextPage})">下一页</a>
			</c:when>
			<c:otherwise>
				下一页
			</c:otherwise>
		</c:choose>
		<a onclick="tz(${info.navigateLastPage})">尾页</a>
	</div>
</body>
  <script type="text/javascript">
  
  function tz(pageNo){
	  $('#pageNo').val(pageNo);
	  $("#form").submit(); 
  }
  </script>
</html>