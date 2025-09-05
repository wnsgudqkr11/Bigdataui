package Ch17;

// 덧셈, 뺄셈, 곱셈, 나눗셈을 수행하는 함수형 인터페이스를 정의 
interface Calculator{
	int calculator(int num1, int num2);
}

public class C03Lamda {

	public static void main(String[] args) {
		Calculator add = (n1, n2) -> n1 + n2;
		Calculator sub = (n1, n2) -> n1>n2 ? n1-n2 : n2 - n1;
		Calculator mul = (n1, n2) -> n1 * n2;
		Calculator div = (n1, n2) -> n1 + n2;
		
//		Calculator sub = null;
//		
//		Calculator mul = null;
//		
//		Calculator div = null;
//		
		// 결과
		System.out.println(add.calculator(10, 20));

	}

}
