package com.itsp.supplier.entity;

public class TaskForShow {
	private String address;
	
	private String operationString;
	
	private String arriveTimeString;
	
	private String latestDepartureTimeString;
	
	private int waitingTime;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOperationString() {
		return operationString;
	}

	public void setOperationString(String operationString) {
		this.operationString = operationString;
	}

	public String getArriveTimeString() {
		return arriveTimeString;
	}

	public void setArriveTimeString(String arriveTimeString) {
		this.arriveTimeString = arriveTimeString;
	}

	public String getLatestDepartureTimeString() {
		return latestDepartureTimeString;
	}

	public void setLatestDepartureTimeString(String latestDepartureTimeString) {
		this.latestDepartureTimeString = latestDepartureTimeString;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
}
