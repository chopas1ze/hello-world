package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import project.dao.FailureDAO;
import project.dao.P_memberDAO;
import project.dto.P_memberDTO;
import project.dto.p_centersDTO;

public class Failure extends JFrame implements ActionListener {
	JLabel title, carL, fail;
	JButton run;
	JComboBox<String> locBox;
	JTextArea memArea, carArea;
	JTable table;
	DefaultTableModel carCenter;
	P_memberDTO mem;
	String carKind, centerName, centerDong, centerPhone;

	public Failure() {
		setTitle("고장신고");
		mem = P_memberDTO.getInstance();
		title = new JLabel("고장신고");
		carL = new JLabel("등록정보");
		memArea = new JTextArea(3, 35);
		memArea.append(mem.getName() + "님의 차량은 " + mem.getCarId() + "입니다.\n");
		memArea.setEditable(false);
		carArea = new JTextArea(3, 35);
		carArea.setEditable(false);
		fail = new JLabel("고장부위 :");
		run = new JButton("등록");

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("선택");
		model.addElement("정상");
		model.addElement("베터리");
		model.addElement("디스크 브레이크");
		model.addElement("브레이크 페달");
		model.addElement("운전대");
		model.addElement("클러치");
		model.addElement("냉각 팬");
		model.addElement("연료 라인");
		model.addElement("소음기");
		locBox = new JComboBox<String>(model);

		JPanel fail1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 70));
		fail1.add(fail);
		fail1.add(locBox);
		fail1.add(run);

		JPanel north = new JPanel(new FlowLayout());
		north.setBorder(new EmptyBorder(15, 0, 0, 0));
		north.add(title);

		JPanel south = new JPanel(new FlowLayout());
		south.setBorder(new EmptyBorder(0, 0, 100, 0));
		south.add(carL);
		south.add(carArea);

		JPanel center = new JPanel(new FlowLayout());
		center.setBorder(new EmptyBorder(30, 0, 0, 0));
		center.add(memArea);
		center.add(fail1);

		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, north);
		add(BorderLayout.CENTER, center);
		add(BorderLayout.SOUTH, south);

		run.addActionListener(this);
		// add(BorderLayout.CENTER, multiArea);

		setSize(400, 500);
		setVisible(true);
		// 밑에 주석제거 하면 login_success 창도 같이 종료됨.
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 가운데로 고정
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		// 프레임 사이즈 고정
		this.setResizable(false);

	}// end Failure()

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		carArea.setText("");
		FailureDAO fail = new FailureDAO();
		p_centersDTO dto = new p_centersDTO();
		int index = locBox.getSelectedIndex();
		if (obj == run && index != 0) {
			fail.regist(locBox.getSelectedItem());
			// centerName,centerDong, centerPhone; //
			carArea.append("고장부위 "+locBox.getSelectedItem().toString()+"이(가) 등록되었습니다.");
		} else {
			carArea.append("고장부위를 선택해주세요.");
		}

	}// end actionPerformed()

}// end class
