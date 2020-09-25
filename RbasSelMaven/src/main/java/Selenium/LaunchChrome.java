package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver","C:\\Raje\\Java\\chromedriver_win32 (3)\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://google.com");
		 System.out.println(driver.getTitle());
	}

}
