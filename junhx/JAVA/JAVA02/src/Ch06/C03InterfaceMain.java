package Ch06;

interface Remote {
	int MAX_VOL=100;		// public static final
	int MIN_VOL=100;		// public static final

	// 강제로 powerOn/Off를 써서 만들어라
	void powerOn(); // 추상메서드
	void powerOff(); // 추상메서드
	void setVolume(int vol);
	// 미완성 상태
}

interface Browser {
	void searchURL(String url);
}

class Tv implements Remote {
	private int nowVol;

	@Override
	public void powerOn() {
		System.out.println("TV ON");
	}

	@Override
	public void powerOff() {
		System.out.println("TV OFF");
	}

	@Override
	public void setVolume(int vol) {
		if(vol>=MAX_VOL)
			this.nowVol = MAX_VOL;
		else if(vol<=MIN_VOL)
			this.nowVol = MIN_VOL;
		else
			this.nowVol = vol;
		System.out.println("TV 현재 볼륨 : " + nowVol);
	}
	// 완성 시킴
}
class SmartTV extends Tv implements Browser{	// implements는 extends 뒤에 넣기

	@Override
	public void searchURL(String url) {
		System.out.println(url + "로 이동");
	}
}


class Radio implements Remote{
	private int nowVol;
	
	@Override
	public void powerOn() {
		System.out.println("RADIO ON");
	}

	@Override
	public void powerOff() {
		System.out.println("RADIO OFF");
	}

	@Override
	public void setVolume(int vol) {
		if(vol>=MAX_VOL)
			this.nowVol = MAX_VOL;
		else if(vol<=MIN_VOL)
			this.nowVol = MIN_VOL;
		else
			this.nowVol = vol;
		System.out.println("RADIO 현재 볼륨 : " + nowVol);
	}
	// 완성 시킴
}

public class C03InterfaceMain {

	public static void TurnOn(Remote controller) {	// TV/Radio 객체
										// Remote controller = new Tv() => UpCasting / 재정의 가능
			controller.powerOn();
		}

	public static void TurnOff(Remote controller) {
		controller.powerOff();
	}
	
	public static void ChangeVolume(Remote controller, int vol) {
		controller.setVolume(vol);
	}
	
	public static void Internet(Browser browser, String url) {
		browser.searchURL(url);
	}

	public static void main(String[] args) {
		Tv tv = new Tv();
		Radio radio = new Radio();
		SmartTV smartTv = new SmartTV();
		
		TurnOn(smartTv);
		ChangeVolume(smartTv, 10);
		Internet(smartTv, "www.naver.com");
		
		TurnOff(smartTv);
		
//		TurnOn(tv);
//		TurnOn(radio);
//		
//		ChangeVolume(tv, 50);
//		ChangeVolume(tv, 120);
//		ChangeVolume(radio, -10);
//		ChangeVolume(radio, 70);
//		
//		TurnOff(tv);
//		TurnOff(radio);
	}

}
