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
      <title>cost list</title>
      <link rel = 'stylesheet' href = 'css/cost_list.css'>
      <script defer src = 'js/cost.js'></script>
   </head>
   <body>
   <div class='background_div'></div>
   <div class='cost_body'>
   	<video src="video/computer_screen.mp4" autoplay loop muted plays-inline class="back-video">
	</video>
      <div id=table_wrapper>
         <h2>원가 관리</h2>   
        
        <form name = 'frmSearch' method = 'post'></form>
        
         <div id='cost_table1'>
            <span class='c1'>제품명</span>
            <span class='c2'> 단가</span>
            <span class='c3'>이익률</span>
         </div>
         
         <c:forEach var='v' items='${list }' varStatus='status'>
         <div id='cost_table2' onclick="view('${v.pr_name}')">
            <span class='c1'>${v.pr_name }</span>
            <span class='c2'>${v.robot_cost }</span>
            <span class='c3'>${v.profit_rate }</span>
         </div>
         </c:forEach>
         
         <div class='BG_Robot'>
     <img src="./images/bg_robot.png">
     </div> 
      </div>
   </div>
     
   </body>
</html>