package com.trcentiswebshop.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.lang.reflect.Method;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.tricentiswebshop.pages.Tricentis_CartPage;
import com.tricentiswebshop.pages.Tricentis_CheckoutPage;
import com.tricentiswebshop.pages.Tricentis_HomePage;
import com.tricentiswebshop.pages.Tricentis_LoginPage;
import com.tricentiswebshop.pages.Tricentis_OrderCompletedPage;
import com.tricentiswebshop.pages.Tricentis_ProductDetailsPage;
import com.tricentiswebshop.pages.Tricentis_ProductPage;
import com.tricentiswebshop.pages.Tricentis_RegisterPage;

public class Tricentis_BaseClass {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	
	public static ExtentSparkReporter reporter;
	public static ExtentTest test;
	public static ExtentReports extent;
	
	public Tricentis_RegisterPage rp;
	public Tricentis_HomePage hp;
	public Tricentis_LoginPage lp;
	public Tricentis_ProductPage pp;
	public Tricentis_ProductDetailsPage pdp;
	public Tricentis_CartPage cp;
	public Tricentis_CheckoutPage cop;
	public Tricentis_OrderCompletedPage oc;
	
	
	@BeforeTest
	public void baseclass()
	{	
		
		reporter = new ExtentSparkReporter("./Reports/myreport.html");
		reporter.config().setDocumentTitle("Automationreport");
		reporter.config().setReportName("functional test");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "window 11");
		extent.setSystemInfo("testername", "xyz");
		extent.setSystemInfo("Browser Name", "Chrome");
		
		ChromeOptions options = new ChromeOptions();	//Incognito
		options.addArguments("--incognito");
//		options.addArguments("--autoplay-policy=no-user-gesture-required");
		
		driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().deleteAllCookies();

	}
	
	@BeforeMethod
	public void pageSetup(Method mthd)
	{
		wait = new WebDriverWait (driver, Duration.ofSeconds(20));
		
		rp = new Tricentis_RegisterPage(driver);
		hp = new Tricentis_HomePage(driver);
		lp = new Tricentis_LoginPage(driver);
		pp = new Tricentis_ProductPage(driver);
		pdp = new Tricentis_ProductDetailsPage(driver);
		cp = new Tricentis_CartPage(driver);
		cop = new Tricentis_CheckoutPage(driver);
		oc = new Tricentis_OrderCompletedPage(driver);
		
		 test = extent.createTest(mthd.getName());
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}
			@AfterMethod
			public void browserclose(ITestResult result)throws IOException
			{
				if(result.getStatus()==ITestResult.FAILURE)
				{
					test.log(Status.FAIL, "test case failed is "+result.getName());
					test.log(Status.FAIL,"test case failed is "+result.getThrowable());
					
					
					
				}
				else if (result.getStatus()==ITestResult.SKIP)
				{
					test.log(Status.SKIP, "test case skipped is "+result.getName());
				}
				else if (result.getStatus()==ITestResult.SUCCESS)
				{
					test.log(Status.PASS, "test case passed is "+ result.getName());
				}
			}
		


}
