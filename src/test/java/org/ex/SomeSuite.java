package org.ex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SomeSuite {
    WebDriver driver;
    @BeforeClass
    public void driverInit() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void firstVerify() {
        driver.get("https://parabank.parasoft.com/");
        Assert.assertEquals("ParaBank | Welcome | Online Banking", driver.getTitle());
    }
    @Test()
    public void firstVerify1() {
        driver.get("https://www.selenium.dev/");
        driver.navigate().back();
        Assert.assertTrue(driver.getTitle().contains("Selenium"), "Page does not contains");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
