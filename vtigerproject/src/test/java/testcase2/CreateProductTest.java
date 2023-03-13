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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass_File;
import Generic_Utility.Excel_File;
import Generic_Utility.Java_File;
import Generic_Utility.Property_File;
import Generic_Utility.Web_Utility;
import POM_File.CreateProduct_Page;
import POM_File.Home_VTIGERPage;
import POM_File.Login_VTIGERPage;
import POM_File.ValidAndVerificationPRODUCT;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateProductTest  extends BaseClass_File {
	//@Test//(retryAnalyzer=Generic_Utility.RetryimpClass.class)
	@Test
	public void CreateProductTest () throws Throwable 
	{
		        Web_Utility wlib= new Web_Utility();
		        Java_File jlib= new Java_File();
				Excel_File elib=new Excel_File();
				int ranum = jlib.getRandomnum();
				Home_VTIGERPage home= new Home_VTIGERPage(driver);
				CreateProduct_Page cpage= new CreateProduct_Page(driver);
		
		        wlib.VTIGERwaitForPageToLoad(driver);
		     	wlib.VTIGERmaximizeScreen(driver);
	
		       home.ClickToProductLink();
	
		       cpage.clickOnCreateProductImg();
		
		        //Assert.assertEquals("A", "B");//(for listerner class/rteyanalyzer)

		       String productDATA = elib.getExcelData("product", 0, 0)+ranum;
		
		     cpage.clickOnCreateProductTextFieldName(productDATA);
	         cpage.clickOnProductSaveButton();
		
	          Thread.sleep(2000);
		
	          ValidAndVerificationPRODUCT VVpage=new ValidAndVerificationPRODUCT(driver);
	          VVpage.Productvalidationpage(driver, productDATA);	
	}

}
