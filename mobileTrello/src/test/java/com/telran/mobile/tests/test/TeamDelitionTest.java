package com.telran.mobile.tests.test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TeamDelitionTest extends TestBase{

@BeforeMethod
public void preconditions() throws InterruptedException {
    if(!app.getTeam().isTeamPresent())
    {
        app.getTeam().createTeam();
    }
}


    @Test
    public void testTeamDelition() throws Exception
    {
        int before = app.getTeam().getTeamsCount();
        System.out.println("before:" + before);

        int before2 = app.getTeam().getTeamsCount2();
        System.out.println("before:" + before2);

        app.getTeam().clickOnFirstTeam();
        app.getSession().pause(1000);
        app.getTeam().clickOnTeamSettings();
        app.getTeam().clickOnDeleteTeamLink();
        app.getTeam().confirmTeamDeletionButton();
        app.getSession().pause(2000);

        int after = app.getTeam().getTeamsCount();
        System.out.println("after:" + after);

        int after2 = app.getTeam().getTeamsCount2();
        System.out.println("after:" + after2);

        Assert.assertEquals(after,before-1);

        System.out.println();

    }


}
