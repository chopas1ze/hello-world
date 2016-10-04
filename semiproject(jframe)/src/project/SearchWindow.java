package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import project.dao.p_centersDAO;
import project.dto.p_centersDTO;
import project.dto.p_locationsDTO;

class SearchWindow extends JFrame implements ActionListener {
	p_centersDTO dto;
	p_locationsDTO lodto;

	CmbListMaker Clm = new CmbListMaker();

	JLabel topName, addressIp;
	JTextArea address, output;
	JButton searchBtn;
	JComboBox addressBoxSi, addressBoxGu, addressBoxDong;
	DefaultComboBoxModel addressModelSi, addressModelGu, addressModelDong;

	Object[] siStr = Clm.clm1("si", "p_locations");
	Object[] guStr = { "" };
	Object[] dongStr = { "" };
	Object[] makerStr = Clm.clm1("car_maker", "p_cars");
	Object[] carStr = { "" };

	public SearchWindow() {
		dto = new p_centersDTO();
		lodto = p_locationsDTO.getInstance();

		output = new JTextArea(7, 30);
		output.setEditable(false);
		searchBtn = new JButton("검색");

		// 콤보박스

		addressModelSi = new DefaultComboBoxModel(siStr);
		addressBoxSi = new JComboBox(addressModelSi);
		addressBoxSi.addActionListener(this);
		addressBoxSi.setPreferredSize(new Dimension(100, 21));

		addressModelGu = new DefaultComboBoxModel(
				Clm.clm2("gu", "p_locations", "si", addressBoxSi.getSelectedItem().toString()));
		addressBoxGu = new JComboBox(addressModelGu);
		addressBoxGu.addActionListener(this);
		addressBoxGu.setPreferredSize(new Dimension(100, 21));

		addressModelDong = new DefaultComboBoxModel(
				Clm.clm2("dong", "p_locations", "gu", addressBoxGu.getSelectedItem().toString()));
		addressBoxDong = new JComboBox(addressModelDong);
		addressBoxDong.addActionListener(this);
		addressBoxDong.setPreferredSize(new Dimension(100, 21));

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel pCombo = new JPanel();

		topName = new JLabel("지역 카센터 검색");
		addressIp = new JLabel("원하는 지역을 입력하세요.");

		topName.setBorder(new EmptyBorder(20, 0, 0, 0));
		addressIp.setBorder(new EmptyBorder(60, 0, 0, 0));
		p3.setBorder(new EmptyBorder(0, 0, 100, 0));

		pCombo.add(addressBoxSi);
		pCombo.add(addressBoxGu);
		pCombo.add(addressBoxDong);
		pCombo.add(searchBtn);
		p1.add(topName);
		p2.add(addressIp);
		p2.add(pCombo);
		p3.add(output, BorderLayout.CENTER);
		
		searchBtn.addActionListener(this);

		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, p1);
		add(BorderLayout.CENTER, p2);
		add(BorderLayout.SOUTH, p3);

		setSize(450, 500);
		setVisible(true);
		// 프레임을 화면 가운데로 고정
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		// 프레임 사이즈 고정
		this.setResizable(false);

		setTitle("지역 카센터 검색");
		// 밑에 주석제거 하면 login_success 창도 같이 종료됨.
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// SearchWindow()

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		output.setText("");
		p_centersDAO dao = new p_centersDAO();
		if (obj == searchBtn) {
			ArrayList<p_centersDTO> aList = dao.searchMethod(addressBoxDong.getSelectedItem().toString());
			if (aList.size()!=0) {
				output.append("해당 지역의 카센터는\n");
				int i=0;
				for (p_centersDTO dto : aList) {
					i++;
					String str = "▶    "+dto.getCenter_name()+"\n";
					String str2 = "☎  " +dto.getCenter_phone()+"\n";
					output.append(str + str2);
					if(i==1){
						output.append("\n");
					}
				}
			}else{
				output.setText("해당 지역의 카센터는 없습니다.");
			}

		} else if (obj == addressBoxSi) {
			addressBoxGu.removeActionListener(this);
			addressModelGu.removeAllElements();
			addressBoxGu.addActionListener(this);
			Object[] k = Clm.clm2("gu", "p_locations", "si", addressBoxSi.getSelectedItem().toString());
			for (int i = 0; i < k.length; i++) {
				addressModelGu.insertElementAt(k[i], i);
			}
			addressBoxGu.setSelectedIndex(0);
		} else if (obj == addressBoxGu) {
			addressModelDong.removeAllElements();
			Object[] k = Clm.clm2("dong", "p_locations", "gu", addressBoxGu.getSelectedItem().toString());
			for (int i = 0; i < k.length; i++) {
				addressModelDong.insertElementAt(k[i], i);
			}
			addressBoxDong.setSelectedIndex(0);
		}

	}// end actionPerformed()

}// end class
