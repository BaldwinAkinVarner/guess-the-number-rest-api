/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.guessthenumber.dao;

import com.sg.guessthenumber.TestApplicationConfiguration;
import com.sg.guessthenumber.dto.Game;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author crouton
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDatabaseDaoTest {
    
    @Autowired
    GameDao gameDao;
    
    
    public GameDatabaseDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
//        List<Game> games = gameDao.getAllGames();
//        for (Game game : games){
//            gameDao.removeGame(game.getGameId());
//        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addGame and getGame methods, of class GameDatabaseDao.
     */
    @Test
    public void testAddGetGame() {
        Game createdGame = new Game();
        createdGame.setAnswer("1111");
        createdGame.setFinishedStatus(false);
        createdGame = gameDao.addGame(createdGame);
        
        Game retrievedGame = gameDao.getGame(createdGame.getGameId());
        
        assertEquals(createdGame, retrievedGame);
    }

    /**
     * Test of getAllGames method, of class GameDatabaseDao.
     */
    @Test
    public void testGetAllGames() {
        Game firstGame = new Game();
        firstGame.setAnswer("2233");
        firstGame.setFinishedStatus(false);
        Game firstCreatedGame = gameDao.addGame(firstGame);
        
        Game secondGame = new Game();
        secondGame.setAnswer("3344");
        secondGame.setFinishedStatus(false);
        Game secondCreatedGame = gameDao.addGame(secondGame);
        
        List<Game> gameList = gameDao.getAllGames();
        
        assertTrue(gameList != null);
        assertTrue(gameList.contains(firstCreatedGame));
        assertTrue(gameList.contains(secondCreatedGame));
    }

    /**
     * Test of updateGameStatus method, of class GameDatabaseDao.
     */
    @Test
    public void testUpdateGameStatus() {
        Game createdGame = new Game();
        createdGame.setAnswer("2244");
        createdGame.setFinishedStatus(false);
        createdGame = gameDao.addGame(createdGame);
        
        Game oldGame = gameDao.getGame(createdGame.getGameId());
        createdGame.setFinishedStatus(true);
        gameDao.updateGameStatus(createdGame);
        
        assertTrue(!oldGame.equals(createdGame));
    }
    
}
