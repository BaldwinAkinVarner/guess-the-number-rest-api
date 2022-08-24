/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.guessthenumber.dto;

import java.util.Objects;

/**
 *
 * @author crouton
 */
public class Game {
    private int gameId;
    private String answer;
    private boolean finished;
    
    public Game(){
        
    }
    
    public Game(int gameId, String answer, boolean finished){
        this.gameId = gameId;
        this.answer = answer;
        this.finished = finished;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getFinishedStatus() {
        return finished;
    }

    public void setFinishedStatus(boolean finished) {
        this.finished = finished;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.gameId;
        hash = 89 * hash + Objects.hashCode(this.answer);
        hash = 89 * hash + (this.finished ? 1 : 0);
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
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.finished != other.finished) {
            return false;
        }
        return Objects.equals(this.answer, other.answer);
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", answer=" + answer + ", finished=" + finished + '}';
    }
    
    
    
}
