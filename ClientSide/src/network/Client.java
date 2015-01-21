package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import config.ClientProperties;
import config.LoadProperties;
import model.Problem;
import model.Solution;

public class Client {

	private String serverAddress;
	private int port;
	private Socket socket;
	//private String domainDescription;
	
	public Client() {	//default C'tor => reads properties from the XML file
		ClientProperties properties = LoadProperties.readProperties();
		this.port = properties.getServerPort();
		this.serverAddress = properties.getIp();
		socket = null;
	}
	
	public Solution getSolution(Problem problem) {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try {
			socket = new Socket(serverAddress, port);					//connecting to server
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			out.writeObject(problem);									//Request to solve this specific Problem
			Solution solution = (Solution)in.readObject();			//getting the server's answer (Solution)
			return solution;
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Server has been disconnected");
			e.printStackTrace();
		} finally {
				try {
					if (out != null && in != null) {
						out.close();
						in.close();
					}
					if (socket != null && !socket.isClosed())
						socket.close();
				} catch (IOException e) {}
		}			
		return null;		//Failed
	}
	
	public void stopClient()
	{
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println("Exiting Safetly");
		}
	}
}
