package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {
	JLabel titleL,idL,pwL,subL;
	JTextField idF;
	JPasswordField pwF;
	JButton loginBtn, joinBtn;
	ImageIcon titleImg;
	
	public Login() {
		this.setBackground(new Color(255, 255, 255));
		idL=new JLabel("아이디 : ");
		pwL=new JLabel("비밀번호 : ");
		subL=new JLabel("made by: 2조");
		
		idF=new JTextField(10);
		pwF=new JPasswordField(10);
		
		loginBtn =new JButton("로그인");
		joinBtn= new JButton("회원가입");
		titleImg=new ImageIcon("./src/project/pic.gif");
		titleL=new JLabel(titleImg);
		
		//배치
		//1.
		JPanel labelP=new JPanel(new GridLayout(2, 1));
		labelP.add(idL);
		labelP.add(pwL);
		labelP.setOpaque(false);
		
		JPanel txtFieldP=new JPanel(new GridLayout(2, 1));
		txtFieldP.add(idF);
		txtFieldP.add(pwF);
		txtFieldP.setOpaque(false);
		
		JPanel btnP=new JPanel();
		btnP.add(joinBtn);
		btnP.add(new JLabel("   "));
		btnP.add(loginBtn);
		btnP.setOpaque(false);
		
		JPanel panel1=new JPanel();
		panel1.add(titleL);
		panel1.setOpaque(false);
		
		JPanel panel2_1=new JPanel();
		panel2_1.add(labelP);
		panel2_1.add(txtFieldP);
		panel2_1.setOpaque(false);
		
		JPanel panel2=new JPanel(new GridLayout(2, 1));
		panel2.add(panel2_1);
		panel2.add(btnP);
		panel2.setOpaque(false);
		
		JPanel panel3=new JPanel();
		panel3.add(subL);
		panel3.setOpaque(false);
		
		JPanel loginP=new JPanel(new BorderLayout());
		loginP.add(panel1,"North");
		loginP.add(panel2, "Center");
		loginP.add(panel3,"South");
		loginP.setOpaque(false);
		
		setLayout(new BorderLayout());
		add("Center", loginP);

			
	}//end login
	
}//end login
