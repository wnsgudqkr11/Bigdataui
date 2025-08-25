package CH05;

import java.util.Scanner;

public class C02Ex {

	public static void main(String[] args) {
		// 문제 2 (삼항연산자 + 논리연산자)
				// 키보드로 국어/영어/수학 점수를 입력받아 각각의부분점수가 40점이상이고
				// 총점수합의 평균이 70점이상이면 '합격'
				// 미만이면 '불합격'을 출력합니다
		
		Scanner sc = new Scanner (System.in);
//		System.out.print("국영수 적어 : ");
//		
//		int kor = sc.nextInt();
//		int eng = sc.nextInt();
//		int math = sc.nextInt();
//		
//		double avg = (double)(kor + eng + math)/3;
//		
//		String result = (kor>40&&eng>40&&math>40&&avg>70 ? "합격" : "불합");
//		
//		System.out.printf("%s" , result);
//		
//		sc.close();
		


				// 미니문제 3 (%연산자)
				// 키보드로 부터 정수값 2개를 입력받아
				// 두수의 합이 짝수이면 "짝수입니다"
				// 홀수이면 "홀수입니다" 를 출력하세요~
		
		System.out.print("정수 2개 적어 : ");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int sum = 0;
		sum = a + b;
		
		
		
		System.out.printf("%s", (sum%2==0) ? "짝" : "홀");
		
//		double avg = (double)(kor + eng + math)/3;
//		
//		String result = (kor>40&&eng>40&&math>40&&avg>70 ? "합격" : "불합");
		
//		System.out.printf("%s" , result);
		
		sc.close();
		
		


	}

}
