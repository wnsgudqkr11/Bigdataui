package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C07TxMain {

	public static void main(String[] args) {
		// DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/opendatadb";

		// JDBC참조변수
		Connection conn = null; // DBMS 의 특정 DB와 연결되는 객체
		PreparedStatement pstmt = null; // SQL Query 전송용 객체
		ResultSet rs = null; // Select 결과물 담을 객체

		// 연결작업
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED...");
			
			// Tx START
			conn.setAutoCommit(false);		
			// Insert
			pstmt = conn.prepareStatement("insert into tbl_a values(1,'a')");
			pstmt.executeUpdate();
			// Insert
			pstmt = conn.prepareStatement("insert into tbl_a values(2,'b')");
			pstmt.executeUpdate();
			// Insert
			pstmt = conn.prepareStatement("insert into tbl_a values(1,'c')");
			pstmt.executeUpdate();
			// Insert
			pstmt = conn.prepareStatement("insert into tbl_a values(4,'d')");
			pstmt.executeUpdate();
			// Tx START
			conn.commit();
			

		} catch (ClassNotFoundException e1) {
			System.out.println("클래스 부재 예외발생!");
		} catch (SQLException e2) {
			System.out.println("SQL 예외발생!");
//			e2.printStackTrace();
			
			try {System.out.println("Rollback처리");conn.rollback();} catch (SQLException e) {e.printStackTrace();}
		} 
		finally {
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}

	}

}
