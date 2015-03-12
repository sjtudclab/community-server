$(document).ready(function(){

	$("body").on("click", "#love_thing", function(){
		$("#love_thing").removeClass("primary");
		$("#love_thing").text("已关注");
		$("#love_thing").attr("disabled", true); 
		alert("用户:"+$("#user_id").text()+" 已关注物品:"+$("#goods_id").text());

		$.ajax({
			url:"/community-server/rest/love/add",
			type:"get",
			//dataType:"json",
			data:{userID:$("#user_id").text(), goodsID:$("#goods_id").text()},
			success:function(data){
				console.log(data);
			},
			error:function(){
				alert("关注物品失败");
			}
		});

	});
});