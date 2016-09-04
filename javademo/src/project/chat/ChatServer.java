package project.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public ChatServer() throws Exception {

		ServerSocket server = new ServerSocket(7777);
		while (true) {
			// 클라이언트 대기상태
			Socket client = server.accept();
			ChatHandler handler = new ChatHandler(client);
			System.out.println("client가" + client.getInetAddress().getHostAddress() + " 으로 접속하셨습니다.");
			handler.start();

		}

	}// end ChatServer()

}// end class
