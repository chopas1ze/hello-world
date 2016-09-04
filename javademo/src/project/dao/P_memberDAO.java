package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java0804_jdbc.dto.EmpDTO;
import project.dto.P_memberDTO;

public class P_memberDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static P_memberDAO dao = new P_memberDAO();

	private P_memberDAO() {

	}

	public static P_memberDAO getInstance() {
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, username, password);
	}// end init()

	private void stop() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// end stop()

		public void login(String id,String pw){
		try {
			conn=init();
			String sql="SELECT * FROM p_members WHERE member_id=? AND password=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				P_memberDTO dto=P_memberDTO.getInstance();
				dto.setId(rs.getString("member_id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("member_name"));
				dto.setBirthday(rs.getDate("member_birthday"));
				dto.setPhone(rs.getString("member_phone"));
				dto.setGender(rs.getString("gender").charAt(0));
				dto.setBuyDate(rs.getDate("buy_date"));
				dto.setCarId(rs.getString("car_id"));
				dto.setLocationId(rs.getString("location_id"));
				dto.setKindId(rs.getString("kind_id"));
				dto.setDistance(rs.getInt("distance"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			stop();
		}
	}


}// end EmpDAO
