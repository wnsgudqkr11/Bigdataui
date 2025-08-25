package Ch04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C03SetMain {

	public static void main(String[] args) {
		Set<String> set = new HashSet();
		
		// 추가
		set.add("HTML/CSS/JS");
		set.add("NODEJS");
		set.add("SCSS");
		set.add("REACT");
		set.add("JAVA");		// older
		set.add("JAVA");		// newer(적용)
		set.add("JSP/SERVLET");
		set.add("STS");
		set.add("SPRING BOOT");	// older
		set.add("SPRING BOOT");	// newer(적용)
		
		// 삭제
		set.remove("REACT");
		
		// 확인
		System.out.println("개수 확인 : " + set.size());
		
		// 탐색(고전) - Iterator
//		첫 번째 방법
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
//		두 번째 방법
		// 탐색(최근)
		for(String el : set) {
			System.out.println(el);
		}
		
		set.clear();
	}
}