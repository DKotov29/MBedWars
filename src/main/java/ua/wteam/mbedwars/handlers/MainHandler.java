package ua.wteam.mbedwars.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.*;
import ua.wteam.mbedwars.MBedWarsPlugin;
import ua.wteam.mbedwars.services.AsyncService;
import ua.wteam.mbedwars.services.KitService;
import ua.wteam.mbedwars.utils.ScoreBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MainHandler implements Listener {

    private MBedWarsPlugin main;
    private Map<String, List<Consumer<Event>>> listenersMap;
    private KitService kitService;
    private ScoreBoard scoreBoard;
    AsyncService asyncService = new AsyncService();


    public MainHandler(MBedWarsPlugin main) {
        this.main = main;
        listenersMap = new HashMap<>();
        this.kitService = new KitService(main);

        addHandleEventAction("PlayerJoinEvent", event -> {
            PlayerJoinEvent joinEvent = (PlayerJoinEvent) event;
            Player player = joinEvent.getPlayer();
            player.sendMessage("§7[§a+§7] " + player.getName());
        });
        addHandleEventAction("PlayerQuitEvent", event -> {
            PlayerJoinEvent joinEvent = (PlayerJoinEvent) event;
            joinEvent.getPlayer().sendMessage("§7[§a-§7] " + joinEvent.getPlayer().getName());
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
        asyncService.submitTask(() -> main.getGameLogic().playerJoined(event.getPlayer()));
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
    public void onChatEvent(AsyncPlayerChatEvent event) {
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

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        handleEventAction(event);
    }

    // <InventoryEvents>
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        handleEventAction(event);
        // проверить наш ли инвентарь
        // если наш взять действие заложенное в кнопке
    }

    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {

    }

    @EventHandler
    public void onInventoryMoveItem(InventoryPickupItemEvent event) {

    }

    @EventHandler
    public void onInventoryMoveItem(InventoryDragEvent event) {

    }
    // </InventoryEvents>
}
