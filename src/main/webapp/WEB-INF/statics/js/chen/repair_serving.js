$serve_id="1";

$(document).ready(function(){
	$("#fill_form").css("display", "none");
	$("#check_progress").css("display", "none");
	$("#check_order").css("display", "none");
	$("#record_serving").css("display", "none");

	$("#l1").click(function(){
		$("#l1").addClass("active");
		$("#l2").removeClass("active");
		$("#l3").removeClass("active");
		$("#l4").removeClass("active");
		$("#check_progress").css("display", "block");
		$("#fill_form").css("display", "none");
		$("#check_order").css("display", "none");
		$("#record_serving").css("display", "none");
		
	});
	$("#l2").click(function(){
		$("#l2").addClass("active");
		$("#l1").removeClass("active");
		$("#l3").removeClass("active");
		$("#l4").removeClass("active");
		$("#fill_form").css("display", "block");
		$("#check_progress").css("display", "none");
		$("#check_order").css("display", "none");
		$("#record_serving").css("display", "none");

	});
	$("#l3").click(function(){
		$("#l3").addClass("active");
		$("#l1").removeClass("active");
		$("#l2").removeClass("active");
		$("#l4").removeClass("active");
		$("#check_order").css("display", "block");
		$("#check_progress").css("display", "none");
		$("#fill_form").css("display", "none");
		$("#record_serving").css("display", "none");
	});

	$("#l4").click(function(){
		$("#l4").addClass("active");
		$("#l3").removeClass("active");
		$("#l1").removeClass("active");
		$("#l2").removeClass("active");
		$("#record_serving").css("display", "block");
		$("#check_order").css("display", "none");
		$("#check_progress").css("display", "none");
		$("#fill_form").css("display", "none");
	});

	$("body").on("click", ".info", function() {
		$order_info = $(this).parent().parent();
		$order_id = $(this).parent().parent().find("td").eq(0).text();
		//console.log($order_id.text());		
		$.ajax({
			url:getUrl("rest/tenement/order/"+$order_id+"/accepted"),
			type:"post",
			success:function(){
				$order_info.remove();
			},
			error:function(){}
		});

	});

});



function application_submit(){

	$real_name = $("#real_name")[0].value;
	$contact_address = $("#contact_address")[0].value;
	$contact_phone = $("#contact_phone")[0].value;
	$description = $("#description").val();
	$certification = $('input[name="certification"]:checked').val();
	$serve_time = $("#serve_time").val();

	//console.log("申请物业维修数据："+$serve_id+" "+$real_name+" "+$certification+" "
	//	+$serve_time+" "+$contact_address+" "+$contact_phone+" "+$description);

	$.ajax({
		url:getUrl("rest/tenement/serving/user/application/create"),
		type:"post",
		data:{serve_id:$serve_id,real_name:$real_name,certification:$certification,serve_time:$serve_time,address:$contact_address,phone:$contact_phone,description:$description},
		success:function(){
			alert("提交成功");
			$("#real_name").val("");
			$("#contact_address").val("");
			$("#contact_phone").val("");
			$("#description").val("");
		},
		error:function(){
			alert("提交申请信息失败");
		}
	});


	return;
};

function application_cancel(){
	alert("取消申请");

	$("#real_name").val("");
	$("#contact_address").val("");
	$("#contact_phone").val("");
	$("#description").val("");

	return;
};

function application_check(){

	$.ajax({
		url:getUrl("rest/tenement/serving/"+$serve_id+"/application/check"),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#progress_status").html(obj.stage);
			$("#progress_name").html(obj.real_name);
			$("#progress_serve_time").html(obj.serve_time);
			$("#progress_cert").html(obj.certification);
			$("#progress_address").html(obj.contact_address);
			$("#progress_phone").html(obj.contact_phone);
			$("#progress_desc").html(obj.description);

		},
		error:function(){}
	});

	return;

};

function get_service_order(){

	$.ajax({
		url:getUrl("rest/tenement/serving/"+$serve_id+"/order/initial"),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#order_data").empty();

			var order_data = "";
			order_data += 
				"<table class=\"table hovered\">"+
				"<thead><tr><th>报修单号</th><th>报修项目</th><th>地址</th><th>联系人</th><th>联系电话</th><th></th></tr></thead>"+
				"<tbody>";

			
			$.each(obj, function (n, value) {
				var order = "";
				order += 
				"<tr><td>"+value.order_id+"</td>"+
					"<td>"+value.order_name+"</td>"+
					"<td>"+value.order_address+"</td>"+
					"<td>"+value.contact_name+"</td>"+
					"<td>"+value.contact_phone+"</td>"+
					"<td>"+"<button class=\"button small info\">接收</button>"+"</td>"+
				"</tr>";

				order_data += order;
			});


			order_data += "</tbody></table>";
			$("#order_data").append(order_data);

		},
		error:function(){}
	});

	return;
}

function save_order_record(){
	$order_id = $("#serve_order_id").val();
	$record = $("#serve_record").val();

	alert("提交对维修单:"+$order_id+"的记录状况");

	$.ajax({
		url:getUrl("rest/tenement/serving/order/record"),
		type:"post",
		dataType:"json",
		data:{order_id:$order_id, record:$record},
		success:function(){
			$("#serve_record").val('');
		}
	});

	return;
};

function get_accepted_order() {
	// body...
	$.ajax({
		url:getUrl("rest/tenement/serving/"+$serve_id+"/order/accepted"),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#serve_order_id").empty();

			$.each(obj, function (n, value) {
				$("#serve_order_id").append("<option>" + value.order_id + "</option>");
			});
		},
		error:function(){}
	});

	return;
};
