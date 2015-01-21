package config;
import java.io.Serializable;

public class ServerProperties implements Serializable {
	
	private int port;
	private int numOfClients;
	
	public ServerProperties(int port, int numOfClients) {
		super();
		this.port = port;
		this.numOfClients = numOfClients;
	}	
	public ServerProperties() { }
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getNumOfClients() {
		return numOfClients;
	}
	public void setNumOfClients(int numOfClients) {
		this.numOfClients = numOfClients;
	}
}
