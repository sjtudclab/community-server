function new_apply() {
        if (citizenId != 0) {
            $.ajax({
                url: getUrl('rest/friends/' + currentUserId() + '/applications/' + citizenId),
                type: 'post',
                success: function() {
                    alert('好友申请已添加。');
                }
            })
        } else {
            alert("请完成选择！");
        }
};


    function new_building_selection(obj,success,failure) {
        $.ajax({
            url: getUrl('rest/buildings/' + obj + '/apartments'),
            type: 'get',
            dataType: 'json',
            success: function(data) {
                console.log("1");
                if (typeof success == "function") {
                    success(data);
                }
            }
        });
    };

    function new_apartment_selection(obj,success,failure) {
        $.ajax({
            url: getUrl('rest/apartment/' + obj + '/citizen'),
            type: 'get',
            dataType: 'json',
            success: function(data) {
                if (typeof success == "function") {
                    success(data);
                }
            }
        });
    };

    function get_building(success,failure) {
        $.ajax({
            url: getUrl('rest/buildings'),
            type: 'get',
            dataType: 'json',
            success: function(data) {
                if (typeof success == "function") {
                    success(data);
                }
            }
        });
    };

    function get_friend(userid,success,failure) {
        $.ajax({
            url: getUrl("rest/friends/" + userid + "/relations"),
            type: 'get',
            dataType: 'json',
            success: function(data) {
                if (typeof success == "function") {
                    success(data);
                }
            }
        });
    };

    function get_appli(userid,success,failure) {
        $.ajax({
            url: getUrl("rest/friends/" + userid + "/applications"),
            type: 'get',
            dataType: 'json',
            success: function(data) {
                if (typeof success == "function") {
                    success(data);
                }
            }
        });
    };