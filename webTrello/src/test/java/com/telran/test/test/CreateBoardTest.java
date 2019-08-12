package com.telran.test.test;

import com.telran.test.model.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoardTest extends TestBase
{
    @Test(dataProvider= "boards", dataProviderClass=DataProviders.class)
    public void boardCreationTestWithDataProvider(Board board) throws InterruptedException
    {

        int beforeCreation = app.getBoard().getBoardsCount();
        System.out.println(app.getBoard().getBoardsCount());

        app.getHeader().clickOnPlusButtonOnHeader();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().confirmBoardCreation();
        app.getHeader().clickOnHomeButton();

        int afterCreation = app.getBoard().getBoardsCount();
        System.out.println(app.getBoard().getBoardsCount());

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }



    @Test(enabled=false)
    public void boardCreationTest() throws InterruptedException
    {

        int beforeCreation = app.getBoard().getBoardsCount();
        System.out.println(app.getBoard().getBoardsCount());

        app.getHeader().clickOnPlusButtonOnHeader();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardCreationForm(new Board().setBoardName("Masa" + System.currentTimeMillis()));
        app.getBoard().confirmBoardCreation();
        app.getHeader().clickOnHomeButton();

        int afterCreation = app.getBoard().getBoardsCount();
        System.out.println(app.getBoard().getBoardsCount());

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }

    @AfterClass(alwaysRun=true)
            public void postAction() throws InterruptedException {
        app.getBoard().cleanBoardList();
    }

}


