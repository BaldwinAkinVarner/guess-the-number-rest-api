/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.guessthenumber.dao;

import com.sg.guessthenumber.TestApplicationConfiguration;
import com.sg.guessthenumber.dto.Game;
import com.sg.guessthenumber.dto.Round;
import java.util.List;
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
public class RoundDatabaseDaoTest {
    
    @Autowired
    RoundDao roundDao;
    
    @Autowired
    GameDao gameDao;
    
    public RoundDatabaseDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addRound and getRoundById methods, of class RoundDatabaseDao.
     */
    @Test
    public void testAddGetRound() {
        Game game = new Game();
        game.setAnswer("1111");
        game.setFinishedStatus(false);
        Game createdGame = gameDao.addGame(game);
        
        Round round = new Round();
        round.setGameId(createdGame.getGameId());
        round.setGuess("5555");
        round.setResult("e:0:p:0");
        Round createdRound = roundDao.addRound(round);
        
        Round retrievedRound = roundDao.getRoundById(createdRound.getRoundId());
        
        assertEquals(retrievedRound, createdRound);
        
    }

    /**
     * Test of getRoundsByGameId method, of class RoundDatabaseDao.
     */
    @Test
    public void testGetRoundsByGameId() {
        Game game = new Game();
        game.setAnswer("1111");
        game.setFinishedStatus(false);
        Game createdGame = gameDao.addGame(game);
        
        Round firstRound = new Round();
        firstRound.setGameId(createdGame.getGameId());
        firstRound.setGuess("5555");
        firstRound.setResult("e:0:p:0");
        Round firstCreatedRound = roundDao.addRound(firstRound);
        
        Round secondRound = new Round();
        secondRound.setGameId(createdGame.getGameId());
        secondRound.setGuess("5555");
        secondRound.setResult("e:0:p:0");
        Round secondCreatedRound = roundDao.addRound(secondRound);
        
        List<Round> roundList = roundDao.getRoundsByGameId(createdGame.getGameId());
        
        assertTrue(roundList != null);
        assertTrue(roundList.contains(firstCreatedRound));
        assertTrue(roundList.contains(secondCreatedRound));
    }

    
}
