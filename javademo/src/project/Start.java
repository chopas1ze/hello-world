package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import project.chat.ChatServer;
import project.dao.P_memberDAO;
import project.dto.P_memberDTO;

public class Start extends JFrame implements ActionListener, KeyListener {
	Login log;

	public Start() {
		setTitle("로그인");
		log = new Login();
		// setLayout(new FlowLayout());
		add(log);

		this.setSize(280, 350);
		// 프레임을 화면 가운데로 고정
		Dimension frameSize = getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

		// 프레임 사이즈 고정
		setResizable(false); 

		setVisible(true);
		// x눌러도 창이 닫히지 않음.
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		log.loginBtn.addActionListener(this);
		log.joinBtn.addActionListener(this);
		log.pwF.addKeyListener(this);

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

	}// end Project()

	public int getConfirmMessage(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("sanSerif", 0, 12));
		label.setForeground(new Color(255, 0, 0)); // Color.red
		return JOptionPane.showConfirmDialog(this, label, "프로그램 종료", JOptionPane.YES_NO_OPTION);

	}// end getConfirmMessage()

	public static void main(String[] args) throws Exception {
		new Start();
		new ChatServer();

	}// end main

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		P_memberDAO dao = P_memberDAO.getInstance();
		P_memberDTO dto = P_memberDTO.getInstance();
		// 로그인후 패널 교체
		if (obj == log.loginBtn) {
			dao.login(log.idF.getText(), log.pwF.getText());
			if (log.idF.getText().equals(dto.getId()) && log.pwF.getText().equals(dto.getPassword())) {
				JOptionPane.showMessageDialog(this, "로그인 성공", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new Main_frame();

			} else {

				int cnt = JOptionPane.showConfirmDialog(this, "아이디 또는 패스워드가 잘못 입력되었습니다.\n다시 입력하시겠습니까?", "로그인 실패",
						JOptionPane.YES_NO_OPTION);
				log.idF.setText("");
				log.pwF.setText("");
				if (cnt == 0) {
					return;
				} else {
					System.exit(0);
				}

			}

		}
		// 회원가입
		if (obj == log.joinBtn) {
			// 프레임을 화면 가운데로 고정
			new Join();
		}

	}// end actionPerformed()

	@Override
	// 패스워드 입력후 엔터키 입력
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			P_memberDAO dao = P_memberDAO.getInstance();
			P_memberDTO dto = P_memberDTO.getInstance();
			dao.login(log.idF.getText(), log.pwF.getText());
			if (log.idF.getText().equals(dto.getId()) && log.pwF.getText().equals(dto.getPassword())) {
				JOptionPane.showMessageDialog(this, "로그인 성공", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new Main_frame();

			} else {

				int cnt = JOptionPane.showConfirmDialog(this, "아이디 또는 패스워드가 잘못 입력되었습니다.\n다시 입력하시겠습니까?", "로그인 실패",
						JOptionPane.YES_NO_OPTION);
				log.idF.setText("");
				log.pwF.setText("");
				if (cnt == 0) {
					return;
				} else {
					System.exit(0);
				}

			}
		}

	}// end keyPressed()

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}// end class
