$(document).ready(function()){
	$("table").hide();

	$("#userManagement").click(function(){
		$.get("users",function(data))
	});
}