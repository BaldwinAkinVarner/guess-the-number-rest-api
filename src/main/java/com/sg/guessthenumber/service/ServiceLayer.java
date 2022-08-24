/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.guessthenumber.service;

import com.sg.guessthenumber.dao.GameDao;
import com.sg.guessthenumber.dao.RoundDao;
import com.sg.guessthenumber.dto.Game;
import com.sg.guessthenumber.dto.Round;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crouton
 */
@Service
public class ServiceLayer {
    
    @Autowired
    GameDao gameDao;

    @Autowired
    RoundDao roundDao;

    public int createGame() {
        Game createdGame = new Game();
        createdGame.setAnswer(generateAnswer());
        gameDao.addGame(createdGame);
        return createdGame.getGameId();
    }

    public Round makeGuess(Round newRound) {
        String answer = gameDao.getGame(newRound.getGameId()).getAnswer();
        String guess = newRound.getGuess();
        String result = calculateResult(guess, answer);
        newRound.setResult(result);
        
        if (guess.equals(answer)){
            Game game = getGame(newRound.getGameId());
            game.setFinishedStatus(true);
            gameDao.updateGameStatus(game);
        }
        return roundDao.addRound(newRound);
    }

    public List<Game> getAllGames() {
        List<Game> listOfGames = gameDao.getAllGames();
        for (Game game : listOfGames) {
            if (game.getFinishedStatus() == false) {
                game.setAnswer("[hidden]");
            }
        }
        return listOfGames;
    }

    public Game getGame(int gameId) {
        Game retrievedGame = gameDao.getGame(gameId);
        if (retrievedGame.getFinishedStatus() == false) {
            retrievedGame.setAnswer("[hidden]");
        }
        return retrievedGame;
    }

    public List<Round> getRounds(int gameId) {
        return roundDao.getRoundsByGameId(gameId);
    }
    
    public String generateAnswer(){
        Random rand = new Random();
        int num1 = rand.nextInt(10);
        int num2 = 0;
        do{
            num2 = rand.nextInt(10);
        } while(num1 == num2);
        int num3 = 0;
        do{
            num3 = rand.nextInt(10);
        } while (num3 == num2 || num3 == num1);
        int num4 = 0;
        do{
            num4 = rand.nextInt(10);
        } while (num4 == num3 || num4 == num2 || num4 == num1);
        
        return String.format("%s%s%s%s", num1, num2, num3, num4);
    }

    private String calculateResult(String guess, String answer) {
        char[] guessArray = guess.toCharArray();
        char[] answerArray = answer.toCharArray();
        int exactGuesses = 0;
        int partialGuesses = 0;
        
        for (int i=0; i < guessArray.length; i++){
            if (answer.indexOf(guessArray[i]) != -1){
                if (guessArray[i] == answerArray[i]){
                    exactGuesses += 1;
                } else {
                    partialGuesses += 1;
                }
            }
        }
        
        return String.format("e:%s:p:%s", exactGuesses, partialGuesses);
    }
    
}
