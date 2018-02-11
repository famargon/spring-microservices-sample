package com.fapps.micro;

public class RemoteSubstractResult {

	private int result;
	private int serverPort;
	private String serviceData;
	
	public RemoteSubstractResult(){
	}
	
	public RemoteSubstractResult(int result, int serverPort) {
		super();
		this.result = result;
		this.serverPort = serverPort;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	public String getServiceData() {
		return serviceData;
	}
	public void setServiceData(String serviceData) {
		this.serviceData = serviceData;
	}
}
