<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<h1>id check Page</h1>
	
		<div id = "checkId">
			<c:if test="${empty member}">
				${param.id} 사용 가능한 아이디 입니다.
			</c:if>
			<c:if test="${not empty member}">
				사용 불가능한 아이디 입니다.
			</c:if>
		</div>
	
		<form action="idCheck" method="get" id = "frm">
		<div class="input-group input-group-sm mb-3">
		  <span class="input-group-text" id="inputGroup-sizing-sm">ID</span>
		  <input value = "${param.id}" type="text" name = "id" id = "id" class="form-control all" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
		  <button type = "submit">확인</button>
		  	<c:if test="${empty member}">
				<button type = "button" id="useId">ID 사용</button>
			</c:if>
		</div>
	</form>
	
	<script type="text/javascript">
		const useId = document.getElementById('useId');
		useId.addEventListener('click', function(){
			let id = window.document.getElementById("id").value;
			opener.document.getElementById('id').value = id; 
			close();
		})
	</script>
</body>
</html>