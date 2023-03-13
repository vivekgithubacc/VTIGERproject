package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProduct_Page {

	public CreateProduct_Page(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productCreateImage;
	
	@FindBy(name="productname")
	private WebElement productTextFieldName;
	
	@FindBy(name="button")
	private WebElement saveProductButton;

	//GETTER
	public WebElement getProductCreateImage() {
		return productCreateImage;
	}

	public WebElement getProductTextFieldName() {
		return productTextFieldName;
	}

	public WebElement getSaveProductButton() {
		return saveProductButton;
	}
	//METHOD
	public void clickOnCreateProductImg()
	{
		productCreateImage.click();
	}
	public void clickOnCreateProductTextFieldName(String expro)
	{
		productTextFieldName.sendKeys(expro);
	}
	public void clickOnProductSaveButton()
	{
		saveProductButton.click();
	}
}
