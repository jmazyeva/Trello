package com.telran.test.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HelperBase
{
    WebDriver driver;

    public HelperBase(WebDriver driver)
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
        System.out.println("Screenshot name:" + screenshot.getName());
    }

}
