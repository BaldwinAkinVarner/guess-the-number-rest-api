/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.guessthenumber.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author crouton
 */
public class Round {
    private String guess;
    private LocalDateTime timeOfGuess;
    private String result;
    private int gameId;
    private int roundId;

    public Round(String guess, LocalDateTime timeOfGuess, String result, int gameId, int roundId) {
        this.guess = guess;
        this.timeOfGuess = timeOfGuess;
        this.result = result;
        this.gameId = gameId;
        this.roundId = roundId;
    }

    public Round(String guess, int gameId) {
        this.guess = guess;
        this.gameId = gameId;
    }

    public Round() {
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public LocalDateTime getTimeOfGuess() {
        return timeOfGuess;
    }

    public void setTimeOfGuess(LocalDateTime timeOfGuess) {
        this.timeOfGuess = timeOfGuess;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.guess);
        hash = 67 * hash + Objects.hashCode(this.timeOfGuess);
        hash = 67 * hash + Objects.hashCode(this.result);
        hash = 67 * hash + this.gameId;
        hash = 67 * hash + this.roundId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Round other = (Round) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.roundId != other.roundId) {
            return false;
        }
        if (!Objects.equals(this.guess, other.guess)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        return Objects.equals(this.timeOfGuess, other.timeOfGuess);
    }
    
    
}
