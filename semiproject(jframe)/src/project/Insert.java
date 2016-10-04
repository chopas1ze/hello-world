package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Insert {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	Scanner sc;
	File file;

	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";

		return DriverManager.getConnection(url, username, password);
	}

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
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void fuel_insert() {
		try {
			file = new File("./src/project/table/p_fuels.txt");
			sc = new Scanner(file);
			conn = init();
			String sql = "INSERT INTO p_fuels VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);

			while (sc.hasNextLine()) {
				String[] arr = sc.nextLine().split("/");
				pstmt.setString(1, arr[0]);
				pstmt.setInt(2, Integer.parseInt(arr[1]));
				pstmt.execute();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			stop();
		}
	}// end fuel_insert()
	
	public void car_insert() {
		try {
			file = new File("./src/project/table/p_cars.txt");
			sc = new Scanner(file);
			conn = init();
			String sql = "INSERT INTO p_cars VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			while (sc.hasNextLine()) {
				String[] arr = sc.nextLine().split("/");
				pstmt.setString(1, arr[1]);
				pstmt.setDouble(2, Double.parseDouble(arr[2]));
				pstmt.setString(3, arr[3]);
				pstmt.setString(4, arr[0]);
				pstmt.execute();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			stop();
		}
	}// end car_insert()

	public void location_insert() {
		try {
			file = new File("./src/project/table/p_locations.txt");
			sc = new Scanner(file);
			conn = init();
			String sql = "INSERT INTO p_locations VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			Random ranX = new Random();
			Random ranY = new Random();
			while (sc.hasNextLine()) {
				String[] arr = sc.nextLine().split("/");

				pstmt.setString(1, arr[0]);
				pstmt.setString(2, arr[1]);
				pstmt.setString(3, arr[2]);
				pstmt.setString(4, arr[3]);
				int x = ranX.nextInt(1000);
				int y = ranY.nextInt(1000);
				pstmt.setInt(5, x);
				pstmt.setInt(6, y);
				pstmt.execute();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			stop();
		}
	}// end location_insert()

	public void centers_insert() {
		try {
			file = new File("./src/project/table/p_centers.txt");
			sc = new Scanner(file);
			conn = init();
			String sql = "INSERT INTO p_centers VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			while (sc.hasNextLine()) {
				String[] arr = sc.nextLine().split("/");
				pstmt.setString(1, arr[0]);
				pstmt.setString(2, arr[1]);
				pstmt.setString(3, arr[2]);
				pstmt.setString(4, arr[3]);
				pstmt.execute();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			stop();
		}
	}// end center_insert()

	public void kinds_insert() {
		try {
			file = new File("./src/project/table/p_kinds.txt");
			sc = new Scanner(file);
			conn = init();
			String sql = "INSERT INTO p_kinds VALUES(?)";
			pstmt = conn.prepareStatement(sql);
			while (sc.hasNextLine()) {

				String arr = sc.nextLine();
				pstmt.setString(1, arr);
				pstmt.execute();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			stop();
		}
	}//end kind_insert();
	public void center_parts_insert() {
		try {
			file = new File("./src/project/table/p_center_parts.txt");
			sc = new Scanner(file);
			conn = init();
			String sql = "INSERT INTO p_center_parts VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			while (sc.hasNextLine()) {
				String[] arr = sc.nextLine().split("/");
				pstmt.setString(1, arr[0]);
				pstmt.setString(2, arr[1]);
				pstmt.execute();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			stop();
		}
	}// end center_parts_insert()

	public void parts_insert() {
		try {
			file = new File("./src/project/table/p_parts.txt");
			sc = new Scanner(file);
			conn = init();
			String sql = "INSERT INTO p_parts VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			while (sc.hasNextLine()) {

				String[] arr = sc.nextLine().split("/");
				pstmt.setString(1, arr[0]);
				pstmt.setString(2, arr[1]);
				pstmt.setString(3, arr[2]);
				pstmt.execute();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			stop();
		}
		
	}// end parts_insert()
	public void car_parts_insert() {
		try {
			file = new File("./src/project/table/p_car_parts.txt");
			sc = new Scanner(file);
			conn = init();
			String sql = "INSERT INTO p_car_parts VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			while (sc.hasNextLine()) {
				String[] arr = sc.nextLine().split("/");
				pstmt.setString(1, arr[0]);
				pstmt.setString(2, arr[1]);
				pstmt.setString(3, arr[2]);
				pstmt.execute();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			stop();
		}
	}// end center_parts_insert()
	
	public static void main(String[] args) {
		 Insert i=new Insert(); 
		 i.fuel_insert(); 
		 i.car_insert();
		 i.location_insert();
		 i.centers_insert(); 
		 i.kinds_insert();
		 i.parts_insert(); 
		 i.center_parts_insert(); 
		 i.car_parts_insert();
		 System.out.println("입력완료");
	}
}
