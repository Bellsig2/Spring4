/**
 * 
 */

const c1 = document.getElementsByClassName("c1");
const btn = document.getElementById("btn");



for (let i of c1) {
	i.addEventListener("click", function() {
		if (i.checked) {
			alert(i.value);
		}
	});
}
for (let i of c1) {
	i.checked = true;
}
