/**
 * 
 */
const btn = document.getElementById("btn");

btn.addEventListener("click", function() {
	const title = document.getElementById("title");
	const writer = document.getElementById("writer");
	const frm = document.getElementById("frm");

	const t1 = document.getElementById("t_1");
	const w1 = document.getElementById("w_1");
	
	t1.innerText = "";
	w1.innerText = "";

	let t = title.value;
	let w = writer.value;
	let title_check = true;
	let write_check = true;

	if (t == "") {
		id_check = false;
		t1.innerText = `필수입력 + ${title_check}`;
	}
	if (w == "") {
		pw_check = false;
		w1.innerText = `필수입력 + ${write_check}`;
	}

	if (title_check == true && write_check == true) {
		frm.submit();
	}
	else if (title_check == false && write_check == false) {
		alert("제목과 내용을 입력하세요.")
	}
	else if (title_check == false) {
		alert("제목을 입력하세요.");
	}
	else if (write_check == false) {
		alert("내용을 입력하세요.");
	}



});