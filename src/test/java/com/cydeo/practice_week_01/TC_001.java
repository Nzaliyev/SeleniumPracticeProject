package com.cydeo.practice_week_01;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_001 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa3.vytrack.com/user/login");
    }

    @Test
    public void vehicleServiceLog() throws InterruptedException {
        WebElement loginUsername = driver.findElement(By.id("prependedInput"));

        loginUsername.sendKeys("user13");

        WebElement loginPassword = driver.findElement(By.id("prependedInput2"));

        loginPassword.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.id("_submit"));

        loginBtn.click();

        WebElement fleetModule = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        fleetModule.click();

        WebElement vehicleServiceLog = driver.findElement(By.xpath("//span[.='Vehicle Services Logs']"));
        vehicleServiceLog.click();

        WebElement vehicleServiceLogText = driver.findElement(By.xpath("//h1[.='VehicleServicesLogs']"));

        Assert.assertTrue(vehicleServiceLogText.isDisplayed(), "Vehicle Service Log is not uploaded!");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
