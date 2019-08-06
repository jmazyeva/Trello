package com.telran.test.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    HelperSession session;
    HelperBoard board;
    HelperTeam team;
    HelperHeaderPage header;

    WebDriver driver;

    public void init() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://trello.com");
        session = new HelperSession(driver);
        board = new HelperBoard(driver);
        team = new HelperTeam(driver);
        header = new HelperHeaderPage(driver);
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

    public HelperTeam getTeam()
    {
        return team;
    }

    public HelperHeaderPage getHeader()
    {
        return header;
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }
}




