/**
 * 
 */
 const btn = document.getElementById("btn");
 const c1 = document.getElementsByClassName("c1");
 const writer = document.getElementById("writer");
 

 
 let ar = ['a','b','c'];
 
/*for(let i in c1) {
	let id = document.getElementById(`id${i}`);
	id.addEventListener("click", function(){
		alert(`id${i}`);
	})
}*/

for(let s of c1) {
	s.addEventListener("click", function(){
		let num = s.dataset.writerNum;
		alert(num);
	});
}

 
 btn.addEventListener("click", function(){
/*	for(let i = 0; i<ar.length; i++) {
		console.log(ar[i]);
	}*/
/*	for(let i of ar) {
		console.log(i);
	}*/
/*	ar.forEach(function(v, i){
		console.log(v, i);
	});*/
	/*c1.forEach(function(v){
		console.log(v);
	});*/
	/*for(let i = 0; i<c1.length; i++) {
		console.log(c1[i]);
	}*/
/*	for(let i of c1) {
		console.log(i.innertext);
	}*/	
});
 