package CH03;

public class C04TypeChange {

	public static void main(String[] args) {
	// 정수 연산식 자동형변환 (int 보다 작은 변수 자료형간(short, char , byte)의 산술연산시 -> int 로 자동형변환 )
	
	byte x = 10;
	byte y = 20;
	
//	byte result1 = x + y; 			        // 오류 발생 - x, y가 int 타입
	byte result1 = (byte)(x + y);
	
	int result2 = x + y;
	System.out.println(result1);

	// 정수 연산식 자동형변환(int 보다 큰 변수 자료형 간의 산술연산시 -> 큰 자료형(long)으로 자동형변환)
	byte var1 = 10;
	int var2 = 100;
	long var3 = 1000L;
	
//	int result = var1 + var2 + var3;      // 오류 발생 - 타입 불일치
	int result =(int)(var1 + var2 + var3);
	
//	long result2 = var1 + var2 + var3;
	// System.out.println(result2);
	
	// 실수연산식
	// 큰 타입으로 자동 형 변환
	int intvar = 10;
	float flvar = 3.3F;
	double dbvar = 5.5;
	int result3 = (int)(intvar + flvar+ dbvar);	//intvar , flvar 가  각각 double 형으로 형변환된값이 더해져서 result 3에 저장
	double result4 = intvar + flvar+ dbvar;
	System.out.println(result3);
	
	}
}