package com.cydeo.utilities;

import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    public static void switchWindowAndVerify(String expectedUrl, String expectedTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String eachWindowHandle : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachWindowHandle);
            if (Driver.getDriver().getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title verification is not passed!");

    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle, "Title verification failed");
    }

}
