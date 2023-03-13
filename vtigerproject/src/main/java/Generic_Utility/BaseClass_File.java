package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_File.Home_VTIGERPage;
import POM_File.Login_VTIGERPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_File {

	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void BS()
	{
		System.out.println("Database Connection started");
	}
	
	@BeforeTest(groups= {"smoke","regression"})
	public void BT()
	{
		System.out.println("parallel execution");
	}
	
	//@Parameters("BROWSER")//crossbrowser
	@BeforeClass(groups= {"smoke","regression"})
	public void BC() throws Throwable //use string BROWSER for crossbrowser
	{	
		//for crossbrowser comment both lines and use string browser
	Property_File plib= new Property_File();		
	String BROWSER = plib.getpropertyVTIGERkeyvalue("browser");
	
		 
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options1= new FirefoxOptions();
			options1.addArguments("--remote-allow-origins=*");
			driver=new FirefoxDriver(options1);
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
		driver= new ChromeDriver();
		}
		System.out.println("launching browsering");	
		sdriver=driver;//(listerner class)
	}
	
	@BeforeMethod(groups= {"smoke","regression"})
	public void BM() throws Throwable 
	{
		Property_File plib= new Property_File();	
		String URL = plib.getpropertyVTIGERkeyvalue("url");
		String USERNAME = plib.getpropertyVTIGERkeyvalue("username");
		String PASSWORD = plib.getpropertyVTIGERkeyvalue("password");
		 driver.get(URL);
		 Login_VTIGERPage loginvtiger =new Login_VTIGERPage(driver);
			loginvtiger.LoginToVTIGERApp(USERNAME, PASSWORD);
		
		System.out.println("login to application");
	}
	
	@AfterMethod(groups= {"smoke","regression"})
	public void AM() 
	{
		Home_VTIGERPage home= new Home_VTIGERPage(driver);
		home.SignOutLink(driver);
		System.out.println("logout from application");
	}
	
	@AfterClass(groups= {"smoke","regression"})
	public void AC()
	{
		System.out.println("close the browser");
	}
	
	@AfterTest(groups= {"smoke","regression"})
	public void AT()
	{
		System.out.println("parallel execution");
	}
	
	@AfterSuite(groups= {"smoke","regression"})
	public void AS()
	{
		System.out.println("Database connection loss");
	}
}
