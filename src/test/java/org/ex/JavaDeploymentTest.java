package org.ex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class JavaDeploymentTest extends BaseTest {

    @Test
    public void downloadLatestJavaWindows () {
        driver.get("https://www.oracle.com/java/technologies/downloads/");
        driver.findElement(By.id("rt01tab-jdk17-windows")).click();
        try {
            driver.findElement(By.partialLinkText("x64_bin.exe")).click();
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void archiveJava () {
        driver.get("https://www.oracle.com/java/technologies/downloads/");
        try {
            driver.findElement(By.xpath("//li[@class='ct12t3']//a")).click();
            driver.navigate().back();
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkNewVersionJava () {
        driver.get("https://www.oracle.com/java/technologies/downloads/");
        Assert.assertTrue(!driver.findElements(By.id("java17")).isEmpty());
    }

}