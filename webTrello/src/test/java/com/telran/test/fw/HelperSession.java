package com.telran.test.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSession extends HelperBase
{
    public HelperSession(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) throws InterruptedException {
        clickOnLoginButton();
        fillUserForm(email, password);
        confirmLoginButton();
        pause(3000);
    }

    public void confirmLoginButton()
    {
        click(By.id("login"));
    }

    public void fillUserForm(String email, String password)
    {
        type(By.id("user"), email);
        type(By.id("password"), password);
    }

    public void clickOnLoginButton()
    {
        click(By.cssSelector("[href='/login']"));
    }

    public void logout()
    {
        if(isUserLoggedIn())
        {
            clickOnAvatar();
            clickLogout();
        }
    }

    public void clickLogout()
    {
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public boolean isUserLoggedIn()
    {
        return isElementPresentFromLoginTest((By.cssSelector("[data-test-id='header-member-menu-button']")));
    }

    public void clickOnAvatar()
    {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }
}
