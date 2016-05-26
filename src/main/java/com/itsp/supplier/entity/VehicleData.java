package com.itsp.supplier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TT_ITSP_VEHICLE")
public class VehicleData {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "vehicle_number")
	private String vehicleNumber;
	
	@Column(name = "vehicle_model")
	private int vehicleModel;

	@Column(name = "capacity_weight")
	private int capacityWeight;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(int vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public int getCapacityWeight() {
		return capacityWeight;
	}

	public void setCapacityWeight(int capacityWeight) {
		this.capacityWeight = capacityWeight;
	}
	
	public String getVehicleModelName(){
		return this.vehicleModel==0?"¿‰≤ÿ≥µ":"∆‰À˚";
	}
}
