package com.half.dslist.repositories;

import com.half.dslist.entitites.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}
