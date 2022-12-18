
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/application.jsp</title>

</head>
<body>
<%	// 자바영역이다.. (모든 자바명령어 사용가능)

// application영역에 저장 된 접속자 수를 가져옴.
Object o = application.getAttribute("cnt");		
// application영역에 있는 "cnt"라는 attribute 속성값을 가지고 와라
// Object에 담는 이유는 getAttribute의 반환값이 Object타입이기 때문..

int cnt = 1;
if(o == null){	// 오늘의 방문자가 없는 경우, 한번도 cnt가 저장되지 않았다, 내가 최초 방문자다.
	cnt = 1;
	
}else{
	cnt = (Integer)o;
	cnt++;
	
}
application.setAttribute("cnt", cnt);
%>
<b>오늘 방문자 수 : <%=cnt %></b>
</body>
</html>