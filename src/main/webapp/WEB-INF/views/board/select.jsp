<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board}Select Page</h1>
	
	<div class="container-fluid">
		<h3>NUM:${dto.num}</h3>
		<h3>Title:${dto.title}</h3>
		<h3>Contents:${dto.contents}</h3>
		<h3>Writer:${dto.writer}</h3>
		<h3>DATE:${dto.regDate}</h3>
		<h3>HITS:${dto.hits}</h3>
		<div>
			<textarea rows="" cols="" readonly="readonly" id="contents">
				${dto.contents}
			</textarea>
		</div>
		<c:forEach items="${dto.files}" var = "f">
			<div>
				<a href ="./down?fileName=${f.fileName}">${f.oriName}</a>
			</div>
		</c:forEach>
	
	<div>
		<div class="mb-3">
		    <label for="writer" class="form-label">Writer</label>
		    <input type="text" class="form-control" name="writer" id="writer" placeholder="Enter Writer" value = "${member.id}" readonly="readonly" >
		    <div id = "w_1" class="er"></div>
		  </div>
		  
		  <div class="mb-3">
		   <label for="contents" class="form-label">Contents</label>
  			<textarea class="form-control" cols=""  name="contents" id="content" rows="6"></textarea>
		  </div>
		 	
		  <div class = "mb-3" id = "con">
		  	<button type = "button" id = "comment">전송</button>
		  </div>
	</div>
	
	
	<a href="./delete?num=${dto.num}">DELETE</a>
	<a href="./update?num=${dto.num}">UPDATE</a>
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">REPLY</a>
	</c:if>
	</div>
	

	
<script type="text/javascript" src="../resources/js/select.js"></script>
<script type="text/javascript">
	$('#comment').click(function(){
		//작성자, 내용을 콘솔에 출력
		let writer = $('#writer').val();
		let contents = $('#contents').val();
		$.post('./comment',{num:'${dto.num}'writer:writer, contents:contents}, function(result){
			console.log(result.trim());
		}) // 앞에는 파라미터 뒤에는 변수명

	});
</script>
</body>
</html>