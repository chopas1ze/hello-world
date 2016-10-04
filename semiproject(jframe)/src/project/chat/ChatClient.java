package project.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import project.dto.P_memberDTO;

public class ChatClient implements Runnable,ActionListener,WindowListener {

	private String host;
	private int port;
	private String userName;
	private JFrame frm;
	private JPanel pan;
	private JTextArea taOutput;
	private JLabel lbName;
	private JTextField tfInput;

	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	private Thread listener;

	public ChatClient(String host, int port) {
		P_memberDTO dto = P_memberDTO.getInstance();
		userName = dto.getName();
		this.host = host;
		this.port = port;
		initComponent();

	}// end ChatClient()

	public void initComponent() {
		P_memberDTO dto = P_memberDTO.getInstance();
		frm = new JFrame("CMS 상담원 채팅");

		taOutput = new JTextArea();
		taOutput.setEditable(false);
		taOutput.setText("<상담원과 연결되었습니다>"+"\n"+dto.getName()+"님 문의사항을 입력해주세요"+"\r\n"+"\r\n");
		tfInput = new JTextField(10);
		pan = new JPanel();
		lbName = new JLabel("입력 :");
		JScrollPane scroll = new JScrollPane(taOutput);
		//자동으로 스크롤이 아래로 내려오도록 하기 위한 작업
		scroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				JScrollBar src = (JScrollBar) e.getSource();
				src.setValue(src.getMaximum());
				
			}
		});
		
		frm.add("Center", scroll);
		frm.add("South", pan);

		pan.setLayout(new BorderLayout());
		pan.add(lbName, BorderLayout.WEST);
		pan.add(tfInput, BorderLayout.CENTER);
		frm.setSize(450, 400);
		frm.setVisible(true);
		Dimension frameSize = frm.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frm.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

		frm.setResizable(false);

		
		// frm.addWindowListener(this);
		 tfInput.addActionListener(this);

	}// end initComponent()

	public String getUserName() {
		return this.userName;
	}

	//서버 연결 및 입출력 스트림 연결
	public void start() {
		if(listener==null){
		try {
			Socket socket = new Socket(host, port);
			dataIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			dataOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
		listener = new Thread(this);
		listener.start();
		frm.setVisible(true);
		}
	}// end start()

	
	@Override
	public void run() {
		System.out.println("메세지 수신 대기 중\n");
		while(!Thread.interrupted()){
			try {
				String line = dataIn.readUTF();
				taOutput.append(line+"\n");
				System.out.println("server>"+line+"\n");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
			
	}// end run()
	
	synchronized public void stop(){
		if(listener!=null){
			listener.interrupt();
			listener=null;
			try {
				dataOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			frm.setVisible(false);
			frm.dispose();
			System.exit(0);
		}
		
	}//end stop()

	@Override
	public void actionPerformed(ActionEvent e) {
		String message=e.getActionCommand();
		try {
			dataOut.writeUTF(getUserName()+":"+message);
			dataOut.flush();
			tfInput.setText("");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}//end actionPerformed()

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		stop();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}



}// end class
