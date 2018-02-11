package com.fapps.micro;

public class SubstractResult {

	private int result;
	private int serverPort;
	
	public SubstractResult(int result, int serverPort) {
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
	
}
