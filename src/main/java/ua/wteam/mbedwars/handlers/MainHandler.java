package ua.wteam.mbedwars.handlers;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ua.wteam.mbedwars.MBedWarsPlugin;
import ua.wteam.mbedwars.managers.ScoreBoardManager;
import ua.wteam.mbedwars.services.KitService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MainHandler implements Listener {

    private MBedWarsPlugin main;
    private Map<String, List<Consumer<Event>>> listenersMap;
    private KitService kitService;
    private ScoreBoardManager scoreBoardManager;


    public MainHandler(MBedWarsPlugin main) {
        this.main = main;
        listenersMap = new HashMap<>();
        this.kitService = new KitService(main);

        //// TEST
        addHandleEventAction("PlayerJoinEvent", event -> {
            PlayerJoinEvent joinEvent = (PlayerJoinEvent) event;

            this.scoreBoardManager = new ScoreBoardManager("§cMBedWars");

            List<String> scores = new ArrayList<>();
            Player player = joinEvent.getPlayer();
            scores.add("Player name: " + player.getName());
            scores.add("---");
            scores.add("XYZ: " + "here coords");
            scoreBoardManager.addLines(scores);
            scoreBoardManager.updateForPlayer(player);
        });

        addHandleEventAction("PlayerMoveEvent", moveEvent -> {

            PlayerMoveEvent playerMoveEvent = (PlayerMoveEvent) moveEvent;
            Player player = playerMoveEvent.getPlayer();
            Location playerLocation = player.getLocation();
            scoreBoardManager.editLine(2, "XYZ: " + Math.round(playerLocation.getX()) + " " +
                    Math.round(playerLocation.getY()) + " " + Math.round(playerLocation.getZ()));
            scoreBoardManager.updateForPlayer(player);
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

    private void handleEventAction(Event event) {
        Event event1 = event;
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

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        handleEventAction(event);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        handleEventAction(event);
    }
}
