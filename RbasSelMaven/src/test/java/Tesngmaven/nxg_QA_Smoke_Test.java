package Tesngmaven;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class nxg_QA_Smoke_Test {
	 @BeforeSuite
	  public void setup() {
			System.out.println("Setup system property for chrome");	}
	  @AfterSuite
	  public void generateTestReport() {
			System.out.println("Generate Test Report");	}
	  @BeforeClass
	  public void beforlaunchbrowser() {
		  System.out.println("launch Chrome Browser");  }

	  @AfterClass
	  public void closebrowser() {
		  System.out.println("Close Browser");  }

	  @BeforeTest
	  public void login() {
			System.out.println("Login method");}

	  @AfterTest
	  public void deleteallCookies() {
			System.out.println("Delete all Cookies");	}

  @Test
 public void nxgQASmokeTest() throws InterruptedException {
	  /*  System.setProperty("webdriver.chrome.driver","C:\\Raje\\Java\\chromedriver_win32 (3)\\chromedriver.exe");*/
	  System.setProperty("webdriver.chrome.driver","C:/Raje/Java/chromedriver_win32 (3)/chromedriver.exe");

		 WebDriver driver=new ChromeDriver();
		 driver.get("https://qa.serenatalab.com/nethotel/login.aspx?goto=/nethotel/home.aspx");
		 System.out.println(driver.getTitle());

		    	
				    String pageTitle = driver.getTitle();
		    	System.out.println(" Title: -  " + pageTitle );
		  
		    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		      	      	
				
		    	WebElement username=driver.findElement(By.id("ctl00_Content_SerLogin_user"));
		    	username.sendKeys("superuser");
		    	
				WebElement pas1=driver.findElement(By.id("ctl00_Content_SerLogin_password"));
				   				 	
				pas1.sendKeys ("QAInProgress");
			 	
				driver.findElement(By.id("ctl00_Content_SerLogin_btn_Login_Login")).click();
					  
			   		
			

			   	System.out.println("Succesfully logged in User  ");
			   	driver.findElement(By.xpath("//ul[@id='ser-header-link']/li[3]/a"));
	 	     	driver.findElement(By.xpath("//li[3]/a")).click();
	 	    driver.quit();   
  }
  
  
 
}
