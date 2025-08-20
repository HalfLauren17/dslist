package com.half.dslist.controllers;

import com.half.dslist.DTO.GameListDTO;
import com.half.dslist.services.GameListService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    
    @Autowired
    private GameListService gameListService;
    
    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> gameListsDTO = gameListService.findAll();
        return gameListsDTO;
    }
 
}
