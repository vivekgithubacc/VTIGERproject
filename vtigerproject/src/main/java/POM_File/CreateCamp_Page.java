package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCamp_Page {

	
		public CreateCamp_Page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	
		@FindBy(xpath="//img[@alt='Create Campaign...']")
		private WebElement  campaignCreateImage;
		
		@FindBy(name="campaignname")
		private WebElement campaignTextFieldName;
		
		@FindBy(name="button")
		private WebElement campaignSaveButton;

		//GETTER
		public WebElement getCampaignCreateImage() {
			return campaignCreateImage;
		}

		public WebElement getCampaignTextFieldName() {
			return campaignTextFieldName;
		}

		public WebElement getCampaignSaveButton() {
			return campaignSaveButton;
		}
       //METHOD
		public void clickOnCamapignCreImg()
		{
			campaignCreateImage.click();
		}
		public void clickOnCmpaignTextField(String campdata)
		{
			campaignTextFieldName.sendKeys(campdata);
		}
		public void clickOncampaignSaveButton()
		{
			campaignSaveButton.click();
		}
		
	}

