package ua.wteam.mbedwars.handlers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ua.wteam.mbedwars.MBedWarsPlugin;
import ua.wteam.mbedwars.inventorygui.GUI;
import ua.wteam.mbedwars.inventorygui.GUIButton;
import ua.wteam.mbedwars.items.ItemBuilder;
import ua.wteam.mbedwars.managers.ScoreBoardManager;
import ua.wteam.mbedwars.services.KitService;
import ua.wteam.mbedwars.timers.ActionTimer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class MainHandler implements Listener {

    private MBedWarsPlugin main;
    private Map<String, List<Consumer<Event>>> listenersMap;
    private KitService kitService;
    private ScoreBoardManager scoreBoardManager;


    public MainHandler(MBedWarsPlugin main) {
        this.main = main;
        listenersMap = new HashMap<String, List<Consumer<Event>>>();
        this.kitService = new KitService(main);

        addHandleEventAction("PlayerJoinEvent", event -> {
            PlayerJoinEvent joinEvent = (PlayerJoinEvent) event;
            main.getActionTimersService().scheduleTask(new ActionTimer(() -> {
                GUI gui = new GUI("main Gui", 2);
                gui.addButtonToFirstEmptyPosition(GUIButton.newBuilder().withItemStack(
                        ItemBuilder.newBuilder()
                                .material(Material.DIAMOND_BOOTS)
                                .build())
                        .build());
                main.getGuiService().showGUIForPlayer(joinEvent.getPlayer(), gui);
            }), 0, TimeUnit.SECONDS);
        });

        //// TEST
        addHandleEventAction("PlayerJoinEvent", event -> {
            PlayerJoinEvent joinEvent = (PlayerJoinEvent) event;

            this.scoreBoardManager = new ScoreBoardManager("§cMBedWars");

            List<String> scores = new ArrayList<>(); // понял, иду в гуи, сотрешь
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
            scoreBoardManager.editLine(2, "XYZ: " + Math.round(playerLocation.getX()) + " " + Math.round(playerLocation.getY()) + Math.round(playerLocation.getZ()));
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

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        handleEventAction(event);
    }
}
