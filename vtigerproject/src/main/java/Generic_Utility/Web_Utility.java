package Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Web_Utility {
	
	public void VTIGERmaximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void VTIGERwaitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void VTIGERswitchToWindow(WebDriver driver,String PartialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		  Iterator<String> it = allId.iterator();
		  
		  while(it.hasNext())
		  {
			 String wid= it.next();
			 driver.switchTo().window(wid);
			 if(driver.getTitle().contains(PartialWindowTitle))
			 {
				 break;
			 }
		  }
	}
	
	public void VTIGERswitchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	public void VTIGERswitchToAlertAndDismss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();		
	}
	
	public void VTIGERswitchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void VTIGERswitchToFrame(WebDriver driver,String id_name_Attributes)
	{
		driver.switchTo().frame(id_name_Attributes);
	}
	
	
	public void VTIGERselect(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void VTIGERselect(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void VTIGERmouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void VTIGERrightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void VTIGERmoveByOffset(WebDriver driver,int x,int y)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	
}
