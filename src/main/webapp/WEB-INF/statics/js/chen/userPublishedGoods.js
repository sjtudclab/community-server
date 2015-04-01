$(document).ready(function(){
	//alert("获取用户物品信息");
	var userID = 1;
	$.ajax({
		url:getUrl("rest/publish/")+userID,
		type:"get",
		dataType:"json",
		success:function(obj){
			console.log("success:"+obj);
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

			$("#unfinished_goods").append(goodsList);
		},

		error:function(){
			alert("获取用户:"+userID+"物品信息失败");
		}

	});
});