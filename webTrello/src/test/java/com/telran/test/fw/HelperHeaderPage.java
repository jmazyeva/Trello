package com.telran.test.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperHeaderPage extends HelperBase
{


    public HelperHeaderPage(WebDriver driver) {
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
