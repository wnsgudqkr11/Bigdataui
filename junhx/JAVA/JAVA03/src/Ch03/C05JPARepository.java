package Ch03;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//--------------------------------
// 제너릭 + JDBC + Reflection 를 활용한 Repository 구현하기
//--------------------------------

public class C05JPARepository<E, D> {
	
	//Class Reflection Attribute
	E entity ;
	Class<?> dataType;
	Class<?> clazz;
	
	
	//JDBC Attribute
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//JDBC Properties Attribute
	String username;
	String password;
	String url;
	
	
	//생성자(호출시 클래스명으로 테이블생성)
	public C05JPARepository(E entity,Class<?> dataType) {
		//-----------------------------------
		//Entity 받기
		//-----------------------------------
		this.entity = entity;
		this.dataType = dataType;
		System.out.println("PrimaryKey DataType : " +dataType );
		try {
		//-----------------------------------
		//properties 설정 - application.properties 내용 읽어오기(추후진행)
		//-----------------------------------
		username = "root";
		password = "1234";
		url = "jdbc:mysql://localhost:3306/tmpdb";
		conn = DriverManager.getConnection(url,username,password);
		//-----------------------------------	
		//Mysql Driver 를 메모리에 적재 
		//-----------------------------------
		Class.forName("com.mysql.cj.jdbc.Driver");	//드라이브 적재
		
		//-----------------------------------
		//Entity에 들어온 값에 맞게 테이블 생성
		//-----------------------------------
		
		clazz = Class.forName(String.valueOf(entity.getClass()).split(" ")[1]);
		Field[] fields =  clazz.getDeclaredFields();
		 
		 String sql ="";
		//-----------------------------------
		 //테이블 생성쿼리 만들기 시작
		//-----------------------------------
		 sql+="CREATE TABLE IF NOT EXISTS tmpdb.";
		//-----------------------------------
		 //테이블명 지정 
		//-----------------------------------
		 sql+=clazz.getSimpleName()+"(";
		//-----------------------------------
		 //컬럼명 / 자료형 / 제약조건 지정
		//-----------------------------------
		 for(Field field :fields) {
			 //System.out.println("Type : " + field.getType()+" ,FieldName : "+field.getName());
			 if(field.getType().toString().contains("String")) {
				 sql+=field.getName() + " varchar(45) not null,"; //column명 , datatype , 제약조건					 
			 }else if(field.getType().toString().contains("int")){
				 sql+=field.getName() + " int not null,";
			 }

		 }	
		 sql = sql.substring(0,sql.lastIndexOf(","));;
		 sql+=")";
		 
		 System.out.println("Execution Sql : " + sql);
		//-----------------------------------
		//테이블 생성
		//-----------------------------------
		 PreparedStatement pstmt =  conn.prepareStatement(sql);
		 int isCreatedTable =  pstmt.executeUpdate();
		 
		 
			 System.out.println(clazz.getSimpleName() + " 테이블 생성완료");
			
	
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(clazz.getSimpleName() + " 테이블 생성실패");
		}
		 		
	}
	
	
	//기본 CRUD Function 구현하기
	//INSERT()
	//UPDATE()
	//DELETE()
	//SELECTBYID(PK자료형)
	//SELECTALL()
	
	
	
	
}