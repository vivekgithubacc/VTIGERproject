package testcase2;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import POM_File.CreateCamp_Page;
import POM_File.CreateProduct_Page;
import POM_File.Home_VTIGERPage;
import POM_File.Login_VTIGERPage;
import POM_File.VVCamapignAndProduct;

public class CampaignAndProductTest extends BaseClass_File  {
	@Test
	public  void CampaignAndProductTest () throws Throwable
	{
		       Excel_File elib1=new Excel_File();
	           Web_Utility wlib=new Web_Utility();
	           Java_File jlib= new Java_File();
	           Excel_File elib=new Excel_File();
	           Home_VTIGERPage home= new Home_VTIGERPage(driver);
	       
	           wlib.VTIGERwaitForPageToLoad(driver);
	           wlib.VTIGERmaximizeScreen(driver);
	           
	           home.ClickToProductLink();
	
	           CreateProduct_Page cpage= new CreateProduct_Page(driver);
	           cpage.clickOnCreateProductImg();

	            int ranum = jlib.getRandomnum();

	            String CAMPproductDATA = elib.getExcelData4("createPROD", 0, 0)+ranum;
	            cpage.clickOnCreateProductTextFieldName(CAMPproductDATA);
	            cpage.clickOnProductSaveButton();

	            VVCamapignAndProduct combo= new VVCamapignAndProduct(driver);
	            combo.COMBOProductvalidationpage(driver, CAMPproductDATA);
	
	            home.ClickToMore(driver);
	            home.ClickToCampaign();

	           CreateCamp_Page ccpage=new CreateCamp_Page(driver);
	           ccpage.clickOnCamapignCreImg();
	
	           String CAMPproductDATA2= elib1.getExcelData5("OrgP", 0, 0)+ranum;
	           ccpage.clickOnCmpaignTextField(CAMPproductDATA2);
	 
	          driver.findElement(By.xpath("//img[@alt='Select']")).click();
	          wlib.VTIGERswitchToWindow(driver, "Products&action");
	
		      Thread.sleep(3000);
		      driver.findElement(By.name("search_text")).sendKeys(CAMPproductDATA);
		      driver.findElement(By.xpath("//input[@type='button']")).click();
		      driver.findElement(By.xpath("//a[text()='"+CAMPproductDATA+"']")).click();
	
		     wlib.VTIGERswitchToWindow(driver, "Campaigns&action");

		     driver.findElement(By.name("button")).click();

		     VVCamapignAndProduct combo1= new VVCamapignAndProduct(driver);
		     combo1.COMBOcampaignvalidation(driver, CAMPproductDATA2);
		
}
}
