package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidAndVerificationORG {

	public ValidAndVerificationORG(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span.dvHeaderText")
	private WebElement actualORGVVdata;
	
	//GETTER
	public WebElement getActualcampaign1data() {
		return actualORGVVdata;
	}
	//METHOD
	public void Organisationvalidation(WebDriver driver,String organisationDATA)
	{
		String actdata = actualORGVVdata.getText();
		if(actdata.contains(organisationDATA))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	}
}
