package Ch04;

import java.util.*;
import java.util.stream.Collectors;

public class C04Ex {

    public static void main(String[] args) {
    	// 1) 1~45 까지 숫자를 6개를 랜덤으로 받아(Random클래스를 이용) set에 저장 / 출력
    	
        Random rnd = new Random();
        Set<Integer> lottoNumbers = new HashSet<>();

        // 랜덤 숫자 6개
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(rnd.nextInt(45) + 1);
        }
        for (Integer el : lottoNumbers)
        	System.out.println(el + " ");
        System.out.println();
        
        // 2) [추가] 저장된 set의 오름차순정렬을 해보세요 (검색을 통해서 해결해봅니다 - 스트림함수사용)
        // 오름차순 정렬
//        List<Integer> sortedNumbers = lottoNumbers.stream()
//                                                   .sorted()
//                                                   .collect(Collectors.toList());
//
//        System.out.println("오름차순 정렬: " + sortedNumbers);
        
        // 2-2)
        List<Integer> list = new ArrayList(lottoNumbers);
        Collections.sort(list);
        list.stream().forEach(System.out::println);
    }
}
