package com.cydeo.practice_week_02;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class T2_PrintTextOfLinks {

    @Test
    public void print_text_of_links_test() throws InterruptedException {
        //TC #2: Printing out the texts of the links on the page
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        Driver.getDriver().get(ConfigurationReader.getProperty("openxcell.url"));
        Thread.sleep(3000);

        //3. Print out all of the texts of the links on the page
        ArrayList<String> allLinksText = new ArrayList<>();
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        for(WebElement eachLink: allLinks){
            allLinksText.add(eachLink.getText());
            System.out.println("eachLink.getText() = " + eachLink.getText());
        }

        System.out.println("allLinksText.size() = " + allLinksText.size());

        Driver.closeDriver();

    }

}
