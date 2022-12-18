<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>sales_input_form</title>
		<link rel = 'stylesheet' href = './css/sales_input_form.css'>
		
		<!-- <script defer src='js/sales_input_form.js'></script> -->
		<script defer src='js/sales.js'></script>
	</head>
	<body>
	<div class='background_div'></div>
	<jsp:useBean id = "pageVo" class = "operation.Page"/>
	<jsp:setProperty property = "*" name = "pageVo"/>
	
	<jsp:useBean id = "vo_cost" class = "operation.CostVo"></jsp:useBean>
	<jsp:setProperty property = "*" name = "vo_cost"/>
	<div class='input-box'>
		<form id = "sales_input_form" name = 'frm_input' method = 'post'>
			<h2>판매정보 입력</h2>
			
		<div class='user-box'>
            <span class = 'cc1'>생산일</span>
            <span class = 'cc2'><input type = "date" id='date' name = 'date' value = '${vo.date }'/></span>
         </div>
		<div class='user-box'>
            <span class = 'cc1'>제품코드</span>
            <span class = 'cc2'>
            <input type = "text" size = '14' id='pr_code' name = 'pr_code' value='${vo.pr_code }'></span>
         </div>
		<div class='user-box'>
            <span class = 'cc5'>제품현황</span>
            <div class = "select">
            <select name='status'>           
            	<option value = '재고등록'>재고등록</option>
            	<option value = '판매완료'>판매완료</option>
           </select>
           </div>
         </div>
         <br/>
		<div class='user-box'>
            <span class = 'cc1'>갱신일자</span>
            <span class = 'cc2'>
            <input type = "date"  name = 'update_time' value = '${vo.update_time }'/>
            </span>
         </div>            
		<div class='user-box'>
            <span class = 'cc1'>생산단가</span>
            <span class = 'cc2'><input type = "text" size = '18' id='pr_cost' name = 'pr_cost' value = '${vo.pr_cost }'></span>
         </div>
         
		<div class='user-box'>
            <span class = 'cc1'>공급가액</span>
            <span class = 'cc2'><input type = "text" size = '18' id='real_price' name = 'real_price' value = '${vo.real_price }'></span>
         </div>
         <br/>   
		<div class='user-box'>
		             <a href="#" id = 'btnCancel' onclick='btnCancel()'>
		             	취소
			            <span></span>
		           		<span></span>
		            	<span></span>
		            	<span></span>
		            </a>
		            <a href="#" id='btnSave' onclick='btnSave()'>
		            	저장
			            <span></span>
		           		<span></span>
		            	<span></span>
		            	<span></span>
		            </a>
         </div>
         
         <input type = 'hidden' name = 'findPrcode' value = '${pageVo.findPrcode }'/>
         <input type = 'hidden' name = 'findDate' value = '${pageVo.findDate }'/>
         <input type = 'hidden' name = 'findStatus' value = '${pageVo.findStatus }'/>
         <input type = 'hidden' name = 'findUpdate_time' value = '${pageVo.findUpdate_time }'/>
         <input type = 'hidden' name = 'findPrname' value = '${pageVo.findPrname }'/>
         <input type = 'hidden' name = 'nowPage' value = '${pageVo.nowPage }'/>
         
         <%-- <input type = 'hidden' name = 'taken_time'/>
         <input type = 'hidden' name = 'status'/>
         <input type = 'hidden' name = 'update_time'/>
         <input type = 'hidden' name = 'pr_cost'/>
         <input type = 'hidden' name = 'real_price'/>
         <input type = 'hidden' name = 'vat'/>
         <input type = 'hidden' name = 'supply_price'/>
         
     
  	 	    
        <input type = 'hidden' name = 'x01' value = '${list_cost.get(0).pr_name }'/>
        <input type = 'hidden' name = 'x02' value = '${list_cost.get(0).robot_cost }'/>
        <input type = 'hidden' name = 'x03' value = '${list_cost.get(0).profit_rate }'/>
        
        <input type = 'hidden' name = 'x11' value = '${list_cost.get(1).pr_name }'/>
        <input type = 'hidden' name = 'x12' value = '${list_cost.get(1).robot_cost }'/>
        <input type = 'hidden' name = 'x13' value = '${list_cost.get(1).profit_rate }'/>
        
        <input type = 'hidden' name = 'x21' value = '${list_cost.get(2).pr_name }'/>
        <input type = 'hidden' name = 'x22' value = '${list_cost.get(2).robot_cost }'/>
        <input type = 'hidden' name = 'x23' value = '${list_cost.get(2).profit_rate }'/>
        
        <input type = 'hidden' name = 'x31' value = '${list_cost.get(3).pr_name }'/>
        <input type = 'hidden' name = 'x32' value = '${list_cost.get(3).robot_cost }'/>
        <input type = 'hidden' name = 'x33' value = '${list_cost.get(3).profit_rate }'/>
        
        <input type = 'hidden' name = 'x41' value = '${list_cost.get(4).pr_name }'/>
        <input type = 'hidden' name = 'x42' value = '${list_cost.get(4).robot_cost }'/>
        <input type = 'hidden' name = 'x43' value = '${list_cost.get(4).profit_rate }'/>
        
        <input type = 'hidden' name = 'x51' value = '${list_cost.get(5).pr_name }'/>
        <input type = 'hidden' name = 'x52' value = '${list_cost.get(5).robot_cost }'/>
        <input type = 'hidden' name = 'x53' value = '${list_cost.get(5).profit_rate }'/>
 --%>
      </form>
      </div>
      <script>
      
      </script>
	</body>
	
	
	
	
	
	
	
</html>
