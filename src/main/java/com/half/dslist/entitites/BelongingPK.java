package com.half.dslist.entitites;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class BelongingPK {
    
    @ManyToOne
    @JoinColumn(name = "gameId")
    private Game game;
    
    @ManyToOne
    @JoinColumn(name = "gameListId")
    private GameList gameList;
    
    public BelongingPK() {
        
    }

    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, gameList);
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        BelongingPK other = (BelongingPK) obj;
        return Objects.equals(this.game, other.game) && Objects.equals(this.gameList, other.gameList);
    }
    
    
}
