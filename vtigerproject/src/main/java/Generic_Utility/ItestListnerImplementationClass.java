package Generic_Utility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestListnerImplementationClass implements ITestListener
{

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}

	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
	 String  filePath = null;
	 
	 String testName = result.getMethod().getMethodName();
		System.out.println("-------excuted----------");
		
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass_File.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileUtils.copyFile(src, new File("./screenshot/"+testName+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP,result.getMethod().getMethodName() );
		test.log(Status.SKIP, result.getThrowable());
	}


	public void onStart(ITestContext context) 
	{
	Date d=new Date();
	System.out.println(d);
	d.toString().replace(" ", "-").replace(":", "-");
	
	ExtentSparkReporter htmlreport =new ExtentSparkReporter(new File("extentreport.html"));
	htmlreport.config().setDocumentTitle("VTIGER Report");
	htmlreport.config().setTheme(Theme.STANDARD);
	htmlreport.config().setReportName("Functional Test");
	
	report=new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("OS", "Windows 10");
	report.setSystemInfo("Environment", "Testing Environment'");
	report.setSystemInfo("URL", "http://localhost:8888");
	report.setSystemInfo("Reporter Name", "VivekChoudhary");
	
	}

	public void onFinish(ITestContext context)
	{
	report.flush();
	}

}
