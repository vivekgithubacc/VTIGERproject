package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VVCamapignAndProduct {
	
	public VVCamapignAndProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span.lvtHeaderText")
	private WebElement actualcomboPRODUCTVVdata;
	@FindBy(css="span.dvHeaderText")
	private WebElement actualCOMBOCAMPAIGNVVdata;
	
//GETTER
	public WebElement getActualcomboPRODUCTVVdata() {
		return actualcomboPRODUCTVVdata;
	}

	public WebElement getActualCOMBOCAMPAIGNVVdata() {
		return actualCOMBOCAMPAIGNVVdata;
	}

//METHOD
	public void COMBOProductvalidationpage(WebDriver driver,String CAMPproductDATA)
	{
		String actdata = actualcomboPRODUCTVVdata.getText();
		if(actdata.contains(CAMPproductDATA))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	}
	
	public void COMBOcampaignvalidation(WebDriver driver,String CAMPproductDATA2)
	{
		String actdata = actualCOMBOCAMPAIGNVVdata.getText();
		if(actdata.contains(CAMPproductDATA2))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	}
}
