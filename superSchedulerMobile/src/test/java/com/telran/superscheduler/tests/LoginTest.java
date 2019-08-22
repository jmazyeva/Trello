package com.telran.superscheduler.tests;

import org.testng.annotations.Test;

public class LoginTest extends TestBase
{
    @Test
    public void testLogin()
    {
        app.getSession().fillLoginForm("j.mazyeva@gmail.com", "123456qQ");
        app.getSession().closeKeyboard();
        app.getSession().tapLoginButton();

    }

}
