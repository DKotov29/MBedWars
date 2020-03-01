package ua.wteam.mbedwars.services;

import ua.wteam.mbedwars.timers.ActionTimer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AsyncService {

    private ScheduledExecutorService scheduledExecutorService;
    private ExecutorService service;

    public AsyncService() {
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this.service = Executors.newFixedThreadPool(6);
    }

    public void scheduleTask(ActionTimer actionTimer, long time, TimeUnit timeUnit) {
        scheduledExecutorService.schedule(actionTimer.getAction(), time, timeUnit);
    }

    public void scheduleRepeatingTask(ActionTimer actionTimer, long time, long repeatingPeriod, TimeUnit timeUnit) {
        scheduledExecutorService.scheduleAtFixedRate(actionTimer.getAction(), time, repeatingPeriod, timeUnit);
    }

    public void submitTask(Runnable action) {
        service.submit(action);
    }

    public void stopService() {
        scheduledExecutorService.shutdown();
    }

    public ExecutorService getService() {
        return service;
    }
}
