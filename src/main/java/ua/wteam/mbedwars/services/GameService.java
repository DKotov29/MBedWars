package ua.wteam.mbedwars.services;

import ua.wteam.mbedwars.game.Game;

public class GameService {

    private Game game;

    public GameService(int teamsAmount, int playerPerTeam){
        this.game = new Game(teamsAmount, playerPerTeam);
    }

    public Game getGame() {
        return game;
    }
}
