<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<c:import url="./temp/boot_head.jsp"></c:import>
<link href="./resources/css/home.css" rel="stylesheet">
</head>
<body>
	<c:import url="./temp/boot_nav.jsp"></c:import>
	<c:if test="${not empty member}">
	<h3>로그인 성공</h3>
	</c:if>
	<c:if test="${empty member}">
	<h3>로그인 실패</h3>
	</c:if>
	<h1 class="c1">Hello world!</h1>
	<h1 id="d1">Other h1</h1>
	<div id="d2">
		<h3>In DIV</h3>
	</div>
	<button onclick="fn1()">click</button>
	<img class="c1" id="d3" alt="key" src="./resources/images/key2.jpg">
	<P>The time on the server is ${serverTime}.</P>
	
	<button id = "btn">CLICK</button>
	<script type="text/javascript">
		$("#btn").click(function(){
			alert('alert');
		})
	</script>
</body>
</html>
