<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
<title>登录</title>
<style type="text/css">
#body {
	background-repeat: no-repeat;
	background-image: url(<%= request.getContextPath ()%>/noCompile/img/bjtp.jpg);
}

#div {
	background-color:white;
	position: absolute;
	height:300px;
	width:400px;
	left: 70%;
	top: 30%;
	opacity: 0.8;
	border-radius:10px;
	text-align: center;
	font-family: YouYuan;
}
label {
	font-size: 20px;
}

input {
	border: 1px solid #ccc;
	padding: 7px 0px;
	border-radius: 3px;
	padding-left: 5px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}
 
input:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6)
}

.login-button { /* 按钮美化 */
	width: 270px; /* 宽度 */
	height: 40px; /* 高度 */
	border-width: 0px; /* 边框宽度 */
	border-radius: 3px; /* 边框半径 */
	background: #1E90FF; /* 背景颜色 */
	cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
	outline: none; /* 不显示轮廓线 */
	font-family: Microsoft YaHei; /* 设置字体 */
	color: white; /* 字体颜色 */
	font-size: 17px; /* 字体大小 */
}
.login-button:hover { /* 鼠标移入按钮范围时改变颜色 */
	background: #5599FF;
}
</style>
</head>
<body   id="body">
<form action="/cyx/login" method="post" id="form">
		<div id="div">
		<br><br><br>
			<label style="font-size: 20px">账&nbsp;&nbsp;户</label>
			<input id="zh" type="text" name="userName"/><br/>
			<br><br>
			<label>密&nbsp;&nbsp;码</label>
			<input id="mm" type="password" name="password"/><br/>
			<br>
			<button type="button" onclick="on()" class="login-button">登录</button>
		</div>
</form>
</body>
 <script type="text/javascript">
 	function on(){
 		if($("#zh").val()==''||$("#zh").val()==null){
 			alert("账户不能为空");
 			return false;
 		}else if($("#mm").val()==''||$("#mm").val()==null){
 			alert("密码不能为空");
 			return false;
 		}else{
 			$.post("/cyx/checkUser",{'userName':$("#zh").val(),'password':$("#mm").val()},
 					function(msg){
 						if(msg =="yes"){
 							$("#form").submit();
 						}else{
 							alert("用户名或密码错误！");	
 						}
 				});
 		}
 	}
 
 
 </script>
</html>