/**
 * 
 */


$("#checkAll").click(function(){
	$(".check").prop("checked", $("this").prop("checked"));
});

$(".check").click(function(){
	$(".check").each(function(v1,v2){
		if(!$(v2).prop("checked")){
			result=false;
			console.log(v1, $(v2).prop("checked"));
		}
	});
	$("#checkAll").prop("checked", result);
});

$("#btn").click(function(){
	if($("#checkAll").prop("checked")) {
		location.href="join";
		}else {
			alert('약관동의 필수');
		}
	})