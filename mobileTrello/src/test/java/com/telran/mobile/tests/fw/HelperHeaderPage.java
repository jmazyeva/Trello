package com.telran.mobile.tests.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperHeaderPage extends HelperBase
{


    public HelperHeaderPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnPlusButtonOnHeader() throws InterruptedException {
        pause(2000);
        click(By.cssSelector("[name=add]"));
    }

    public void clickOnHomeButton() throws InterruptedException {

        pause(5000);
        click(By.cssSelector("[name='house']"));
        click(By.cssSelector("[name='house']"));
        pause(5000);
    }
}
