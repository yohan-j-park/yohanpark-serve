<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cost_modify</title>
<link rel='stylesheet' href='css/cost_modify.css'>
<script defer src='js/cost.js'></script>
</head>
<body>
	<img src="images/cost_modify_background.png" class="back-video">
   </img>
   <div class='cost_modify_box'>
   <img src="images/wallpaper.jpg" class="back-video">
   </img>
      <div id=table_wrapper>
         <h2>원가정보 수정</h2>
         <div id = 'a1'>
             <span class='a1'></span>
         </div>
         
      <form id = "cost_modify" name='frm_cost_modify' method='post'>
         <div class = "user-box">
            <span class = 'cc1'>제품명</span>
            <span class = 'cc2'>
               <input type='text' size='18' id='pr_name' name='pr_name' value='${vo.pr_name }' readonly/>
            </span>
         </div>
         <div class = "user-box">
            <span class='cc1'>원가</span>
            <span class='cc2'>
               <input type='text' size='18' id='robot_cost' name='robot_cost' value='${vo.robot_cost }'/>
            </span>
         </div>
         <div class = "user-box">
            <span class = 'cc1'>이익률</span>
            <span class = 'cc2'>
               <input type='text' size='18' id='profit_rate' name='profit_rate' value='${vo.profit_rate }'/>
            </span>
         </div>
         <br/>
         <div class="user-box" id="btnBox">
               <a href="#" id='btnModify'>
                  수정
                  <span></span>
                    <span></span>
                  <span></span>
                  <span></span>
               </a>
                
               <a href="#" id = 'btnList'>
                  목록
                  <span></span>
                    <span></span>
                  <span></span>
                  <span></span>
               </a> 
            </div>
            </form>
   </div>
   </div>
</body>
</html>
