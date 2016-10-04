package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.dto.P_carsDTO;
import project.dto.P_memberDTO;
import project.dto.YujiDTO;

public class YujiDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	P_memberDTO DTO = P_memberDTO.getInstance();

	public YujiDAO() {

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

	public YujiDTO searchMethod() {
		YujiDTO dto = YujiDTO.getInstance();
		try {
			conn = init();
			String sql = "SELECT m.member_name , c.car_id , c.eff , c.fuel_kind, f.price"
					+ " FROM P_MEMBERS m, P_CARS c, P_FUELS f"
					+ " WHERE m.car_id = c.car_id AND c.fuel_kind = f.fuel_kind AND m.member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			 String name = DTO.getId();
			//String name = "hiyo";
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setMember_id(rs.getString("member_name"));
				dto.setEff(rs.getFloat("eff"));
				dto.setFuel_id(rs.getString("fuel_kind"));
				dto.setPrice(rs.getInt("price"));
				dto.setCar_id(rs.getString("car_id"));

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}

		return dto;
	}// end searchMethod()

}// end EmpDAO
