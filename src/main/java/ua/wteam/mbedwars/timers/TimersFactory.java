package ua.wteam.mbedwars.timers;

import ua.wteam.mbedwars.actions.Action;

import java.util.concurrent.TimeUnit;

public class TimersFactory {

    public static ActionTimer getNew(Action action, long time, TimeUnit timeUnit){
        return new ActionTimer(action, time, timeUnit);
    }

    public static ActionTimer getActionTimerSeconds(Action action, long time){
        return new ActionTimer(action, time, TimeUnit.SECONDS);
    }

    public static ActionTimer getActionTimerMilliSeconds(Action action, long time){
        return new ActionTimer(action, time, TimeUnit.MILLISECONDS);
    }

    public static ActionTimer getActionTimerMilliMinutes(Action action, long time){
        return new ActionTimer(action, time, TimeUnit.MINUTES);
    }

}
