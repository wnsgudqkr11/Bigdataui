package Ch04;

import java.util.*;

public class C02ListMain {

	public static void main(String[] args) {
		
//		List<String> list = new ArrayList();
//		List<String> list = new LinkedList();
		List<String> list = new Vector();
		
		// 추가
		list.add("HTML/CSS/JS");
		list.add("NODEJS");
		list.add("SCSS");
		list.add("REACT");
		list.add("JAVA");
		list.add("JSP/SERVLET");
		list.add("STS");
		list.add("SPRING BOOT");

		// 조회
		System.out.println("개수 확인 : " + list.size());
		System.out.println("idx로 조회 : " + list.get(2));
		System.out.println("Value로 idx확인 : " + list.indexOf("JAVA"));
		list.forEach(System.out::println);
		
		// 삭제
		list.remove(0);
		list.remove("JQUERY");
		System.out.println("---");
		list.forEach(System.out::println);
		
		// 전체삭제
		list.clear();	
		
	}
}
