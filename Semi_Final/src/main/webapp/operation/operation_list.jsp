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
		<title>operation list</title>
		<link rel = 'stylesheet' href = 'css/operation_list.css'>
		<script defer src = 'js/operation.js'></script>
	</head>
	<div class='background_div'></div>
	<div class='list_body'>
		<video src="video/computer_screen.mp4" autoplay loop muted plays-inline class="back-video">
		</video>
				<div id=table_wrapper>
					<h2 class="op_listTitle">생산정보 조회</h2>		
					<form id = "table" name = 'frm_search' method = 'post'>
						<div id = operationSearch>
							<span class='marginCss'>기준일</span>
		            		<input type = "date" name='findDate' value ="${pageVo.findDate }" min = "2023-04-01" style='cursor:pointer'/>
		            		<span class='marginCss'>호기</span>
		            		<select name='findMachine_no' style='cursor:pointer'>
		              			 <option value =""></option>
            					 <option value ='1' ${(pageVo.findMachine_no eq '1')? 'selected' : '' }>1</option>
		              			 <option value ='2' ${(pageVo.findMachine_no eq '2')? 'selected' : '' }>2</option>

		            		</select>
		           			<span class='marginCss'>담당자</span>
		  		            <select name='findManager' style='cursor:pointer'>
					             <option value=""></option>
					             <option value="강씨" ${(pageVo.findManager eq "강씨")? 'selected' : '' }>강씨</option>
					             <option value="이씨" ${(pageVo.findManager eq "이씨")? 'selected' : '' }>이씨</option>
					             <option value="박씨" ${(pageVo.findManager eq "박씨")? 'selected' : '' }>박씨</option>
		            		</select>
		            		<span class='marginCss'>제품코드</span>
		            		<input type="text" name="findPrcode" size=14 value="${pageVo.findPrcode }" placeholder="제품 코드 입력"/>
		            		<span class='marginCss'>제품이름</span>
		            		<select name='findPrname' style='cursor:pointer'>
		             			<option value=""></option>
		               			<option value="엑스봇로봇두뇌" ${(pageVo.findPrname eq "엑스봇로봇두뇌")? 'selected' : '' }>엑스봇로봇두뇌</option>
		               			<option value="엑스봇로봇신경" ${(pageVo.findPrname eq "엑스봇로봇신경")? 'selected' : '' }>엑스봇로봇신경</option>
		               			<option value="엑스봇로봇머리" ${(pageVo.findPrname eq "엑스봇로봇머리")? 'selected' : '' }>엑스봇로봇머리</option>
		               			<option value="엑스봇로봇몸통" ${(pageVo.findPrname eq "엑스봇로봇몸통")? 'selected' : '' }>엑스봇로봇몸통</option>
		               			<option value="엑스봇로봇팔" ${(pageVo.findPrname eq "엑스봇로봇팔")? 'selected' : '' } >엑스봇로봇팔</option>
		               			<option value="엑스봇로봇다리" ${(pageVo.findPrname eq "엑스봇로봇다리")? 'selected' : '' }>엑스봇로봇다리</option>               
		            		</select>
		           		   <a href='javascript:void(0)' id='btnSearch' class ='btnA' onclick='btnSearch()'>
                           <span></span>
                          <span></span>
                          <span></span>
                          <span></span>
                           조회
                        </a>
                        <br/><br/>
                        <a href='javascript:void(0)' id='btnInsert' class ='btnA' onclick='btnInsert()'>
                           <span></span>
                          <span></span>
                          <span></span>
                          <span></span>
                           입력
                        </a>
                     <input type = 'hidden' name = 'nowPage' value = "${pageVo.nowPage }"/>
                        <a href='javascript:void(0)' id='btnStat' class ='btnA' onclick='btnStat()'>
                           <span></span>
                          <span></span>
                          <span></span>
                          <span></span>
                           통계
                        </a>
						</div>
			            
					</form>
					<div id = "r1">
						<span class = "c1">No</span>
						<span class = "c2">생산일자</span>
						<span class = "c3">호기</span>
						<span class = "c4">매니저</span>
						<span class = "c5">제품코드</span>
						<span class = "c6">제품이름</span>
						<span class = "c7">생산시간</span>
						<span class = "c8">불량여부</span>
						<span class = "c9">재고상태</span>
					</div>
				
	
			<c:forEach var='v' items='${list }' varStatus='status'>
	         <div class='item' onclick = "view('${v.pr_code}')">
	            <span class='c1'>${status.count + pageVo.startNo }</span>
	            <span class='c2'>${v.date}</span>
	            <span class='c3'>${v.machine_no }</span>
	            <span class='c4'>${v.manager }</span>
	            <span class='c5'>${v.pr_code }</span>
	            <span class='c6'>${v.pr_name }</span>
	            <span class='c7'>${v.taken_time }</span>
	            <span class='c8'>${v.pf }</span>
	            <span class='c9'>${v.status }</span>
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