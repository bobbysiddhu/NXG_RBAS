package Tesngmaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NXG_QAlab {

	public static void main(String[] args)
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Raje\\Java\\chromedriver_win32 (3)\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
	/*	 driver.get("https://google.com");*/
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
				/*   driver.findElement(By.class("fa fa-sign-out  ser-icon-default")).click();	
				 //*[@id="ser-header-link"]/li[3]/a/text()*/
	}
	}

