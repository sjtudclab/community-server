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
function get_apartment(parameter) {
	return getData("/apartment/" + parameter, "apartment");
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
function get_buildings(parameter) {
	return getData("/buildings/" + parameter, "buildings");
}

/* @RequestMapping(Constants.REST + "/citizen")
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_citizen() {
	return getData("/citizen", "citizen");
}

/* @RequestMapping(Constants.REST + "/managementCitizens/")
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_managementCitizens(parameter) {
	return getData("/managementCitizens/" + parameter, "managementCitizens");
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
function get_information(parameter) {
	return getData("/information/" + parameter, "information");
}
function post_information() {	
}

/* @RequestMapping(Constants.REST + "/item/")
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value="create",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_item(parameter) {
	return getData("/item/" + parameter, "item");
}

/* @RequestMapping(Constants.REST + "/roles/")
 * @RequestMapping(value="",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value="{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_roles(parameter) {
	return getData("/roles/" + parameter, "roles");
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

function get_topic_byid(topicId)
{
	$.ajax({
        url: getUrl('rest/topic/' + topicId),
        type:"get",
        dataType:"json",
        success:function(obj){
            $("#title").html(obj.title);
            $("#attachment").attr("src", obj.attachment);
            $("#content").html(decodeURI(obj.content));

            $.each(obj.options, function(optionIndex, option) {
                var start = "<tr><th style=\"text-align:left\"><label>";
                var end = "</label></th></tr>";
                var option = "<input type=\"radio\" value=\"" + option.id + "\" name=\"option\">" + option.name;

                $('#vote_table').append(start + option + end);
            })

            $('#vote_table').append("<tr><th><button onclick=\"submit()\">确定</button></th></tr>");
        },
        error:function(){
            alert("获取物品" + $goodsID + "信息失败");
        }
    }); 
}

function get_all_topic()
{
	$(document).ready(function(){
        $.ajax({
           type: "GET",
           url: getUrl('rest/topic?type=1'),
           dataType: "json",
           success: function(data) {
               console.log(data);
               $('#announce').empty();
               $.each(data, function(commentIndex, comment) {

                   console.log(data.length);
                   console.log(comment.attachment);
                   var dt = "<div class=\"timeline-row\">"+"<div class=\"timeline-icon\">"+"<div class=\"bg-primary\">"+"<i class=\"fa fa-pencil\"></i></div></div>";
                   var dp = "<div class=\"panel timeline-content\">"+"<div class=\"panel-body\">";
                   var ti = "<div class=\"timeline-time\">";
                   var title = comment.title;
                   var de = "</div>";
                   var unixTimestamp = new Date(comment.submit_time);
                   commonTime = unixTimestamp.toLocaleString();

                   var vote_url = getUrl("resident/vote/" + comment.topic_id)
                   var vote = "<a href=\"" + vote_url + "\"><p>进入投票</p></a>";

                   if (comment.attachment != null) {
                       var u = comment.attachment;
                       var images = "<img class=\"img-responsive\"src=\""+getUrl(u)+"\">";

                       $('#announce').append(dt+ti+commonTime+de+dp+"<p>" + title + "</p>" + images+"<p>"+comment.content+"</p>" + vote +de+de+de);
                   } else {
                       $('#announce').append(dt+ti+commonTime+de+dp+"<p>" + title + "</p>" + images+"<p>"+comment.content+"</p>" + vote +de+de+de);
                   }



               })
           },//success
           error: function(data) {
               console.log(data);
           }
       });//ajax
    }); 
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

function get_topic_result_byid(temp)
{
	$.ajax({
        url: getUrl('rest/topic/' + temp),
        type:"get",
        dataType:"json",
        success:function(obj){
            $("#title").html(obj.title);
            $("#attachment").attr("src", obj.attachment);
            $("#content").html(decodeURI(obj.content));

            $.each(obj.options, function(index, option) {
                $("#display_region").append("<p>{0} : {1} 票</p>".format(option.name, option.voteCount));
            })
        },
        error:function(){
            alert("获取物品"+$goodsID+"信息失败");
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
function post_vote()
{
}

/* @RequestMapping(Constants.REST + "/work_report/")
 * @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 * @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
 */
function get_work_report(parameter) {
	return getData("/work_report/" + parameter, "work report");
}
function post_work_report()
{
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
    return r_data;
}
