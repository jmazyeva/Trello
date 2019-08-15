package com.telran.test.fw;

import com.telran.test.test.TestBase;
import org.openqa.selenium.*;
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
    EventFiringWebDriver driver;
    String browser;

    public class MyListener extends AbstractWebDriverEventListener
    {
        HelperBase helper = new HelperBase(driver);
        Logger logger = LoggerFactory.getLogger(MyListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Start search element: " + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Element is found: " + by);
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error(throwable.toString());
            try {
                helper.takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ApplicationManager(String browser)
    {
        this.browser = browser;
    }

    public void init() throws InterruptedException
    {
        try {
            if (browser.equals(BrowserType.CHROME)) {
                driver = new EventFiringWebDriver(new ChromeDriver());
            } else if (browser.equals(BrowserType.FIREFOX)) {
                driver = new EventFiringWebDriver(new FirefoxDriver());
            } else if (browser.equals(BrowserType.EDGE)) {
                driver = new EventFiringWebDriver(new EdgeDriver());
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

        driver.register(new MyListener());

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




