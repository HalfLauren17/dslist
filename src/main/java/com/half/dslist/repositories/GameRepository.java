package com.half.dslist.repositories;

import com.half.dslist.entitites.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
