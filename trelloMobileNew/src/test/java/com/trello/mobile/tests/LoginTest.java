package com.trello.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase
{
    @Test
    public void testLogin()
    {
        app.getSession().clickOnLoginButton();
        app.getSession().fillLoginForm("ybagaut@gmail.com", "112014312qQ");
//        app.getSession().closeKeyboard(); hide the keyboard
        app.getSession().tapLoginButton();

        Assert.assertTrue(app.getSession().isUserLoggedIn());

    }

}
