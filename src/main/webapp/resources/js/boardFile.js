/**
 * 
 */

 let files = '<div class="input-group mb-3">';
 files = files + '<input type="file" class="form-control" name = "files"';
 files = files + '<button class="btn btn-outline-secondary del" type="button">X</button>';
 files = files + '</div>';
 
/* let files = '<div class="input-group mb-3">';
 files = files + '<input type="file" class="form-control">';
 files = files + '  <button class="btn btn-outline-secondary del" type="button">X</button>';
 files = files + '</div>';*/

let count = 0;


$("#add_btn").click(function() {
	if(count<5){
		count++;
		$("#fileAddResult").append(files);
	}
	else {
		alert("최대 5개 까지만 가능");
	}
})

$("#fileAddResult").on('click', '.del' ,function(){
	$(this).parent().remove();
	count--;
});