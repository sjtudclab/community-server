$(document).ready(function(){
	// 查看物品详细信息
	$("body").on("click", ".goods", function(){
		$goodsID = $(this).find("div").eq(1).find("span").eq(1).text();
		//alert("id:"+$goodsID);
		location.href = "market_thing_info.html?id=" + $goodsID;

	});
});

function search_goods(){
	alert("开始搜索物品");
	var content = $("#search_input")[0].value;
	$.ajax({
		url:getUrl("rest/SecondGoods/search/") + content,
		type:"get",
		dataType:"json",
		success:function(obj) {
			$("#search_goods").empty();
			
			var goodsList = "";
			if (obj.length > 0) {
				$.each(obj, function (n, value) {
					//alert(n +" "+ value.title);
					var goods = "";
					goods +=
					"<div class=\"tile double goods\">" +                // class goods用于查看物品的详细信息
	                    "<div class=\"tile-content image\">" +
	                        "<img src=\""+value.imagePath+"\">" +
	                    "</div>" +

	                    "<div class=\"brand bg-dark opacity\">" +
	                        "<span class=\"text\">"+decodeURI(value.title)+"</span>" + 
	                        "<span style=\"display:none\">"+value.id+"</span>" +
	                    "</div>" +
	                "</div>";

	                goodsList += goods;
				});
			}
			else{
				goodsList = "<h2>暂时未搜索到物品信息</h2>";
			}

			$("#search_goods").append(goodsList);

		},
		error:function() {
			alert("搜索信息失败");
		}
	});
	return;
};
