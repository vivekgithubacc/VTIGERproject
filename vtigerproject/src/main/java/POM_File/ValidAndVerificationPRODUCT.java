package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidAndVerificationPRODUCT 
{
	public ValidAndVerificationPRODUCT(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="span.lvtHeaderText")
	private WebElement actualPRODUCTVVdata;
	
	//GETTER
	public WebElement getActualPRODUCTVVdata() {
		return actualPRODUCTVVdata;
	}
	//METHODS
	public void Productvalidationpage(WebDriver driver,String productDATA)
	{
		String actdata = actualPRODUCTVVdata.getText();
		if(actdata.contains(productDATA))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	}
}
