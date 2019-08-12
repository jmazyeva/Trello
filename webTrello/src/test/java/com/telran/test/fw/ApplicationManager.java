package com.telran.test.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    HelperSession session;
    HelperBoard board;
    HelperTeam team;
    HelperHeaderPage header;
    HelperProfile profile;
    WebDriver driver;
    private String browser;

    public ApplicationManager(String browser)
    {
        this.browser = browser;
    }

    public void init() throws InterruptedException
    {
        try {
            if (browser.equals(BrowserType.CHROME)) {
                driver = new ChromeDriver();
            } else if (browser.equals(BrowserType.FIREFOX)) {
                driver = new FirefoxDriver();
            } else if (browser.equals(BrowserType.EDGE)) {
                driver = new EdgeDriver();
            }
        }
        catch (Exception e)
            {
                System.out.println("Unknown browser format!");
            }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://trello.com");
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




