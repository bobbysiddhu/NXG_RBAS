package ExcelTest;

import Selenium.Xls_Reader;

public class nxgexcelread {

	public static void main(String[] args) {
		
			/*  Xls_Reader reader = new Xls_Reader("C:\\Raje\\Java\\RBAS_Java\\RbasSelMaven\\src\\test\\java\\NXGTestData\\NXG_Logins.xlsx");*/
			/*Xls_Reader reader = new Xls_Reader("C:\\Raje\\Java\\NXG_Logins.xlsx");*/
		 
	/*   Xls_Reader reader = new Xls_Reader("./src/test/java/NXGTestData/NXG_Logins.xlsx");
	   System.out.println("excel opened");
	   
	   String sheetName= "login";
	   int colNum =0;
	   int rowNum=2;
	   String exdata= reader.getCellData(sheetName, colNum , rowNum);
	   
	   System.out.println(exdata);
	   
	   int rowCount1 = reader.getRowCount(sheetName);
	   System.out.println("total Rows:" +rowCount1);*/
	
	Xls_Reader reader = new Xls_Reader("./src/test/java/NXGTestData/NXG_Logins_withoutURL.xlsx");
	  
	   String sheetName= "login";
	   
	   int rowCount = reader.getRowCount(sheetName);
	   
	   for(int rowNum=2;rowNum<=rowCount;rowNum++) {
	   		   String loginId= reader.getCellData(sheetName,"Username",rowNum);
	   		String passWord= reader.getCellData(sheetName,"password",rowNum);
	   
	   System.out.println(loginId+"  "+passWord);
	   }
	}
}