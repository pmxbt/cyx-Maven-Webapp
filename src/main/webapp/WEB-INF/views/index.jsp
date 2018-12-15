<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>楚悠行</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=request.getContextPath() %>/noCompile/js/jquery-3.2.1.min.js"></script>
<style type="text/css">
a {
	cursor: pointer;
}

p {
	cursor: pointer;
}

.div_menu1 {
	float: left;
	width: 200px;
	text-align: center;
	height: 100%;
	cursor: pointer;
	line-height: 40px;
}

.div_menu1:hover {
	background-color: #3399CC;
}

.div_1 {
	height: 30px;
}

.menu1_name {
	height: 100%;
	padding-left: 20px;
	line-height: 30px;
	background-color:3FBFBFB;
	border-style: solid;
	border-width: 1px;
	border-color: #E5E5E5;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
	color: #3399CC;
}
.div_left_children{
	border-style: solid;
	border-width: 1px;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
	border-color: #E5E5E5;
	height: 90%;
	color: #3399CC;
	padding-left: 20px;
}
.a_menu{
	padding-left: 40px;
}
</style>
  </head>
  
  <body>
  	<div style="width: 100%;height: 968px;float: left;">
	  	<div id="div_top" style="width: 100%; height:14% ;float: left;">
	  		<div  style="height:70%;width: 100%;background-color: #3399CC">
	  			<span style="font-size: 50px;color: white;line-height: 100px;padding-left: 20px;text-shadow: 5px 2px 6px #000;">楚悠行</span>
	  		</div>
	  		<div style="height:30%;width: 100%;float: left;background-color: #99CCCC">
		  		<div style="float: left;text-align: center;width: 200px;font-size: 14px;line-height: 40px;color: white;">${date1}</div>
		  		<c:forEach var="menu1" items="${menu}" >
		  			<div  onclick="left_menu(${menu1.id})" class="div_menu1" 
		  					${menu1.id==1?'style="background-color: #3399CC;"':''}>
		  				<a style="color: white;">${menu1.name}</a>
		  			</div>
		  		</c:forEach>
	  		</div>
	  	</div>
	  	<div style="width: 15%;height: 85%;float: left;">
		  	<div id="div_left"  style="width: 95%;height: 95%;margin:0 auto">
		  		<c:forEach items="${menu}" var = "menu1">
			  		<div class="div_1" id='id1${menu1.id}' ${menu1.id!=1?'style="display: none"':''}>
			  			<p class="menu1_name">
			  				${menu1.name}
			  			</p>
			  		</div>
		  			<div class="div_left_children" id='id${menu1.id}' ${menu1.id!=1?'style="display: none"':''}>
			  		<c:forEach items="${menu1.list}" var = "menu2">
			  				<p  onclick = "open_url('${menu2.url}')">${menu2.name}</p>
			  				<div style="display: none">
								<c:forEach items = "${menu2.list}" var = "menu3">
									<a class="a_meau3" style="padding-left: 20px;" onclick = "open_url('${menu3.url}')">${menu3.name}</a><br>
								</c:forEach>
			  				</div>
			  		</c:forEach>
			  		</div>
		  		</c:forEach>
			</div>
		</div>
	  	<div id="div_right" style="width: 85%;height: 85%;float: left;">
		  <iframe id="div_right_iframe" src="" style="width: 100%;height: 100%;border: 0px"></iframe>
	  	</div>
  	
  </div>
</body>
<script type="text/javascript">
function left_menu(id){
	var ids = "#id"+id;
	$("#div_left div.div_left_children").css("display","none");
	$(ids).show();
	var ids1 ="#id1"+id;
	$("#div_left div.div_1").css("display","none");
	$(ids1).show();
}

$(".div_menu1").click(function(){
	$(this).css("background-color","#338BCC");
	$(this).siblings("div").css("background-color","");
});

$("#div_left p").click(function(){
	 $(this).next("div").css("display","").siblings("div").css("display","none");
});

	/*function left_menu(id){
		$("#div_left").empty();
		$.post("/cyx/catalog/getSubMenu",{'id':id},
			function(data){
			for(var i =0;i<data.length;i++){
				var id1 = "secondTier"+data[i].id;
				$("#div_left").append('<ul>'
						+'<li style="list-style: none;height:20px;cursor: pointer;" id='+id1+' >'
						+'<a onclick="open_menu(\''+id1+'\',\''+data[i].id+'\'),open_url(\''+data[i].url+'\')">'
						+data[i].name
						+'</a>'
						+'</li>'
						+'</ul>'
						);
			};
		});
	}  
	
	function open_menu(li_id,id){
		var li_id1 = "#"+li_id;
		$("#div_left").children().children().children().children().remove();
		$.post("/cyx/catalog/getSubMenu",{'id':id},
			function(data){
				for(var i=0;i<data.length;i++){
					$(li_id1).append('<ul>'
							+'<li style="list-style:none;height:30px;cursor: pointer;" >'
							+'<a onclick = "open_url(\''+data[i].url+'\')">'
							+data[i].name
							+'</li>'
							+'</ul>'
					);
				}			
			});
	}
	
	*/
	function open_url(url){
		$("#div_right_iframe").attr("src",url);
	}
</script>
  
</html>
