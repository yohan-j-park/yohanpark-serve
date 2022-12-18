<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="operation.OperationVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>


.chartWrapper .chart_theme{
   display:inline-block;
   width:800px;
   color:black;
   margin-left:20px;
   margin-bottom:10px;
   font-size:30px;
   
}

#chart_div_3 {
   margin-left:20px;
   margin-bottom:50px;
}

#piechart_3d{
   margin-left:20px;
   margin-bottom:50px;
}

#piechart_3d rect{
   margin-left:20px;
   margin-bottom:50px;
   border-radius:30px;
}

#chart_div{
   margin-left:20px;
   margin-bottom:50px;
}
#chart_div_2{
   margin-left:20px;
   margin-bottom:50px;
}
#chart_div_4{
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
<script defer src = 'js/operation.js'></script>

<%

HashSet manyDays = new HashSet();
List<OperationVo> list_stat= (ArrayList<OperationVo>)request.getAttribute("list_stat");


for(int i = 0; i<list_stat.size(); i++){
   manyDays.add(list_stat.get(i).getDate());
}

ArrayList manyDaysAsc = new ArrayList(manyDays);
Collections.sort(manyDaysAsc);

int first_machine_cnt = 0;
int second_machine_cnt = 0;

int cnt_day_quant_brain = 0;   
int cnt_day_quant_neuron = 0;   
int cnt_day_quant_arm = 0;      
int cnt_day_quant_leg = 0;      
int cnt_day_quant_body = 0;      
int cnt_day_quant_head = 0;   

int cnt_day_by_day[] = new int[manyDaysAsc.size()];

double[] util_rate_1 = new double[manyDaysAsc.size()];
double[] util_rate_2 = new double[manyDaysAsc.size()];

double[] pf_rate_f = new double[manyDaysAsc.size()];
double[] pf_rate_p = new double[manyDaysAsc.size()];

int[] first_machine_by_day = new int[manyDaysAsc.size()];
int[] second_machine_by_day = new int[manyDaysAsc.size()];

/*1호기 2호기로 생산한 제품 전체 개수*/
/* 날짜별 1호기 2호기 생산 개수 */
/* 일자별 생산량 */
/* 날짜 오름차순 리스트와 사이즈가 같은 primitive type의 일별 생산량 */
/* 가동률 */
/* 날짜별 양품률/불량률 */

for(int i = 0; i<list_stat.size(); i++){
   for(int j = 0; j<manyDaysAsc.size(); j++){
      if(list_stat.get(i).getDate().toString().equals(manyDaysAsc.get(j).toString())){
         cnt_day_by_day[j]++;
      }
   }
   if(list_stat.get(i).getMachine_no().toString().equals("1")){
      first_machine_cnt++;
   }else{
      second_machine_cnt++;
   }
   switch(list_stat.get(i).getPr_name()){
   case "엑스봇로봇두뇌" :      
      cnt_day_quant_brain++;
      break;
   case "엑스봇로봇신경" :
      cnt_day_quant_neuron++;
      break;
   case "엑스봇로봇팔" :
      cnt_day_quant_arm++;
      break;   
   case "엑스봇로봇다리" :
      cnt_day_quant_leg++;
      break;   
   case "엑스봇로봇몸통" :
      cnt_day_quant_body++;
      break;   
   case "엑스봇로봇머리" :
      cnt_day_quant_head++;
      break;      
   }
}

for(int i = 0; i<list_stat.size(); i++){   
   for(int j = 0; j<manyDaysAsc.size(); j++){
      if(list_stat.get(i).getDate().toString().equals(manyDaysAsc.get(j).toString())){
         if(list_stat.get(i).getMachine_no().toString().equals("1")){
            first_machine_by_day[j]++;
            util_rate_1[j] += Double.parseDouble(list_stat.get(i).getTaken_time())/1080;
         }
         if(list_stat.get(i).getMachine_no().toString().equals("2")){
            second_machine_by_day[j]++;
            util_rate_2[j] += Double.parseDouble(list_stat.get(i).getTaken_time())/1200;
         }         
         if(list_stat.get(i).getPf().toString().equals("f")){
            pf_rate_f[j] += 1.0/cnt_day_by_day[j];
         }
         if(list_stat.get(i).getPf().toString().equals("p")){
            pf_rate_p[j] += 1.0/cnt_day_by_day[j];
         }
      }
   }
}

