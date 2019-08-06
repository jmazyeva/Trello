package com.telran.test.test;


import org.testng.annotations.*;


public class TeamDelitionTest extends TestBase{




    @Test
    public void testTeamDelition() throws Exception
    {
        int before = app.getTeam().getTeamsCount();
        System.out.println("before:" + before);

        int before2 = app.getTeam().getTeamsCount2();
        System.out.println("before:" + before2);

        app.getTeam().clickOnFirstTeam();
        app.getTeam().clickOnTeamSettings();
        app.getTeam().clickOnDeleteTeamLink();
        app.getTeam().confirmTeamDeletionButton();
        app.getSession().pause(5000);

        int after = app.getTeam().getTeamsCount();
        System.out.println("after:" + after);

        int after2 = app.getTeam().getTeamsCount2();
        System.out.println("after:" + after2);
    }


}
