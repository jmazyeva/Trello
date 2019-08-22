package com.telran.mobile.tests.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    HelperSession session;
    HelperBoard board;
    HelperTeam team;
    HelperHeaderPage header;
    HelperProfile profile;
    AppiumDriver driver;
    String browser;

    public ApplicationManager(String browser)
    {
        this.browser = browser;
    }

    public void init() throws InterruptedException
    {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        session = new HelperSession(driver);
        board = new HelperBoard(driver);
        team = new HelperTeam(driver);
        header = new HelperHeaderPage(driver);
        profile = new HelperProfile(driver);


        session.login("ybagaut@gmail.com", "112014312qQ");
    }


    public void stop()
    {
        driver.quit();
    }


    public HelperSession getSession()
    {
        return session;
    }

    public HelperBoard getBoard()
    {
        return board;
    }

    public HelperTeam getTeam() { return team; }

    public HelperHeaderPage getHeader()
    {
        return header;
    }

    public HelperProfile getProfile() { return profile; }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }
}




