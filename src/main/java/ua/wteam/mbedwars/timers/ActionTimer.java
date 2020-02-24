package ua.wteam.mbedwars.timers;

import ua.wteam.mbedwars.actions.Action;

import java.util.concurrent.TimeUnit;

public class ActionTimer{

    private Action action;
    private long time;
    private TimeUnit timeUnit;

    public ActionTimer(Action action, long time, TimeUnit unit){
        this.action = action;
        this.time = time;
        this.timeUnit = unit;
    }

    public Action getAction() {
        return action;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public long getTime() {
        return time;
    }

}
