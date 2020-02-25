package ua.wteam.mbedwars.game;

public class Game {

    private final int teamsAmount;
    private final int playerPerTeam;
    private GamePhase phase;

    public Game(int teamsAmount, int playerPerTeam) {
        phase = GamePhase.IN_LOBBY;
        this.teamsAmount = teamsAmount;
        this.playerPerTeam = playerPerTeam;
    }

    public void enterPreStarting() {

    }

    public void enterStarting() {

    }

    public void enterStarted() {

    }

    public void enterFinishing() {

    }
}
