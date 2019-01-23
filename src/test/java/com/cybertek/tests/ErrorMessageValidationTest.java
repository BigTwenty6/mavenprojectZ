package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidationTest extends TestBase {

    @Test
    public void  wrongEmailTest(){
        HomePage homePage = new HomePage();

        driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        homePage.username.sendKeys("admin");
//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("admin");

        homePage.password.sendKeys("test");
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");


        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        String error ="Invalid Login or Password";
        String  actualError = driver.findElement(By.id("ctl00_MainContent_status")).getText();

        Assert.assertEquals(error,actualError);

    }

    @Test
    public void  wrongPasswordTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("wrong password");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        String expectederror ="Invalid Login or Password";
        String  actualError = driver.findElement(By.id("ctl00_MainContent_status")).getText();

        Assert.assertEquals(actualError,expectederror);
    }

}
