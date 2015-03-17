package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.List;

/**
 *2015年3月17日 下午1:32:46
 *@author changyi yuan
 */
public class FsrelationTransfer {
	private String  name;
	private List<String> fNames;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getfNames() {
		return fNames;
	}
	public void setfNames(List<String> fNames) {
		this.fNames = fNames;
	}
}
