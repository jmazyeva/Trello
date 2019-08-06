package com.telran.test.test;


import com.telran.test.fw.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException
    {
        app.init();
    }

    @AfterClass
    public void tearDown()
    {
        app.stop();
    }

}
