package com.bnta.quiz_API.services;

import com.bnta.quiz_API.models.Player;
import com.bnta.quiz_API.models.PlayerDTO;
import com.bnta.quiz_API.repositories.PlayerRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public void addPlayer(PlayerDTO playerDTO){
     Player player = new Player(playerDTO.getName());
     playerRepository.save(player);
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player getPlayerById(int id){
        return playerRepository.findById(id).get();
    }

    public void deletePlayer(int id){
        playerRepository.deleteById(id);
    }

    public void updatePlayer(PlayerDTO playerDTO, int id){
        Player playerToUpdate = playerRepository.findById(id).get();
        playerToUpdate.setName(playerDTO.getName());
        playerRepository.save(playerToUpdate);
    }
}
