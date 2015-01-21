package config;

import java.io.Serializable;

public class ClientProperties implements Serializable {

	private int serverPort;
	private String ip;
	
	public ClientProperties() {}
	
	public ClientProperties(int serverPort, String ip) {
		super();
		this.serverPort = serverPort;
		this.ip = ip;
	}
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
