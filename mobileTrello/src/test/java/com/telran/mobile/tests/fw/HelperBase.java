package com.telran.mobile.tests.fw;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class HelperBase
{
    AppiumDriver driver;

    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public HelperBase(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public void click(By locator)
    {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text)
    {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    private boolean isElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public boolean isElementPresentFromLoginTest(By locator)
    {
        return driver.findElements(locator).size()>0;
    }

    public void pause(int millis) throws InterruptedException
    {
        Thread.sleep(millis);
    }

    public void attache(By locator, File file)
    {
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void takeScreenshot() throws IOException
    {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("src\\test\\screenshots\\screenshot-" + System.currentTimeMillis() + ".png");
        Files.copy(tmp, screenshot);
        logger.info("-------------------------------------------------");
        logger.info("Screenshot name:" + screenshot.getName());
        logger.info("-------------------------------------------------");
    }

}
