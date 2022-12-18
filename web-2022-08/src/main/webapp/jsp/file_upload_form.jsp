<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/file_upload_form.jsp</title>
</head>
<body>
<h2>파일 업로드</h2>
<form name='frm' method='post' action='../upload.do' enctype='multipart/form-data'>
	<label>메시지</label>
	<input type='text' size='40' name='msg' value='방가...'/><br/>
	<input type='file' name='att' multiple/><br/>
	<input type='submit' value='전송'/>
</form>
</body>
</html>