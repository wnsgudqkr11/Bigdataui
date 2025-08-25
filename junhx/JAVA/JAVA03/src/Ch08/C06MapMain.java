package Ch08;

import java.util.HashMap;
import java.util.Map;

public class C06MapMain {

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap();	
		
		//추가
		map.put("aaa",1111);
		map.put("bbb",2222);
		map.put("ccc",3333);
		map.put("ddd",4444);	// older가 삭제
		map.put("ddd",5555);	// newer가 적용
		
		// 확인
		for(String key : map.keySet()) {	// ["aaa","bbb","ccc","ddd"]
			System.out.println(key+" : " + map.get(key));
		}
		
		// 삭제
		map.remove("aaa");
		
		// 확인
		System.out.println("SIZE : "  + map.size());
		System.out.println("단건 : "  + map.get("bbb"));
		
	}
}
