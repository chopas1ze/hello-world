package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import project.dao.JoinDAO;
import project.dto.P_memberDTO;

public class Join extends JFrame implements ActionListener{
	JLabel titleL,nameL,idL,pwL,pwChkL,birthL,phoneL,distanceL,addressL,makerL,buyDateL,carL,genderL,messageL;
	JTextField nameF,idF,distanceF,phoneF1,phoneF2;
	JPasswordField pwF,pwChkF;
	JButton cancleBtn, joinBtn;
	JRadioButton agrR,disAgrR,manR,womanR;
	JComboBox yearC,monthC,dayC,phoneC,siC,guC,dongC,makerC,carC,buyYearC,buyMonthC,buyDayC;
	DefaultComboBoxModel yearModel,monthModel,dayModel,phoneModel,siModel,guModel,dongModel
		,makerModel,carModel,buyYearModel,buyMonthModel,buyDayModel;
	
	Object[] phoneStr={"010","011","016","017","018","019"};
	Object[] yearStr=arr(1900,2016,"up");
	Object[] monthStr=arr(1,12,"down");
	Object[] dayStr = arr(1,31,"down");
	Object[] buyYearStr=arr(1960,2016,"up");
	Object[] buyMonthStr=arr(1,12,"down");
	Object[] buyDayStr = arr(1,31,"down");
	
	CmbListMaker Clm=new CmbListMaker();
	Object[] siStr=Clm.clm1("si", "p_locations");
	Object[] guStr={""};
	Object[] dongStr={""};
	Object[] makerStr=Clm.clm1("car_maker", "p_cars");
	Object[] carStr={""};
	
