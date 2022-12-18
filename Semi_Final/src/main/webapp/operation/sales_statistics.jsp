<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
<%@page import="operation.OperationVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sales_statistics</title>
<style>
.chartWrapper .chart_theme{
   display:inline-block;
   width:800px;
   color:black;
   margin-left:20px;
   margin-bottom:10px;
   font-size:30px;   
}
#chart_div{
   margin-left:20px;
   margin-bottom:50px;
}
#chart_div_2{
   margin-left:20px;
   margin-bottom:50px;
}
#chart_div_3{
   margin-left:20px;
   margin-bottom:20px;
}
.button {
  position:absolute;
  background: #3D4C53;
  left:0;
  top:0;
  width : 200px;
  height : 50px;
  overflow: hidden;
  text-align : center;
  transition : .2s;
  cursor : pointer;
  border-radius: 3px;
  box-shadow: 0px 1px 2px rgba(0,0,0,.2);
}
.btnTwo {
  position : relative;
  width : 200px;
  height : 100px;
  margin-top: -100px;
  padding-top: 2px;
  background : #26A69A;
  left : -250px;
  transition : .3s;
  font-size:30px;
}
.btnText {
  color : white;
  transition : .3s;
}
.btnText2 {
  margin-top : 50px;
  margin-right : -130px;
  color : #FFF;
}
.button:hover .btnTwo{ /*When hovering over .button change .btnTwo*/
  left: -130px;
}
.button:hover .btnText{ /*When hovering over .button change .btnText*/
  margin-left : 65px;
}
.button:active { /*Clicked and held*/
  box-shadow: 0px 5px 6px rgba(0,0,0,0.3);
}

div.content{
	background-color:white;
	position:relative;
}

.move_top{
	position:fixed;
	left:150px;
	bottom:130px;
	z-index:3;
}

