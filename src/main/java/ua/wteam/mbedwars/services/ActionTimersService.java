package ua.wteam.mbedwars.services;

import ua.wteam.mbedwars.timers.ActionTimer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ActionTimersService {

    private ScheduledExecutorService service;

    public ActionTimersService() {
        service = Executors.newSingleThreadScheduledExecutor();
    }

    public void scheduleTask(ActionTimer actionTimer, long time, TimeUnit timeUnit) {
        service.schedule(actionTimer.getAction(), time, timeUnit);
    }

    public void scheduleRepeatingTask(ActionTimer actionTimer, long time, long repeatingPeriod, TimeUnit timeUnit) {
        service.scheduleAtFixedRate(actionTimer.getAction(), time, repeatingPeriod, timeUnit);
    }

    public void stopService() {
        service.shutdown();
    }

}
