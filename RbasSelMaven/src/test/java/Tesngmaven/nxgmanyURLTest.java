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

import Selenium.Xls_Reader;

public class nxgmanyURLTest {

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

  @BeforeSuite
  public void setup() {
		System.out.println("Setup system property for chrome");	}
  @AfterSuite
  public void generateTestReport() {
		System.out.println("Generate Test Report");	}


  @Test
  public void nxgmanyUrlTest() {
      
	WebDriver driver = new ChromeDriver();

	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   
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
	   	System.out.println("User Succesfully logged in "+loginId);
	   	/*System.out.println(loginId+"  "+passWord);*/
	   	
	   	username.clear();
	   	username.sendKeys(loginId);
	   	lockword.clear();
	   	lockword.sendKeys(passWord);
	    driver.findElement(By.id("ctl00_Content_SerLogin_btn_Login_Login")).click();
	 		  	   		
	   driver.findElement(By.id("ser-header-link"));
	   driver.findElement(By.linkText("Logout")).click();		   			   
     }
    driver.quit();   
  }
}
