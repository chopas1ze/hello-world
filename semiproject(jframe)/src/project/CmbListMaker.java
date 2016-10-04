package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CmbListMaker {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public CmbListMaker() {
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
	
	public Object[] clm1(String col,String table){
		ArrayList<Object> arr=new ArrayList<Object>();
		
		Object[] clm=null;
		try {
			conn=init();
			String sql="SELECT DISTINCT "+col+" FROM "+table;
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				arr.add(rs.getString(col));
			}
			clm=new Object[arr.size()];
			for(int i=0;i<arr.size();i++){
				clm[i]=arr.get(i);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			stop();
		}
		return clm;
		
	}
	
	public Object[] clm2(String col,String table,String sCol,String word){
		ArrayList<Object> arr=new ArrayList<Object>();
		
		Object[] clm=null;
		try {
			conn=init();
			String sql="SELECT DISTINCT "+col+" FROM "+table+" WHERE "+sCol+" = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, word);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				arr.add(rs.getString(col));
			}
			clm=new Object[arr.size()];
			for(int i=0;i<arr.size();i++){
				clm[i]=arr.get(i);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			stop();
		}
		return clm;
		
	}
}
