package com.bnta.quiz_API.controllers;

import com.bnta.quiz_API.models.Player;
import com.bnta.quiz_API.models.PlayerDTO;
import com.bnta.quiz_API.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {

    @Autowired
    PlayerService playerService;


//    CREATE - PLAYER
    @PostMapping
    public ResponseEntity<List<Player>> createPlayer(@RequestBody PlayerDTO playerDTO){
      playerService.addPlayer(playerDTO);
        return new ResponseEntity(playerService.getAllPlayers(), HttpStatus.CREATED);
    }

//    GET - INDEXES
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }


//    GET - SHOW BY INDEX
    @GetMapping(value = "/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id){
        Player player =playerService.getPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

//    UPDATE - PLAYER
    @PutMapping(value = "/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody PlayerDTO playerDTO, @PathVariable int id){
        Player player = playerService.updatePlayer(playerDTO,id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }


//    DELETE - PLAYER
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> deletePlayer(@PathVariable Integer id){
        playerService.deletePlayer(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
