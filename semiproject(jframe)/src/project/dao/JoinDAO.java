package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.dto.P_memberDTO;

public class JoinDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public JoinDAO() {
		// TODO Auto-generated constructor stub
	}
	private Connection init() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";

		return DriverManager.getConnection(url, username, password);
	}//init()
	
	private void stop() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}//end stop()
	
	public void jMem(P_memberDTO dto){
		try {
			conn=init();
			String sql="INSERT INTO p_members VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getName());
			pstmt.setDate(3,dto.getBirthday());
			pstmt.setString(4,dto.getPhone());
			pstmt.setString(5,dto.getPassword());
			pstmt.setString(6,""+dto.getGender());
			pstmt.setDate(7,dto.getBuyDate());
			pstmt.setInt(8,dto.getDistance());
			pstmt.setString(9,dto.getCarId());
			pstmt.setString(10,dto.getLocationId());
			pstmt.setString(11,dto.getKindId());
			pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			stop();
		}
	}
	public boolean jChk(String id){
		ArrayList<String> arr=null;
		boolean chk=false;
		try {
			arr=new ArrayList<String>();
			conn=init();
			String sql="SELECT member_id FROM p_members WHERE member_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				arr.add(rs.getString("member_id"));
			}
			if(arr.isEmpty()){
				chk=true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			stop();
		}
		return chk;
	}//end jChk
	
	public String findLocId(String si,String gu,String dong){
		String lId=null;
		try {
			conn=init();
			String sql="SELECT location_id FROM p_locations WHERE si=? AND gu=? AND dong=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,si);
			pstmt.setString(2,gu);
			pstmt.setString(3,dong);
			rs=pstmt.executeQuery();
			rs.next();
			lId=rs.getString("location_id");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			stop();
		}
		return lId;
	}//end findLocId
}
