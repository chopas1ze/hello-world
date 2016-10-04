package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.dto.P_memberDTO;

public class FailureDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static FailureDAO dao = new FailureDAO();

	public FailureDAO() {

	}

	public static FailureDAO getInstance() {
		return dao;
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

	public ArrayList<P_memberDTO> regist(Object object) {
		ArrayList<P_memberDTO> aList = new ArrayList<P_memberDTO>();
		try {
			P_memberDTO dto = P_memberDTO.getInstance();
			conn = init();
			String sql1 = "update P_members set kind_id=? where member_id = ? ";
			pstmt = conn.prepareStatement(sql1);
			// pstmt.setString(1, dto.getKindId());
			// pstmt.setString(1, String.valueOf(object));
			pstmt.setString(1, object.toString());
			// pstmt.setString(2, dto.id());
			pstmt.setString(2, dto.getId());

			String sql2 = " select *  from P_members";
			rs = pstmt.executeQuery();

			pstmt = conn.prepareStatement(sql2);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setKindId((rs.getString("kind_Id")));
				aList.add(dto);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			stop();
		}

		return aList;
	}

}// end class
