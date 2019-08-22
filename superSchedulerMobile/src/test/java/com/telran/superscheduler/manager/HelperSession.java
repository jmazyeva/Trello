package com.telran.superscheduler.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HelperSession extends HelperBase
{
    public HelperSession(AppiumDriver driver)
    {
        super(driver);
    }

    public void fillLoginForm(String email, String password)
    {
        type(By.id("log_email_input"), email);
        type(By.id("log_password_input"), password);
    }

    public void tapLoginButton()
    {
        click(By.id("login_btn"));
    }





}
