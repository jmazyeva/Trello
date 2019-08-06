package com.telran.test.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperTeam extends HelperBase
{

    public HelperTeam(WebDriver driver) {
        super(driver);
    }

    public void clickOnCreateTeamButton()
    {
        click(By.cssSelector("[data-test-id='header-create-team-name-input']"));
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

    public void fillNameField(String teamName)
    {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
    }

    public void clickOnDescriptionField()
    {
        click(By.cssSelector("[name='desc']"));
    }

    public void fillDescriptionField(String description)
    {
        type(By.cssSelector("[name='desc']"), description);
    }

    public void clickOnCreateButton()
    {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }
}
