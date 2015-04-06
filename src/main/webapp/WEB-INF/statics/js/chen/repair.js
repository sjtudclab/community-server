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


$id="1";

function order_submit(){
	$type = $("#fill_form_type").val();
	$address = $("#fill_form_address")[0].value;
	$name = $("#fill_form_name")[0].value;
	$phone = $("#fill_form_phone")[0].value;
	$serve_id = $("#fill_form_serve_id").val();
	
	alert($address+" "+$name+" "+$phone+" "+$type+" "+$serve_id);

	$.ajax({
		url:getUrl("rest/tenement/user/order/create"),
		type:"post",
		//dataType:"json",
		data:{user_id:"1", type:$type, address:$address, contact_name:$name, contact_phone:$phone, serve_id:$serve_id},
		success:function(){
			alert("提交物业报修单成功");
			$("#fill_form_address").val("");
			$("#fill_form_name").val("");
			$("#fill_form_phone").val("");
		},
		error:function(){
			alert("提交物业报修单失败");
		}
	});

	return;

};

function order_cancel(){
	alert("取消物业报修单");
	$("#fill_form_address").val("");
	$("#fill_form_name").val("");
	$("#fill_form_phone").val("");

	return;
};

function check_order() 
{
	//alert("查看报修记录");


	$.ajax({
		url:getUrl("rest/tenement/"+$id+"/order/check"),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#order_data").empty();

			var order_data = "";
			order_data += 
				"<table class=\"table hovered\">"+
				"<thead><tr><th>报修单号</th><th>报修项目</th><th>维修人员</th><th>状态</th></tr></thead>"+
				"<tbody>";

			
			$.each(obj, function (n, value) {
				var order = "";
				order += 
				"<tr><td>"+value.order_id+"</td>"+
					"<td>"+value.order_name+"</td>"+
					"<td>"+value.serve_id+"</td>"+
					"<td>"+value.stage+"</td>"+
				"</tr>";

				order_data += order;
			});


			order_data += "</tbody></table>";
			$("#order_data").append(order_data);
		},
		error:function(){

		}
	});



	return;
};


function get_finished_order(){
	//alert("评价物业服务");

	//获取已完成的物业报修单号
	$.ajax({
		url:getUrl("rest/tenement/"+$id+"/order/finished"),
		type:"get",
		dataType:"json",
		success:function(obj){

			$("#comment_order_id").empty();

			$.each(obj, function (n, value) {
				$("#comment_order_id").append("<option>" + value.order_id + "</option>");
			});

		},
		error:function(){

		}
	});


	return;
};


function comment_order(){
	$order_id = $("#comment_order_id").val();
	$score = $('input[name="star"]:checked').val();
	$comment = $("#user_comment").val();

	alert("提交对"+$order_id+"的评价");

	$.ajax({
		url:getUrl("rest/tenement/user/order/comment"),
		type:"post",
		dataType:"json",
		data:{order_id:$order_id, user_score:$score, user_comment:$comment},
		success:function(){

		},
		error:function(){}
	});

	return;
}