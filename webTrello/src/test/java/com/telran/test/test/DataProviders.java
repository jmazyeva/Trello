package com.telran.test.test;

import com.telran.test.model.Board;
import com.telran.test.model.Team;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders
{
    @DataProvider
    public Iterator<Object[]> teams() throws IOException
    {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\resources\\DataForTeam.csv")));
        String line = reader.readLine();

        while(line != null)
        {
            String[] split = line.split(",");
            list.add(new Object[]{new Team().setTeamName(split[0]).setDescription(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> boards() throws IOException
    {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\resources\\DataForBoards.csv")));
        String line = reader.readLine();

        while(line != null)
        {
            String[] split = line.split(",");
            list.add(new Object[]{new Board().setBoardName(split[0])});
            line = reader.readLine();
        }
        return list.iterator();
    }


}