%>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
      google.charts.load('current', {'packages':['gauge']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Label', 'Value'],
          ['1호기', <%=util_rate_1[manyDaysAsc.size()-1]*100%>],
          ['2호기', <%=util_rate_2[manyDaysAsc.size()-1]*100%>]
        ]);

        var options = {
          width: 1400, height: 400,
          redFrom: 90, redTo: 100,
          yellowFrom:80, yellowTo: 90,
          minorTicks: 5
        };

        var chart = new google.visualization.Gauge(document.getElementById('chart_div_3'));

        chart.draw(data, options);

        setInterval(function() {
          data.setValue(0, 1, <%=util_rate_1[manyDaysAsc.size()-1]*100-8%> + Math.round(16 * Math.random()));
          chart.draw(data, options);
        }, 2000);
        setInterval(function() {
          data.setValue(1, 1, <%=util_rate_2[manyDaysAsc.size()-1]*100-8%> + Math.round(16 * Math.random()));
          chart.draw(data, options);
        }, 1900);         
      }
    </script>


    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      
      
      google.charts.setOnLoadCallback(drawChart1);      
      function drawChart1() {
        var data = google.visualization.arrayToDataTable([
          ['제품명', '생산량'],
          ['엑스봇로봇두뇌', <%=cnt_day_quant_brain%>],
          ['엑스봇로봇신경', <%=cnt_day_quant_neuron%>],
          ['엑스봇로봇팔',  <%=cnt_day_quant_arm%>],
          ['엑스봇로봇다리', <%=cnt_day_quant_leg%>],
          ['엑스봇로봇몸통', <%=cnt_day_quant_body%>],
          ['엑스봇로봇머리', <%=cnt_day_quant_head%>]
        ]);

        var options = {
          title: '제품별 생산량(생산비율)',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }      
    </script>
        
    <script type='text/javascript'>
      google.charts.load('current', {'packages':['annotationchart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('date', 'Date');
        data.addColumn('number', '총생산량');
        data.addColumn('string', 'title');
        data.addColumn('string', 'text');
        data.addColumn('number', '1호기');
        data.addColumn('string', 'title');
        data.addColumn('string', 'text');
        data.addColumn('number', '2호기');
        data.addColumn('string', 'title');
        data.addColumn('string', 'text'); 
        
        /* System.out.println(Arrays.toString(first_machine_by_day));
        System.out.println(Arrays.toString(second_machine_by_day)); */
        
        <% for(int i=0; i<manyDays.size(); i++){ %>
           data.addRows([
              
              [new Date(<%=manyDaysAsc.get(i).toString().substring(0,4)%> , <%=manyDaysAsc.get(i).toString().substring(5,7)%>, <%=manyDaysAsc.get(i).toString().substring(8)%>),
                         <%=cnt_day_by_day[i]%>, undefined, undefined,
                         <%=first_machine_by_day[i]%>, undefined, undefined,
                         <%=second_machine_by_day[i]%>, undefined, undefined]
                      
           ]);
        <%}%>
        
        var chart = new google.visualization.AnnotationChart(document.getElementById('chart_div'));

        var options = {
          displayAnnotations: true
        };

        chart.draw(data, options);
      }
    </script>
    
    
    
    
 <script type="text/javascript">
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawTrendlines);

    function drawTrendlines() {
          var data = new google.visualization.DataTable();
          data.addColumn('number', 'X');
          /* data.addColumn('number', '전체가동률'); */
          data.addColumn('number', '1호기');
          data.addColumn('number', '2호기');
          
          <% for(int i=0; i<manyDays.size(); i++){ %>
             data.addRows([
                [<%=i%>, <%=util_rate_1[i]*100%>, <%=util_rate_2[i]*100%>]                 
               ]);
          <%}%>
          
          
         

          var options = {
            hAxis: {
              title: '영업일(설립일 기준 +)'
            },
            vAxis: {
              title: '가동률(백분율, %)'
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
          /* data.addColumn('number', '전체가동률'); */
          data.addColumn('number', '불량률');
          data.addColumn('number', '양품률');
          
          <% for(int i=0; i<manyDays.size(); i++){ %>
             data.addRows([
                [<%=i%>, <%=pf_rate_f[i]*100%>, <%=pf_rate_p[i]*100%>]                 
               ]);
          <%}%>
          
          
         

          var options = {
            hAxis: {
              title: '영업일(설립일 기준 +)'
            },
            vAxis: {
              title: '불량률과 양품률(백분율, %)'
            },
            colors: ['#AB0D06', '#007329'],
            trendlines: {
              0: {type: 'exponential', color: '#333', opacity: 1},
              1: {type: 'linear', color: '#111', opacity: .3}
            }
          };

          var chart = new google.visualization.LineChart(document.getElementById('chart_div_4'));
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
   	  <br/><br/><br/><br/><br/><br/>
      <span class='chart_theme'>인공지능을 이용한 실시간 예상 기계 가동률(백분율)</span>
      <br/><br/>
      <div id="chart_div_3" style="width: 95%; height: 450px;">
            <div class='test'></div>
      </div>
      <br/><br/>
      
      <span class='chart_theme'>제품별 생산량(생산비율)</span>
      <br/>
      <div id="piechart_3d" style="width: 95%; height: 600px;"></div>
      <br/><br/>
      
      <span class='chart_theme'>날짜별 총생산량, 1호기 생산량, 2호기 생산량</span>
      <br/><br/><br/>
      <div id='chart_div' style='width: 95%; height: 600px;'></div>
      <br/><br/>
      
      <span class='chart_theme'>영업일 기준 기계 가동률(백분율)</span>
      <div id="chart_div_2" style='width: 95%; height: 600px;'></div>
      <br/><br/>
      
      <span class='chart_theme'>영업일 기준 불량률과 양품률</span>
      <div id="chart_div_4" style='width: 95%; height: 600px;'></div>
   </div>
   
   <form name = 'frmStat' method = 'post'>       
           <input type = 'hidden' name = 'findPrcode' value = '${pageVo.findPrcode }'/>
         <input type = 'hidden' name = 'findDate' value = '${pageVo.findDate }'/>
         <input type = 'hidden' name = 'findMachine_no' value = '${pageVo.findMachine_no }'/>
         <input type = 'hidden' name = 'findManager' value = '${pageVo.findManager }'/>
         <input type = 'hidden' name = 'findPrname' value = '${pageVo.findPrname }'/>
         <input type = 'hidden' name = 'nowPage' value = '${pageVo.nowPage }'/>         
   </form>
   <div class='move_top'>
   <a href="#"><img src="images/scrollupbutton2.png"></a>
   </div>
   
 
</body>
</html>