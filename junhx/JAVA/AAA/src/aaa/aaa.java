package aaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class aaa {

	// DB CONN DATA
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/tmpdb";

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static void conn() throws SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("DB CONNECTED...");
	}

	public static List<BookDto> selectAll() throws SQLException {
		return null;
	}

	public static BookDto select(Long bookCode) throws SQLException {
		return null;
	}

	public static int insertBook(BookDto bookDto) throws SQLException {
		return -1;
	}

	public static int updateBook(BookDto bookDto) throws SQLException {
		return -1;
	}

	public static int deleteBook(Long bookCode) throws SQLException {
		return -1;
	}

	public static void main(String[] args) {
		try {
			// DB CONN
			conn();

			// TX START
			insertBook(new BookDto(1L, "도서1", "출판사1", "isbn-1"));
			insertBook(new BookDto(2L, "도서2", "출판사2", "isbn-2"));
			insertBook(new BookDto(3L, "도서3", "출판사3", "isbn-3"));

			// SELECTALL
			List<BookDto> allBook = selectAll();
			System.out.println("selectAll : ");
			allBook.forEach(e -> System.out.println(e));

			// SELECT
			BookDto dto = select(1L);
			System.out.println("select : " + dto);

			// UPDATE
			dto.setBookName("수정도서명-1");
			int r1 = updateBook(dto);
			if (r1 > 0)
				System.out.println("수정완료 : " + r1);

			// DELETE
			int r2 = deleteBook(2L);
			if (r2 > 0)
				System.out.println("삭제완료 : " + r2);

			// END
		} catch (Exception e) {
			// TX ROLLBACKALL
		}
	}
}
