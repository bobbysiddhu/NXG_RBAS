package Tesngmaven;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class nxgpwdreset {
  private static final int WebElement = 0;

@Test
  public void nxgADMpwd() {
	/*	System.setProperty("webdriver.chrome.driver","C:\\Raje\\Java\\chromedriver.exe");*/
		WebDriver driver = new ChromeDriver();

    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);      	    	
		driver.get("https://qa.serenatalab.com/nethotel/login.aspx?goto=/nethotel/home.aspx");
		driver.manage().window().maximize();

    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);      	      	
		driver.findElement(By.id("ctl00_Content_SerLogin_user")).sendKeys("superuser");
	    driver.findElement(By.id("ctl00_Content_SerLogin_password")).sendKeys("QAInProgress");
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      	      	
		driver.findElement(By.id("ctl00_Content_SerLogin_btn_Login_Login")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      	
    	
     	/* App Exists and opening */
     	driver.findElement((By.tagName("a")));
     	List<WebElement> applinks= driver.findElements((By.tagName("a")));
    for(WebElement objcurrentlink : applinks=driver.findElements((By.tagName("a"))))
    	{		String Strlinktext= objcurrentlink.getText();
    		if (Strlinktext != null && !Strlinktext.trim().isEmpty())	
     	  		{  	System.out.println(Strlinktext);
         	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         	/*	if(Strlinktext.equalsIgnoreCase("Analyzer"))
         		{ 	System.out.println( "Analyser is present");  */
         	/*	driver.findElement(By.xpath("//div[@id='ctl00_Content_ser-appmenu2']/div/div/a/div/img")).click();

         	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   
         		
         	          		WebElement ANAlogin = driver.findElement(By.xpath("//ul[@id='ser-header-link']/li[3]/a"));
         		Actions act= new Actions(driver);
         		act.moveToElement(ANAlogin).perform();
         		driver.findElement(By.xpath("//*[@id='ser-header-link']/li[3]/a/i")).click();
         		
         		
             	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          
         	    System.out.println( "Analyser is Opened");  
          	 
	 	     	 }*/
	 	     	     	
         		}
        	      	 }
 
     	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         boolean AnalyzerUser=driver.findElement(By.xpath("//a[contains(text(),'User,Super')]")).isDisplayed();
         System.out.println(AnalyzerUser+ "Right user");	
         System.out.println(driver.getCurrentUrl());
      	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     	driver.findElement(By.linkText("Logout")).click();
     	  driver.quit();
  }

  }
