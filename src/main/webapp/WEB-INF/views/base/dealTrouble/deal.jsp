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
<input type="hidden" id="ifdelete" name="ifdelete" value="${dt.ifdelete}">

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
		<c:choose>
			<c:when test="${dt.state ==0}">
				<tr>
					<th>委派维修人员</th>
					<td colspan="3">
						<select name="fixUserId">
							<option></option>
							<c:forEach var="d" items="${dealUser}">
								<option value="${d.id}">${d.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</c:when>
			<c:when test="${dt.state ==1}">
				<tr>
					<th>委派维修人员</th>
					<td>
						<input type="hidden" name="fixUserId" value="${dt.fixUserId}">
						<input type="text" value="${dt.fixUser.name}" readonly="readonly">
					</td>
					<th>维修日期</th>
					<td>
						<input class="Wdate" type="text" name="rq2" id="rq2" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
					</td>
				</tr>
				<tr>
					<th>故障原因</th>
					<td colspan="3">
						<textarea id="reason"></textarea>
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
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="tbody">
								<tr>
									<td>
										<select onchange="cc(1)" id="type1">
											<option></option>
											<c:forEach var = "d" items="${dtList}">
											 	<option value="${d.id}">${d.name}</option>
											</c:forEach>
										</select>		
									</td>
									<td>
										<select id="device1" name="deviceId" onchange="ccc(1)" >
										</select>
									</td>
									<td>
										<input type="text" id="count1" name="count" onkeyup="javascript:check(this,1);">
									</td>
									<td>
										<input type="text" id="totalCost1" name="totalCost" readonly="readonly">
									</td>
									<td>
										<input type="button" value="新增" style="width: 100px" onclick="addTr();">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				
			</c:when>
			<c:when test="${dt.state==2}">
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
			</c:when>
			<c:when test="${dt.state==3}">
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
						<textarea name="visitRemark"></textarea>
					</td>
				</tr>
			</c:when>
		</c:choose>
		
		<tr>
			<td colspan="4"style="height:30px;line-height:30px;text-align: center;vertical-align: middle">
				<c:choose>
					<c:when test="${dt.state==2}">
						<input type="button" class="btn" value="确认收款" style="width: 80px"  onclick="sub()"/>
					</c:when>
					<c:otherwise>
						<input type="button" class="btn" value="提交" style="width: 80px"  onclick="sub()"/>
					</c:otherwise>
				</c:choose>
				<input type="button" class="btn" value="返回" style="width: 80px"
				onclick="javascript:history.go(-1);" />
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
  <script type="text/javascript">
  function cc(d){
	  var name = "#device"+d;
	  var typename = "#type"+d;
	  $(name).empty();
	  $.post("/cyx/dealTrouble/getDeviceByType",{'type_id':$(typename).val()},
		  function(data){
			$(name).append('<option></option>');
		  	for(var i = 0; i < data.length; i++){
			  	$(name).append('<option value="'+data[i].id+'">'+data[i].name+'('+data[i].price+')</option>')
		  	}
	  	});
  }
  
  function ccc(id){
	  	var device = "#device"+id;
	  	var count = "#count"+id;
	  	var totalCost = "#totalCost"+id;
		if($(device).val() !=null&&$(device).val() !=""&&$(count).val() !=null&&$(count).val() !=""){
			 $.post("/cyx/dealTrouble/getTotalCost",{'device_id':$(device).val(),'count':$(count).val()},
					  function(data){
				 		$(totalCost).val(data);
				  	});
		}else{
			$(totalCost).val("");
		}
	  	
  }
  
	function check(obj,id){
		if('' !=obj.value.replace(/\d{1,}\.{0,1}\d{0,1}/,'')){
	          obj.value = obj.value.match(/\d{1,}\.{0,1}\d{0,1}/) == null ? '':obj.value.match(/\d{1,}\.{0,1}\d{0,1}/);      
	    }
		var device = "#device"+id;
		var totalCost = "#totalCost"+id; 
		if($(device).val() !=null&&$(device).val() !=""&&obj.value !=null&&obj.value !=""){
			 $.post("/cyx/dealTrouble/getTotalCost",{'device_id':$(device).val(),'count':obj.value},
					  function(data){
				 		$(totalCost).val(data);
				  	});
		}else{
			$(totalCost).val("");
		}
		
	}
	var n = 1;
	
	function addTr(){
		n++;
		$("#tbody").append('<tr class="ch">'
				+'<td><select onchange="cc('+n+')" id="type'+n+'"><option></option><c:forEach var = "d" items="${dtList}"><option value="${d.id}">${d.name}</option></c:forEach></select></td>'
				+'<td><select id="device'+n+'" name="deviceId" onchange="ccc('+n+')"></select></td>'
				+'<td><input type="text" id="count'+n+'" name="count" onkeyup="javascript:check(this,'+n+');"></td>'
				+'<td><input type="text" id="totalCost'+n+'" name="totalCost" readonly="readonly"></td>'
				+'<td><input type="button" value="移除 " style="width: 100px" onclick="DelTr(this)"/></td>'
				+'</tr>');
	}

	function DelTr(k){
		$(k).parents(".ch").remove();
	}

	
	
	function sub(){
		if($("#state").val() ==1){
			var ddcs = [];
	  		var deviceIds =[];var totalCosts =[];var counts =[];
	        $("select[name='deviceId']").each(function(){
	        	deviceIds.push($(this).val());
	        })
	        $("input[name='totalCost']").each(function(){
	        	totalCosts.push($(this).val());
	        })
	        $("input[name='count']").each(function(){
	        	counts.push($(this).val());
	        })
	  		for(var i=0;i < deviceIds.length;i++){
	  			var data = {dealId:$("#dealId").val(),deviceId:deviceIds[i],totalCost:totalCosts[i],count:counts[i]};
	  			ddcs.push(data);
	  		}
	        console.log(data);
	  		 $.ajax({
	  	        type:"POST",
	  	        url: "/cyx/dealTrouble/update2",
	  	        dataType:"json",
	  	        contentType:"application/json", // 指定这个协议很重要
	  	        data:JSON.stringify(ddcs), //只有这一个参数，json格式，后台解析为实体，后台可以直接用
	  	        success:function(data){
		  	      	$("#form").attr("action","/cyx/dealTrouble/update3?total="+data.data+"&rq="+$("#rq2").val()+"&id="+$("#dealId").val()+"&reason="+$("#reason").val());
		  			$("#form").submit(); 
	  	        },
	  			error:function(data){
	  				alert("网页提交错误");
	  			}
	  	    });
		}else{
			$("#form").submit(); 
		}
	}
	
  
  </script>
</html>