.move_top img{
	width:60px;
	height:60px;
}
</style>
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
   <script defer src = 'js/sales.js'></script>
   <% 
   HashSet manyDays = new HashSet();
   List<OperationVo> list_stat= (ArrayList<OperationVo>)request.getAttribute("list_stat");
   
   for(int i = 0; i<list_stat.size(); i++){
      manyDays.add(list_stat.get(i).getDate());
   }

   
   
   ArrayList manyDaysAsc = new ArrayList(manyDays);
   Collections.sort(manyDaysAsc);
   
   /* 날짜별 판매량 */
   double[] sold = new double[manyDaysAsc.size()];
   double[] inven = new double[manyDaysAsc.size()];
   for(int i = 0; i<list_stat.size(); i++){
      for(int j = 0; j<manyDaysAsc.size(); j++){
         if(list_stat.get(i).getDate().toString().equals(manyDaysAsc.get(j).toString())){
            if(list_stat.get(i).getStatus().toString().equals("판매완료")){
               sold[j] += 1;
            }
            if(list_stat.get(i).getStatus().toString().equals("재고등록")){
               inven[j] += 1;
            }
         }
      }
   }
   
   /* 분기별 판매량 */
   double[] sold_q = new double[9];
   for(int i = 0; i<list_stat.size(); i++){
      if(list_stat.get(i).getStatus().toString().equals("판매완료")){
         if(list_stat.get(i).getDate().substring(0,7).equals("2023-04")||
            list_stat.get(i).getDate().substring(0,7).equals("2023-05")||
            list_stat.get(i).getDate().substring(0,7).equals("2023-06")){
            sold_q[0] ++;
            }
         if(list_stat.get(i).getDate().substring(0,7).equals("2023-07")||
            list_stat.get(i).getDate().substring(0,7).equals("2023-08")||
            list_stat.get(i).getDate().substring(0,7).equals("2023-09")){
            sold_q[1] ++;
            }
         if(list_stat.get(i).getDate().substring(0,7).equals("2023-10")||
            list_stat.get(i).getDate().substring(0,7).equals("2023-11")||
            list_stat.get(i).getDate().substring(0,7).equals("2023-12")){   
            sold_q[2] ++;      
         }
         if(list_stat.get(i).getDate().substring(0,7).equals("2024-01")||
            list_stat.get(i).getDate().substring(0,7).equals("2024-02")||
            list_stat.get(i).getDate().substring(0,7).equals("2024-03")){   
            sold_q[3] ++;      
         } 
         if(list_stat.get(i).getDate().substring(0,7).equals("2024-04")||
            list_stat.get(i).getDate().substring(0,7).equals("2024-05")||
            list_stat.get(i).getDate().substring(0,7).equals("2024-06")){   
            sold_q[4] ++;      
         }
         if(list_stat.get(i).getDate().substring(0,7).equals("2024-07")||
            list_stat.get(i).getDate().substring(0,7).equals("2024-08")||
            list_stat.get(i).getDate().substring(0,7).equals("2024-09")){   
            sold_q[5] ++;      
         }
         if(list_stat.get(i).getDate().substring(0,7).equals("2024-10")||
            list_stat.get(i).getDate().substring(0,7).equals("2024-11")||
            list_stat.get(i).getDate().substring(0,7).equals("2024-12")){   
            sold_q[6] ++;      
         }
         if(list_stat.get(i).getDate().substring(0,7).equals("2025-01")||
            list_stat.get(i).getDate().substring(0,7).equals("2025-02")||
            list_stat.get(i).getDate().substring(0,7).equals("2025-03")){   
            sold_q[7] ++;      
         } 
         if(list_stat.get(i).getDate().substring(0,7).equals("2025-04")||
            list_stat.get(i).getDate().substring(0,7).equals("2025-05")||
            list_stat.get(i).getDate().substring(0,7).equals("2025-06")){   
            sold_q[8] ++;      
         }
         
         }
   }
   
   /* 23년 2,3,4 24년 1,2,3,4 25년 1,2,3,4 */
   /* 분기별 매출 추이 */
   /* 분기별 마진율 */
   double[] sales = new double[9];
   double[] margin_rate = new double[9];
   
   for(int i = 0; i<list_stat.size(); i++){
      if(list_stat.get(i).getStatus().toString().equals("판매완료")){
      if(list_stat.get(i).getDate().substring(0,7).equals("2023-04")||
         list_stat.get(i).getDate().substring(0,7).equals("2023-05")||
         list_stat.get(i).getDate().substring(0,7).equals("2023-06")){
         sales[0] += Double.parseDouble(list_stat.get(i).getSupply_price());
         margin_rate[0] += Double.parseDouble(list_stat.get(i).getPr_cost())/(sold_q[0]*Double.parseDouble(list_stat.get(i).getSupply_price()));
      }
      if(list_stat.get(i).getDate().substring(0,7).equals("2023-07")||
         list_stat.get(i).getDate().substring(0,7).equals("2023-08")||
         list_stat.get(i).getDate().substring(0,7).equals("2023-09")){
         margin_rate[1] += Double.parseDouble(list_stat.get(i).getPr_cost())/(sold_q[1]*Double.parseDouble(list_stat.get(i).getSupply_price()));
         sales[1] += Double.parseDouble(list_stat.get(i).getSupply_price());
      }
      if(list_stat.get(i).getDate().substring(0,7).equals("2023-10")||
         list_stat.get(i).getDate().substring(0,7).equals("2023-11")||
         list_stat.get(i).getDate().substring(0,7).equals("2023-12")){         
         margin_rate[2] += Double.parseDouble(list_stat.get(i).getPr_cost())/(sold_q[2]*Double.parseDouble(list_stat.get(i).getSupply_price()));
         sales[2] += Double.parseDouble(list_stat.get(i).getSupply_price());
      }
      if(list_stat.get(i).getDate().substring(0,7).equals("2024-01")||
         list_stat.get(i).getDate().substring(0,7).equals("2024-02")||
         list_stat.get(i).getDate().substring(0,7).equals("2024-03")){         
         margin_rate[3] += Double.parseDouble(list_stat.get(i).getPr_cost())/(sold_q[3]*Double.parseDouble(list_stat.get(i).getSupply_price()));
         sales[3] += Double.parseDouble(list_stat.get(i).getSupply_price());
      } 
      if(list_stat.get(i).getDate().substring(0,7).equals("2024-04")||
         list_stat.get(i).getDate().substring(0,7).equals("2024-05")||
         list_stat.get(i).getDate().substring(0,7).equals("2024-06")){         
         margin_rate[4] += Double.parseDouble(list_stat.get(i).getPr_cost())/(sold_q[4]*Double.parseDouble(list_stat.get(i).getSupply_price()));
         sales[4] += Double.parseDouble(list_stat.get(i).getSupply_price());
      }
      if(list_stat.get(i).getDate().substring(0,7).equals("2024-07")||
         list_stat.get(i).getDate().substring(0,7).equals("2024-08")||
         list_stat.get(i).getDate().substring(0,7).equals("2024-09")){         
         margin_rate[5] += Double.parseDouble(list_stat.get(i).getPr_cost())/(sold_q[5]*Double.parseDouble(list_stat.get(i).getSupply_price()));
         sales[5] += Double.parseDouble(list_stat.get(i).getSupply_price());
      }
      if(list_stat.get(i).getDate().substring(0,7).equals("2024-10")||
         list_stat.get(i).getDate().substring(0,7).equals("2024-11")||
         list_stat.get(i).getDate().substring(0,7).equals("2024-12")){         
         margin_rate[6] += Double.parseDouble(list_stat.get(i).getPr_cost())/(sold_q[6]*Double.parseDouble(list_stat.get(i).getSupply_price()));
         sales[6] += Double.parseDouble(list_stat.get(i).getSupply_price());
      }
      if(list_stat.get(i).getDate().substring(0,7).equals("2025-01")||
         list_stat.get(i).getDate().substring(0,7).equals("2025-02")||
         list_stat.get(i).getDate().substring(0,7).equals("2025-03")){         
         margin_rate[7] += Double.parseDouble(list_stat.get(i).getPr_cost())/(sold_q[7]*Double.parseDouble(list_stat.get(i).getSupply_price()));
         sales[7] += Double.parseDouble(list_stat.get(i).getSupply_price());
      } 
      if(list_stat.get(i).getDate().substring(0,7).equals("2025-04")||
         list_stat.get(i).getDate().substring(0,7).equals("2025-05")||
         list_stat.get(i).getDate().substring(0,7).equals("2025-06")){         
         margin_rate[8] += Double.parseDouble(list_stat.get(i).getPr_cost())/(sold_q[8]*Double.parseDouble(list_stat.get(i).getSupply_price()));
         sales[8] += Double.parseDouble(list_stat.get(i).getSupply_price());
      }
         
      }
   }
   
   %>

   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Date', '판매량', '재고량'],
         
          <% for(int i=0; i<manyDays.size(); i++){ %>
               ['<%=manyDaysAsc.get(i)%>', <%=sold[i]%>, <%=inven[i]%>],
             <% if(i==manyDays.size()-1){ %>
                ['<%=manyDaysAsc.get(i)%>', <%=sold[i]%>, <%=inven[i]%>]
              <%}%>
           <%}%>
        ]);

        var options = {
          title: 'Company Performance',
          hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript">
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawTrendlines);

    function drawTrendlines() {
          var data = new google.visualization.DataTable();
          data.addColumn('number', 'X');
          data.addColumn('number', '매출액');
          
          <% for(int i=0; i<9; i++){ %>
             data.addRows([
                [<%=i%>, <%=sales[i]%>]                 
               ]);
          <%}%>
          
          
         

          var options = {
            hAxis: {
              title: '사업연도(당사는 2023년 6월부터 매 3개월을 회계기간 단위로 삼고있습니다.)'
            },
            vAxis: {
              title: '매출액(원, KRW)'
            },
            colors: ['#AB0D06', '#007329'],
            trendlines: {
              0: {type: 'exponential', color: '#333', opacity: 1},
              1: {type: 'linear', color: '#111', opacity: .3}
            }
          };

          var chart = new google.visualization.LineChart(document.getElementById('chart_div_2'));
          chart.draw(data, options);
        } 
 </script>
 <script type="text/javascript">
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawTrendlines);

    function drawTrendlines() {
          var data = new google.visualization.DataTable();
          data.addColumn('number', 'X');
          data.addColumn('number', '마진율');
          
          <% for(int i=0; i<9; i++){ %>
             data.addRows([
                [<%=i%>, <%=1-margin_rate[i]%>]                 
               ]);
          <%}%>
          
          
         

          var options = {
            hAxis: {
              title: '사업연도(당사는 2023년 6월부터 매 3개월을 회계기간 단위로 삼고있습니다.)'
            },
            vAxis: {
              title: '마진율(Profit/Sales)'
            },
            colors: ['#AB0D06', '#007329'],
            trendlines: {
              0: {type: 'exponential', color: '#333', opacity: 1},
              1: {type: 'linear', color: '#111', opacity: .3}
            }
          };

          var chart = new google.visualization.LineChart(document.getElementById('chart_div_3'));
          chart.draw(data, options);
        } 
 </script>
