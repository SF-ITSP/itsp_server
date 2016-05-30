package com.itsp.supplier.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.itsp.common.util.DateUtil;

@Entity
@Table(name = "TT_ITSP_TASK")
public class TaskDataSource {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "address")
	private String address;

	@Column(name = "operation")
	private int operation;

	@Column(name = "arrive_time")
	private Date arriveTime;

	@Column(name = "latest_departure_time")
	private Date latestDepartureTime;

	@Column(name = "waiting_time")
	private int waitingTime;

	public String getOperationString() {
		if (this.operation == 0) {
			return "装车";
		}

		return "卸车";
	}

	public String getArriveTimeString() {
		return DateUtil.string(this.arriveTime, DateUtil.HH_MM);
	}

	public String getLatestDepartureTimeString() {
		return DateUtil.string(this.latestDepartureTime, DateUtil.HH_MM);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public Date getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Date getLatestDepartureTime() {
		return latestDepartureTime;
	}

	public void setLatestDepartureTime(Date latestDepartureTime) {
		this.latestDepartureTime = latestDepartureTime;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
}
