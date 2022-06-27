package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

    public static void loginToSmartBear(String username, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearsoftware.practice.url"));

        // Enter username: “Tester
        WebElement usernameBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
        usernameBox.sendKeys(username);

        //Enter password: “test”
        WebElement passwordBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_password"));
        passwordBox.sendKeys(password);

        //5. Click to Login button
        WebElement element = Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button"));
        element.click();
    }

}
