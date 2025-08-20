package com.half.dslist.services;

import com.half.dslist.DTO.GameListDTO;
import com.half.dslist.entitites.GameList;
import com.half.dslist.repositories.GameListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;
       
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gameLists = gameListRepository.findAll();
        List<GameListDTO> gameListsDTO = gameLists.stream().map(x -> new GameListDTO(x)).toList();
        return gameListsDTO;
    }
}
