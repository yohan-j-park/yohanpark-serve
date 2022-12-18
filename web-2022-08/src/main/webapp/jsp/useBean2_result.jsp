<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/useBean2_result.jsp</title>
</head>
<body>
<h2>useBean 태그를 사용하지 않는 방법</h2>
<%
String id = request.getParameter("id");
int kor = Integer.parseInt(request.getParameter("kor"));
int eng = Integer.parseInt(request.getParameter("eng"));
int mat = Integer.parseInt(request.getParameter("mat"));
int tot = kor+eng+mat;
double avg = tot/3.0d; 
%>

<ul>
	<li>id : <%=id %></li>
	<li>kor : <%=kor %></li>
	<li>eng : <%=eng %></li>
	<li>mat : <%=mat %></li>
	<li>tot : <%=tot %></li>
	<li>avg : <%=avg %></li>
</ul>

<h2>useBean 태그를 사용 한 방법</h2>
<jsp:useBean id="vo2" class="jsp.BeanTestVo2"/>
<jsp:setProperty property="*" name="vo2"/> <% /* property에 *을 주게 되면 form태그에 저장한 값이 한꺼번에 세팅된다 */ %>
<ul>
	<li>아이디 : <%=vo2.getId() %></li>
	<li>국어 : <%=vo2.getKor() %></li>
	<li>영어 : <%=vo2.getEng() %></li>
	<li>수학 : <%=vo2.getMat() %></li>
	<li>총점 : <%=vo2.getTot() %></li>
	<li>평균 : <%=vo2.getAvg() %></li>
	
</ul>
</body>
</html>