/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.guessthenumber.dao;

import com.sg.guessthenumber.dto.Round;
import java.util.List;

/**
 *
 * @author crouton
 */
public interface RoundDao {
    Round addRound(Round roundToAdd);
    List<Round> getRoundsByGameId(int gameId);
    Round getRoundById(int roundId);
}
