package ua.wteam.mbedwars.game;

public class Game {

    private final int teamsAmount;
    private final int playerPerTeam;
    private GamePhase phase;

    public Game(int teamsAmount, int playerPerTeam) {
        phase = GamePhase.INLOBBY;
        this.teamsAmount = teamsAmount;
        this.playerPerTeam = playerPerTeam;
    }

    public void enterPrestarting() {

    }

    public void enterStarting() {

    }

    public void enterStarted() {

    }

    public void enterFinishing() {

    }
}
