package com.itsp.supplier.entity;

public class Driver {
	
	private String drivingLicenseType;
	private int age;
	private String name;
	private long carrierId;
	private int drivingExperience;
	private long id;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(long carrierId) {
		this.carrierId = carrierId;
	}
	public String getDrivingLicenseType() {
		return drivingLicenseType;
	}
	public void setDrivingLicenseType(String drivingLicenseType) {
		this.drivingLicenseType = drivingLicenseType;
	}
	public int getDrivingExperience() {
		return drivingExperience;
	}
	public void setDrivingExperience(int drivingExperience) {
		this.drivingExperience = drivingExperience;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
