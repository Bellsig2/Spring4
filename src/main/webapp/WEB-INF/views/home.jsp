<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript">
	alert('Hello world');
</script>
<link href="./resources/css/home.css" rel="stylesheet">
</head>
<body>
	<h1 class="c1">Hello world!</h1>
	<h1 id="d1">Other h1</h1>
	<div id="d2">
		<h3>In DIV</h3>
	</div>
	<button onclick="fn1()">click</button>
	<img class="c1" id="d3" alt="key" src="./resources/images/key2.jpg">
	<P>The time on the server is ${serverTime}.</P>

	<script type="text/javascript" src="./resources/js/home.js">
		console.log('body Script');
	</script>
	<script type="text/javascript" src="./resources/js/function_1.js">
		
	</script>
</body>
</html>
