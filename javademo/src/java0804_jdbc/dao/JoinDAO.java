package java0804_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java0804_jdbc.dto.DepartmentsDTO;
import java0804_jdbc.dto.EmployeesDTO;
import java0804_jdbc.dto.LocationsDTO;

public class JoinDAO {

	private static JoinDAO dao = new JoinDAO();
	private JoinDAO() {
		
	}
	public static JoinDAO getInstance(){
		return dao;
	}
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
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

	public ArrayList<EmployeesDTO> listMethod(){
		ArrayList<EmployeesDTO> aList = new ArrayList<EmployeesDTO>();
		
		try {
			conn=init();
			stmt=conn.createStatement();
			
			String sql = "SELECT e.employee_id, e.first_name, e.salary, d.department_id,"
					  + " d.department_name,l.location_id,l.city"
						+ " FROM employees e, departments d, locations l" +
						" WHERE e.department_id=d.department_id AND d.location_id=l.location_id";
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				EmployeesDTO edto = new EmployeesDTO();
				edto.setEmployee_id(rs.getInt("employee_id"));
				edto.setFirst_name(rs.getString("first_name"));
				edto.setSalary(rs.getInt("salary"));
				DepartmentsDTO mdto = new DepartmentsDTO();
				mdto.setDepartment_id(rs.getInt("department_id"));
				mdto.setDepartment_name(rs.getString("department_name"));
				edto.setMdto(mdto);
				LocationsDTO ldto = new LocationsDTO();
				ldto.setLocation_id(rs.getInt("location_id"));
				ldto.setCity(rs.getString("city"));
				edto.setLdto(ldto);
				aList.add(edto);
				

			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			stop();
		}
		
		return aList;
		
		
	}//end listMethod()
	
}//end JoinDAO
