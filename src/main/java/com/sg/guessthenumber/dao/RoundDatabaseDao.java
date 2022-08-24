/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.guessthenumber.dao;

import com.sg.guessthenumber.dto.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crouton
 */
@Repository
public class RoundDatabaseDao implements RoundDao {
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Round addRound(Round roundToAdd) {
        final String INSERT_ROUND = "INSERT INTO round(game_id, guess, result) VALUES(?,?,?)";
        jdbc.update(INSERT_ROUND, roundToAdd.getGameId(), roundToAdd.getGuess(), roundToAdd.getResult());
        
        int newRoundId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        roundToAdd.setRoundId(newRoundId);
        return getRoundById(newRoundId);
    }

    @Override
    public List<Round> getRoundsByGameId(int gameId) {
        try{
            final String SELECT_ROUNDS_BY_GAME_ID = "SELECT * FROM round WHERE game_id = ? ORDER BY guess_time";
            List<Round> retrievedRounds = jdbc.query(SELECT_ROUNDS_BY_GAME_ID, new RoundMapper(), gameId);
            return retrievedRounds;
        } catch(DataAccessException ex){
            return null;
        }
    }

    @Override
    public Round getRoundById(int roundId) {
        try{
            final String SELECT_ROUND_BY_ID = "SELECT * FROM round WHERE round_id = ?";
            return jdbc.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), roundId);
        } catch(DataAccessException ex){
            return null;
        }
    }
    
    public static final class RoundMapper implements RowMapper<Round> {
        
        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException{
            Round round = new Round();
            round.setRoundId(rs.getInt("round_id"));
            round.setGameId(rs.getInt("game_id"));
            round.setGuess(rs.getString("guess"));
            
            Timestamp timestamp = rs.getTimestamp("guess_time");
            round.setTimeOfGuess(timestamp.toLocalDateTime());
            
            round.setResult(rs.getString("result"));
            return round;
            
        }
    }
    
}
