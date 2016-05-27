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

	@Column(name = "type")
	private int type;

	@Column(name = "weight")
	private int weight;

	@Column(name = "carrier_id")
	private long carrierId;

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(long carrierId) {
		this.carrierId = carrierId;
	}

	public String getTypeName() {
		return this.type == 0 ? "冷藏车" : "其他";
	}

}