</head>
<body>

    
 <div class="button" onclick='btnBack()'>
    <p class="btnText">돌아가기</p>
     <div class="btnTwo">
      <p class="btnText2">⬅</p>
    </div>
 </div>
 <div class='chartWrapper'>
 	<br/>
 	<br/>
 	<br/>
 	<br/>
 	<br/>
 	<br/>
    <span class='chart_theme'>날짜별 판매량 및 재고량</span>
    <div id="chart_div" style="width: 95%; height: 500px;"></div>
    <span class='chart_theme'>분기별 매출액 추이</span>
    <div id="chart_div_2" style="width: 95%; height: 500px;"></div>
    <span class='chart_theme'>분기별 마진율 추이</span>
    <div id="chart_div_3" style="width: 95%; height: 500px;"></div>
 </div>
    
    <form name = 'frmStat' method = 'post'>       
         <input type = 'hidden' name = 'findPrcode' value = '${pageVo.findPrcode }'/>
         <input type = 'hidden' name = 'findDate' value = '${pageVo.findDate }'/>
         <input type = 'hidden' name = 'findUpdate_time' value = '${pageVo.findUpdate_time }'/>
         <input type = 'hidden' name = 'findPrname' value = '${pageVo.findPrname }'/>
         <input type = 'hidden' name = 'findStatus' value = '${pageVo.findStatus }'/>
         <input type = 'hidden' name = 'nowPage' value = '${pageVo.nowPage }'/>        
   </form>
   <div class='move_top'>
   <a href="#"><img src="images/scrollupbutton2.png" class="scrollup"></a>
   </div>
</body>
</html>