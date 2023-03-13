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
import POM_File.CreateOrganaisation_Page;
import POM_File.Home_VTIGERPage;
import POM_File.Login_VTIGERPage;
import POM_File.ValidAndVerificationORG;

public class CreateOrganisationTest  extends BaseClass_File
{@Test(groups="smoke")
	public void CreateOrganisationTest () throws Throwable
	{     
	     Excel_File elib=new Excel_File();
	     Java_File jlib= new Java_File();
		 Web_Utility wlib= new Web_Utility();
		 wlib.VTIGERwaitForPageToLoad(driver);

         wlib.VTIGERmaximizeScreen(driver);	
	
		Home_VTIGERPage home= new Home_VTIGERPage(driver);
		home.ClickOrganisationLink();
		
		CreateOrganaisation_Page ppage= new CreateOrganaisation_Page(driver);
		ppage.clickonCreateOrgnstionImg();
	
		int ranum = jlib.getRandomnum();
	
		String organisationDATA = elib.getExcelData2("organisation", 0, 0)+ranum;
		
		ppage.clickonCreateorgnstionTextField(organisationDATA);
		ppage.clickOnSaveButton();

		ValidAndVerificationORG VVorg= new ValidAndVerificationORG(driver);
		VVorg.Organisationvalidation(driver, organisationDATA);
		
		}	
}