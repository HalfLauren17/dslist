package com.half.dslist.controllers;

import com.half.dslist.DTO.GameDTO;
import com.half.dslist.DTO.GameMinDTO;
import com.half.dslist.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    @Autowired
    private GameService gameService;
    
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> gamesMinDTO = gameService.findAll();
        return gamesMinDTO;
    }
    
    @GetMapping(value = "/{gameId}")
    public GameDTO findById(@PathVariable Long gameId) {
        GameDTO gameDTO = gameService.findById(gameId);
        return gameDTO;
    }
}
