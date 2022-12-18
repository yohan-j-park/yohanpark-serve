<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>sales_modify</title>
      <link rel = 'stylesheet' href = './css/sales_modify.css'>   
      <script defer src = 'js/sales_modify.js'></script>
      <script defer src = 'js/sales.js'></script>    
   </head>
   <body>
   <img src="images/brain_info.jpg">
   <div class='background-div'>
   </div>
   <div class="modify-box">
        <h2>판매정보 수정</h2>
      <form id = "sales_modify" name = 'frm_sales' method = 'post'>
         <div class="user-box">
            <span class = 'cc6'>생산일</span>
            <span class = 'cc2'><input type = "date" id='date' name = 'date' value = '${vo.date }' onchange='auto_input()'/></span>
         </div>
         <div class="user-box">
            <span class = 'cc1'>제품코드</span>
            <span class = 'cc2'>
            <input type = "text" size = '14' id='pr_code' name = 'pr_code' value='${vo.pr_code }' readonly></span>
         </div>
         <div class="user-box">
            <span class = 'cc3'>제품현황</span>
            <div class="select">
               <select name='status' onchange='auto_input()'>          
                  <option value = '재고등록' ${(vo.status eq '재고등록')? 'selected' : '' }>재고등록</option>
                  <option value = '판매완료' ${(vo.status eq '판매완료')? 'selected' : '' }>판매완료</option>
                 </select>
           </div>
         </div>
         <br/>
         <div class="user-box">
            <span class = 'cc1'>갱신일자</span>
            <span class = 'cc2'>
            <input type = "date"  id='date' name = 'update_time' value = '${vo.update_time }' onchange='auto_input()'/>
            </span>
         </div>            
          <div class="user-box">
            <span class = 'cc1'>생산단가</span>
            <span class = 'cc2'><input type = "text" size = '18' id='pr_cost' name = 'pr_cost' value = '${vo.pr_cost }'></span>
         </div>
         <div class="user-box">
            <span class = 'cc1'>공급가액</span>
            <span class = 'cc2'><input type = "text" size = '18' id='real_price' name = 'real_price' value = '${vo.real_price }'></span>
         </div>
         <div class="user-box">
            <span class = 'cc1'>부가세</span>
            <span class = 'cc2'><input type = "text" size = '18' id='vat' name = 'vat' value = '${vo.vat }'></span>
         </div>
         <div class="user-box">
            <span class = 'cc1'>매출가액</span>
            <span class = 'cc2'><input type = "text" size = '18' id='supply_price' name = 'supply_price' value = '${vo.supply_price }'></span>
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
         <input type = 'hidden' name = 'findUpdate_time' value = '${pageVo.findUpdate_time }'/>
         <input type = 'hidden' name = 'findPrname' value = '${pageVo.findPrname }'/>
         <input type = 'hidden' name = 'findStatus' value = '${pageVo.findStatus }'/>
         <input type = 'hidden' name = 'nowPage' value = '${pageVo.nowPage }'/>
     
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
      </form> 
   </div>  
   </body>
</html>