package Tesngmaven;

import java.util.List;
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
  public void nxgloginfromportal() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Raje\\Java\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
      driver.manage().deleteAllCookies();
					   
		/* read from excel*/
		Xls_Reader reader = new Xls_Reader("./src/test/java/NXGTestData/NXG_Logins_URL.xlsx");
			   
		   String sheetName= "login";
		   int rowCount = reader.getRowCount(sheetName);
	    
	    for(int rowNum=2;rowNum<=rowCount;rowNum++) {
	    	
	    	String enviurl= reader.getCellData(sheetName,"URL",rowNum);
	    	System.out.println("URL :  - " +enviurl);
	    	String pageTitle = driver.getTitle();
	    	System.out.println(" Title: -  " + pageTitle );
	    	
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

		   	System.out.println("Succesfully logged in User  "+loginId);
		
		   	/* Get First App */
		   	WebElement APPExists = driver.findElement(By.xpath("//*[@id='ctl00_Content_ser-appmenu2']/div/div/a[1]/div/span"));
		   	String ANAtxt = APPExists.getText();
		/*   	String ANAtxt1 = ANAExists.getAttribute("innerHTML");*/
		   	System.out.println(ANAtxt);
		  /* 	System.out.println(ANAtxt1);*/
		   	List<WebElement> applinks= driver.findElements((By.tagName("a")));
		    for(WebElement objcurrentlink : applinks=driver.findElements((By.tagName("a"))))
		    	{		String Strlinktext= objcurrentlink.getText();
		    		if (Strlinktext != null && !Strlinktext.trim().isEmpty())	
		     	  		{  	System.out.println(Strlinktext);
		         	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);}
		    	}
		         	
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
     		 	 		driver.close();
     		 	 	}
     		 	 System.out.println("Successfully out from Analyzer");
     		 	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     		 	 driver.navigate().back();
     		 	 String currentURL = driver.getCurrentUrl();
     		 	System.out.println("Current url is " +currentURL );
     		 	Thread.sleep(2000);
     			}
		   	if (driver.findElement(By.xpath("//*[@id=\'ctl00_Content_ser-appmenu2\']/div/div/a[15]/div/span")).getText().equalsIgnoreCase("WebAdmin"))
	   		{
    			 System.out.println( "WebAdmin is present");  
    		 	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
    		 	 
    		 	 driver.findElement(By.xpath("//div[@id=\"ctl00_Content_ser-appmenu2\"]/div/div/a[15]/div/img")).click();
    		 	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    		 	 boolean AdmPresence1= driver.findElement(By.xpath("//ul[@id=\"ser-header-link\"]/li[2]/a/i")).isDisplayed();
    		 	 if  (AdmPresence1)
    		 	 	{ System.out.println(loginId + "WebAdmin user");
    		 	 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    		 	 	WebElement logoutfound =  driver.findElement(By.cssSelector(".fa.fa-sign-out.ser-icon-default"));
    		 	 		logoutfound.click();
    		 	 	}
    		 	 System.out.println("Successfully out from Webadmin");
    		 	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     		 	 driver.navigate().back();
     		 	 String currentURL = driver.getCurrentUrl();
     		 	System.out.println("Current url is " +currentURL );
     		 	Thread.sleep(2000);
     		 	driver.close();
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
