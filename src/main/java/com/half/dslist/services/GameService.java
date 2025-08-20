package com.half.dslist.services;

import com.half.dslist.DTO.GameMinDTO;
import com.half.dslist.entitites.Game;
import com.half.dslist.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;
    
    public List<GameMinDTO> findAll(){
       List<Game> games = gameRepository.findAll();
       List<GameMinDTO> gamesDTO = games.stream().map(x -> new GameMinDTO(x)).toList();
       return gamesDTO;
    }
}
