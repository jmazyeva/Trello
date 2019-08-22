package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HelperSession extends HelperBase
{
    public HelperSession(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickOnLoginButton()
    {
        click(By.id("log_in_button"));
    }

    public void fillLoginForm(String email, String password)
    {
        type(By.id("user"), email);
        type(By.id("password"), password);
    }

    public void tapLoginButton()
    {
        click(By.id("authenticate"));
    }


    public boolean isUserLoggedIn()
    {
        return isElementPresentFromLoginTest(By.id("notification_icon"));
    }




}
