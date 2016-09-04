package project;

import static java.lang.Math.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import project.dto.P_memberDTO;

public class Recommend extends JFrame implements ActionListener {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	JLabel adrL, titleL, nameL, carL;
	JButton closeBtn, searchBtn;
	JTextArea recF;

	public Recommend() {
		setTitle("추천 카센터 검색");
		Font font =new Font("sansSerif", 1, 30);
		titleL = new JLabel("카센터 추천");
		titleL.setFont(font);
		adrL = new JLabel(adr(P_memberDTO.getInstance().getLocationId()));
		carL = new JLabel(car(P_memberDTO.getInstance().getCarId()));
		nameL = new JLabel(P_memberDTO.getInstance().getName() + "님");

		titleL.setHorizontalAlignment(JLabel.CENTER);
		adrL.setHorizontalAlignment(JLabel.CENTER);
		carL.setHorizontalAlignment(JLabel.CENTER);
		nameL.setHorizontalAlignment(JLabel.CENTER);
		
		closeBtn = new JButton("취소");
		searchBtn = new JButton("카센터 검색");
		closeBtn.addActionListener(this);

		searchBtn.addActionListener(this);
		recF = new JTextArea();
		recF.setLineWrap(true);
		recF.setEditable(false);

		JPanel btnP = new JPanel();
		btnP.add(searchBtn);
		btnP.add(closeBtn);

		JPanel labelP=new JPanel(new GridLayout(4, 1));
		labelP.add(titleL);
		labelP.add(nameL);
		labelP.add(adrL);
		labelP.add(carL);
		
		BoxLayout boxL=new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		this.setLayout(boxL);
		add(labelP);
		add(recF);
		add(btnP);

		setVisible(true);
		setSize(500, 500);
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setResizable(false);
	}

	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String ur1 = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(ur1, username, password);

	}

	private void stop() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}// end stop()

	public String adr(String LId) {
		String adr = "주소 : ";
		try {
			conn = init();
			String sql = "SELECT si,gu,dong FROM p_locations WHERE location_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				adr += rs.getString("si") + "  " + rs.getString("gu") + "  " + rs.getString("dong");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
		return adr;
	}

	public String car(String carId) {
		String car = "제조사 : ";
		try {
			conn = init();
			String sql = "SELECT car_maker FROM p_cars WHERE car_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				car += rs.getString("car_maker") + "  차량: " + carId;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
		return car;
	}

	public int[] findGps(String LId) {
		int[] gps = new int[2];
		try {
			conn = init();
			String sql = "SELECT gps_x,gps_y FROM p_locations WHERE location_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LId);
			rs = pstmt.executeQuery();
			rs.next();
			gps[0] = rs.getInt("gps_x");
			gps[1] = rs.getInt("gps_y");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
		return gps;
	}

	public TreeMap<Double, String> dist() {
		TreeMap<Double, String> dist = null;
		int a[] = findGps(P_memberDTO.getInstance().getLocationId());
		try {
			dist = new TreeMap<Double, String>();
			conn = init();
			String sql = null;
			if (P_memberDTO.getInstance().getKindId().toString().equals("정상")) {
				sql = "SELECT l.location_id,l.gps_x,l.gps_y FROM p_locations l,p_centers c WHERE c.location_id=l.location_id";
				pstmt = conn.prepareStatement(sql);
			} else {
				sql = "SELECT l.location_id,l.gps_x,l.gps_y " + "FROM p_locations l,p_center_parts cp, p_centers c "
						+ "WHERE c.center_id=cp.center_id " + "AND l.location_id=c.location_id "
						+ "AND cp.part_id=(SELECT part_id " + "FROM p_car_parts " + "WHERE car_id=? AND kind_id=?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, P_memberDTO.getInstance().getCarId());
				pstmt.setString(2, P_memberDTO.getInstance().getKindId());
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				dist.put(sqrt(pow(a[0] - rs.getInt("gps_x"), 2) + pow(a[1] - rs.getInt("gps_y"), 2)),
						rs.getString("location_id"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dist;
	}

	public String[] findCenter(String CId) {
		String[] center = new String[2];
		try {
			conn = init();
			String sql = "SELECT center_name,center_phone FROM p_centers WHERE location_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				center[0] = rs.getString("center_name");
				center[1] = rs.getString("center_phone");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
		return center;
	}

	public String findPart() {
		String part = null;
		try {
			conn = init();
			String sql = "SELECT part_id FROM p_car_parts WHERE car_id=? AND kind_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, P_memberDTO.getInstance().getCarId());
			pstmt.setString(2, P_memberDTO.getInstance().getKindId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				part = rs.getString("part_id");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
		return part;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == searchBtn) {
			recF.setText("");
			TreeMap<Double, String> tree = dist();
			Set<Double> set = tree.keySet();
			Iterator<Double> ite = set.iterator();
			if (!P_memberDTO.getInstance().getKindId().toString().equals("정상")) {
				recF.append("고장 부위 " + P_memberDTO.getInstance().getKindId().toString() + "에 필요한 ");
				recF.append("부품 " + findPart() + "를 가지고 있는 카센터는\n\r");
			}
			for (int i = 0; i < 3; i++) {
				Double key = ite.next();
				String CId = tree.get(key);
				String[] center = findCenter(CId);

				recF.append((i + 1) + "." + center[0] + "\n     " + adr(CId) +"\n     전화번호 : "
						+ center[1] + "\n     거리 : " + round(key * 10) / 10.0 + "km" + "\n\r");

			}recF.append("입니다.");

		}if(obj==closeBtn){
			dispose();
		}
	}

}
