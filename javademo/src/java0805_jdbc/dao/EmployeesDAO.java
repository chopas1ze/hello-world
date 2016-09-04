package java0805_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import java0805_jdbc.EmployeesDTO;

public class EmployeesDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static EmployeesDAO dao = new EmployeesDAO();

	private EmployeesDAO() {

	}

	public static EmployeesDAO getInstance() {
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
	
	public ArrayList<EmployeesDTO> listMethod(String search){
		ArrayList<EmployeesDTO> aList = new ArrayList<EmployeesDTO>();
		try {
			conn = init();
			String sql = "SELECT * FROM employees WHERE lower(first_name) like ? ORDER BY employee_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search.toLowerCase() + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeesDTO dto = new EmployeesDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setDepartment_id(rs.getInt("department_id"));
				aList.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
		
		
		return aList;
	}//end listMethod()
	
	
	
	
}//end class
