$id = "1";

$(document).ready(function(){
	$("#manage_prove").css("display", "none");
	$("#manage_serviceman").css("display", "none");
	$("#manage_comment").css("display", "none");
	$("#manage_serving_progress").css("display", "none");

	$("#l1").click(function(){
		$("#l1").addClass("active");
		$("#l2").removeClass("active");
		$("#l3").removeClass("active");
		$("#l4").removeClass("active");
		$("#manage_prove").css("display", "block");
		$("#manage_serviceman").css("display", "none");
		$("#manage_comment").css("display", "none");
		$("#manage_serving_progress").css("display", "none");
	});

	$("#l2").click(function(){
		$("#l1").removeClass("active");
		$("#l2").addClass("active");
		$("#l3").removeClass("active");
		$("#l4").removeClass("active");
		$("#manage_prove").css("display", "none");
		$("#manage_serviceman").css("display", "block");
		$("#manage_comment").css("display", "none");
		$("#manage_serving_progress").css("display", "none");
	});

	$("#l3").click(function(){
		$("#l1").removeClass("active");
		$("#l2").removeClass("active");
		$("#l3").addClass("active");
		$("#l4").removeClass("active");
		$("#manage_prove").css("display", "none");
		$("#manage_serviceman").css("display", "none");
		$("#manage_comment").css("display", "block");
		$("#manage_serving_progress").css("display", "none");
	});

	$("#l4").click(function(){
		$("#l1").removeClass("active");
		$("#l2").removeClass("active");
		$("#l3").removeClass("active");
		$("#l4").addClass("active");
		$("#manage_prove").css("display", "none");
		$("#manage_serviceman").css("display", "none");
		$("#manage_comment").css("display", "none");
		$("#manage_serving_progress").css("display", "block");
	});

	$("body").on("click", ".default", function() {
		$serve_id = $(this).parent().parent().find("td").eq(0).text();
		alert("警告维修人员:"+$serve_id);
		$(".default").attr("disabled", true);
	});
});


function get_all_serve_id(){
	$.ajax({
		url:getUrl("rest/tenement/serving/application/all"),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#serve_id").empty();
			$("#serve_id").append("<option>请选择</option>");
			$.each(obj, function (n, value) {
				$("#serve_id").append("<option>" + value.serve_id + "</option>");
			});
		},
	});
	return;
};

function get_serviceman_apply(serve_id){

	$.ajax({
		url:getUrl("rest/tenement/serving/"+serve_id+"/application/check"),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#real_name").html(obj.real_name);
			$("#serve_time").html(obj.serve_time);
			$("#cert").html(obj.certification);
			$("#contact_address").html(obj.contact_address);
			$("#contact_phone").html(obj.contact_phone);
			$("#desc").html(obj.description);
		}
	});

	return;
};

function pass_serviceman(){
	$serve_id = $("#serve_id").val();
	$.ajax({
		url:getUrl("rest/tenement/serving/application/"+$serve_id+"/pass"),
		type:"post",
		dataType:"json",
		success:function(obj){
			alert("完成对"+$serve_id+"的审核");
		}
	});
	return;
};

function unpass_serviceman(){
	$serve_id = $("#serve_id").val();
	$.ajax({
		url:getUrl("rest/tenement/serving/application/"+$serve_id+"/unpass"),
		type:"post",
		dataType:"json",
		success:function(obj){
			alert("完成对"+$serve_id+"的审核");
		}
	});
	return;
};

function get_comment_order_id(){
	$.ajax({
		url:getUrl("rest/tenement/all/order/commented"),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#order_id").empty();
			$("#order_id").append("<option>请选择</option>");
			$.each(obj, function (n, value) {
				$("#order_id").append("<option>" + value.order_id + "</option>");
			});
		}
	});
	return;
};

function get_selected_comment(order_id){
	//alert(order_id);
	$.ajax({
		url:getUrl("rest/tenement/order/comment/"+order_id),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#order_serve_id").html(obj.serve_id);
			$("#order_score").html(obj.user_score);
			$("#order_comment").html(obj.user_comment);
		}
	});
	return;
};

function get_all_order_id(){
	$.ajax({
		url:getUrl("rest/tenement/all/order"),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#order_id_2").empty();
			$("#order_id_2").append("<option>请选择</option>");
			$.each(obj, function (n, value) {
				$("#order_id_2").append("<option>" + value.order_id + "</option>");
			});
		}
	});
	return;
};

function get_selected_order(order_id){
	$.ajax({
		url:getUrl("rest/tenement/one/order/"+order_id),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#progress_status").html(obj.stage);
			$("#progress_type").html(obj.order_name);
			$("#progress_address").html(obj.order_address);
			$("#progress_contact_name").html(obj.contact_name);
			$("#progress_contact_phone").html(obj.contact_phone);
		}
	});
	return;
};

function get_serviceman_info(){
	$.ajax({
		url:getUrl("rest/tenement/manage/serviceman/all"),
		type:"get",
		dataType:"json",
		success:function(obj){
			$("#serviceman_data").empty();

			var serviceman_data = "";
			serviceman_data += 
				"<table class=\"table hovered striped\">"+
				"<thead><tr>"+
				"<th class=\"text-left\">维修人员</th>"+
				"<th class=\"text-left\">维修次数</th>"+
				"<th class=\"text-left\">评分(0~5)</th>"+
				"<th class=\"text-left\"></th>"+
				"</tr></thead>"+
				"<tbody>";

			
			$.each(obj, function (n, value) {
				var person = "";
				person += 
				"<tr><td>"+value.serve_id+"</td>"+
					"<td class=\"right\">"+value.times+"</td>"+
					"<td class=\"right\">"+value.score+"</td>"+
					"<td class=\"right\">"+"<button class=\"default\">警告</button>"+"</td>"+
				"</tr>";

				serviceman_data += person;
			});


			serviceman_data += "</tbody></table>";
			$("#serviceman_data").append(serviceman_data);
		}
	});
	return;
};