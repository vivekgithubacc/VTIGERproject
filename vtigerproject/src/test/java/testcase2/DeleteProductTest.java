package testcase2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass_File;
import Generic_Utility.Excel_File;
import Generic_Utility.Java_File;
import Generic_Utility.Property_File;
import Generic_Utility.Web_Utility;
import POM_File.CreateProduct_Page;
import POM_File.Home_VTIGERPage;
import POM_File.Login_VTIGERPage;


public class DeleteProductTest  extends BaseClass_File  {
@Test(groups="regression")
	public  void DeleteProductTest () throws Throwable {

		Web_Utility wlib= new Web_Utility();
		Java_File jlib= new Java_File();
		Excel_File elib=new Excel_File();
		
		wlib.VTIGERwaitForPageToLoad(driver);
	 	wlib.VTIGERmaximizeScreen(driver);
	
		Home_VTIGERPage home= new Home_VTIGERPage(driver);
		home.ClickToProductLink();
		
		CreateProduct_Page cpage= new CreateProduct_Page(driver);
		cpage.clickOnCreateProductImg();
	
		int ranum = jlib.getRandomnum();
		
		String PRODUCTDELETEDATA = elib.getExcelData1("prodelt", 0, 0)+ranum;
		
		cpage.clickOnCreateProductTextFieldName(PRODUCTDELETEDATA);
		cpage.clickOnProductSaveButton();
		
		driver.findElement(By.name("Delete")).click();
		wlib.VTIGERswitchToAlertAndAccept(driver);
	
	}

}
