<%@page import="operation.OperationVo"%>
<%@page import="operation.OperationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>operation_modify</title>
      <link rel = 'stylesheet' href = './css/operation_modify.css'>   
      <script defer src = 'js/operation.js'></script>
         
   </head>
   <body>
    <img src="images/brain_info.jpg">
	<div class='background-div'>
	</div>
		<div class="modify-box">
	      <h2>생산정보 수정</h2>
	      <form id = "operation_modify.jsp" name = 'frm_operation' method = 'post'>
	         <div class="user-box">
	            <span class = 'cc1'>제품코드</span>
	            <span class = 'cc2'>
	            <input type = "text" size = '14' id='pr_code' name = 'pr_code' value='${vo.pr_code }' readonly></span>
	         </div>
	         <div class="user-box">
	            <span class = 'cc1' id='code1'>제품명</span>
	            <span class = 'cc2'>
	            <input type = "text" size = '10' id='pr_name' name = 'pr_name' value = '${vo.pr_name }' readonly></span>
	         </div>
	         <div class="user-box">
	            <span class = 'cc6'>생산일</span>
	            <span class = 'cc2'><input type = "date" id='date' name = 'date' value = '${vo.date }' required/></span>
	         </div>
	         <div class="user-box">
	            <span class = 'cc3'>호기</span>
	            <div class="select">
		            <!-- <span class = 'cc4'> -->
						<select name='machine_no' name='format' id='format'>
				            <option value = '1' ${(vo.machine_no eq '1')? 'selected' : '' }>1</option>
				            <option value = '2' ${(vo.machine_no eq '2')? 'selected' : '' }>2</option>
			           </select>
		           <!-- </span> -->
	           </div>
	         </div><br/>
	         <div class="user-box">
	               <span class = 'cc1'>담당자</span>
	               <span class = 'cc2'>
	               <input type = "text" size = '14' name = 'manager' value = '${vo.manager }'></span>       
	         </div>
	         <div class="user-box">
		        <span class = 'cc5'>불량여부</span>
	         	<div class = "select">
		            <select name='pf'>
			            <option value = 'p' ${(vo.pf eq 'p')? 'selected' : '' }>p</option>
			            <option value = 'f' ${(vo.pf eq 'f')? 'selected' : '' }>f</option>
		            </select>
	         	</div>
	         </div>
	         <br/>   
	         <div class="user-box">
	            <a href="#" id='btnModify'>
	            	수정
		            <span></span>
	           		<span></span>
	            	<span></span>
	            	<span></span>
	            </a>
	             <a href="#" id = 'btnDelete'>
	             	삭제
		            <span></span>
	           		<span></span>
	            	<span></span>
	            	<span></span>
	            </a>
	            <a href="#" id = 'btnSelect'>
	            	목록
		            <span></span>
	           		<span></span>
	            	<span></span>
	            	<span></span>
	            </a> 
	         </div>
	         <input type = 'hidden' name = 'findPrcode' value = '${pageVo.findPrcode }'/>
	         <input type = 'hidden' name = 'findDate' value = '${pageVo.findDate }'/>
	         <input type = 'hidden' name = 'findMachine_no' value = '${pageVo.findMachine_no }'/>
	         <input type = 'hidden' name = 'findManager' value = '${pageVo.findManager }'/>
	         <input type = 'hidden' name = 'findPrname' value = '${pageVo.findPrname }'/>
	         <input type = 'hidden' name = 'nowPage' value = '${pageVo.nowPage }'/>
	         </form>   
    	</div> 
   </body>
</html>