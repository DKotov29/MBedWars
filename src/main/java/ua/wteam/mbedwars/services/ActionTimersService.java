package ua.wteam.mbedwars.services;

import ua.wteam.mbedwars.timers.ActionTimer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ActionTimersService {

    private ScheduledExecutorService service;

    public ActionTimersService() {
        service = Executors.newSingleThreadScheduledExecutor();
    }

    public void sheduleTask(ActionTimer actionTimer) {
        service.schedule(actionTimer.getAction(), actionTimer.getTime(), actionTimer.getTimeUnit());
    }

    public void stopService() {
        service.shutdown();
    }

}
