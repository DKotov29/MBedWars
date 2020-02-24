package ua.wteam.mbedwars.timers;

import java.util.concurrent.TimeUnit;

public class ActionTimer {

    private final Runnable action;
    private final long time;
    private final TimeUnit timeUnit;
    private final long repeatingPeriod;

    public ActionTimer(Runnable action, long time, TimeUnit unit) {
        this.action = action;
        this.time = time;
        this.timeUnit = unit;
        repeatingPeriod = 0;
    }

    public ActionTimer(Runnable action, long time, TimeUnit unit, long repeatingPeriod) {
        this.action = action;
        this.time = time;
        this.timeUnit = unit;
        this.repeatingPeriod = repeatingPeriod;
    }

    public Runnable getAction() {
        return action;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public long getTime() {
        return time;
    }

    public long getRepeatingPeriod() {
        return repeatingPeriod;
    }
}
