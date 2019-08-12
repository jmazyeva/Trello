package com.telran.test.fw;

import com.telran.test.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperTeam extends HelperBase
{
    HelperHeaderPage header = new HelperHeaderPage(driver);

    public HelperTeam(WebDriver driver) {
        super(driver);
    }

    public void clickOnCreateTeamButton()
    {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void confirmTeamDeletionButton()
    {
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-confirm")));
        click(By.cssSelector(".js-confirm"));
    }

    public void clickOnDeleteTeamLink() throws InterruptedException
    {
        Thread.sleep(2000);
        click(By.cssSelector(".quiet-button"));
    }

    public void clickOnTeamSettings()
    {
        click(By.cssSelector(".icon-gear"));
    }

    public void clickOnFirstTeam()
    {
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));
    }

    public int getTeamsCount()
    {
        WebElement teamList =  driver.findElement(By.cssSelector("nav.home-left-sidebar-container .js-react-root"));
        return teamList.findElements(By.xpath(".//li")).size();
    }

    public int getTeamsCount2()
    {
        return driver.findElements(By.cssSelector("nav.home-left-sidebar-container .js-react-root li")).size();
    }



    public void clickOnCreateButton()
    {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public boolean isTeamPresent()
    {
    return isElementPresentFromLoginTest(By.cssSelector("nav.home-left-sidebar-container .js-react-root li"));
    }

    public void createTeam() throws InterruptedException
    {
        header.clickOnPlusButtonOnHeader();
        clickOnCreateTeamButton();
        fillTeamForm(new Team().setTeamName("firstTeam" + System.currentTimeMillis()).setDescription("Uhuuuuuuuu!"));
        clickOnCreateButton();
        header.clickOnHomeButton();
    }

    public void cleanTeams() throws InterruptedException
    {
        int count = getTeamsCount();
        while(count>3)
        {
            clickOnFirstTeam();
            pause(1000);
            clickOnTeamSettings();
            clickOnDeleteTeamLink();
            confirmTeamDeletionButton();
            count = getTeamsCount();
        }
    }

    public void fillTeamForm(Team team)
    {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());

        type(By.cssSelector("[name='desc']"), team.getDescription());
    }
}
