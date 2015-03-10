$(document).ready(function(){
	//alert("Welcome Second Goods");
	/*$.ajax({
		url:"/archetype-server/rest/SecondGoods/3",
		type:"get",
		dataType:"json",
		success:function(data){
			console.log("id:"+data.id+
					" category:"+decodeURI(data.category)+
					" type:"+decodeURI(data.type)+
					" title:"+decodeURI(data.title)+
					" imagePath:"+decodeURI(data.imagePath)+
					" desc:"+decodeURI(data.desc) );
			alert("success");
		},
		error:function(){
			alert("获取 信息失败");
		}

	});*/
	
	$.ajax({
		url:"/archetype-server/rest/SecondGoods/latest",
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

			$("#latestSecondGoods").append(goodsList); // 显示最新发布的物品

			//alert("xixi latest length:"+obj.length);
		},
		error:function(){
			alert("获取物品信息失败");
		}
	});

	// 查看物品详细信息
	$("body").on("click", ".goods", function(){
		$goodsID = $(this).find("div").eq(1).find("span").eq(1).text();
		//alert("id:"+$goodsID);
		location.href = "market_thing_info.html?id=" + $goodsID;

	});



	
});