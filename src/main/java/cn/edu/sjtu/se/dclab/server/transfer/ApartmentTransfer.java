package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.entity.Citizen;
import cn.edu.sjtu.se.dclab.server.entity.User;

/**
 *2015年3月17日 下午2:25:36
 *@author changyi yuan
 */
public class ApartmentTransfer {
	private long id;
    private String floor;
    private String location;
    private Citizen owner;
    private String resident;
    private String serialNumber;
    private Collection<User> users;
	public ApartmentTransfer() {
	}
   
	public ApartmentTransfer(long id, String floor, String location,
			Citizen owner, String resident, String serialNumber) {
		super();
		this.id = id;
		this.floor = floor;
		this.location = location;
		this.owner = owner;
		this.resident = resident;
		this.serialNumber = serialNumber;
	}

	public ApartmentTransfer(Apartment apartment) {
		this.id = apartment.getId();
		//this.floor = apartment.getFloor();
		//this.location = apartment.getLocation();
		this.owner = apartment.getOwner();
		//this.resident = apartment.getResident();
		this.serialNumber = apartment.getSerialNumber();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Citizen getOwner() {
		return owner;
	}

	public void setOwner(Citizen owner) {
		this.owner = owner;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

}
