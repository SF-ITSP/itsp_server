package com.itsp.supplier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TT_ITSP_VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@GeneratedValue
	@Column(name = "vehicle_model")
	private int vehicleModel;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(int vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	
}
