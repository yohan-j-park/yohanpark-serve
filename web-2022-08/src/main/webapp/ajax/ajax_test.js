/**
 * ajax test
 */

var btnText = document.querySelector('#btnLoadText');
var btnHtml = document.querySelector('#btnLoadHtml');
var btnJsp = document.querySelector('#btnLoadJSP');
var btnJson = document.querySelector('#btnLoadJson');

var divText = document.querySelector('#text');
var divHtml = document.querySelector('#html');
var divJsp = document.querySelector('#jsp');
var divJson = document.querySelector('#json');



var city = document.querySelector('#city');
var theater = document.querySelector('#theater');
var movie = document.querySelector('#movie');

city.onchange = function(){
   var xhr = new XMLHttpRequest();
   xhr.open('get','theater.jsp?city=' + city.value);
   xhr.send();
   xhr.onreadystatechange = function(){
      if(xhr.status==200 && xhr.readyState==4){
         var data = xhr.responseText;
         var json = JSON.parse(data);
         var html;
         for(k of json){
            html += `<option value="${k}"> ${k} </option>`;
/* 
            var op = new Option(k,k);
            theater.appendChild(op);
*/
         }
         theater.innerHTML = html;
      }
   }
}

theater.onchange = function(){
   var xhr = new XMLHttpRequest();
   xhr.open('get','movie.jsp?theater=' + theater.value);
   xhr.send();   
   xhr.onreadystatechange = function(){
      if(xhr.status==200 && xhr.readyState==4){
         var data = xhr.responseText;
         var json = JSON.parse(data);
         movie.length=0;
//         var html;
         for(k of json){
            var op = new Option(k,k);
            movie.appendChild(op);
//            html += `<option value ="${k}"> ${k} </option>`;
         }
//         movie.innerHTML = html;
      }
   }
}


var cnt=0;
var btnInsert = document.querySelector('#btnInsert');
btnInsert.addEventListener('click',function(){
   var appendZone = document.querySelector('#appendZone');
   appendZone.width='650px';
   cnt++;
   
   //추가 할 div 생성
   var div = document.createElement("div");   //1)
   div.setAttribute("class","appenddiv");
   div.style.backgroundColor='#ddd';
   div.style.width='650px';
   div.style.padding='5px';
   div.style.margin='5px';
   
   var txt = document.createElement("input");   //2)
   txt.setAttribute("type","text");
   txt.setAttribute("value","아무거나" + cnt);
   div.appendChild(txt);
   
   var btn = document.createElement("input");   //3)
   btn.setAttribute("type","button");
   btn.setAttribute("value", "삭제" + cnt);
   btn.addEventListener('click',function(ev){
      var tag = ev.srcElement;
      var parent = tag.parentNode;   // = div
      appendZone.removeChild(parent);
   })
   div.appendChild(btn);
   
   appendZone.appendChild(div);   
})
// 삭제버튼
var btnDelete = document.querySelector('#btnDelete');
btnDelete.addEventListener('click',function(){
   var appendZone = document.querySelector('#appendZone');
   appendZone.innerHTML = '';
   cnt = 0;
})


btnText.addEventListener('click',function(){
   
   var xhr = new XMLHttpRequest();      //1) 객체 생성
   xhr.open('get','data.txt');         //2) open(객체 초기화)
   xhr.onreadystatechange = function(){//3) 이벤트 핸들러 작성
      if(xhr.status==200 && xhr.readyState==4){   //5)클라이언트의 요청이 정상 처리되고, 모든 응답정보(데이터)를 수신 받았을 때 
         divText.innerHTML = xhr.responseText;   //6) 화면을 갱신하지 않고 응답받은 요청을 divText영역에 나타냄
      }   
   }
   xhr.send();                     //4) 서버에게 요청처리
})

btnHtml.addEventListener('click',function(){
   
   // $(divHtml).load('data.html');   한 줄로 요약
   
   var xhr = new XMLHttpRequest();
   xhr.open('get', 'data.html');
   xhr.onreadystatechange = function(){
      if(xhr.status==200 && xhr.readyState==4){
         divHtml.innerHTML = xhr.responseText;
      }
   }
   xhr.send();
})

