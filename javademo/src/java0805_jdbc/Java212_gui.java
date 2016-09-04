package java0805_jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import java0805_jdbc.dao.EmployeesDAO;

class DesignTest extends JFrame implements ActionListener, MouseListener{

	JTextField inputTxt;
	JButton searchBtn;
	JTable table;
	DefaultTableModel model;

	public DesignTest() {
		inputTxt = new JTextField(20);
		searchBtn = new JButton("검색");
		
		JPanel jp = new JPanel();
		jp.add(inputTxt) ; jp.add(searchBtn);
		
		//테이블 헤드
		Object[] obj = {"사원번호","사원명","급여","부서번호"};
		model = new DefaultTableModel(obj,0){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		table = new JTable(model);

		//컬럼이동 불가능
		table.getTableHeader().setReorderingAllowed(false);
		
		//라인의 높이
		table.setRowHeight(20);
		
		add(BorderLayout.NORTH,jp);
		add(BorderLayout.CENTER, new JScrollPane(table));
		
		//이벤트 리스너 연결
		searchBtn.addActionListener(this);
		searchBtn.addMouseListener(this);
		
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// end DesignTest()

	@Override
	public void actionPerformed(ActionEvent e) {
		while(model.getRowCount()!=0){
			model.setRowCount(0);
		}
			
		
		EmployeesDAO dao = EmployeesDAO.getInstance();
		ArrayList<EmployeesDTO> aList = dao.listMethod(inputTxt.getText());
		
		for(EmployeesDTO dd : aList){
			Vector<Object> v = new Vector<Object>();	
			v.addElement(dd.getEmployee_id());
			v.addElement(dd.getFirst_name());
			v.addElement(dd.getSalary());
			v.addElement(dd.getDepartment_id());
			model.addRow(v);
		
		}
		
		inputTxt.setText("");
		

	}//end actionPerformed()

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == searchBtn){
			searchBtn.setText("SEARCH");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == searchBtn){
			searchBtn.setText("검색");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}// end DesignTest

public class Java212_gui {

	public static void main(String[] args) {
		new DesignTest();

	}// end main()

}// end class
