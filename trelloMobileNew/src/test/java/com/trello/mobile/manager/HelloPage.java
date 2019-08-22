package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HelloPage extends HelperBase
{
    public HelloPage(AppiumDriver driver)
    {
        super(driver);
    }


    public String getText()
    {
        return driver.findElement(By.id("text")).getText();
    }

    public boolean isLoginButtonPresent()
    {
    return isElementPresentFromLoginTest(By.id("log_in_button"));
    }

    public boolean isSignupButtonPresent()
    {
    return isElementPresentFromLoginTest(By.id("sign_up_button"));
    }
}
