<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thumbnail/thumbnail_form.jsp</title>
</head>
<body>
<form name='frm' method='post' action='../thumbnail.do' enctype='multipart/form-data'>
    <span>썸네일로 만들 이미지를 선택하세요</span><br/><br/>     
    <input type='file' name='att' multiple="multiple" accept="image/*"/><br/><br/>
    <input type='submit'/>
</form>

</body>
</html>