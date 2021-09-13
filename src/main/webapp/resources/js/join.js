/**
 * 
 */

const id = document.getElementById("id");
const all = document.getElementsByClassName("all");
const btn = document.getElementById("btn");
const pw = document.getElementsByClassName("pw");
const frm = document.getElementById("frm");
const idCheck = document.getElementById("idCheck");

idCheck.addEventListener("click", function() {
	open("./idCheck?id=" + id.value, "", "width = 400, height=200, top=200, left=300");
});


/*id.addEventListener("keyup", function(){
	if(id.value.length<6){
		document.getElementById("idResult").innerText = "6글자 이하입니다"
	}
	else{
		document.getElementById("idResult").innerText = "6글자 이상입니다."
	}
})*/

/*id.addEventListener("blur", function(){
	id.value = "";
})
*/
id.addEventListener("blur", function() {
	if (id.value.trim().length < 6) {
		document.getElementById("idResult").innerHTML = "아이디가 6글자 미만입니다."
		id.focus();
	}
});


document.getElementById("pwcheck").addEventListener("blur", function() {
	if (pw[0].value != pw[1].value) {
		document.getElementById("pwResult").innerHTML = "비밀번호가 같지 않습니다.";
		pw[0].focus();
	}
})


btn.addEventListener("click", function() {
	let check = checkEmpty(all);
	let check2 = checkEqual(pw[0].value, pw[1].value);
	let c1 = checkLength();

	if (check && check2 && c1) {
		frm.submit();
	}
	else  {
		alert("필수입력하세요.");
	}
})

function checkLength() {
	let l = pw[0].value.trim().length;
	if (l >= 6) {
		return true;
	}
	else {
		return false;
	}
}


function checkEmpty(alls) {
	let check = true;
	for (let i of alls) {
		if (i.value == "") {
			check = false;
			break;
		}
	}
	return check;
}

function checkEqual(check1, check2) {
	return check1 == check2;
}

