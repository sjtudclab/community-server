(function($) {
	setCookie = function(name,value,days) {
	    if (days) {
	        var date = new Date();
	        date.setTime(date.getTime()+(days*24*60*60*1000));
	        var expires = "; expires="+date.toGMTString();
	    }
	    else var expires = "";
	    document.cookie = name+"="+value+expires+"; path=/";
	}

	getCookie = function(name) {
	    var nameEQ = name + "=";
	    var ca = document.cookie.split(';');
	    for(var i=0;i < ca.length;i++) {
	        var c = ca[i];
	        while (c.charAt(0)==' ') c = c.substring(1,c.length);
	        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	    }
	    return null;
	}

	eraseCookie = function(name) {
	    createCookie(name,"",-1);
	}

	saveUser = function(user) {
		setCookie("csUser", JSON.stringify(user));
	}
	
	currentUser = function() {
		var userString = getCookie("csUser");
		try {
			return JSON.parse(userString);
		} catch (e) {
			return null;
		}
	}
	
	currentUserId = function() {
		var cu = currentUser();
		if (cu == null) {
			window.location = 'metrologin.html';
			return 0;
		}
		return typeof cu.id == "undefined" ? 0 : cu.id;
	}
	
	getUrl = function(){
		var root = "/community-server/";
		return root;
	}
	
})(jQuery);