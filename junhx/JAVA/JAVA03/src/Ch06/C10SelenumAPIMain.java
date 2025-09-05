package Ch06;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C10SelenumAPIMain {
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "src/drivers/chromedriver.exe";
	
	public static void main(String[] args) {
		// Seleum 3.x 기준 브라우저 활성화 방법(4.x 부터는 chromdrive.exe 를 윈도우 PATH에 등록시 경로 설정 필요없음)
		System.setProperty(WEB_DRIVER_PATH, WEB_DRIVER_ID);
		
		// 크롬브라우저 옵션 설정
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--no-sandbox");
		
		// 크롬브라우저 활성화
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.naver.com");
		
		// 특정 요소 위치 선택 (키워드 입력하기)
		WebElement searchEl = driver.findElement(By.id("query"));
		
		// 키워드 입력
		searchEl.sendKeys("모니터");
		
		// 엔터키 전달
		searchEl.sendKeys(Keys.RETURN);
		
		// 쇼핑버튼 클릭 ( .api_flicking_wrap .tab:nth-child(1) )
		WebElement shoppingBtnEl = driver.findElement(By.cssSelector(".api_flicking_wrap .tab:nth-child(1)"));
		// 새창열기(target="_blank") 제거
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('target')",shoppingBtnEl);
		
		shoppingBtnEl.click();
		
		Thread.sleep(500);
		
		// 리뷰 좋은 순 클릭 (.subFilter_sort__4Q_hv._nlog_click
		
		// 창 닫기
		// driver.close();
		
		
		
	}

}
