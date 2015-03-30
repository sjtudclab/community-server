package cn.edu.sjtu.se.dclab;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 *2015年3月30日 下午7:47:25
 *@author changyi yuan
 */
public class EncoderTeset {
	public static void main(String[] args) {
		StandardPasswordEncoder encoder = new StandardPasswordEncoder("dclab@sjtu");
		String[] strs = new String[]{"admin","mlm","zzz","cyg","hhp","zhh","hyt","lxj","jrw","syl"};
		for(String str : strs)
			System.out.println(encoder.encode(str));
	}
}
