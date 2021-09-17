/**
 * 
 */

$('#id').blur(function() {
	let id = $('#id').val();
	$.get('./idCheckAjax?id='+id, function(data){
		if(data.trim()=='1') {
			$('#idResult').html('사용 가능');
		}else {
			$('#idResult').html('사용 불가능');
		}
	});
})

$("#btn").click(function() {
	let result = true;
	let t;
	$(".all").each(function(s1, s2) {
		if ($(s2).val() == "") {
			result = false;
			t = s2;
		}
	});

	if (result) {
		alert('submit');
	}
	else {
		alert('필수입력');
		$(t).focus();
	}
})


