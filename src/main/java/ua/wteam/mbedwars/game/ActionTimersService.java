package ua.wteam.mbedwars.game;

import ua.wteam.mbedwars.timers.ActionTimer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ActionTimersService {

    private static ScheduledExecutorService service;

    public ActionTimersService(){
        service = Executors.newSingleThreadScheduledExecutor();
    }

    public static void sheduleTask(ActionTimer actionTimer){
        service.schedule(actionTimer.getAction(), actionTimer.getTime(), actionTimer.getTimeUnit());
    }

    public static void stopService(){
        service.shutdown();
    }

}
