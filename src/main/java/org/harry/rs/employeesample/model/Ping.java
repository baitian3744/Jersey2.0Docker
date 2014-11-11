package org.harry.rs.employeesample.model;

public class Ping {
	public enum HealthStatus {
		ACTIVE, FAILURE
	}

	private String requestTime;
	private String machineName;
	private HealthStatus healthStatus;
	private String locationURI;
	private String guid;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getLocationURI() {
		return locationURI;
	}

	public void setLocationURI(String locationURI) {
		this.locationURI = locationURI;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public HealthStatus getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(HealthStatus healthStatus) {
		this.healthStatus = healthStatus;
	}

}
