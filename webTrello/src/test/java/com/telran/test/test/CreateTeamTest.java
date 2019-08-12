package com.telran.test.test;


import com.telran.test.model.Team;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateTeamTest extends TestBase
{
    @Test(dataProvider= "teams", dataProviderClass=DataProviders.class)
    public void createTeamWithDataProvider(Team team) throws InterruptedException
    {

        int before = app.getTeam().getTeamsCount();

        app.getHeader().clickOnPlusButtonOnHeader();
        app.getTeam().clickOnCreateTeamButton();
        app.getTeam().fillTeamForm(team);
        app.getTeam().clickOnCreateButton();
        app.getHeader().clickOnHomeButton();

        int after = app.getTeam().getTeamsCount();

        Assert.assertEquals(after, before + 1);

    }



    @Test(enabled = false)//test won't be run
    public void createTeam() throws InterruptedException
    {

        int before = app.getTeam().getTeamsCount();

        app.getHeader().clickOnPlusButtonOnHeader();
        app.getTeam().clickOnCreateTeamButton();
        app.getTeam().fillTeamForm(new Team().setTeamName("firstTeam" + System.currentTimeMillis()).setDescription("Uhuuuuuuuu!"));
        app.getTeam().clickOnCreateButton();
        app.getHeader().clickOnHomeButton();

        int after = app.getTeam().getTeamsCount();

        Assert.assertEquals(after, before + 1);

    }
    @AfterClass(alwaysRun=true)
    public void postAction() throws InterruptedException
    {
        app.getTeam().cleanTeams();
    }


}
