package com.tricentiswebshop.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trcentiswebshop.base.Tricentis_BaseClass;



public class Tricentis_DataDriven extends Tricentis_BaseClass{


//    WebDriver driver;
//
//    @BeforeTest
//    public void setup() {
//        driver = new ChromeDriver();
//        driver.get("https://demowebshop.tricentis.com/login");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @DataProvider(name = "invalidloginData")
    public Object[][] getData() throws Exception {

        String path = "./src/test/resources/ExcelSheet/Tricentis_Webshop.xlsx";
        return ExcelUtils.getTestData(path, "Sheet1");
    }

    @Test(dataProvider = "invalidloginData")
    public void loginTest(String email, String password) {

    	 driver.findElement(By.linkText("Log in")).click();
    	
        
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Email")).clear();
        
        
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("Password")).clear();
        
        driver.findElement(By.className("login-button")).click();

        System.out.println("Executed for " + email  +" and "+password);
    }
    
//    @AfterTest
//    public void close() {
//    	driver.close();
//    }
}
