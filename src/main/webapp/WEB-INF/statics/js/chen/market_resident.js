/* JS API for market resident
 * get and send data
 */

function get_latest_market_data(success, failure) {
	$.ajax({
		url:getUrl("rest/SecondGoods/latest"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},
		error:function(){
			alert("获取物品信息失败");
		}
	});
};

function check_market_thing(goodsID) {
	location.href = getUrl("resident/market_thing_info?id=" + goodsID);
};

function get_thing_data(goodsID, success, failure) {
	$.ajax({
		url:getUrl("rest/SecondGoods/") + goodsID,
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},
		error:function(){
			alert("获取物品"+goodsID+"信息失败");
		}
	});
};

function send_click_love_data(user_id, goods_id) {
	$.ajax({
		url:getUrl("rest/love/add"),
		type:"get",
		//dataType:"json",
		data:{userID:user_id, goodsID:goods_id},
		success:function(data){
			console.log(data);
		},
		error:function(){
			alert("关注物品失败");
		}
	});
};

function get_user_love_data(user_id, success, failure) {
	$.ajax({
		url:getUrl("rest/love/")+user_id,
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},
		error:function(){
			alert("获取用户:"+userID+"关注的物品信息失败");
		}
	});
};

function get_user_publish_data(user_id, success, failure) {
	$.ajax({
		url:getUrl("rest/publish/")+user_id,
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},

		error:function(){
			alert("获取用户:"+user_id+"物品信息失败");
		}

	});
};

function get_search_data(content, success, failure){
	$.ajax({
		url:getUrl("rest/SecondGoods/search/") + content,
		type:"get",
		dataType:"json",
		success:function(obj) {
			if (typeof success == "function") {
				success(obj);
			}
		},
		error:function() {
			alert("搜索信息失败");
		}
	});
};