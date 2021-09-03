<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/header.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/nav.jsp"></c:import>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.regdate}</td>
					<td>${dto.hits}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./noticeInsert"><button class="button">글쓰기</button></a>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</body>
</html>