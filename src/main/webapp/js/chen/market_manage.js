$(document).ready(function(){
	$("#goods_finished").css("display", "none");
	$("#goods_unfinished").css("display", "none");
	$("#comment_repair").css("display", "none");

	$("#l1").click(function(){
		$("#l1").addClass("active");
		$("#l2").removeClass("active");
		$("#l3").removeClass("active");
		$("#goods_unfinished").css("display", "block");
		$("#goods_finished").css("display", "none");
		$("#comment_repair").css("display", "none");
		$("#welcome_repair").css("display", "none");

		$.ajax({
			url:"rest/SecondGoods/stage/1",
			type:"get",
			dataType:"json",
			success:function(obj){
				$("#goods_unfinished_list").empty();

				var goodsList = "";

				$.each(obj, function (n, value) {
					var goods = "";

					goods += 
					"<div class=\"row goods\">" +
                        "<a href=\"\">" +
	                        "<div class=\"span8\">" +
	                        decodeURI(value.title) +
	                        "</div>" +
	                        "<div class=\"span4\">" +
	                        "<span>"+decodeURI(value.owner)+"</span>" +
	                        "</div>" +
                        "</a>" +										
                    "</div>";

					goodsList += goods;
				});

				$("#goods_unfinished_list").append(goodsList);
			},
			error:function(){
				alert("获取待审核物品信息失败");
			}
		});
		
	});
	$("#l2").click(function(){
		$("#l2").addClass("active");
		$("#l1").removeClass("active");
		$("#l3").removeClass("active");
		$("#goods_finished").css("display", "block");
		$("#goods_unfinished").css("display", "none");
		$("#comment_repair").css("display", "none");
		$("#welcome_repair").css("display", "none");

		$.ajax({
			url:"rest/SecondGoods/stage/2",
			type:"get",
			dataType:"json",
			success:function(obj){
				$("#goods_finished_list").empty();

				var goodsList = "";

				$.each(obj, function (n, value) {
					var goods = "";

					goods += 
					"<div class=\"row goods\">" +
                        "<a href=\"\">" +
	                        "<div class=\"span8\">" +
	                        decodeURI(value.title) +
	                        "</div>" +
	                        "<div class=\"span4\">" +
	                        "<span>"+decodeURI(value.owner)+"</span>" +
	                        "</div>" +
                        "</a>" +										
                    "</div>";

					goodsList += goods;
				});

				$("#goods_finished_list").append(goodsList);
			},
			error:function(){
				alert("获取已审核物品信息失败");
			}
		});
	});


	$("#l3").click(function(){
		$("#l3").addClass("active");
		$("#l1").removeClass("active");
		$("#l2").removeClass("active");
		$("#comment_repair").css("display", "block");
		$("#goods_unfinished").css("display", "none");
		$("#goods_finished").css("display", "none");
		$("#welcome_repair").css("display", "none");
	});


});