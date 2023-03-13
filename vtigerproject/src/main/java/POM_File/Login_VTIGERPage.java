package POM_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_VTIGERPage {
	public Login_VTIGERPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(name="user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement LoginButton;

	//GETTER
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}
//METHOD
	public WebElement getLoginButton() {
		return LoginButton;
	}
	public void LoginToVTIGERApp(String UserName,String PassWord)
	{
		UserTextField.sendKeys(UserName);
		PasswordTextField.sendKeys(PassWord);
		LoginButton.click();
	}	
	
}
