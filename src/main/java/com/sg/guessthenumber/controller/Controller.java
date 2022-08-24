/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.guessthenumber.controller;

import com.sg.guessthenumber.dto.Game;
import com.sg.guessthenumber.dto.Round;
import com.sg.guessthenumber.service.ServiceLayer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author crouton
 */
@RestController
@RequestMapping("/api")
public class Controller {
    
    @Autowired
    ServiceLayer service;
    
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int createGame(){
        return service.createGame();
    }
    
    @PostMapping("/guess")
    @ResponseStatus(HttpStatus.CREATED)
    public Round makeGuess(@RequestBody Round newRound){
        return service.makeGuess(newRound);
    }
    //fix
    
    @GetMapping("/game")
    public List<Game> getAllGames(){
        return service.getAllGames();
    }
    
    @GetMapping("/game/{gameId}")
    public Game getGame(@PathVariable int gameId){
        return service.getGame(gameId);
    }
    
    @GetMapping("/rounds/{gameId}")
    public List<Round> getRounds(@PathVariable int gameId){
        return service.getRounds(gameId);
    }
}
