package com.itsp.supplier.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TT_ITSP_REQUIREMENT")
public class RequirementData {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "vehicle_model")
	private int vehicleModel;

	@Column(name = "capacity_weight")
	private int capacityWeight;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public String getVehicleModelName() {
		return this.vehicleModel==0?"¿‰≤ÿ≥µ":"∆‰À˚";
	}

}
