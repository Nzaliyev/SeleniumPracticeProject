package com.cydeo.practice_week_02;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T3_NumberOfEmptyLinks {

    @Test
    public void number_of_empty_links_test() throws InterruptedException {
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        Driver.getDriver().get(ConfigurationReader.getProperty("openxcell.url"));
        Thread.sleep(3000);

        //3. Count the number of links that does not have text and verify
        //Expected: 109
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        int numberOfEmptyLinks = 0;
        int numberOfEmptyLinksExpected = 257;
        for(WebElement eachLink: allLinks){
            if (!eachLink.getText().isEmpty()){
                System.out.println("eachLink.getText() = " + eachLink.getText());
            }else {
                numberOfEmptyLinks++;
            }
        }

        Assert.assertEquals(numberOfEmptyLinks,numberOfEmptyLinksExpected,"Empty links number test failed!");

        Driver.closeDriver();


    }

}
