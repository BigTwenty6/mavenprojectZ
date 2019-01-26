package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExample {

    /**
     * Explicit Wait:
     * •There can be instance when a particular element takes more than a minute to load.
     * •In that case you definitely not like to set a huge time to Implicit wait, as if you do this your browser will going to wait for the same time for every element.
     * •To avoid that situation you can simply put a separate time on the required element only.
     * •By following this your browser implicit wait time would be short for every element and it would be large for specific element.
     */

    WebDriver driver;

    @Test
    public void test() {
        driver = Driver.getDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello World");

    }

}
