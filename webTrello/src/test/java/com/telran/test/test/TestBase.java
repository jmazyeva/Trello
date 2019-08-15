package com.telran.test.test;

//imports
import com.telran.test.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun=true)
    public void startLogger(Method m, Object[] p)
    {
        logger.info("Start " + m.getName() + " with parameters " + Arrays.asList(p));//parameters from DataProvider
    }

    @AfterMethod(alwaysRun=true)
    public void stopLogger(Method m)
    {
        logger.info("Stop " + m.getName());
    }



    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws InterruptedException
    {
        app.init();
    }

    @AfterSuite
    public void tearDown()
    {
        app.stop();
    }

}
