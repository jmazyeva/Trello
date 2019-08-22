package com.telran.mobile.tests.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase
{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getBoard().isBoardPresent())
        {
            app.getBoard().createBoard();
        }
    }

    @Test
    public void BoardDeletionTest() throws InterruptedException
    {
        int beforeDeletionBoard = app.getBoard().getBoardsCount();
        System.out.println("before:" + beforeDeletionBoard);

        app.getBoard().clickOnFirstBoardForDeletion();
        app.getBoard().clickOnMoreButtonForDeletion();
        app.getBoard().clickOnCloseButtonForDeletion();
        app.getBoard().clickOnConfirmCloseButtonForDeletion();
        app.getBoard().clickOnPermanentlyDeleteBoardButton();
        app.getBoard().clickOnConfirmDeleteButton();
        app.getHeader().clickOnHomeButton();

        int afterDeletionBoard = app.getBoard().getBoardsCount();
        System.out.println("after:" + afterDeletionBoard);

        Assert.assertEquals(afterDeletionBoard, beforeDeletionBoard-1);
    }













}
