/* JS API for tenement resident
 * get and receive data from server
 */

function order_data_submit(id,type,address,name,phone,serve_id){
	
	$.ajax({
		url:getUrl("rest/tenement/user/order/create"),
		type:"post",
		//dataType:"json",
		data:{user_id:id, type:type, address:address, contact_name:name, contact_phone:phone, serve_id:serve_id},
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

};

function check_order_data(id, success, failure) {
	
	$.ajax({
		url:getUrl("rest/tenement/"+id+"/order/check"),
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

function get_finished_order_data(id, success, failure){
	
	$.ajax({
		url:getUrl("rest/tenement/"+id+"/order/finished"),
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

function comment_order_data(order_id,score,comment){

	$.ajax({
		url:getUrl("rest/tenement/user/order/comment"),
		type:"post",
		dataType:"json",
		data:{order_id:order_id, user_score:score, user_comment:comment},
		success:function(){

		},
		error:function(){}
	});

};