btnJsp.addEventListener('click',function(){
   var xhr = new XMLHttpRequest();
   xhr.open('get','data.jsp?dan=5');
   xhr.onreadystatechange = function(){
      if(xhr.status==200 && xhr.readyState==4){
         divJsp.innerHTML = xhr.responseText;            
      }
   }
   xhr.send();
})

btnJson.addEventListener('click',function(){
   var xhr = new XMLHttpRequest();
   xhr.open('get','data_json.jsp');
   xhr.onreadystatechange = function(){
      if(xhr.status==200 && xhr.readyState==4){
         var json = JSON.parse(xhr.responseText);
         /*var data = xhr.responseText;
         var json = JSON.parse(data);*/
         var html =` <li>id:     + json.id
                   <li>name:   + json.name
                   <li>phone:  + json.phone`;
         divJson.innerHTML = html;
      }
   }
   xhr.send();
})

var btnStudent = document.querySelector('#btnStudent');
var frm = document.querySelector('#frm');


std = function(){
   var btnSearch = document.querySelector('#btnSearch');
   var divList = document.querySelector('#list');
   btnSearch.addEventListener('click',function(){
      var xhr = new XMLHttpRequest();
      var findStr = document.frm.findStr.value;
      xhr.open('get','student_list.jsp?findStr='+findStr);
      xhr.onreadystatechange = function(){
      if(xhr.status==200 && xhr.readyState==4){
         var jsonArray = JSON.parse(xhr.responseText);
         console.log(jsonArray);
         var html= "<div>";
         for(obj of jsonArray){
            html +=`<div style='width:600px;'>
                       <span style='display:inline-block; width:100px;'>  ${obj.id}  </span>
                       <span style='display:inline-block; width:100px;'>  ${obj.name}  </span>
                       <span style='display:inline-block; width:150px;'>  ${obj.phone}  </span>
                       <span style='display:inline-block; width:100px;'>  ${obj.address}  </span>
                   </div>`;   
         }
         html += "</div>";
         divList.innerHTML = html;
         }
      }
      xhr.send();
   })
}
//학생정보 조회
btnStudent.addEventListener('click', function(){
   var xhr = new XMLHttpRequest();
   xhr.open('get','student_form.html');
   xhr.onreadystatechange = function(){
      if(xhr.status==200 && xhr.readyState==4){
         frm.innerHTML = xhr.responseText;
         std();
      }
   }
   xhr.send();
   
})
      
//직원정보 조회
var btnEmployee = document.querySelector('#btnEmployee');
var frm_employee = document.querySelector('#frm_employee');

btnEmployee.addEventListener('click', function(){
   var xhr = new XMLHttpRequest();
   xhr.open('get','employee_form.html');
   xhr.onreadystatechange = function(){
      if(xhr.status==200 && xhr.readyState==4){
         frm_employee.innerHTML = xhr.responseText;
         emp();
      }
   }
   xhr.send();
})
emp = function(){
   var btnSearch1 = document.querySelector('#btnSearch1');
   var list = document.querySelector('#employee_list');
   btnSearch1.addEventListener('click', function(){
      var findStr1 = document.frm1.findStr1.value;
      var xhr = new XMLHttpRequest();
      xhr.open('get','employee_list.jsp?findStr1='+findStr1);
      xhr.onreadystatechange = function(){
         if(xhr.status==200 && xhr.readyState==4){
            var jsonArray = JSON.parse(xhr.responseText);
            var html="<div>";
            for(obj of jsonArray){
               html +="<div>"
                   + "   <span>" + obj.employeeNumber + "</span>"
                   + "   <span>" + obj.lastName + "</span>"
                   + "   <span>" + obj.phone + "</span>"
                   + "   <span>" + obj.email + "</span>"
                   + "</div>";
               
            }
            html +="</div>";
            list.innerHTML = html;
         }
      }
      xhr.send();
   })
}


