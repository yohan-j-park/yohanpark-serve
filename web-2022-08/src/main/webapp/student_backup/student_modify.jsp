<%@page import="student.StudentVo"%>
<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='./css/student.css'>
<script src='//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js'></script>
<script defer src='js/student.js'></script>

</head>
<body>

<div id='std_input'  class='std_input'>
    <h2>학생정보 수정</h2>
    <form name='frm_student' method='post'>
        <span class='id'>아이디</span>
        <input type='text' name='id' value='${vo.id }' readOnly/>
        <br/>
        <span class='name'>성명</span>
        <input type='text' name='name' value='${vo.name }'/>
        <br/>
        <span class='gender'>성별</span>
        <label>
        		<input type='radio' name='gender' value='m' 
                    ${ (vo.gender eq 'm')? 'checked':'' }/> 남자 
        </label>
                    
        <label>
        		<input type='radio' name='gender' value='f' 
        				${ (vo.gender eq 'f')? 'checked':'' } />
           여자
        </label>
        
        <br/>
        <span class='pwd'>암호</span>
        <input type='password' name='pwd'/>
        <br/>
        <span class='pwd'>암호확인</span>
        <input type='password' name='pwd2'/>
        <br/>
        <span class='phone'>연락처</span>
        <input type='text' name='phone' value='${vo.phone }'/>
        <br/>
        <span class='zipcode'>우편번호</span>
        <input type='text' name='zipcode' value='${vo.zipcode }'/>
        <input type='button' value='우편번호 검색' name='btnFindZip'/>
        <br/>
        <span class='address'>주소</span>
        <input type='text' name='address'  value='${vo.address }' size='40'/>
        <br/>
        <span class='address'>상세주소</span>
        <input type='text' name='address2'  value='${vo.address2 }' size='30'/>
        <br/>
        <span class='email'>이메일</span>
        <input type='text' name='email'  value='${vo.email }'/>
        <br/>
        <div class='btnZone'>
            <span></span>
            <input type='button' value='수정' id='btnModify' />
            <input type='button' value='삭제' id='btnDelete' />
            <input type='button' value='목록' id='btnSelect' />
        </div>
        
		<input type='text' name='findStr' value='${pageVo.findStr }'/>    
		<input type='text' name='nowPage' value='${pageVo.nowPage }'/>    
        
    </form>
    
    <script>
    	var frm = frm_student;
    	frm.btnFindZip.onclick = function(){// 우편번호
    	    new daum.Postcode({
    	       oncomplete : function(data){
    	          frm.address.value = data.address;
    	          frm.zipcode.value = data.zonecode;
    	       }
    	    }).open();
    	 }
    </script>

</div>
</body>
</html>













