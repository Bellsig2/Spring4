<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/header.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/nav.jsp"></c:import>
	<form action="./noticeInsert" method="post">
		제목 : <input type="text" name="title">
		글쓰기 : <input type="text" name="contents">
		글쓴이 : <input type="text" name="writer">
		날짜 : <input type="date" name="regdate">
		조회수 : <input value="0" name="hits">
		<button class="button">전송</button>
	</form>
</body>
</html>