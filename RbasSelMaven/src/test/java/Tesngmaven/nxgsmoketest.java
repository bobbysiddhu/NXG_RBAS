package Tesngmaven;

import org.testng.annotations.Test;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import Selenium.Xls_Reader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class nxgsmoketest {
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
  public void nxgloginfromportal() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Raje\\Java\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
      driver.manage().deleteAllCookies();
					   
		/* read from excel*/
		Xls_Reader reader = new Xls_Reader("./src/test/java/NXGTestData/NXG_Logins_URL.xlsx");
			   
		   String sheetName= "login";
		   int rowCount = reader.getRowCount(sheetName);
	    
	    for(int rowNum=2;rowNum<=rowCount;rowNum++) {
	    	
	    	String enviurl= reader.getCellData(sheetName,"URL",rowNum);
	    	System.out.println("URL :" +enviurl);
	    	
	    	driver.get(enviurl);
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      	      	
			
	    	WebElement username=driver.findElement(By.id("ctl00_Content_SerLogin_user"));
			WebElement lockword=driver.findElement(By.id("ctl00_Content_SerLogin_password"));
	    	
			String loginId= reader.getCellData(sheetName,"Username",rowNum);
		   	String passWord= reader.getCellData(sheetName,"password",rowNum);
		   	
		   	username.clear();
		   	username.sendKeys(loginId);
		   	lockword.clear();
		   	lockword.sendKeys(passWord);
		   	
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id("ctl00_Content_SerLogin_btn_Login_Login")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			System.out.println(loginId+"  "+passWord);

		   	System.out.println("User Succesfully logged in "+loginId);
		
		   	/* Get First App */
		   	WebElement APPExists = driver.findElement(By.xpath("//*[@id='ctl00_Content_ser-appmenu2']/div/div/a[1]/div/span"));
		   	String ANAtxt = APPExists.getText();
		/*   	String ANAtxt1 = ANAExists.getAttribute("innerHTML");*/
		   	System.out.println(ANAtxt);
		  /* 	System.out.println(ANAtxt1);*/

		   	if(APPExists.getText().equalsIgnoreCase("Analyzer"))
		   		{
     			 System.out.println( "Analyser is present");  
     			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     		driver.findElement(By.xpath("//div[@id='ctl00_Content_ser-appmenu2']/div/div/a/div/img")).click();
 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     	System.out.println("Successfully into Analyzer");
     		System.out.println("Analyser is opened" );
     		boolean AnalyzerimgPresence1= driver.findElement(By.xpath("//ul[@id=\"ser-header-link\"]/li[2]/a/i")).isDisplayed();
     		if  (AnalyzerimgPresence1)
 			{ System.out.println(loginId + "Analyzer user");
	     	
   	 	    	driver.findElement(By.cssSelector(".ser-action-enabled:nth-child(3) > a"));
     			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   	 	     	driver.findElement(By.xpath("//ul[@id='ser-header-link']/li[3]/a"));
   				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   	 	     	driver.findElement(By.xpath("//li[3]/a")).click();
 			}
			System.out.println("Successfully out from Analyzer");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     			}
		
	     	else {
	     		System.out.println("NO Analyzer");
	     	 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     	 	driver.findElement(By.cssSelector(".ser-action-enabled:nth-child(3) > a"));
   	 	     	driver.findElement(By.xpath("//ul[@id='ser-header-link']/li[3]/a"));
     			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   	 	     	driver.findElement(By.xpath("//li[3]/a")).click();
	     	}	   	
		
	     }
	    driver.quit();   
  }
  
  
 
}
