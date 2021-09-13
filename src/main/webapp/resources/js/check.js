/**
 * 
 */
const check = document.getElementsByClassName("check");
const checkAll = document.getElementById("checkAll");
const btn = document.getElementById("btn");

checkAll.addEventListener("click", function() {
	for(let i of check) {
		i.checked = checkAll.checked;
	}
});

for(let i of check) {
	i.addEventListener("click", function(){
		let result = true;
		for(c of check){
			if(!c.checked){
				result = false;
				break;
			}
		}
		checkAll.checked = result;
	})
} 

btn.addEventListener("click", function(){
	if(checkAll.checked == true) {
		location.href = "./join";
	}
	else{
		alert("필수약관에 동의하셔야 합니다.");
	}
})
