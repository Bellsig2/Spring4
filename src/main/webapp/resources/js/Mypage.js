/**
 * 
 */
 
const update = document.getElementsByClassName("update");
const update_btn = document.getElementById("update_btn");
const frm = document.getElementsByClassName("frm");

update_btn.addEventListener("click", function(){
	for(let i of update) {
	if(i.value == "") {
		alert("공란을 채워주세요");
		break;
	}
	else {
		frm.submit();
	}
}	
})
