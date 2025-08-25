package CH03;

import java.util.Scanner;
import java.util.Arrays;

public class C01ArrayMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [] arr1 = new int[5];
		System.out.println("배열 길이 : " + arr1.length);
		System.out.println("5개의 값을 입력하셈");
		arr1[0] = sc.nextInt();
		arr1[1] = sc.nextInt();
		arr1[2] = sc.nextInt();
		arr1[3] = sc.nextInt();
		arr1[4] = sc.nextInt();
		
		for(int i=0;i<arr1.length;i++) {
			System.out.println(i+"."+arr1[i]);
		}
		System.out.println("-----------------");
		for(int el:arr1) {
			System.out.println(el);
		}
		System.out.println("-----------------");
//		Arrays.stream(arr1).forEach((el)->{System.out.println(el);});
//		Arrays.stream(arr1).forEach(el->System.out.println(el));
		// 단일 매서드
//		Arrays.stream(arr1).forEach(System.out::println);
		
		// 배열에 입력된 정수중에 최대값과 최소값을 출력
//		int max = arr1[0];
//		int min = arr1[0];
//		
//		for(int el : arr1) {
//			if(max<el)
//				max=el;
//			if(min>el)
//				min=el;
//		}
//		System.out.println("MAX : " + max);
//		System.out.println("MIN : " + min);
		
		System.out.println("MAX : " + Arrays.stream(arr1).max().getAsInt());
		System.out.println("MAX : " + Arrays.stream(arr1).min().getAsInt());
		
	}

}
