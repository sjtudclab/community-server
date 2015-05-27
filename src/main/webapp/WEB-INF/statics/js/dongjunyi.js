/* @RequestMapping(Constants.REST + "/announcement/")
 * @RequestMapping(value="",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value="",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_announcement() {
	return getData("/announcement", "block info");
}
function post_announcement() {
}

/* @RequestMapping(Constants.REST + "/apartment/")
 * @RequestMapping(value="",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value="{id}/citizen",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_apartment(parameter, success, failure)
{
	$.ajax({
		url:getUrl("rest/apartment/" + parameter),
		type:"get",
		dataType:"json",
		success:function(data){
			if (typeof success == "function") {
				success(data);
			}
		},
		error:function(obj){console.log(obj);}
	});	
}
/* @RequestMapping(Constants.REST + "/block_info/")
 * @RequestMapping(value="manager",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_block_info(parameter) {
	return getData("/block_info/" + parameter, "block info");
}

/* @RequestMapping(Constants.REST + "/block_room/")
 * @RequestMapping(value="{block}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_block_room(parameter) {
	return getData("/block_room/" + parameter, "block room");
}

/* @RequestMapping(Constants.REST + "/buildings/")
 * @RequestMapping(value="",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value="{id}/apartments",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_buildings(parameter, success, failure)
{
	$.ajax({
        url: getUrl('rest/buildings/' + parameter),
        type:"get",
        dataType:"json",
        success:function(data){
            if (typeof success == "function") {
				success(data);
				}
        },
        error:function(){
        }
    }); 
}

/* @RequestMapping(Constants.REST + "/citizen")
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_citizen(success, failure)
{
	$.ajax({
		url:getUrl("rest/citizen"),
		type:"get",
		dataType:"json",
		success:function(data){
			if (typeof success == "function") {
				success(data);
			}
		},
		error:function(obj){console.log(obj);}
	});	
}

/* @RequestMapping(Constants.REST + "/managementCitizens/")
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_managementCitizens(parameter, success, failure)
{
	$.ajax({
		url:getUrl("rest/managementCitizens/"+parameter),
		type:"get",
		dataType:"json",
		success:function(users,status){
			if (typeof success == "function") {
				success(users,status);
			}
		},
		error:function(){}
	});	
}

function get_managementCitizens_owner(success, failure)
{
	$.ajax({
		url:getUrl("rest/managementCitizens/owner"),
		type:"get",
		dataType:"json",
		success:function(data){
			if (typeof success == "function") {
				success(data);
			}
		},
		error:function(obj){console.log(obj);}
	});	
}

function get_managementCitizens_tenement(success, failure)
{
	$.ajax({
		url:getUrl("rest/managementCitizens/tenement"),
		type:"get",
		dataType:"json",
		success:function(data){
			if (typeof success == "function") {
				success(data);
			}
		},
		error:function(obj){console.log(obj);}
	});	
}

function get_managementCitizens_committee(success, failure)
{
	$.ajax({
		url:getUrl("rest/managementCitizens/committee"),
		type:"get",
		dataType:"json",
		success:function(data){
			if (typeof success == "function") {
				success(data);
			}
		},
		error:function(obj){console.log(obj);}
	});	
}

function put_managementCitizens(data, success, failure)
{
	$.ajax({
			 type: "put",
			 url: getUrl("rest/managementCitizens"),
			 contentType: "application/json",
			 data: JSON.stringify(us),
			 success: function(data){
				 if (typeof success == "function") {
						success(data);
				 }
			 },
			 error: function(data){
				 alert('调整人事失败！');
			 }
		  }); 
}

/* @RequestMapping(Constants.REST + "/residentCitizens/")
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_residentCitizens(parameter) {
	return getData("/residentCitizens/" + parameter, "residentCitizens");
}

/* @RequestMapping(Constants.REST + "/serviceCitizens/")
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_serviceCitizens(parameter) {
	return getData("/serviceCitizens/" + parameter, "serviceCitizens");
}

/* @RequestMapping(Constants.REST + "/commissioner/")
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_commissioner(parameter) {
	return getData("/commissioner/" + parameter, "commissioner");
}

/* @RequestMapping(Constants.REST + "/activity/")
 * @RequestMapping(value="all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value="create",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_activity(parameter) {
	return getData("/activity/" + parameter, "activity");
}

/* @RequestMapping(Constants.REST + "/information/")
 * @RequestMapping(value="{type}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value="{type}/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "search/{keyword}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "block/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_information(parameter, success, failure)
{
	 $.ajax({
           type: "GET",
           url: getUrl('rest/information/'+parameter),
           dataType: "json",
           success: function(data) {
              if (typeof success == "function") {
				success(data);
				}
           },//success
           error: function(data) {
               console.log(data);
           }
       });//ajax
}



function post_information() {	
}

/* @RequestMapping(Constants.REST + "/roles/")
 * @RequestMapping(value="",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_roles(success, failure)
{
	$.ajax({
        url: getUrl('rest/roles'),
        type:"get",
        dataType:"json",
        success:function(roles,status){
            if (typeof success == "function") {
				success(roles,status);
				}
        },
        error:function(){
        }
    }); 
}


/* @RequestMapping(Constants.REST + "/room_info/")
 * @RequestMapping(value="{name}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_room_info(parameter) {
	return getData("/room_info/" + parameter, "room info");
}

/* @RequestMapping(Constants.REST + "/topic/")
 * @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "vote", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "vote/result/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_topic(parameter) {
	return getData("/topic/" + parameter, "topic");
}

function get_topic_byid(topicId, success, failure)
{
	$.ajax({
        url: getUrl('rest/topic/' + topicId),
        type:"get",
        dataType:"json",
        success:function(obj){
            if (typeof success == "function") {
				success(obj);
				}
        },
        error:function(){
        }
    }); 
}

function get_all_topic(success, failure)
{
	 $.ajax({
           type: "GET",
           url: getUrl('rest/topic?type=1'),
           dataType: "json",
           success: function(data) {
              if (typeof success == "function") {
				success(data);
				}
           },//success
           error: function(data) {
               console.log(data);
           }
       });//ajax
}

function post_topic(jsonData)
{
	$.ajax({
        url: getUrl('rest/topic/vote'),
        type: "post",
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success:function() {
            alert("投票成功");
        }
    })
}

function get_topic_result_byid(topicId, success, failure)
{
	$.ajax({
        url: getUrl('rest/topic/' + topicId),
        type:"get",
        dataType:"json",
        success:function(obj){
            if (typeof success == "function") {
				success(obj);
				}
        },
        error:function(){
        }
    }); 
}

/* @RequestMapping(Constants.REST + "/vote/")
 * @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_vote() {
	return getData("/vote/" + "all", "vote");
}

/* @RequestMapping(Constants.REST + "/work_report/")
 * @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_work_report(parameter, success, failure)
{
	$.ajax({
		url:getUrl("rest/work_report/"+parameter),
		type:"get",
		dataType:"json",
		success:function(data){
			if (typeof success == "function") {
				success(data);
			}
		},
		error:function(){}
	});	
}


function getData(url_string, info)
{
	var r_data = "error";
	$.ajax(
        {
          url: getUrl("rest" + url_string),
          dataType: "JSON",
          type: "GET", 
          success: function (data) { 
            r_data = data;
          },
          error: function() {
          	alert("Fail to get " + info + "!");
          }
        }
    )
    
}
