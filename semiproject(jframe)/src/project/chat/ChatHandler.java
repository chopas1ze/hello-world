package project.chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

public class ChatHandler implements Runnable {
	Socket socket;
	DataInputStream dataIn;
	DataOutputStream dataOut;
	Thread listener;
	private static Vector<ChatHandler> handlers = new Vector<ChatHandler>();
	
	
	public ChatHandler(Socket socket) {
		this.socket = socket;
	}// end ChatHandler ()

	public void start() {
		try {
			dataIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			dataOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			listener = new Thread(this);
			listener.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}// end start()

	@Override
	public void run() {
		//Vector에 현재 서버에 접속한 클라이언트 정보 저장
		handlers.addElement(this);
		while(!Thread.interrupted()){
			try {
				String message = dataIn.readUTF();
				broadcast(message);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}//end run()
	
	//현재 서버에 접속된 클라이언트 모두에 메세지를 전송
	public void broadcast(String message){
		synchronized (handlers) {
			Enumeration<ChatHandler> enu = handlers.elements();
			while(enu.hasMoreElements()){
				ChatHandler handler = enu.nextElement();
				try {
					handler.dataOut.writeUTF(message);
					handler.dataOut.flush();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}//end broadcast()

}// end class
