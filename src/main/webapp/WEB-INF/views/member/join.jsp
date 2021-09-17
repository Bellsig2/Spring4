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
<h1>Join입니다.</h1>
<div class="container-fluid all">
	<form action="join" method="post" enctype="multipart/form-data" id = "frm">
		<div class="input-group input-group-sm mb-3">
		  <span class="in	put-group-text" id="inputGroup-sizing-sm">ID</span>
		  <input name = "id" type="text" id = "id" class="form-control all" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
		  <button  type = "button" id="idCheck">idcheck</button>
		</div>
		<div id="idResult"></div>
		
		 <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">비밀번호</label>
		    <input type="password"class="form-control all pw" id="pw">
		 </div>
		 
		 <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">비밀번호 확인</label>
		    <input name = "pw" type="password" class="form-control all pw" id="pwcheck">
		 </div>
		 <div id = "pwResult"></div>
		
		<div class="input-group input-group-sm mb-3">
		  <span class="input-group-text" id="inputGroup-sizing-sm">name</span>
		  <input name = "name" type="text" class="form-control all" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
		</div>
		
		<div class="input-group input-group-sm mb-3">
		  <span class="input-group-text" id="inputGroup-sizing-sm">Phone</span>
		  <input name = "phone" type="tel" class="form-control all" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
		</div>
		
		<div class="mb-3">
		   <label for="exampleInputEmail1" class="form-label">Email address</label>
		   <input name = "email"type="email" class="form-control all" id="exampleInputEmail1" aria-describedby="emailHelp">
		</div>
		<div class="mb-3" id="f">
			<label for="photo" class="form-label">Photo</label>
			<input type="file" class="form-control all photo" name="photo">
		</div>
		<!-- input file 추가 영역 -->
		<div id = "addResult">
		</div>
		 <button id = "btn" type="submit" class="btn btn-dark">가입</button>
	</form>
</div>
<script type="text/javascript" src="../resources/js/join.js"></script>
<script type="text/javascript" src="../resources/js/file.js"></script>

</body>
</html>