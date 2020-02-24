package ua.wteam.mbedwars.game;

public class Game implements IGame {

    GamePhase phase;

    public Game(){
        phase = GamePhase.INLOBBY;
    }

    @Override
    public void enterPrestarting() {

    }

    @Override
    public void enterStarting() {

    }

    @Override
    public void enterStarted() {

    }

    @Override
    public void enterFinishing() {

    }
}
