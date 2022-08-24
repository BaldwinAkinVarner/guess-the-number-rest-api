/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.guessthenumber.dao;

import com.sg.guessthenumber.dto.Game;
import java.util.List;

/**
 *
 * @author crouton
 */
public interface GameDao {
    Game addGame(Game gameToAdd);
    List<Game> getAllGames();
    Game getGame(int gameId);
    void updateGameStatus(Game gameToUpdate);
//    void removeGame(int gameId);
}
