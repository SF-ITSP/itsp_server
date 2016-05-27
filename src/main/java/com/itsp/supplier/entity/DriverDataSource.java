package com.itsp.supplier.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TT_DRIVER")
public class DriverDataSource {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "driving_license_Type")
	private String drivingLicenseType;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "carrier_id")
	private long carrierId;
	
	@Column(name = "first_drive_date")
	private Date firstDriveDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public Date getFirstDriveDate() {
		return firstDriveDate;
	}
	public void setFirstDriveDate(Date firstDriveDate) {
		this.firstDriveDate = firstDriveDate;
	}
	
}
