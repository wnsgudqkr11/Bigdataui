package Ch01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class C07LocalDateTimeFormatMain {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("YYYY/MM/DD 입력 : ");
//		String ymd = sc.next();
//		
//		// 포매터 객체 생성(입력용)
//		DateTimeFormatter fmtin = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		LocalDate date = LocalDate.parse(ymd,fmtin);
//		System.out.println(date);
//		
//		// 포매터 객체 생성 (출력용)
//		DateTimeFormatter fmtout = DateTimeFormatter.ofPattern("yyyy*MM*dd");
//		System.out.println("출력포맷 : " + fmtout.format(date));
		
//		-------------------------------------------------------------
		
		Scanner sc = new Scanner(System.in);
		System.out.print("YYYY/MM/DD HH:MM:SS 입력 : ");
		String ymd = sc.nextLine();
		
		// 포매터 객체 생성(입력용)
		DateTimeFormatter fmtin = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDate date = LocalDate.parse(ymd,fmtin);
		System.out.println(date);
		
//		포매터 객체 생성 (출력용)
		DateTimeFormatter fmtout = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		System.out.println("출력포맷 : " + fmtout.format(date));
	}

}
