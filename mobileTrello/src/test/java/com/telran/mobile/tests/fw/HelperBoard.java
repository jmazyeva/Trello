package com.telran.mobile.tests.fw;


import com.telran.mobile.tests.model.Board;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBoard extends HelperBase
{

    public HelperBoard(AppiumDriver driver) {
        super(driver);
    }
    HelperHeaderPage header = new HelperHeaderPage(driver);

    public void selectCreateBoardFromDropDown()
    {
        click(By.xpath("//*[@data-test-id='header-create-board-button']"));
    }

    public void fillBoardCreationForm(Board board)
    {
    type(By.cssSelector("[data-test-id='header-create-board-title-input']"), board.getBoardName());
    click(By.cssSelector("button.W6rMLOx8U0MrPx"));
    //select without Team
    click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));
    }

    public void confirmBoardCreation()
    {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }

    public int getBoardsCount()
    {
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }



    //Methods For Deletion Board

    public void clickOnFirstBoardForDeletion()
    {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }



    public void clickOnMoreButtonForDeletion()
    {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']"));
    }

    public void clickOnCloseButtonForDeletion()
    {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickOnConfirmCloseButtonForDeletion()
    {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }

    public void clickOnPermanentlyDeleteBoardButton()
    {
    click(By.cssSelector("[class='quiet js-delete']"));
    }

    public void clickOnConfirmDeleteButton()
    {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }


    public void cleanBoardList() throws InterruptedException
    {
        int count = getBoardsCount();
        while(count>4)
        {
            clickOnFirstBoardForDeletion();
            clickOnMoreButtonForDeletion();
            clickOnCloseButtonForDeletion();
            clickOnConfirmCloseButtonForDeletion();
            clickOnPermanentlyDeleteBoardButton();
            clickOnConfirmDeleteButton();
            header.clickOnHomeButton();
            count = getBoardsCount();
        }
    }

    //Methods for check of present element
    public void createBoard() throws InterruptedException {

       header.clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm(new Board().setBoardName("Masa" + System.currentTimeMillis()));
        confirmBoardCreation();
        header.clickOnHomeButton();
    }

    public boolean isBoardPresent()
    {
        return isElementPresentFromLoginTest(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }
}
