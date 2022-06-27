package com.cydeo.practice_week_02;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Smartbear_order_verification {

    @Test
    public void smartBear_order_verification_test() throws InterruptedException {
        //1. Open browser and login to Smartbear software

        SmartBearUtils.loginToSmartBear("Tester","test");

        //2. Click on View all orders
        WebElement allOrderBtn = Driver.getDriver().findElement(By.linkText("View all orders"));
        allOrderBtn.click();
        Thread.sleep(3000);

        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement susanMcLarenOrderDateActual = Driver.getDriver().findElement(By.xpath("((//table[@class='SampleTable']//tr)[6])//td[5]"));
        String susanMcLarenOrderDateExpected = "01/05/2010";

        Assert.assertEquals(susanMcLarenOrderDateActual.getText(),susanMcLarenOrderDateExpected,"Susan McLaren order verification failed!");

        Driver.closeDriver();

    }

}
