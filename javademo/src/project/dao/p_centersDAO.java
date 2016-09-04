package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.dto.p_centersDTO;

public class p_centersDAO {
	private static p_centersDAO dao = new p_centersDAO();
	
	public p_centersDAO() {
		
	}
	
	public static p_centersDAO getInstance(){
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
	public ArrayList<p_centersDTO> searchMethod(String dong){
	ArrayList<p_centersDTO> aList = new ArrayList<p_centersDTO>();
	try {
		conn = init();
		String sql="Select center_name, center_phone FROM p_centers WHERE location_id="
				    +"(select location_id from p_locations where dong = ?)";
		//String sql="Select center_name, center_phone FROM p_centers WHERE location_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dong);
		rs = pstmt.executeQuery();
		while(rs.next()){
			p_centersDTO dto=new p_centersDTO();
			dto.setCenter_name(rs.getString("center_name"));
			dto.setCenter_phone(rs.getString("center_phone"));
			aList.add(dto);
		}
			
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		stop();
	}
	return aList;
	}//end searchMethod

}//end class
