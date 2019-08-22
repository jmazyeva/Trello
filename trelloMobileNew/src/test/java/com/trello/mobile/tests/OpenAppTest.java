package com.trello.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAppTest extends TestBase
{
    @Test
    public void openApp() throws InterruptedException {
        System.out.println("app is opened");

        String firstPageText = app.getHelloPage().getText();
        Assert.assertEquals(firstPageText, "Hello Trello!");
        Assert.assertTrue(app.getHelloPage().isLoginButtonPresent());
        Assert.assertTrue(app.getHelloPage().isSignupButtonPresent());
        app.getHelloPage().swipeToLeft();

        app.getSession().pause(1000);

        String secondPageText = app.getHelloPage().getText();
        Assert.assertEquals(secondPageText,"Get organized");
        Assert.assertTrue(app.getHelloPage().isLoginButtonPresent());
        Assert.assertTrue(app.getHelloPage().isSignupButtonPresent());
        app.getHelloPage().swipeToLeft();

        app.getSession().pause(1000);

        String thirdPageText = app.getHelloPage().getText();
        Assert.assertEquals(thirdPageText,"Add details");
        Assert.assertTrue(app.getHelloPage().isLoginButtonPresent());
        Assert.assertTrue(app.getHelloPage().isSignupButtonPresent());
        app.getHelloPage().swipeToLeft();

        app.getSession().pause(5000);
    }

}
