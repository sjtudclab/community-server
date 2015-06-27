/* JavaScript function api for tenement serving
 * get and post data
 */

function application_data_submit(serve_id,real_name,contact_address,contact_phone,
		description,certification,serve_time){

	//console.log("申请物业维修数据："+$serve_id+" "+$real_name+" "+$certification+" "
	//	+$serve_time+" "+$contact_address+" "+$contact_phone+" "+$description);

	$.ajax({
		url:getUrl("rest/tenement/serving/user/application/create"),
		type:"post",
		data:{serve_id:serve_id,real_name:real_name,certification:certification,serve_time:serve_time,address:contact_address,phone:contact_phone,description:description},
		success:function(){
			alert("提交申请信息成功");
			$("#real_name").val("");
			$("#contact_address").val("");
			$("#contact_phone").val("");
			$("#description").val("");
		},
		error:function(){
			alert("提交申请信息失败");
		}
	});


};

function application_data_check(serve_id, success, failure){

	$.ajax({
		url:getUrl("rest/tenement/serving/"+serve_id+"/application/check"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},
		error:function(){}
	});

};

function get_service_order_data(serve_id, success, failure){

	$.ajax({
		url:getUrl("rest/tenement/serving/"+serve_id+"/order/initial"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},
		error:function(){}
	});

};

function save_order_record_data(order_id, record){

	$.ajax({
		url:getUrl("rest/tenement/serving/order/record"),
		type:"post",
		dataType:"json",
		data:{order_id:order_id, record:record},
		success:function(){
			$("#serve_record").val('');
		}
	});

};

function get_accepted_order_data(serve_id, success , failure) {
	$.ajax({
		url:getUrl("rest/tenement/serving/"+serve_id+"/order/accepted"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},
		error:function(){}
	});

};