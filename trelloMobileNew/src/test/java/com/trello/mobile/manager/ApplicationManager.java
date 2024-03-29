package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    HelperSession session;
    AppiumDriver driver;
    HelloPage helloPage;

    public void init() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","QA");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("appPackage","com.trello");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:\\Users\\mazyeva\\Documents\\GitHub\\Trello\\trelloMobileNew\\src\\test\\resources\\trello.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        helloPage = new HelloPage(driver);
        session = new HelperSession(driver);

        //session.login("ybagaut@gmail.com", "112014312qQ");
    }

    public HelloPage getHelloPage()
    {
        return helloPage;
    }

    public void stop()
    {
        driver.quit();
    }

    public HelperSession getSession()
    {
        return session;
    }


}




