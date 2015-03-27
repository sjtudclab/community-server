$(document).ready(function(){
	var body = $("table tbody");
	body.hide();
	$("#personnelManagement").click(function(){
		//var username = $.cookie("username");
		$.get("rest/users/" + "admin",function(data,status){
			$(data).each(function(){
				body.append("<tr class='pending-user'>");
				
				body.append("<td>" + data.id + "</td>");
				body.append("<td>" + data.username + "</td>");
				var roleNames = "";
				$.each(data.roles,function(n,value){
					roleNames += value.name;
				});
				body.append("<td>" + roleNames + "</td>");
				body.append("<td><span class='user-actions'>" +
						"<a href='javascript:void(0);' class='label label-success'>Approve</a>" +
						" <a href='javascript:void(0);' class='label label-important'>Reject</a>" +
						"</span></td>");
				
				body.append("</tr>")
			});
			
			body.show();
		});
	});
});