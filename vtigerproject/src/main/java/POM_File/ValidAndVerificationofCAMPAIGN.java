package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidAndVerificationofCAMPAIGN {

	public ValidAndVerificationofCAMPAIGN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="span.dvHeaderText")
	private WebElement actualCAMPAIGNVVdata;
	
	//GETTER
	public WebElement getActualcampaign1data() {
		return actualCAMPAIGNVVdata;
	}
	//METHOD
	public void campaignvalidation(WebDriver driver,String CAMAPIGNDATA)
	{
		String actdata = actualCAMPAIGNVVdata.getText();
		if(actdata.contains(CAMAPIGNDATA))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	}
}
