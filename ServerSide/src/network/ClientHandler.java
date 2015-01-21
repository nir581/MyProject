package network;

import tasks.Task;

public interface ClientHandler extends Task {
//will decide how to handle the Connection with the Client
	void startConversation();
	void stopConversation();
}
