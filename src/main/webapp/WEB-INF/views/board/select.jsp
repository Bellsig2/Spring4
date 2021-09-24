<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.more {
	cursor: pointer;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board}SelectPage</h1>

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
		<c:forEach items="${dto.files}" var="f">
			<div>
				<a href="./down?fileName=${f.fileName}">${f.oriName}</a>
			</div>
		</c:forEach>

		<div id="commentList" data-board-num="${dto.num}"></div>

		<div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label> <input
					type="text" class="form-control" name="writer" id="writer"
					placeholder="Enter Writer" value="${member.id}" readonly="readonly">
				<div id="w_1" class="er"></div>
			</div>

			<div class="mb-3">
				<label for="content" class="form-label">Contents</label>
				<textarea class="form-control" cols="" name="contents" id="content"
					rows="6"></textarea>
			</div>

			<div class="mb-3" id="con">
				<button type="button" id="comment">전송</button>
			</div>
		</div>


		<a href="./delete?num=${dto.num}">DELETE</a> <a
			href="./update?num=${dto.num}">UPDATE</a>
		<c:if test="${board ne 'notice'}">
			<a href="./reply?num=${dto.num}">REPLY</a>
		</c:if>
	</div>



	<!-- <script type="text/javascript" src="../resources/js/select.js"></script> -->
	<script type="text/javascript">
		getCommentList(1);
		let content = '';
		$("#commentList").on("click",".commentUpdate",function(){
			let ta = '<textarea rows="5" cols="" id="contents">';
			let btn = '<button type="button" id="updateBtn" class="btn btn-primary">update</button>';
				btn= btn+'<button type="button" id="" class="btn btn-primary can">Cancel</button>';
			let num = $(this).attr('data-comment-update');
			content = $("#content"+num).html().trim();
			$("#content"+num).html(ta+$('#content'+num).html()+'</textarea>'+btn)
		});
		
		$("#commentList").on("click", "#updateBtn", function(){
			let contents = $(this).prev().val().trim();
			let cn = $(this).parent().prev().text().trim();
			console.log(cn);
			
		 		$.ajax({
				type : "POST",
				url : "./commentUpdate",
				data : {
					commentNum : cn,
					contents : contents
				},
		 		success: function(result) {
		 			if(result.trim()>0){
		 				alert('수정 성공');
		 				getCommentList(1);
		 			}
		 			else {
		 				alert("수정 실패")
		 			}
		 		}
			}) 
		})
		
		$("#commentList").on('click', '.can', function(){
			console.log(content)
			$(this).parent().html(content);
		})

		
		$("#commentList").on("click", ".commentDel", function() {
			let commentNum = $(this).attr("data-comment-del");
			$.ajax({
				type : "POST",
				url : "./commentDel",
				data : {
					commentNum : commentNum,
				},
				success : function(result) {
					getCommentList(1);
				}
			})
		});

		$("#commentList").on("click", ".more", function() {
			let pn = $(this).attr("data-comment-pn")
			getCommentList(pn)
		})

		$(".more").click(function() {
			console.log("클릭");
		});

		function getCommentList(pageNumber) {
			let num = $("#commentList").attr("data-board-num");
			$.ajax({
				type : "GET",
				url : "./getCommentList",
				data : {
					num : num,
					pn : pageNumber
				},
				success : function(result) {
					result = result.trim();
					$("#commentList").html(result);
				},
				error : function(xhr, status, error) {
					console.log(error);
				}

			});
		}

		$("#comment").click(function() {
			//작성자, 내용을 콘솔에 출력
			let writer = $("#writer").val();
			let contents = $("#content").val();
			$.post('./comment', {
				num : '${dto.num}',
				writer : writer,
				contents : contents
			}, function(result) {
				console.log(result.trim());
				$('#content').val("");
				getCommentList();
			}) // 앞에는 파라미터 뒤에는 변수명
		});
	</script>
</body>
</html>