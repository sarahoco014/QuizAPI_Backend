package com.bnta.quiz_API.controllers;

import com.bnta.quiz_API.models.Player;
import com.bnta.quiz_API.models.PlayerDTO;
import com.bnta.quiz_API.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {

    @Autowired
    PlayerService playerService;


//    CREATE -
    @PostMapping
    public ResponseEntity<List<Player>> createPlayer(@RequestBody PlayerDTO playerDTO){
      playerService.addPlayer(playerDTO);
        return new ResponseEntity(playerService.getAllPlayers(), HttpStatus.CREATED);
    }
    

}
