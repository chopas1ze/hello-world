package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import project.chat.ChatClient;
import project.chat.ChatServer;
import project.dao.YujiDAO;
import project.dto.P_memberDTO;
import project.dto.YujiDTO;

public class Main_frame extends JFrame implements ActionListener {
	JTextArea jtA;
	JButton jungbiB, gojangB, moneyB, searchB, logoutB, endB, chatB;
	Start pro;
	Login log;
	JFrame win;
	Calendar cl = Calendar.getInstance();
	int year = cl.get(Calendar.YEAR);
	int mm = cl.get(Calendar.MONTH) + 1;
	int dd = cl.get(Calendar.DATE);
	// int age = year - Integer.parseInt(arr[0]);

	public Main_frame() {
		P_memberDTO DTO = P_memberDTO.getInstance();
		String today = year + "년 " + mm + "월 " + dd+"일";
		String wel = DTO.getName()+"님 방가방가 ^_^";
		String info ="차종 : " + DTO.getCarId() +"\n\r평균주행거리 : " + DTO.getDistance()+"km";

		Font font = new Font("sansSerif", 0, 12);
		jtA = new JTextArea(7, 1);
		jtA.setText(today + "\n" + wel + "\n" + info);
		Font font2= new Font("sansSerif", 1, 15);
		jtA.setFont(font2);
		jtA.setEditable(false);

		jungbiB = new JButton("추천 카센터 검색");
		gojangB = new JButton("고장 신고");
		moneyB = new JButton("유류비 계산");
		searchB = new JButton("지역 카센터 검색");
		logoutB = new JButton("logout");
		endB = new JButton("프로그램 종료");
		chatB = new JButton("상담원 연결");

		jungbiB.setFont(font);
		gojangB.setFont(font);
		moneyB.setFont(font);
		searchB.setFont(font);
		logoutB.setFont(font);
		endB.setFont(font);
		chatB.setFont(font);

		jungbiB.setToolTipText("회원님의 추천 카센터를 조회합니다");
		gojangB.setToolTipText("고장 신고 하십시오 ");
		moneyB.setToolTipText("회원님의 1일 유류비를 계산합니다");
		searchB.setToolTipText("회원님과 가까운 카센터를 검색합니다");
		logoutB.setToolTipText("로그인 화면으로 돌아갑니다");
		endB.setToolTipText("프로그램을 종료합니다");
		chatB.setToolTipText("상담원과의 채팅을 연결합니다");

		jungbiB.setPreferredSize(new Dimension(130, 50));
		gojangB.setPreferredSize(new Dimension(130, 50));
		moneyB.setPreferredSize(new Dimension(130, 50));
		searchB.setPreferredSize(new Dimension(130, 50));
		logoutB.setPreferredSize(new Dimension(130, 50));
		endB.setPreferredSize(new Dimension(130, 50));
		chatB.setPreferredSize(new Dimension(130, 50));
		
		
			
		JPanel textP = new JPanel(new BorderLayout());
		textP.add("Center", jtA);
		textP.add("East", new JLabel("        "));
		textP.add("West", new JLabel("         "));
		textP.add("South", new JLabel("          "));
		textP.add("North", new JLabel("       "));

		JPanel button1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
		button1.add(jungbiB);
		button1.add(gojangB);
		button1.add(moneyB);
		
		JPanel button2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
		button2.add(searchB);
		button2.add(logoutB);
		button2.add(endB);
	
		JPanel chat = new JPanel(new FlowLayout(FlowLayout.RIGHT,71,20));
		chat.add(chatB);

		//이미지 
		JPanel imgPanel = new JPanel() {
			private static final long serialVersionUID = 1L;
			ImageIcon icon = new ImageIcon("./src/project/back.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		
		jtA.setOpaque(false);
		imgPanel.setLayout(new BoxLayout(imgPanel, BoxLayout.Y_AXIS));
		textP.setOpaque(false);
		button1.setOpaque(false);
		button2.setOpaque(false);
		chat.setOpaque(false);
		imgPanel.add(jtA);
		imgPanel.add(chat);
		imgPanel.add(button1);
		imgPanel.add(button2);
		
		
		getContentPane().add(imgPanel);
		
		setVisible(true);
		setSize(600, 400);
		this.setTitle(" 2조 CMS");
		// 프레임을 화면 가운데로 고정
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

		this.setResizable(false);

		jungbiB.addActionListener(this);
		moneyB.addActionListener(this);
		gojangB.addActionListener(this);
		logoutB.addActionListener(this);
		searchB.addActionListener(this);
		endB.addActionListener(this);
		chatB.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// 윈도우창 닫기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int msg = getConfirmMessage("정말로 종료하겠습니까?");
				if (msg == 0)
					System.exit(0);
				else
					return;
			}
		});
	}// end Login_success()

	// 유류비 계산
	public void money() {
		P_memberDTO DTO = P_memberDTO.getInstance();
		YujiDAO dao = new YujiDAO();
		YujiDTO dto = dao.searchMethod();
		int sum = (int) ((DTO.getDistance() / dto.getEff()) * dto.getPrice());
		String str = dto.getMember_id() + " 회원님의 1일 유류비는  " + sum + " 원 입니다";
		JOptionPane.showMessageDialog(this, str, "유류비 계산", JOptionPane.INFORMATION_MESSAGE);

	}// end money()

	public int getConfirmMessage(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("sanSerif", 0, 12));
		label.setForeground(new Color(255, 0, 0)); // Color.red
		return JOptionPane.showConfirmDialog(this, label, "프로그램 종료", JOptionPane.YES_NO_OPTION);

	}// end getConfirmMessage()

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 고장 신고
		if (obj == gojangB) {
			if (win != null)
				win.dispose();
			win = new Failure();
		}
		// 지역카센터
		if (obj == searchB) {
			if (win != null)
				win.dispose();
			win = new SearchWindow();
		} // 카센터추천
		if (obj == jungbiB) {
			if (win != null)
				win.dispose();
			win = new Recommend();
		}
		if (obj == moneyB) {
			money();
		}
		if (obj == logoutB) {
			if (win != null)
				win.dispose();
			dispose();
			new Start();
		}
		if (obj == endB) {
			int msg = getConfirmMessage("정말로 종료하겠습니까?");
			if (msg == 0)
				System.exit(0);
			else
				return;
		}
		if (obj == chatB){
			try {
			
				ChatClient client = new ChatClient("127.0.0.1", 7777);
				client.start();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}// end actionPerformed()

}// end class
