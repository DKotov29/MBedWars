package ua.wteam.mbedwars.handlers;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ua.wteam.mbedwars.MBedWarsPlugin;
import ua.wteam.mbedwars.services.KitService;
import ua.wteam.mbedwars.services.ScoreBoardService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MainHandler implements Listener {

    private MBedWarsPlugin main;
    private Map<String, List<Consumer<Event>>> listenersMap;
    private KitService kitService;
    private ScoreBoardService scoreBoardService;


    public MainHandler(MBedWarsPlugin main) {
        this.main = main;
        listenersMap = new HashMap<String, List<Consumer<Event>>>();
        this.kitService = new KitService(main);
        this.scoreBoardService = new ScoreBoardService();


        //// TEST
        addHandleEventAction("PlayerJoinEvent", event -> {
            PlayerJoinEvent eve = (PlayerJoinEvent) event;
            scoreBoardService.applyScoreboardToPlayer();
        });

    }

    public void addHandleEventAction(String eventName, Consumer<Event> action) {
        if (listenersMap.get(eventName) == null) {
            List<Consumer<Event>> actionList = new ArrayList<>();
            actionList.add(action);
            listenersMap.put(eventName, actionList);
        } else {
            listenersMap.get(eventName).add(action);
        }
    }

    public void handleEventAction(Event event) {
        List<Consumer<Event>> actions = listenersMap.get(event.getClass().getSimpleName());
        if (actions != null) {
            actions.forEach(action -> action.accept(event));
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        handleEventAction(event);
    }

    @EventHandler
    public void onPlayerLeave(PlayerKickEvent event) {
        handleEventAction(event);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        handleEventAction(event);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        handleEventAction(event);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        handleEventAction(event);
    }
}
