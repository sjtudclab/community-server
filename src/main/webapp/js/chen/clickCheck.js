$(document).ready(function(){

	$("body").on("click", "#agree_thing", function(){
		$("#agree_thing").removeClass("primary");
		$("#agree_thing").text("已审核");
		$("#agree_thing").attr("disabled", true);
		$("#unagree_thing").css("display", "none");
		alert("用户:"+$("#user_id").text()+" 已审核物品:"+$("#goods_id").text());

		
		$.ajax({
			url:"rest/SecondGoods/stage/update",
			type:"get",
			//dataType:"json",
			data:{goodsID:$("#goods_id").text(), stage:"2"},
			success:function(data){
				console.log(data);
			},
			error:function(){
				alert("审核物品失败");
			}
		});

	});

	$("body").on("click", "#unagree_thing", function(){
		$("#unagree_thing").removeClass("primary");
		$("#unagree_thing").text("已审核");
		$("#unagree_thing").attr("disabled", true);
		$("#agree_thing").css("display", "none");
		alert("用户:"+$("#user_id").text()+" 已审核物品:"+$("#goods_id").text());

		$.ajax({
			url:"rest/SecondGoods/stage/update",
			type:"get",
			//dataType:"json",
			data:{goodsID:$("#goods_id").text(), stage:"3"},
			success:function(data){
				console.log(data);
			},
			error:function(){
				alert("审核物品失败");
			}
		});
	});

});