package com.cydeo.practice_week_01;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframe_Task extends TestBase {

    @Test
    public void iframeTaskTest(){
        driver.get("https://practice.cydeo.com/iframe ");
        driver.switchTo().frame("mce_0_ifr");

        WebElement commentBody = driver.findElement(By.xpath("//body[@id='tinymce']"));
        commentBody.clear();

        commentBody.sendKeys("Hello World");

        Assert.assertTrue(commentBody.getText().equals("Hello World"), "Comment text is not updated!");

        driver.switchTo().defaultContent();

        String iframeHeaderAct = driver.findElement(By.tagName("h3")).getText();
        String iframeHeaderTextExpc = "TinyMCE";

        Assert.assertTrue(iframeHeaderAct.contains(iframeHeaderTextExpc), "Header text is not verified!");




    }

}
