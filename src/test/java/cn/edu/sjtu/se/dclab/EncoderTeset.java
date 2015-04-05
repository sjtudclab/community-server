package cn.edu.sjtu.se.dclab;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * 2015年3月30日 下午7:47:25
 *
 * @author changyi yuan
 */
public class EncoderTeset {

	private static final byte[] salt = new String("dclab").getBytes();

	public static void main(String[] args) {
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(
				"dclab@sjtu");
		String[] strs = new String[] { "admin", "mlm", "zzz", "cyg", "hhp",
				"zhh", "hyt", "lxj", "jrw", "syl" };
		for (String str : strs)
			System.out.println(encoder.encode(str));
		String rawStr = "admin";
		String encodedStr = "a4a4fface3fc60cab60248926a2338a79db64e333b9073d3837ca351aafb1671e20d943bc20311b1";
		System.out.println(encoder.matches(rawStr, encodedStr));

	}
}
