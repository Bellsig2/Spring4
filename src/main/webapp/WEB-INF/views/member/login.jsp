<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temp/boot_head.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Login page</h1>
	
	<form action="login" method="post" id = "frm">
		<div class="input-group input-group-sm mb-3">
		  <span class="input-group-text" id="inputGroup-sizing-sm">ID</span>
		  <input type="text" name ="id"id = "id" class="form-control all" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
		  <div id="idResult"></div>
		</div>
		
		 <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">비밀번호</label>
		    <input type="password" name="pw"class="form-control all pw" id="pw">
		 </div>
		 <button id = "btn" type="submit" class="btn btn-dark">Dark</button>
	</form>
</body>
</html>