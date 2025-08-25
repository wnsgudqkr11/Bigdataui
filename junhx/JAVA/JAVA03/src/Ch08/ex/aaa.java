package Ch08.ex;

//java.util 패키지에 있는 여러 유틸리티 클래스들을 사용하기 위해 사용
import java.util.*;

public class aaa {

    //  Scanner 객체 생성 - 사용자의 입력을 받기 위해 사용
    private static Scanner sc = new Scanner(System.in);

    // 단어들 저장할 리스트 - 전역에서 공유 가능
    private static List<String> worldList = new ArrayList<String>();

    // 정렬 함수 (오름/내림)
    // worldList 안에 있는 모든 단어들을 정렬함
    public static void sort(boolean isAsend) { // true, false를 구별하기 위해 boolean을 사용
        if (isAsend) { // true
            Collections.sort(worldList); // isAsend가 오름차순으로 정렬
        } else { // false
            Collections.sort(worldList, Collections.reverseOrder()); // isAsend가 내림차순으로 정렬
        }
    }

    // 단어 추가 함수
    public static void add(String word) {
        worldList.add(word); // 입력받은 단어를 리스트에 추가
    }

    // 리스트에 있는 단어들 출력
    public static void show() {
    	// 리스트에 있는 단어를 하나씩 출력
        for (String word : worldList) {
            System.out.println(word); 
        }
    }

    public static void main(String[] args) {

        int n = 0; // 메뉴 번호 담을 변수

        while (true) { // 무한루프 - 종료 전까지 반복
            // 실행 시 보일 메뉴 띄우기
            System.out.println("------------M E N U------------");
            System.out.println("1 추가");
            System.out.println("2 정렬");
            System.out.println("3 확인");
            System.out.println("4 종료");
            System.out.println("------------M E N U------------");
            System.out.print("번호 : ");

            n = sc.nextInt(); // 번호 입력
            sc.nextLine();     // nextInt() 뒤에 남아 있는 엔터(\n) 제거
            // 엔터를 제거하지 않으면 다음 nextLine() 입력이 즉시 종료
            
            switch (n) {
                case 1: // 단어 추가
                    System.out.print("단어 입력: ");
                    String word = sc.nextLine(); // 사용자가 입력한 단어를 word에 저장
                    add(word); // 리스트에 추가
                    break; // 선택한 case만 실행 후 switch문 종료

                case 2: // 리스트 정렬
                    System.out.print("오름차순 여부(1:오름,0:내림) : ");
                    int no = sc.nextInt();// 사용자가 1 또는 0 입력
                    if (no == 1) sort(true); // 1을 입력하면 오름차순으로 정렬
                    else sort(false); // 0을 입력하면 내림차순으로 정렬
                    break;

                case 3: // 리스트 확인
                    show(); // 현재 리스트 출력
                    break;

                case 4: // 프로그램 종료
                    System.out.println("프로그램 종료");
                    System.exit(-1); // 프로그램 끝
                    break;

                default: // 지정된 번호 이외의 번호 입력 했을 경우
                    System.out.println("다시입력하세요");
            }
        }
    }
}
