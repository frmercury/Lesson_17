package org.ex;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MavenDeploymentTest extends BaseTest {

    @Test
    public void downloadLatestMaven () {
        driver.get("https://maven.apache.org/download.cgi");
        try {
            driver.findElement(By.partialLinkText("bin.zip")).click();
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void archiveMaven () {
        driver.get("https://maven.apache.org/download.cgi");
        try {
            driver.findElement(By.linkText("archives")).click();
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkNewVersionMaven () {
        driver.get("https://maven.apache.org/download.cgi");
        Assert.assertTrue(!driver.findElements(By.id("downloading-apache-maven-3-8-4")).isEmpty());
    }
}
