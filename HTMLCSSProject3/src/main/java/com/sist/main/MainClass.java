package com.sist.main;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*
 *   <ul class="list-restaurants type-single-big top_list_restaurant_list">
              <li class="toplist_list">
              <span class="title ">
                          <a href="/restaurants/9EVyzauilukl"
                             onclick="trackEvent('CLICK_RESTAURANT', {&quot;position&quot;:0,&quot;restaurant_key&quot;:&quot;9EVyzauilukl&quot;})">
                            1.<h3> 시라카와</h3>
                          </a>
                        </span>
 */
public class MainClass {

	
		
		public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
		public static final String WEB_DRIVER_PATH = "C:\\webDev\\chromedriver.exe"; //드라이버 경로
		
		public static void main(String[] args) {
			//드라이버 설정
			try {
				System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//크롬 설정을 담은 객체 생성
			ChromeOptions options = new ChromeOptions();
			//브라우저가 눈에 보이지 않고 내부적으로 돈다.
			//설정하지 않을 시 실제 크롬 창이 생성되고, 어떤 순서로 진행되는지 확인할 수 있다.
			options.addArguments("headless");
			
			//위에서 설정한 옵션은 담은 드라이버 객체 생성
			//옵션을 설정하지 않았을 때에는 생략 가능하다.
			//WebDriver객체가 곧 하나의 브라우저 창이라 생각한다.
			WebDriver driver = new ChromeDriver(options);
			
			//이동을 원하는 url
			String url = "https://www.mangoplate.com/top_lists/2697_bukchon";
			
			//WebDriver을 해당 url로 이동한다.
			driver.get(url);
			
			
			List<WebElement> el1 = driver.findElements(By.className("info"));
			driver.findElements(By.cssSelector(url));
			
			System.out.println(el1);
			for (WebElement item:el1)
			{
				String link=item.findElement(By.tagName("a")).getAttribute("href");
				System.out.println(link);
			}
			//브라우저 이동시 생기는 로드시간을 기다린다.
			//HTTP응답속도보다 자바의 컴파일 속도가 더 빠르기 때문에 임의적으로 1초를 대기한다.
			//try {Thread.sleep(1000);} catch (InterruptedException e) {}
			
			//class="nav" 인 모든 태그를 가진 WebElement리스트를 받아온다.
			//WebElement는 html의 태그를 가지는 클래스이다.
			//List<WebElement> el1 = driver.findElements(By.className("artist"));
			
			/*
			 * for (int i = 0; i < el1.size(); i++) { //nav 클래스의 객체 중 "뉴스"라는 텍스트를 가진
			 * WebElement를 클릭한다. if(el1.get(i).getText().equals("뉴스")) { el1.get(i).click();
			 * break; } }
			 * 
			 * //1초 대기 try {Thread.sleep(1000);} catch (InterruptedException e) {}
			 * 
			 * //버튼을 클릭했기 때문에 브라우저는 뉴스창으로 이동돼 있다. //이동한 뉴스 창의 IT/과학 뉴스 헤드라인을 가져온다.
			 */
			//iT/과학뉴스를 담은 div
			//WebElement el2 = driver.findElement(By.className("list-restaurants"));
			
			
			//div속에서 strong태그를 가진 모든 element를 받아온다.
			//List<WebElement> el3 = el2.findElements(By.className("title"));
			
			//int count = 0;
			//for (int i = 0; i < el3.size(); i++) {
				//뉴스의 제목을 모두 출력한다.
				//System.out.println(++count + "번 뉴스: "+ el3.get(i).getText());
			//}
			/*
			 * for(int i=0;i<el1.size();i++) { System.out.println(el1.get(i).getText()); }
			 * 
			 * List<WebElement> el2 = driver.findElements(By.className("albumtitle"));
			 * 
			 * for(int i=0;i<el2.size();i++) { System.out.println(el2.get(i).getText()); }
			 */
			
            
			/*
			 * try { //드라이버가 null이 아니라면 if(driver != null) { //드라이버 연결 종료 driver.close();
			 * //드라이버 연결 해제
			 * 
			 * //프로세스 종료
			 * 
			 * } } catch (Exception e) { throw new RuntimeException(e.getMessage()); }
			 * finally { driver.quit(); }
			 */
		}
	}


