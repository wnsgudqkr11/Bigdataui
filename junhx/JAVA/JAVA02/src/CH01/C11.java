package CH01;

class Buyer{
	private int myMoney;
	private int appleCnt;
	
	// 모든 인자 생성자
	public Buyer(int myMoney, int appleCnt) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}
	
	public void payment(Seller 사과장수, int money) {
		myMoney -= money;
		int cnt = 사과장수.receive(money);
		this.appleCnt += cnt;
	}
	
	// toString
	@Override
	public String toString() {
		return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
	}
	
}

class Seller{
	private int myMoney;
	private int appleCnt;
	private int price;
	
	// 모든 인자 생성자
	public Seller(int myMoney, int appleCnt, int price) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
		this.price = price;
	}
	
	public int receive(int money) {
		this.myMoney+=money;
		int cnt = money / this.price;
		appleCnt -= cnt;
		return cnt;
	}
	
	// toString
	@Override
	public String toString() {
		return "Seller [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", price=" + price + "]";
	}
	
}

public class C11 {
	public static void main(String[] args) {
		
		Buyer 홍길동 = new Buyer(10000, 0);
		Buyer 티모 = new Buyer(20000, 0);
		
		Seller 사과장수1 = new Seller(50000, 100, 1000);
		
		// 구매하는 작업
		홍길동.payment(사과장수1, 3000);
		티모.payment(사과장수1, 8000);
		
		System.out.println(홍길동);
		System.out.println(티모);
		System.out.println(사과장수1);
		
	}
}
