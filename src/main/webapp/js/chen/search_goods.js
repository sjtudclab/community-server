
function search_goods(){
	alert("开始搜索物品");
	var content = $("#search_input")[0].value;
	$.ajax({
		url:"rest/SecondGoods/search/" + content,
		type:"get",
		dataType:"json",
		success:function(obj) {
			$("#search_goods").empty();
			var goodsList = "";
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

			$("#search_goods").append(goodsList);

		},
		error:function() {
			alert("搜索信息失败");
		}
	});
	return;
};
