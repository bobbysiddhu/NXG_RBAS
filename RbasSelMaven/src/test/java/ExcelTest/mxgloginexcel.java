package ExcelTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Selenium.Xls_Reader;

public class mxgloginexcel {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Raje\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		
		/*driver.manage().window().maximize();*/
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			   
		/* read from excel*/
		Xls_Reader reader = new Xls_Reader("./src/test/java/NXGTestData/NXG_Logins_withoutURL.xlsx");
			   
		   String sheetName= "login";
		   int rowCount = reader.getRowCount(sheetName);
	    
	    for(int rowNum=2;rowNum<=rowCount;rowNum++) {
	    	
	    	driver.get("https://qa.serenatalab.com/nethotel/login.aspx?goto=/nethotel/home.aspx");
			/*driver.manage().window().maximize();*/
			
	    	WebElement username=driver.findElement(By.id("ctl00_Content_SerLogin_user"));
			WebElement lockword=driver.findElement(By.id("ctl00_Content_SerLogin_password"));
	    	
			String loginId= reader.getCellData(sheetName,"Username",rowNum);
		   	String passWord= reader.getCellData(sheetName,"password",rowNum);
		   	System.out.println(loginId+"  "+passWord);
		   	
		   	username.clear();
		   	username.sendKeys(loginId);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   	lockword.clear();
		   	lockword.sendKeys(passWord);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    driver.findElement(By.id("ctl00_Content_SerLogin_btn_Login_Login")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 		  	   		
		   driver.findElement(By.id("ser-header-link"));
		   driver.findElement(By.linkText("Logout")).click();		   			   
		   }
	}

}
