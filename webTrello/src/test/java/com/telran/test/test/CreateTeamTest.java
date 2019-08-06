package com.telran.test.test;


import org.testng.annotations.Test;

public class CreateTeamTest extends TestBase
{
    @Test
    public void createTeam() throws InterruptedException {
        app.getHeader().clickOnPlusButtonOnHeader();
        app.getTeam().clickOnCreateTeamButton();
        app.getTeam().fillNameField("firstTeam");
        app.getTeam().clickOnDescriptionField();
        app.getTeam().fillDescriptionField("Uhuuuuuuuu!");
        app.getTeam().clickOnCreateButton();
        app.getHeader().clickOnHomeButton();

    }


}
