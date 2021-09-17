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
	
	<h1>List Page</h1>

<div class="col-md-7 my-2 mx-auto">	
		<!-- search Form Start-->
		<form action="./list" method="get">
		
		 <div class="input-group mb-3" >
		  <select name="kind" class="form-select form-select-sm" aria-label=".form-select-sm example">
			  <option value="k1">Title</option>
			  <option value="k2">Contents</option>
			  <option value="k3">Writer</option>
		  </select>
		  
		  <input type="text" name="search" class="form-control" aria-label="Text input with dropdown button">
		  <button type="submit" class="btn btn-outline-secondary">Search</button>
		</div>
			
		</form>



	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">NUM</th>
	      <th scope="col">TITLE</th>
	      <th scope="col">WRITER</th>
	      <th scope="col">REGDATE</th>
	      <th scope="col">HITS</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${list}" var="dto" varStatus="i">
		    <tr>
		      <th scope="row">${dto.num}</th>
		     <td><span class="c1" data-writer-num="${i.index}">
		      
		      <c:catch>
			      <c:forEach begin="1" end="${dto.depth}">
			      	--
			      </c:forEach>
		      </c:catch>
		      
		      <a href="./select?num=${dto.num}">${dto.title}</a></span></td>
		      <td id="writer${i.index}">${dto.writer}</td>
		      <td>${dto.regDate}</td>
		      <td>${dto.hits}</td>
		    </tr>
	   </c:forEach>
	  </tbody>
	</table>
	
<!-- Pageing -->
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		      <a class="page-link" href="./list?kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    
		   	<li class="page-item">
		      <a class="page-link" href="./list?pn=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&lt;</span>
		      </a>
		    </li>
		    
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
				<li class="page-item"><a class="page-link" href="./list?pn=${n}&kind=${pager.kind}&search=${pager.search}">${n}</a></li>
			</c:forEach>
			
			<li class="page-item">
		      <a class="page-link" href="./list?pn=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&gt;</span>
		      </a>
		    </li>
		   
		    <li class="page-item">
		      <a class="page-link" href="./list?pn=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	 <!-- <button id="btn">CLICK</button>	  -->
	 <%-- <c:if test="${not empty member}"> --%>
		<button id="btn"> <a href="./insert" class="btn btn-secondary">ADD</a></button>	 
<%-- 	 </c:if> --%>

</div>	
	
	<script type="text/javascript" src="../resources/js/list.js"></script>
</body>
</html>