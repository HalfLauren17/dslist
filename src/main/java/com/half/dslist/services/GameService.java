package com.half.dslist.services;

import com.half.dslist.DTO.GameDTO;
import com.half.dslist.DTO.GameMinDTO;
import com.half.dslist.entitites.Game;
import com.half.dslist.projections.GameMinProjection;
import com.half.dslist.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;
    
    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        Game game = gameRepository.findById(gameId).get();
        return new GameDTO(game);
    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
       List<Game> games = gameRepository.findAll();
       List<GameMinDTO> gamesDTO = games.stream().map(x -> new GameMinDTO(x)).toList();
       return gamesDTO;
    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long gameListId){
       List<GameMinProjection> gamesProj = gameRepository.searchByList(gameListId);
       List<GameMinDTO> gamesMinDTO = gamesProj.stream().map(x -> new GameMinDTO(x)).toList();
       return gamesMinDTO;
    }
}
