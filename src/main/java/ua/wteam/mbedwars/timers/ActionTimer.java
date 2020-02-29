package ua.wteam.mbedwars.timers;

public class ActionTimer {

    private final Runnable action;

    public ActionTimer(Runnable action) {
        this.action = action;
    }

    public Runnable getAction() {
        return action;
    }
}
