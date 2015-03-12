$(document).ready(function(){
	//alert("Goods Info Page");

	$.extend({
	  getUrlVars: function(){
	    var vars = [], hash;
	    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
	    for(var i = 0; i < hashes.length; i++)
	    {
	      hash = hashes[i].split('=');
	      vars.push(hash[0]);
	      vars[hash[0]] = hash[1];
	    }
	    return vars;
	  },
	  getUrlVar: function(name){
	    return $.getUrlVars()[name];
	  }
	});

	// Get object of URL parameters
	//var allVars = $.getUrlVars();
	//console.log("parameters:"+allVars);
	 
	// Getting URL var by its nam
	$goodsID = $.getUrlVar('id');
	//alert("通过URL获取参数:" + $goodsID);

	$.ajax({
		url:"/community-server/rest/SecondGoods/" + $goodsID,
		type:"get",
		dataType:"json",
		success:function(obj){
			//console.log("success:"+obj);
			//alert(decodeURI(obj.title));
			
			$("#goods_id").html($goodsID);
			$("#user_id").html(1);         // 用户 ID

			$("#imagePath").attr("src", obj.imagePath);
			//$("#imagePath").attr("src", "images/11.jpg");
			$("#title").html(decodeURI(obj.title));
			$("#type").html(decodeURI(obj.type));
			$("#category").html(decodeURI(obj.category));
			$("#desc").html(decodeURI(obj.desc));
			$("#owner").html(decodeURI(obj.owner));
			$("#phone").html(decodeURI(obj.phone));
				
		},
		error:function(){
			alert("获取物品"+$goodsID+"信息失败");
		}
	});

});