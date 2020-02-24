package ua.wteam.mbedwars.timers;

import java.util.concurrent.TimeUnit;

public class TimersFactory {

    public static ActionTimer getNew(Runnable action, long time, TimeUnit timeUnit) {
        return new ActionTimer(action, time, timeUnit);
    }

    public static ActionTimer getActionTimerSeconds(Runnable action, long time) {
        return new ActionTimer(action, time, TimeUnit.SECONDS);
    }

    public static ActionTimer getActionTimerMilliSeconds(Runnable action, long time) {
        return new ActionTimer(action, time, TimeUnit.MILLISECONDS);
    }

    public static ActionTimer getActionTimerMilliMinutes(Runnable action, long time) {
        return new ActionTimer(action, time, TimeUnit.MINUTES);
    }

}
