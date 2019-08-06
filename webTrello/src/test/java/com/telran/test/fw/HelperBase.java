package com.telran.test.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

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
}
