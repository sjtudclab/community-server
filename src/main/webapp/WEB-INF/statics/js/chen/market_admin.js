/* JS API for market resident
 * get and send data
 */

function get_unchecked_data(success, failure) {
	$.ajax({
		url:getUrl("rest/SecondGoods/stage/1"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},
		error:function(){
			alert("获取待审核物品信息失败");
		}
	});
};

function get_checked_data(success, failure) {
	$.ajax({
		url:getUrl("rest/SecondGoods/stage/2"),
		type:"get",
		dataType:"json",
		success:function(obj){
			if (typeof success == "function") {
				success(obj);
			}
		},
		error:function(){
			alert("获取已审核物品信息失败");
		}
	});
};

function check_pass(goods_id) {
	$.ajax({
		url:getUrl("rest/SecondGoods/stage/update"),
		type:"get",
		//dataType:"json",
		data:{goodsID:goods_id, stage:"2"},
		success:function(data){
			console.log(data);
		},
		error:function(){
			alert("审核物品失败");
		}
	});
};

function check_unpass(goods_id) {
	$.ajax({
		url:getUrl("rest/SecondGoods/stage/update"),
		type:"get",
		//dataType:"json",
		data:{goodsID:goods_id, stage:"3"},
		success:function(data){
			console.log(data);
		},
		error:function(){
			alert("审核物品失败");
		}
	});
};