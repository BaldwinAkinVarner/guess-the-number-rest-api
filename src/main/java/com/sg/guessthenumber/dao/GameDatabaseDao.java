/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.guessthenumber.dao;

import com.sg.guessthenumber.dto.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author crouton
 */
@Repository
public class GameDatabaseDao implements GameDao{
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    @Transactional
    public Game addGame(Game gameToAdd) {
        final String INSERT_GAME = "INSERT INTO game(answer) VALUES (?)";
        jdbc.update(INSERT_GAME, gameToAdd.getAnswer());
        int newGameId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        gameToAdd.setGameId(newGameId);
        return gameToAdd;
    }

    @Override
    public List<Game> getAllGames() {
        final String SELECT_ALL_GAMES = "SELECT * FROM game";
        return jdbc.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    public Game getGame(int gameId) {
        try{
            final String SELECT_GAME_BY_ID = "SELECT * FROM game WHERE game_id = ?";
            return jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), gameId);
        } catch (DataAccessException ex){
            return null;
        }
    }
    
    @Override
    public void updateGameStatus(Game gameToUpdate){
        final String UPDATE_GAME = "UPDATE game SET finished = ? WHERE game_id = ?";
        jdbc.update(UPDATE_GAME, gameToUpdate.getFinishedStatus(), gameToUpdate.getGameId());
    }

//    @Override
//    public void removeGame(int gameId) {
//        final String DELETE_GAME_BY_ID = "DELETE FROM game WHERE game_id = ?";
//        jdbc.update(DELETE_GAME_BY_ID, gameId);
//    }
    
    public static final class GameMapper implements RowMapper<Game> {
        
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setGameId(rs.getInt("game_id"));
            game.setAnswer(rs.getString("answer"));
            game.setFinishedStatus(rs.getBoolean("finished"));
            return game;
        }
    }
    
}
