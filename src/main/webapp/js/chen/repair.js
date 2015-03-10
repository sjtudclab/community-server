$(document).ready(function(){
	$("#fill_form").css("display", "none");
	$("#check_progress").css("display", "none");
	$("#comment_repair").css("display", "none");

	$("#l1").click(function(){
		$("#l1").addClass("active");
		$("#l2").removeClass("active");
		$("#l3").removeClass("active");
		$("#check_progress").css("display", "block");
		$("#fill_form").css("display", "none");
		$("#comment_repair").css("display", "none");
		$("#welcome_repair").css("display", "none");

		
		
	});
	$("#l2").click(function(){
		$("#l2").addClass("active");
		$("#l1").removeClass("active");
		$("#l3").removeClass("active");
		$("#fill_form").css("display", "block");
		$("#check_progress").css("display", "none");
		$("#comment_repair").css("display", "none");
		$("#welcome_repair").css("display", "none");
	});
	$("#l3").click(function(){
		$("#l3").addClass("active");
		$("#l1").removeClass("active");
		$("#l2").removeClass("active");
		$("#comment_repair").css("display", "block");
		$("#check_progress").css("display", "none");
		$("#fill_form").css("display", "none");
		$("#welcome_repair").css("display", "none");
	});

});