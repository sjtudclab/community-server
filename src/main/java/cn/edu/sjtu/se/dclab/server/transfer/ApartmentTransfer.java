package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;

/**
 *2015年3月17日 下午2:25:36
 *@author changyi yuan
 */
public class ApartmentTransfer {
	private long id;
    private String name;
    private String area;
    private String serialNumber;
    private Collection<ResidentCitizen> residents;

	public ApartmentTransfer() {
	}

	public ApartmentTransfer(Apartment apartment) {
		this.setId(apartment.getId());
		this.setName(apartment.getName());
		this.setArea(apartment.getArea());
		this.setSerialNumber(apartment.getSerialNumber());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Collection<ResidentCitizen> getResidents() {
		return residents;
	}

	public void setResidents(Collection<ResidentCitizen> residents) {
		this.residents = residents;
	}
}
