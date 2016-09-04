package java0803_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import java0803_jdbc.dto.MemDTO;
/*
 * java.sql.PreparedStatement
 * 1 반복되는 쿼리문의 수행에 사용한다.
 * 2 미리 정의된 SQL문을 수행하기 때문에 Statement에 비해 속도가 빠르다.
 * 3 위치표시자(placeholder)(?)를 사용하여 쿼리문을 간략하게 작성한다.
 */
public class MemDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/*
	 * 싱글톤 패턴
	 * : 하나의 객체만을 생성해서 사용할 수 있도록 설계한 구조이다.
	 * 1 생성자의 접근제어자는 private
	 * 2 객체자신을 생성을 한다.
	 * 3 생성된 객체를 넘겨줄 수 있는 메소드를 정의한다.
	 */
	
	private static MemDAO dao = new MemDAO();

	private MemDAO() {

	}

	public static MemDAO getInstance() {
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

	public ArrayList<MemDTO> listMethod(String s) {
		
		
		ArrayList<MemDTO> aList = new ArrayList<MemDTO>();
		try {

			conn = init();

			//stmt = conn.createStatement();
			
					
			String sql = "SELECT * FROM mem WHERE name like ? ORDER BY num ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+s+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				aList.add(dto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;

	}// end listMethod()

public ArrayList<MemDTO> listMethod() {
		
		
		ArrayList<MemDTO> aList = new ArrayList<MemDTO>();
		try {

			conn = init();

			stmt = conn.createStatement();
					
			String sql = "SELECT * FROM mem  ORDER BY num";
			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				aList.add(dto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;

	}// end listMethod()

	public void insertMethod(MemDTO dto) {
		try {
			conn = init();
			//stmt = conn.createStatement();
			//insert into mem values(mem_num_seq.nextval, '홍길동',30,'서울');
			/*String sql="INSERT INTO mem(num,name,age,loc) VALUES(mem_num_seq.nextval,'"+dto.getName()+"',"+dto.getAge()+",'"+dto.getLoc()+"')";
			stmt.executeUpdate(sql);*/
			String sql="INSERT INTO mem(num,name,age,loc) VALUES(mem_num_seq.nextval,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getLoc());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}

	}// end insertMethod()
	
	public int insertMethod(ArrayList<MemDTO> mdata){
		int cnt[] = null;
		try {
			conn = init();
			String sql = "INSERT INTO mem(num,name,age,loc) VALUES(mem_num_seq.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i<mdata.size();i++){
				MemDTO dto = mdata.get(i);
				pstmt.setString(1, dto.getName());
				pstmt.setInt(2, dto.getAge());
				pstmt.setString(3, dto.getLoc());
				pstmt.addBatch();
			}
			cnt = pstmt.executeBatch();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			stop();
		}
		
		return cnt.length;
		
	}//end insertMethod()
	
	public void updateMethod(HashMap<String, Object> map){
		try {
			conn=init();
			String sql="update mem set name=? where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, (String)map.get("name"));
			pstmt.setInt(2, (Integer)map.get("num"));
			pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			stop();
		}
		
		
	}//end updateMethod()

	public void deleteMethod(int num){
		try {
			conn=init();
			String sql="DELETE FROM mem WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			stop();
		}
		
		
	}//end deleteMethod()
	
	
}// end class
