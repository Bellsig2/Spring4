<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>My Page</h1>
	<form action="./insert" class = frm>
	ID : <input type="text" value = "${member.id}" name = "id" class="update">
	PW : <input type="password" value = "${member.pw}" name = "pw" class="update">
	NAME : <input type="text" value = "${member.name}"  class="update" readonly="readonly">
	PHONE : <input type="tel" value ="${member.phone}" name = "phone" class="update">
	Email : <input type="text" value = "${member.email}" name = "email" class="update">
	<button type = "button" id = "update_btn">수정</button>
	</form>
	<a href = "./delete?id=${sessionScope.member.id}&pw=${sessionScope.member.pw}"><button type = "button" id = "btn">회원탈퇴</button></a>
	<script type="text/javascript" src = "../resources/js/Mypage.js"></script>
</body>
</html>