package CH07;

import java.util.Scanner;

public class C01While {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		
//		int i = 1;
//		int sum = 0;
//		
//		int n = sc.nextInt();
//		while(i<=n) 
//		{
//				System.out.println("i : " + i);
//				sum = sum + i;
//				i++;
//		}
//		System.out.println("SUM : " + sum);
		
//		=========
//		int h = sc.nextInt();
//		int i = 0;
//		while (i<4) {
//			
//			while(h<5) {
//				System.out.print("*");
//				h++;
//			}
//			
//			System.out.println();
//			i++;
//		}
		
		
//		int h = sc.nextInt();
//		int i=0;
//		while(i<h) {
//				int j = 0;
//				while(j < h-i) {
//						System.out.print("*");
//						j++;
//				}
//				System.out.println();
//				i++;
//		}

		
		int i = 0;
		while (i < 4) {
			
			int j = 0;
			while (j < 3-i) {
				System.out.print(" ");
				j++;
			}
			int k = 0;
			while(k<=2*i) {
				System.out.print("*");
				k++;
			}
			System.out.println();
			i++;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
