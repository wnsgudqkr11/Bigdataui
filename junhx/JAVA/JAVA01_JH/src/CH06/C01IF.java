package CH06;

import java.util.Scanner;

public class C01IF {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 :" );
//		int age = sc.nextInt();
//		if(age >= 8 )
//			System.out.println("학교 다님");
//		System.out.println("첫번째 IF 코드 블럭 종료");
//		
//		if(age < 8 )
//			System.out.println("학교 안 다님");
//	  	
//		
//		System.out.println("두번째 IF 코드 블럭 종료");
//		System.out.println("프로그램 종료");

		System.out.print("점수 입력 : ");
		int a = sc.nextInt();
		
		if (a >= 90) {
			System.out.println("A");
		}
		else if (a>= 80) {
			System.out.println("B");
		}
		else if (a >= 70) {
				System.out.println("C");
		}
		else if (a>=60) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
		
		
		
		sc.close();
		
	}

}
