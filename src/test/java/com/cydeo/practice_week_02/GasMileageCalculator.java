package com.cydeo.practice_week_02;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculator {

    @Test
    public void gas_mileage_calculator_test() throws InterruptedException {
        //1. Add a new class GasMileageCalculatorTest
        //2. Go to https://www.calculator.net
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator.url"));

        //3. Search for “gas mileage” using search box
        WebElement searchBox = Driver.getDriver().findElement(By.id("calcSearchTerm"));
        searchBox.sendKeys("gas mileage");
        WebElement searchBtn = Driver.getDriver().findElement(By.id("bluebtn"));

        //4. Click on the “Gas Mileage Calculator” link
        WebElement gasMileageCalculatorLink = Driver.getDriver().findElement(By.linkText("Gas Mileage Calculator"));
        gasMileageCalculatorLink.click();

        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        BrowserUtils.verifyTitle("Gas Mileage Calculator");

        //b. “Gas Mileage Calculator” label is displayed
        String labelText = Driver.getDriver().findElement(By.xpath("//h1[.='Gas Mileage Calculator']")).getText();
        String labelTextExpected = "Gas Mileage Calculator";
        Assert.assertEquals(labelText,labelTextExpected,"Label text verification failed!");

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdBox = Driver.getDriver().findElement(By.id("uscodreading"));
        currentOdBox.clear();
        currentOdBox.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement prevOdBox = Driver.getDriver().findElement(By.id("uspodreading"));
        prevOdBox.clear();
        prevOdBox.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAddBox = Driver.getDriver().findElement(By.id("usgasputin"));
        gasAddBox.clear();
        gasAddBox.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPriceBox = Driver.getDriver().findElement(By.id("usgasprice"));
        gasPriceBox.clear();
        gasPriceBox.sendKeys("3.55");

        //10. Click on Calculate button
        WebElement calculateBtn = Driver.getDriver().findElement(By.xpath("(//input[@value='Calculate'])[1]"));
        Thread.sleep(3000);
        calculateBtn.click();

        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”
        String gasMileageTextActual = Driver.getDriver().findElement(By.xpath("//p[@class='verybigtext']")).getText();
        String gasMileageTextExpected = "23.44 mpg";
        Assert.assertTrue(gasMileageTextActual.contains(gasMileageTextExpected),"Gas mileage calculator text verification failed!");


    }

}
