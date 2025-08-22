package com.half.dslist.services;

import com.half.dslist.DTO.GameListDTO;
import com.half.dslist.entitites.Belonging;
import com.half.dslist.entitites.BelongingPK;
import com.half.dslist.entitites.GameList;
import com.half.dslist.projections.GameMinProjection;
import com.half.dslist.repositories.GameListRepository;
import com.half.dslist.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;
    
    @Autowired
    private GameRepository gameRepository;
       
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gameLists = gameListRepository.findAll();
        List<GameListDTO> gameListsDTO = gameLists.stream().map(x -> new GameListDTO(x)).toList();
        return gameListsDTO;
    }

    @Transactional
    public void move(Long gameListId, int sourceIndex, int destinationIndex){
        List <GameMinProjection> gamesProj = gameRepository.searchByList(gameListId);
        
        GameMinProjection temp = gamesProj.remove(sourceIndex);
        gamesProj.add(destinationIndex, temp);
        
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;
        
        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(gameListId, gamesProj.get(i).getId(), i);
        }
    }
}
