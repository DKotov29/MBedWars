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
import java.util.*;
import java.util.function.Consumer;

public class MainHandler implements Listener {

    private MBedWarsPlugin main;
    private Map<String, List<Consumer>> listenersMap;


    public MainHandler(MBedWarsPlugin main) {
        this.main = main;
        listenersMap = new HashMap<String, List<Consumer>>();

        // TEST
        List<Consumer> actionList = new ArrayList<>();
        actionList.add(event -> System.out.println(((BlockBreakEvent) event).getPlayer().getName()));
        listenersMap.put("BlockBreakEvent", actionList);
        /**/
    }

    public void addHandleEventAction(String eventName, Consumer action) {
        if (listenersMap.get(eventName) == null) {
            List<Consumer> actionList = new ArrayList<>();
            actionList.add(action);
            listenersMap.put(eventName, actionList);
        } else {
            listenersMap.get(eventName).add(action);
        }
    }

    public void handleEventAction(Event event) {
        List<Consumer> actions = listenersMap.get(event.getClass().getSimpleName());
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
