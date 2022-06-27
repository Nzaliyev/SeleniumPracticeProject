package com.cydeo.practice_week_02;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TC1_Smartbear_link_verification {

    @Test
    public void link_verification(){
        // Open browser
//        // Go to "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
//    Driver.getDriver().get(ConfigurationReader.getProperty("smartbearsoftware.practice.url"));
//
//    // Enter username: “Tester
//        WebElement usernameBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
//        usernameBox.sendKeys("Tester");
//
//        //Enter password: “test”
//        WebElement passwordBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_password"));
//        passwordBox.sendKeys("test");
//
//        //5. Click to Login button
//        WebElement element = Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button"));
//        element.click();

        SmartBearUtils.loginToSmartBear("Tester","test");

        //6. Print out count of all the links on landing page
        List <WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("allLinks size = " + allLinks.size());

        //7. Print out each link text on this page
        for (WebElement each : allLinks){
            System.out.println(each);
        }

        Driver.closeDriver();

    }

}
