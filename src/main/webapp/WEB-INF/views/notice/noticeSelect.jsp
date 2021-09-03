<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/header.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/nav.jsp"></c:import>

num : ${num.num}
title : ${num.title}
con : ${num.contents}

<a href="./noticeDelete?num=${num.num}"><button>삭제</button></a>
</body>
</html>