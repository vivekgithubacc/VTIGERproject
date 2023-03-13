package testcase3;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass_File;
import Generic_Utility.Excel_File;
import Generic_Utility.Java_File;
import Generic_Utility.Web_Utility;
import POM_File.CreateCamp_Page;
import POM_File.CreateOrganaisation_Page;
import POM_File.CreateProduct_Page;
import POM_File.Home_VTIGERPage;

public class ProductAndOrgRegionalRegressiontest extends BaseClass_File  {
@Test
	public void ProductAndOrgRegionalRegression () throws Throwable 
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
	          String productDATA = elib.getExcelData("product", 0, 0)+ranum;
		      cpage.clickOnCreateProductTextFieldName(productDATA);
		      cpage.clickOnProductSaveButton();
	          Thread.sleep(2000);
	       	String actdata = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
	        if(actdata.contains(productDATA))
	       {
	        	System.out.println("pass");
	         }
	        else
	       {
		   System.out.println("fails");
	     }
	             
	}
@Test
public void CreateOrganisationtest () throws Throwable
{

	Web_Utility wlib= new Web_Utility();
	wlib.VTIGERwaitForPageToLoad(driver);
	wlib.VTIGERmaximizeScreen(driver);	
	Home_VTIGERPage home= new Home_VTIGERPage(driver);
	home.ClickOrganisationLink();
	CreateOrganaisation_Page ppage= new CreateOrganaisation_Page(driver);
	ppage.clickonCreateOrgnstionImg();
	Java_File jlib= new Java_File();
	int ranum = jlib.getRandomnum();
	Excel_File elib=new Excel_File();
	String organisationDATA = elib.getExcelData2("organisation", 0, 0)+ranum;
	ppage.clickonCreateorgnstionTextField(organisationDATA);
	ppage.clickOnSaveButton();
	String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
    if(actdata.contains(organisationDATA))
    {System.out.println("pass");
     }
     else
     {
	System.out.println("fails");
     }
	
	}	
@Test
public  void CreateCampaignTest () throws Throwable {
	Web_Utility wlib= new Web_Utility();
	wlib.VTIGERwaitForPageToLoad(driver);
	wlib.VTIGERmaximizeScreen(driver);	
	Home_VTIGERPage hpage=new Home_VTIGERPage(driver);
	hpage.ClickToMore(driver);
	hpage.ClickToCampaign();
	CreateCamp_Page ccpage=new CreateCamp_Page(driver);
	ccpage.clickOnCamapignCreImg();
	Java_File jlib= new Java_File();
	int ranum = jlib.getRandomnum();
	Excel_File elib=new Excel_File();
	String CAMAPIGNDATA = elib.getExcelData3("camp", 0, 0)+ranum;
	ccpage.clickOnCmpaignTextField(CAMAPIGNDATA);
	ccpage.clickOncampaignSaveButton();
	String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
    if(actdata.contains(CAMAPIGNDATA))
    {System.out.println("pass");
     }
     else
     {
	System.out.println("fails");
     }
	
}

}
