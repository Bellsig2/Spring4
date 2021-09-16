/**
 * 
 */

$("#btn").click(function() {
	let result = true;
	let t;
	$(".all").each(function(s1, s2) {
		if ($(s2).val() == "") {
			result = false;
			t = s2;
		}
	});
	
	if(result) {
		alert('submit');
	}
	else {
		alert('필수입력');
		$(t).focus();
	}
})


