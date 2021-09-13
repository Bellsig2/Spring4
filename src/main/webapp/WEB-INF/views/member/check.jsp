<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid" >
		<div class="form-check">
			<input class="form-check-input" type="checkbox" value="" id="checkAll">
			<label class="form-check-label" for="checkAll"> Check All </label>
		</div>
	<div class="form-check">
			<input class="form-check-input check" type="checkbox" value="" id="flexCheckDefault" class = "check">
			<label class="form-check-label" for="flexCheckDefault"> 약관1 </label>
		</div>
		<div class="form-check">
			<input class="form-check-input check" type="checkbox" value="" id="flexCheckDefault" class = "check">
			<label class="form-check-label" for="flexCheckDefault"> 약관2 </label>
		</div>
		<div class="form-check">
			<input class="form-check-input check" type="checkbox" value="" id="flexCheckDefault"  class = "check">
			<label class="form-check-label" for="flexCheckDefault"> 약관3 </label>
		</div>
		<div class="form-check">
			<input class="form-check-input check" type="checkbox" value="" id="flexCheckDefault" class = "check">
			<label class="form-check-label" for="flexCheckDefault"> 약관4 </label>
		</div>
	</div>
	<button id="btn">회원가입</button>
	<a href = "./join" class=""></a>
	<script type="text/javascript" src = "../resources/js/check.js">
	</script>
</body>
</html>