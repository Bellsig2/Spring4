let d3 = document.getElementById("d3");


function fn1() {
	alert("d3")
}

let fn2 = function() {
	alert("익명함수");
	fn1();
}


d3.addEventListener("mouseleave", fn1);
d3.addEventListener("mouse")