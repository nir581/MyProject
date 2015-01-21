package run;

import java.util.Scanner;

import network.MyTCPIPServer;

public class RunServer {

	private MyTCPIPServer server;
	private static boolean flag;
	
	public RunServer() {
		server = null;
	}
	
	public static void main(String[] args) {
		RunServer run = new RunServer();
		int num = 0;
		String action = "";
		System.out.println("Server side");
		Scanner scanner = new Scanner(System.in);
		flag=true;
		while (flag) {
			num++;
			System.out.print("Please Enter command #"+num+": ");
			action = scanner.nextLine();
			if (action.startsWith("start") || action.equals("exit"))
				run.executeAction(action);
			else
				System.out.println("invalid command, please try again");
		}
		scanner.close();
	}

	private void executeAction(String action) {
		String sp[] = action.split(" ");
		if (sp[0].equals("start")) {				//creating the server
			if (sp.length > 1) {
				int port = Integer.parseInt(sp[1]);
				int numOfClients = Integer.parseInt(sp[2]);
				server = new MyTCPIPServer(port, numOfClients);
			}
			else									//Default C'tor
				server = new MyTCPIPServer();						
			server.startServer();				//starting server	
		}
		else if (sp[0].equals("exit")) {		//shutting down the server
			System.out.println("Server is shutting down");
			if (server != null)
				server.stopServer();
			flag = false;
		}	
	}
}
