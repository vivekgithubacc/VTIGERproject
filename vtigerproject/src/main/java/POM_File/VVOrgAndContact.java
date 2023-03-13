package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VVOrgAndContact {

	public VVOrgAndContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="span.dvHeaderText")
	private WebElement actualcomboORGVVdata;
	@FindBy(css="span.dvHeaderText")
	private WebElement actualCOMBOCONTACTVVdata;

//GETTER
	public WebElement getActualcomboORGVVdata() {
		return actualcomboORGVVdata;
	}

	public WebElement getActualCOMBOCONTACTVVdata() {
		return actualCOMBOCONTACTVVdata;
	}

	//METHOD
	public void COMBOORGCONvalidationpage(WebDriver driver,String ORGandPRODUCTDATA)
	{
		String actdata = actualcomboORGVVdata.getText();
		if(actdata.contains(ORGandPRODUCTDATA))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	}
	
	public void COMBOCONTACTvalidation(WebDriver driver,String ORGandPRODUCTDATA1)
	{
		String actdata = actualCOMBOCONTACTVVdata.getText();
		if(actdata.contains(ORGandPRODUCTDATA1))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	}
}
