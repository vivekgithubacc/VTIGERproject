package testcase2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import POM_File.CreateOrganaisation_Page;
import POM_File.Home_VTIGERPage;
import POM_File.Login_VTIGERPage;
import POM_File.VVOrgAndContact;


public class OrganisationAndContactTest  extends BaseClass_File{
@Test
	public  void OrganisationAndContactTest () throws Throwable {

		Web_Utility wlib=new Web_Utility();
		Java_File jlib= new Java_File();
		Excel_File elib=new Excel_File();
		
		wlib.VTIGERwaitForPageToLoad(driver);	
		wlib.VTIGERmaximizeScreen(driver);

		Home_VTIGERPage home= new Home_VTIGERPage(driver);
		home.ClickOrganisationLink();
		
		CreateOrganaisation_Page ppage= new CreateOrganaisation_Page(driver);
		ppage.clickonCreateOrgnstionImg();
	
		int ranum = jlib.getRandomnum();

		String ORGandPRODUCTDATA = elib.getExcelData6("conorgs", 0, 0)+ranum;
		ppage.clickonCreateorgnstionTextField(ORGandPRODUCTDATA);
		
		Thread.sleep(3000);
		ppage.clickOnSaveButton();
	
		VVOrgAndContact ORGCC= new VVOrgAndContact(driver);
		ORGCC.COMBOORGCONvalidationpage(driver, ORGandPRODUCTDATA);
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
		Excel_File elib1=new Excel_File();
		String ORGandPRODUCTDATA1 = elib.getExcelData7("corgnsaton", 0, 0)+ranum;
		
		driver.findElement(By.name("lastname")).sendKeys(ORGandPRODUCTDATA1);
		
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		wlib.VTIGERswitchToWindow(driver, "Accounts&action");

		 driver.findElement(By.id("search_txt")).sendKeys(ORGandPRODUCTDATA);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.xpath("//a[.='"+ORGandPRODUCTDATA+"']")).click();
		 wlib.VTIGERswitchToWindow(driver, "Contacts&action");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		VVOrgAndContact ccpage= new VVOrgAndContact(driver);
		ccpage.COMBOCONTACTvalidation(driver, ORGandPRODUCTDATA1);
		
	}
	}


