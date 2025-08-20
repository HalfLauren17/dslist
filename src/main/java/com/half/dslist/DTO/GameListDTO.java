package com.half.dslist.DTO;

import com.half.dslist.entitites.GameList;

public class GameListDTO {
    private Long id;
    private String name;
    
    public GameListDTO() {
        
    }

    public GameListDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public GameListDTO(GameList entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    
}
