package com.cydeo.practice_week_02;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.SmartBearUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Smartbear_order_placing {

    @Test
    public void smartbear_order_placing_test() throws InterruptedException {
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button
        SmartBearUtils.loginToSmartBear("Tester","test");

        //6. Click on Order
        WebElement orderBtn = Driver.getDriver().findElement(By.linkText("Order"));
        orderBtn.click();

        //7. Select familyAlbum from product, set quantity to 2
        WebElement productSelect = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select select = new Select(productSelect);
        select.selectByVisibleText("FamilyAlbum");

        //8. Click to “Calculate” button
        WebElement calculateBtn = Driver.getDriver().findElement(By.cssSelector("input[value=\"Calculate\"]"));
        calculateBtn.click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        WebElement customerNameBox, streetBox, cityBox, stateBox, zipBox, quantityBox;
        customerNameBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        streetBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        cityBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        stateBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        zipBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        quantityBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        Faker faker = new Faker();

        customerNameBox.sendKeys(faker.name().fullName());
        streetBox.sendKeys(faker.address().streetAddress());
        stateBox.sendKeys(faker.address().state());
        cityBox.sendKeys(faker.address().city());
        zipBox.sendKeys(faker.numerify("#####"));
        quantityBox.sendKeys("10");


        Thread.sleep(3000);

        //10. Click on “visa” radio button
        WebElement visaRadioBtn = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioBtn.click();

        //11. Generate card number using JavaFaker
        WebElement cardNumberBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumberBox.sendKeys(faker.finance().creditCard().replace("-",""));

        WebElement expDateBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expDateBox.sendKeys("12/24");

        //12. Click on “Process”
        WebElement processBtn = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processBtn.click();
        Thread.sleep(3000);

        //13. Verify success message “New order has been successfully added.”
        String expectedText = "New order has been successfully added.";
        WebElement actualText = Driver.getDriver().findElement(By.xpath("//div[@class='content']/table//strong"));
        Assert.assertEquals(actualText.getText(),expectedText,"Success message verification failed!");
        Thread.sleep(3000);

        Driver.closeDriver();

    }

}
