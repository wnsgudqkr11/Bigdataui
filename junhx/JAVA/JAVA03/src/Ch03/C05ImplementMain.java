package Ch03;

import java.sql.SQLException;

//----------------------
//Entitys - 생성할 테이블명 + 컬럼명
//----------------------
class Member{
	private String username;
	private String password;
	private String role;
}
class Board{
	private int no;
	private String writer;
	private String contents;
	private String LocalDateTime;
	
}


//----------------------
//MyRepositorys - DB CRUD 를 위한 객체 
//----------------------
class MemberRepository extends C05JPARepository<Member,String>{
	public MemberRepository(Member entity, Class<?> dataType) {
		super(entity, dataType);
		// TODO Auto-generated constructor stub
	}
}
class BoardRepository extends C05JPARepository<Board,String>{
	public BoardRepository(Board entity, Class<?> dataType) {
		super(entity, dataType);
		// TODO Auto-generated constructor stub
	}	
}

//----------------------
//Execute
//----------------------
public class C05ImplementMain {
	//MemberRepository 생성(Member Table생성)
	public static MemberRepository memberRepository = new MemberRepository(new Member(),String.class);
	//BoardRepository 생성(Board Table생성)
	public static BoardRepository boardRepository= new BoardRepository(new Board(),Long.class);

	public static void main(String[] args) throws Exception {
		System.out.println("TEST");
	}
}