	public Join() {
		setTitle("회원가입");
		//라벨
		titleL=new JLabel("회원가입");
		nameL=new JLabel("성명 : ");
		idL=new JLabel("ID : ");
		pwL=new JLabel("PW : ");
		pwChkL=new JLabel("PW 확인 : ");
		birthL=new JLabel("생년월일 : ");
		phoneL=new JLabel("핸드폰 : ");
		distanceL=new JLabel("일일 평균 주행거리 : ");
		addressL=new JLabel("주소 : ");
		makerL=new JLabel("제조업체 : ");
		buyDateL=new JLabel("구입일 : ");
		carL=new JLabel("차 종류 : ");
		genderL=new JLabel("성별 : ");
		messageL=new JLabel("");
		//텍스트필드
		idF=new JTextField(7);
		nameF = new JTextField(4);
		phoneF1 = new JTextField(4);
		phoneF2 = new JTextField(4);
		distanceF = new JTextField(4);
		
		//패스워드필드
		pwF= new JPasswordField(7);
		pwChkF= new JPasswordField(7);
		
		//버튼
		joinBtn = new JButton("회원가입");
		cancleBtn = new JButton("취소");
		joinBtn.addActionListener(this);
		joinBtn.setEnabled(false);
		
		//라디오버튼
		agrR = new JRadioButton("동의", false);
		disAgrR = new JRadioButton("동의안함", false);
		agrR.addActionListener(this);
		disAgrR.addActionListener(this);
		ButtonGroup group = new ButtonGroup();
		group.add(agrR);
		group.add(disAgrR);
		
		manR = new JRadioButton("남", true);
		womanR = new JRadioButton("여", false);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(manR);
		group2.add(womanR);
		
		//콤보박스
		yearModel = new DefaultComboBoxModel(yearStr);
		yearC = new JComboBox(yearModel);
		yearC.setPreferredSize(new Dimension(65, 21));
		monthModel = new DefaultComboBoxModel(monthStr);
		monthC = new JComboBox(monthModel);
		monthC.setPreferredSize(new Dimension(65, 21));
		dayModel = new DefaultComboBoxModel(dayStr);
		dayC = new JComboBox(dayModel);
		dayC.setPreferredSize(new Dimension(65, 21));
		phoneModel = new DefaultComboBoxModel(phoneStr);
		phoneC = new JComboBox(phoneModel);
		phoneC.setPreferredSize(new Dimension(65, 21));
		
		siModel = new DefaultComboBoxModel(siStr);
		siC = new JComboBox(siModel);
		siC.setPreferredSize(new Dimension(100,21));
		siC.addActionListener(this);
		
		guModel = new DefaultComboBoxModel(Clm.clm2("gu","p_locations","si",siC.getSelectedItem().toString()));
		guC = new JComboBox(guModel);
		guC.setPreferredSize(new Dimension(80,21));
		guC.addActionListener(this);
		dongModel = new DefaultComboBoxModel(Clm.clm2("dong","p_locations","gu",guC.getSelectedItem().toString()));
		
		dongC = new JComboBox(dongModel);
		dongC.setPreferredSize(new Dimension(80,21));
		makerModel = new DefaultComboBoxModel(makerStr);
		makerC = new JComboBox(makerModel);
		makerC.setPreferredSize(new Dimension(100,21));
		makerC.addActionListener(this);
		carModel = new DefaultComboBoxModel(Clm.clm2("car_id", "p_cars", "car_maker", makerC.getSelectedItem().toString()));
		carC = new JComboBox(carModel);
		carC.setPreferredSize(new Dimension(105,21));
		buyYearModel = new DefaultComboBoxModel(buyYearStr);
		buyYearC = new JComboBox(buyYearModel);
		buyYearC.setPreferredSize(new Dimension(65,21));
		buyMonthModel = new DefaultComboBoxModel(buyMonthStr);
		buyMonthC = new JComboBox(buyMonthModel);
		buyMonthC.setPreferredSize(new Dimension(65,21));
		buyDayModel = new DefaultComboBoxModel(buyDayStr);
		buyDayC = new JComboBox(buyDayModel);
		buyDayC.setPreferredSize(new Dimension(65,21));
		
		//배치	
		
		JPanel nameFP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameFP.add(nameF);
		JPanel nameP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameP.add(nameL);
		nameP.add(nameFP);
		
		JPanel idFP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idFP.add(idF);
		JPanel idP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idP.add(idL);
		idP.add(idFP);
		
		JPanel pwFP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pwFP.add(pwF);
		JPanel pwP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pwP.add(pwL);
		pwP.add(pwFP);
		
		JPanel pwChkFP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pwChkFP.add(pwChkF);
		JPanel pwChkP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pwChkP.add(pwChkL);
		pwChkP.add(pwChkFP);
		
		JPanel joinP1  = new JPanel(new GridLayout(4,1));
		joinP1.add(nameP);
		joinP1.add(idP);
		joinP1.add(pwP);
		joinP1.add(pwChkP);
		
		JPanel birthP1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		birthP1.add(yearC);
		JPanel birthP2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		birthP2.add(monthC);
		JPanel birthP3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		birthP3.add(dayC);
		JPanel birthP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		birthP.add(birthL);
		birthP.add(birthP1);
		birthP.add(new JLabel("년"));
		birthP.add(birthP2);
		birthP.add(new JLabel("월"));
		birthP.add(birthP3);
		birthP.add(new JLabel("일"));
		
		JPanel phoneP1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		phoneP1.add(phoneC);
		JPanel phoneP2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		phoneP2.add(phoneF1);
		JPanel phoneP3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		phoneP3.add(phoneF2);
		JPanel phoneP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		phoneP.add(phoneL);
		phoneP.add(phoneP1);
		phoneP.add(new JLabel("-"));
		phoneP.add(phoneP2);
		phoneP.add(new JLabel("-"));
		phoneP.add(phoneP3);
		
		JPanel distanceFP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		distanceFP.add(distanceF);
		JPanel distanceP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		distanceP.add(distanceL);
		distanceP.add(distanceFP);
		distanceP.add(new JLabel("km"));
		
		JPanel genP =new JPanel();
		genP.add(genderL);
		genP.add(manR);
		genP.add(womanR);
		
		JPanel disGenP= new JPanel();
		disGenP.add(distanceP);
		disGenP.add(genP);

		JPanel addressP1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addressP1.add(siC);
		JPanel addressP2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addressP2.add(guC);
		JPanel addressP3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addressP3.add(dongC);
		JPanel addressP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addressP.add(addressL);
		addressP.add(addressP1);
		addressP.add(addressP2);
		addressP.add(addressP3);
		
		JPanel joinP2=new JPanel(new GridLayout(4,1));
		joinP2.add(birthP);
		joinP2.add(phoneP);
		joinP2.add(disGenP);
		joinP2.add(addressP);
		
		JPanel topP = new JPanel(new FlowLayout());
		topP.setBorder(new TitledBorder("개인 정보"));
		topP.add(joinP1);
		topP.add(joinP2);
		
		
		JPanel makerCP=new JPanel(new FlowLayout(FlowLayout.LEFT));
		makerCP.add(makerC);
		JPanel makerP=new JPanel(new FlowLayout(FlowLayout.LEFT));
		makerP.add(makerL);
		makerP.add(makerCP);
		
		JPanel carCP=new JPanel(new FlowLayout(FlowLayout.LEFT));
		carCP.add(carC);
		JPanel carP=new JPanel(new FlowLayout(FlowLayout.LEFT));
		carP.add(carL);
		carP.add(carCP);
		
		JPanel joinP3= new JPanel(new FlowLayout());
		joinP3.add(makerP);
		joinP3.add(carP);
		
		JPanel buyDateP= new JPanel(new FlowLayout());
		buyDateP.add(buyDateL);
		buyDateP.add(buyYearC);
		buyDateP.add(new JLabel("년"));
		buyDateP.add(buyMonthC);
		buyDateP.add(new JLabel("월"));
		buyDateP.add(buyDayC);
		buyDateP.add(new JLabel("일"));
		
		JPanel midP = new JPanel(new BorderLayout());
		midP.setBorder(new TitledBorder("차량 정보"));
		midP.add("North",joinP3);
		midP.add("Center",buyDateP);
		
		JPanel agrP= new JPanel();
		agrP.add(agrR);
		agrP.add(disAgrR);
		
		JPanel btnP= new JPanel();
		btnP.add(joinBtn);
		btnP.add(cancleBtn);
		
		JPanel botP=new JPanel(new GridLayout(3,1));
		botP.add(agrP);
		botP.add(btnP);
		botP.add(messageL);
		
		JPanel totalP = new JPanel(new BorderLayout());
		totalP.add("North",topP);
		totalP.add("Center",midP);
		totalP.add("South",botP);
		
		setLayout(new BorderLayout());
		add("Center", totalP);
		add("East",new JLabel("  "));
		add("West",new JLabel("  "));
		add("South",new JLabel("  "));
		add("North",new JLabel("  "));
		cancleBtn.addActionListener(this);
		
		setSize(580,530);
		
		Dimension frameSize = getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		setResizable(false);
		
		setVisible(true);
		
		
	}//end Join()
	
