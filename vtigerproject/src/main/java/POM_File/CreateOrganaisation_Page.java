package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganaisation_Page {

	public CreateOrganaisation_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organisationCreateImage;
	
	@FindBy(name="accountname")
	private WebElement  organisationTextFieldName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
      //GETTER
	public WebElement getOrganisationCreateImage() {
		return organisationCreateImage;
	}

	public WebElement getOrganisationTextFieldName() {
		return organisationTextFieldName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//METHOD
	public void clickonCreateOrgnstionImg()
	{
		organisationCreateImage.click();
	}
	public void clickonCreateorgnstionTextField(String data)
	{
		organisationTextFieldName.sendKeys(data);
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
}
