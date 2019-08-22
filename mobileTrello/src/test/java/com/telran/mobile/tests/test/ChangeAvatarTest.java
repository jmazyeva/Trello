package com.telran.mobile.tests.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ChangeAvatarTest extends TestBase
{
    @BeforeMethod
    public void preconditions() throws IOException {
        app.getProfile().takeScreenshot();
    }

    @Test
    public void ChangeAvatar() throws InterruptedException
    {
        app.getSession().clickOnAvatar();
        app.getProfile().clickOnProfileButton();
        app.getProfile().pause(2000);
        app.getProfile().moveToImage();
        app.getProfile().attachPhoto(new File("src\\test\\resources\\img2.gif"));
        app.getHeader().clickOnHomeButton();
    }
    @AfterMethod
    public void postActions() throws IOException {
        app.getProfile().takeScreenshot();
    }

}
