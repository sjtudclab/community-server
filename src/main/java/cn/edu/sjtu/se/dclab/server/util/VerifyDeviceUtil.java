package cn.edu.sjtu.se.dclab.server.util;

import java.util.Map;

import cn.edu.sjtu.se.dclab.auth.thrift.AuthClient;

public class VerifyDeviceUtil {
	public static Object verifyDevice(Map<String, Object> map) {
		AuthClient client = AuthClient.getInstance();

		if (map.containsKey("token")) {
			String token = (String) map.get("token");
			return client.verifyDevice(token);
		} else {
			String publicKey = (String) map.get("publicKey");
			String encrypedString = (String) map.get("encryptedString");
			String originalString = (String) map.get("orignalString");
			
			String ret = client.verifyDevice(publicKey, encrypedString, originalString);
			return ret;
		}

	}


}
