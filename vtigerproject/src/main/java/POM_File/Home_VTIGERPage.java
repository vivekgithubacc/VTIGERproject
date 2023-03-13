package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Web_Utility;

public class Home_VTIGERPage {
	public Home_VTIGERPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(linkText="Products")
		private WebElement  ProductLinkedText;
		
		@FindBy(linkText="More")
		private WebElement MoreLink;
		
		@FindBy(name="Campaigns")
		private WebElement CampaignLinkText;
		
		@FindBy(linkText="Organizations")
		private WebElement OrganisationLinkText;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement SignOutImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement SignOut;
		
//GETTER
	public WebElement getProductLinkedText() {
		return ProductLinkedText;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getCampaignLinkText() {
		return CampaignLinkText;
	}

	public WebElement getOrganisationLinkText() {
		return OrganisationLinkText;
	}

	public WebElement getSignOutImg() {
		return SignOutImg;
	}

	public WebElement getSignOut() {
		return SignOut;
	}
	
//METHOD
	public void ClickToProductLink()
	{
		ProductLinkedText.click();
	}
	
	public void ClickToMore(WebDriver driver)
	{
		Web_Utility wlib= new Web_Utility();
		wlib.VTIGERmouseOverOnElement(driver, MoreLink);
	}
	
	public void ClickToCampaign()
	{
		CampaignLinkText.click();
	 }
	
	public void ClickOrganisationLink()
	{
		OrganisationLinkText.click();
	}
	
  public void SignOutLink(WebDriver driver)
{
	Actions act= new Actions(driver);
	act.moveToElement(SignOutImg).perform();
	SignOut.click();
	}
}
