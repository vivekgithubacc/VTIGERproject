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
import POM_File.CreateCamp_Page;
import POM_File.Home_VTIGERPage;
import POM_File.Login_VTIGERPage;
import POM_File.ValidAndVerificationofCAMPAIGN;

public class CreateCampaignTest  extends BaseClass_File {
@Test(groups="smoke")
	public  void CreateCampaignTest () throws Throwable {

		Web_Utility wlib= new Web_Utility();
		Java_File jlib= new Java_File();
		Excel_File elib=new Excel_File();
		Home_VTIGERPage hpage=new Home_VTIGERPage(driver);
		
		wlib.VTIGERwaitForPageToLoad(driver);
		wlib.VTIGERmaximizeScreen(driver);

		hpage.ClickToMore(driver);
		hpage.ClickToCampaign();
		
		CreateCamp_Page ccpage=new CreateCamp_Page(driver);
		ccpage.clickOnCamapignCreImg();
		
		int ranum = jlib.getRandomnum();
		
		String CAMAPIGNDATA = elib.getExcelData3("camp", 0, 0)+ranum;
		
		ccpage.clickOnCmpaignTextField(CAMAPIGNDATA);
		ccpage.clickOncampaignSaveButton();
	
		ValidAndVerificationofCAMPAIGN VVpage= new ValidAndVerificationofCAMPAIGN(driver);
		VVpage.campaignvalidation(driver, CAMAPIGNDATA);
		
	}

}
