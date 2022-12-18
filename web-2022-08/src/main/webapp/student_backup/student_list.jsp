<%@page import="student.StudentVo"%>
<%@page import="java.util.List"%>
<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 조회</title>
<link rel='stylesheet' href='./css/student.css'>
<script defer src='js/student.js'></script>
</head>
<body>

<div id='std_list'>
    <h2>학생정보 조회</h2>
    
    <form name='frm_search' method='post'>
        <input type='button' value='입력' name='btnInsert'/>
        <input type='search' name='findStr' value="${pageVo.findStr }"/>
        <input type='button' value='조회' name='btnSelect'/>
        <input type='text' name='nowPage' value="${pageVo.nowPage }"/>
    </form>
    
    
    <ul>
        <li class='title'> <!-- 타이틀 -->
            <span class='no'>No</span>
            <span class='id'>아이디</span>
            <span class='name'>성명</span>
            <span class='gender'>성별</span>
            <span class='phone'>연락처</span>
            <span class='address'>주소</span>
            <span class='email'>이메일</span>
            <span class='zipcode'>우편번호</span>
        </li>
        
        
        <c:forEach var='v' items="${list }" varStatus='status'>
	        <li class='item' onclick="view('${v.id}')">
	            <span class='no'>${status.count }</span>
	            <span class='id'>${v.id }</span>
	            <span class='name'>${v.name }</span>
	            <span class='gender'>${v.gender }</span>
	            <span class='phone'>${v.phone }</span>
	            <span class='address'>${v.address }</span>
	            <span class='email'>${v.email }</span>
	            <span class='zipcode'>${v.zipcode }</span>
	        </li>
        </c:forEach>
        
        <li class='btn_page'> <!-- page이동 버튼 -->
      		<c:if test="${pageVo.startPage>1 }">
	            <input type='button' value='처음' onclick='movePage(1)'/>
	            <input type='button' value='이전' onclick='movePage(${pageVo.startPage-1})'/>
      		</c:if>
	   		
   			<c:forEach var='i' begin='${pageVo.startPage }' end='${pageVo.endPage }'>
	            <input type='button' value='${i }' onclick='movePage(${i})'/>
   			</c:forEach>
            
            <c:if test="${pageVo.totPage gt pageVo.endPage }">
	            <input type='button' value='다음' onclick='movePage(${pageVo.endPage+1})'/>
	            <input type='button' value='맨끝' onclick='movePage(${pageVo.endPage})'/>
            </c:if>
        </li>	        
    </ul>
    
</div>
</body>
</html>








