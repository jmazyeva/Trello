package com.telran.test.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBoardTest extends TestBase
{
    @Test

    public void boardCreationTest() throws InterruptedException {

        int beforeCreation = app.getBoard().getBoardsCount();
        System.out.println(app.getBoard().getBoardsCount());

        app.getHeader().clickOnPlusButtonOnHeader();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardCreationForm("Masa" + System.currentTimeMillis());
        app.getBoard().confirmBoardCreation();
        app.getHeader().clickOnHomeButton();

        int afterCreation = app.getBoard().getBoardsCount();
        System.out.println(app.getBoard().getBoardsCount());

        Assert.assertEquals(afterCreation, beforeCreation+1);
    }


}
