<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>검색</h3>
	<hr />
<!-- 
form tag
 - 요청시 전송되는 데이타를 묶어주는 단위
 - form 안에 있는 데이타들은 요청시 같이 전송된다.
 - action:요청할 URL(서블릿URL)
 - method:요청방법
 -->
	<form action="4.search_result.jsp" method="get">
		검색어:<input type="text" name="searchkeyword">
		<!--
		<< submit button >>
			form안에 존재해야하며 버튼클릭시에 자기가 속해있는 폼의
			데이타모두를 가지고 action url 에 기술되어있는
			서블릿으로 요청한다
		 -->
		<input type="submit" value="검색요청">
	</form>
</body>
</html>