	public String[] arr(int start,int end,String S){
		String[] arr=new String[end-start+1];
		if(S.equals("down"))
			for(int i=start;i<=end;i++){
				arr[i-start]=String.valueOf(i);
			}
		else
			for(int i=end;i>=start;i--){
				arr[end-i]=String.valueOf(i);
			}
		return arr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==siC){
			guC.removeActionListener(this);
			guModel.removeAllElements();
			guC.addActionListener(this);
			Object[] k=Clm.clm2("gu","p_locations","si",siC.getSelectedItem().toString());
			for(int i=0;i<k.length;i++){
				guModel.insertElementAt(k[i], i);
			}
			guC.setSelectedIndex(0);
		}else if(obj==guC){
			dongModel.removeAllElements();
			Object[] k=Clm.clm2("dong","p_locations","gu",guC.getSelectedItem().toString());
			for(int i=0;i<k.length;i++){
				dongModel.insertElementAt(k[i], i);
			}
			dongC.setSelectedIndex(0);
		}else if(obj==makerC){
			carModel.removeAllElements();
			Object[] k=Clm.clm2("car_id", "p_cars", "car_maker", makerC.getSelectedItem().toString());
			for(int i=0;i<k.length;i++){
				carModel.insertElementAt(k[i], i);
			}
			carC.setSelectedIndex(0);
		}else if(obj==joinBtn){
			JoinDAO jm=new JoinDAO();
			if(nameF.getText().toString().equals("")||
					idF.getText().toString().equals("")||
					pwF.getText().toString().equals("")||
					pwChkF.getText().toString().equals("")||
					distanceF.getText().toString().equals("")||
					phoneF1.getText().toString().equals("")||
					phoneF2.getText().toString().equals("")){
				messageL.setText("빈칸을 모두 채워주세요");
			}else if(!jm.jChk(idF.getText())){
				messageL.setText("이미 존재하는 아이디입니다.");
			}else if(!pwF.getText().toString().equals(
					pwChkF.getText().toString())){
				messageL.setText("비밀번호가 일치하지 않습니다.");
			}else{
				P_memberDTO mdto=P_memberDTO.getInstance();
				mdto.setName(nameF.getText());
				mdto.setBirthday(Date.valueOf(yearC.getSelectedItem().toString()+
						"-"+monthC.getSelectedItem().toString()+
						"-"+dayC.getSelectedItem().toString()));
				mdto.setId(idF.getText());
				mdto.setPhone(phoneC.getSelectedItem().toString()+
						"-"+phoneF1.getText()+"-"+phoneF2.getText());
				mdto.setPassword(pwF.getText().toString());
				mdto.setLocationId(jm.findLocId(siC.getSelectedItem().toString(),
						guC.getSelectedItem().toString(),
						dongC.getSelectedItem().toString()));
				mdto.setBuyDate(Date.valueOf(buyYearC.getSelectedItem().toString()+
						"-"+buyMonthC.getSelectedItem().toString()+
						"-"+buyDayC.getSelectedItem().toString()));
				mdto.setCarId(carC.getSelectedItem().toString());
				mdto.setDistance(Integer.parseInt(distanceF.getText().toString()));
				if(manR.isSelected()){
					mdto.setGender('M');
				}else{
					mdto.setGender('F');
				}
				mdto.setKindId("정상");
				jm.jMem(mdto);
				
				JOptionPane.showMessageDialog(this, "회원가입 완료");
				dispose();
			}
		}else if(obj==agrR){
			joinBtn.setEnabled(true);
		}else if(obj==disAgrR){
			joinBtn.setEnabled(false);
		}else if(obj==cancleBtn){
			dispose();
		}
	}

}//end join