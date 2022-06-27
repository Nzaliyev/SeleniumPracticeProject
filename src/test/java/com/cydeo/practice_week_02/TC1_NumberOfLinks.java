package com.cydeo.practice_week_02;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC1_NumberOfLinks {

    @Test
    public void number_of_links_test(){
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com

        Driver.getDriver().get(ConfigurationReader.getProperty("openxcell.url"));

        //3. Count the number of the links on the page and verify
        //Expected: 332

        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        int numberOfLinksActual = allLinks.size();
        int numberOfLinksExpected = 337;

        Assert.assertEquals(numberOfLinksActual,numberOfLinksExpected,"Number of links verification failed!");



    }

}
