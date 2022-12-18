<%@page import="operation.OperationVo"%>
<%@page import="java.util.List"%>
<%@page import="operation.OperationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>sales_list</title>
		<link rel = 'stylesheet' href='css/sales_list.css'>
		<script defer src = 'js/sales.js'></script>
	</head>
	<div class='background_div'></div>
	<div class='list_body'>
		<video src="video/computer_screen.mp4" autoplay loop muted plays-inline class="back-video">
		</video>
				<div id=table_wrapper>
					<h2 class="op_listTitle">판매정보 조회</h2>		
					<form id = "table" name = 'frm_search' method = 'post'>
						<div id = salesSearch>
							<span>생산일자</span>
		            		<input type = "date" name='findDate' value ="${pageVo.findDate }" min = "2023-04-01" style='cursor:pointer'/>
							<span>판매일자</span>
		            		<input type = "date" name='findUpdate_time' value ="${pageVo.findUpdate_time }" min = "2023-04-01" style='cursor:pointer'/>
		            		<span>제품이름</span>
		            		<select name='findPrname' style='cursor:pointer'>
		             			<option value=""></option>
		               			<option value="엑스봇로봇두뇌" ${(pageVo.findPrname eq "엑스봇로봇두뇌")? 'selected' : '' }>엑스봇로봇두뇌</option>
		               			<option value="엑스봇로봇신경" ${(pageVo.findPrname eq "엑스봇로봇신경")? 'selected' : '' }>엑스봇로봇신경</option>
		               			<option value="엑스봇로봇머리" ${(pageVo.findPrname eq "엑스봇로봇머리")? 'selected' : '' }>엑스봇로봇머리</option>
		               			<option value="엑스봇로봇몸통" ${(pageVo.findPrname eq "엑스봇로봇몸통")? 'selected' : '' }>엑스봇로봇몸통</option>
		               			<option value="엑스봇로봇팔" ${(pageVo.findPrname eq "엑스봇로봇팔")? 'selected' : '' }>엑스봇로봇팔</option>
		               			<option value="엑스봇로봇다리" ${(pageVo.findPrname eq "엑스봇로봇다리")? 'selected' : '' }>엑스봇로봇다리</option>       
		            		</select>
		            		<span>제품현황</span>
		            		<select name='findStatus' style='cursor:pointer'>
		              			 <option value =""></option>
            					 <option value ='재고등록' ${(pageVo.findStatus eq '재고등록')? 'selected' : '' }>재고등록</option>
		              			 <option value ='판매완료' ${(pageVo.findStatus eq '판매완료')? 'selected' : '' }>판매완료</option>
		            		</select>
		           			<span class='marginCss'>제품코드</span>
		            		<input type="text" name="findPrcode" size=15 value="${pageVo.findPrcode }" placeholder="제품 코드 입력"/>
							<a href='#' id='btnSearch' class ='btnA' onclick='btnSearch()'>
	                           	<span></span>
	                          	<span></span>
	                          	<span></span>
	                          	<span></span>
	                           	조회
                       		</a>
		            		<br/><br/>
		            		
						   <input type = 'hidden' name = 'nowPage' value = "${pageVo.nowPage }"/>
							<a href='#' id='btnStat'  class ='btnA' onclick='btnStat()'>
	                          <span></span>
	                          <span></span>
	                          <span></span>
	                          <span></span>
	                           통계
                       		</a>
							<!-- <input type = 'text' name = 'id'/> -->
						</div>
			            
					</form>
					<div id = "r1">
						<span class = "c1">No</span>
						<span class = "c2">생산일자</span>
						<span class = "c3">제품코드</span>
						<span class = "c4">판매현황</span>
						<span class = "c5">갱신일자</span>
						<span class = "c6">생산단가</span>
						<span class = "c7">공급가액</span>
						<span class = "c8">부가세</span>
						<span class = "c9">매출가액</span>
					</div>
				
	
			<c:forEach var='v' items='${list }' varStatus='status'>
	         <div class='item' onclick = "view('${v.pr_code}')">
	            <span class='c1'>${status.count + pageVo.startNo }</span>
	            <span class='c2'>${v.date}</span>
	            <span class='c3'>${v.pr_code }</span>
	        	<span class='c4'>${v.status}</span>
	        	<span class='c5'>${v.update_time}</span>
	            <span class='c6'>${v.pr_cost}</span>
	            <span class='c7'>${v.real_price}</span>
	            <span class='c8'>${v.vat}</span>
	            <span class='c9'>${v.supply_price}</span>
	           </div>
			</c:forEach>
	
			
	
			<div id = "bottom_line">
			</div>
			<div class="pageNumber">
				<!-- page 이동 버튼 -->
				<c:if test="${pageVo.startPage>1 }">
					<button style="cursor: pointer;" class='btn1' onclick='movePage(1)'><<</button>
					<button style="cursor: pointer;" class='btn'
						onclick='movePage(${pageVo.startPage-1})'><</button>
				</c:if>
	
	
				<c:forEach var='i' begin='${pageVo.startPage }'
					end='${pageVo.endPage }'>
					<button style="cursor: pointer;" class='btn'
						onclick='movePage(${i})'>${i }</button>
				</c:forEach>
	
				<c:if test="${pageVo.totPage gt pageVo.endPage }">
					<button style="cursor: pointer;" class='btn'
						onclick='movePage(${pageVo.endPage+1})'>></button>
					<button style="cursor: pointer;" class='btn'
						onclick='movePage(${pageVo.totPage})'>>></button>
				</c:if>
			</div>							
		</div>
	</div>
</html>