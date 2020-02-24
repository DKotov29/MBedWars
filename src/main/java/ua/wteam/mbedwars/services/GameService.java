package ua.wteam.mbedwars.services;

import ua.wteam.mbedwars.game.Game;

public class GameService {

    private Game game;

    public GameService(){
        this.game = new Game();
    }

    public Game getGame() {
        return game;
    }
}
