package com.itsp.supplier.entity;

public class Task {
	private String address;

	private String operation;

	private String arriveTime;

	private String latestDepartureTime;

	private int waitingTime;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getLatestDepartureTime() {
		return latestDepartureTime;
	}

	public void setLatestDepartureTime(String latestDepartureTime) {
		this.latestDepartureTime = latestDepartureTime;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
}
