package cn.edu.sjtu.se.dclab.server.controller.rest;


import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.se.dclab.auth.thrift.AuthClient;
import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.util.DataUtil;
import cn.edu.sjtu.se.dclab.server.util.VerifyDeviceUtil;

@Controller
@RequestMapping(Constants.REST + "securytest")
public class SecuryTestController {

	@RequestMapping(value = "test", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String test(@RequestBody String message) {
		Map<String,Object> map = DataUtil.getFromJson(message);
		Object ret = VerifyDeviceUtil.verifyDevice(map);
		boolean verified = false;
		String newToken = "";
		if (ret instanceof Boolean) {
			verified = (Boolean) ret;
		} else {
			String retString = (String) ret;
			if (ret.equals("false")) {
				verified = false;
			} else {
				verified = true;
				newToken = retString;
				return newToken;
			}
		}
		return verified ? "Success": "Fail";
	}
}
