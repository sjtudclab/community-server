/* api for tenement management
 * get data from server
 */

function get_all_serve_id(success, failure){
	$.ajax({
		url:getUrl("rest/tenement/serving/application/all"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},
	});
};

function get_serviceman_apply(serve_id, success, failure){

	$.ajax({
		url:getUrl("rest/tenement/serving/"+serve_id+"/application/check"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		}
	});
};

function pass_serviceman(serve_id, success, failure){
	$.ajax({
		url:getUrl("rest/tenement/serving/application/"+serve_id+"/pass"),
		type:"post",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		}
	});
};

function unpass_serviceman(serve_id, success, failure){
	$.ajax({
		url:getUrl("rest/tenement/serving/application/"+serve_id+"/unpass"),
		type:"post",
		dataType:"json",
		success:function(){
			if (typeof success == "function") {
				success(obj);
			}
		}
	});
};

function get_comment_order_id(success, failure){
	$.ajax({
		url:getUrl("rest/tenement/all/order/commented"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		}
	});
};

function get_selected_comment(order_id, success, failure){
	$.ajax({
		url:getUrl("rest/tenement/order/comment/"+order_id),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		}
	});
};

function get_all_order_id(success, failure){
	$.ajax({
		url:getUrl("rest/tenement/all/order"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		}
	});
};

function get_selected_order(order_id, success, failure){
	$.ajax({
		url:getUrl("rest/tenement/one/order/"+order_id),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		}
	});
};

function get_serviceman_info(success, failure){
	$.ajax({
		url:getUrl("rest/tenement/manage/serviceman/all"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		}
	});
};
