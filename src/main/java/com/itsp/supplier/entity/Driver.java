package com.itsp.supplier.entity;

public class Driver {
	
	private String drivinglicenseType;
	private int age;
	private String name;
	
	private long carrierId;
	
	private int drivingExperience;
	
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
	public String getDrivinglicenseType() {
		return drivinglicenseType;
	}
	public void setDrivinglicenseType(String drivinglicenseType) {
		this.drivinglicenseType = drivinglicenseType;
	}
	public int getDrivingExperience() {
		return drivingExperience;
	}
	public void setDrivingExperience(int drivingExperience) {
		this.drivingExperience = drivingExperience;
	}
	
}
