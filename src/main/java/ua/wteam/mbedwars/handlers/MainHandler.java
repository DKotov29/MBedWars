package ua.wteam.mbedwars.handlers;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ua.wteam.mbedwars.MBedWarsPlugin;
import ua.wteam.mbedwars.kits.Kit;
import ua.wteam.mbedwars.services.KitService;

import java.util.*;
import java.util.function.Consumer;

public class MainHandler implements Listener {

    private MBedWarsPlugin main;
    private Map<String, List<Consumer<Event>>> listenersMap;

    private KitService kitService;


    public MainHandler(MBedWarsPlugin main) {
        this.main = main;
        listenersMap = new HashMap<String, List<Consumer<Event>>>();
        this.kitService = new KitService(main);

        addHandleEventAction("PlayerJoinEvent", event -> {
            PlayerJoinEvent event1 = (PlayerJoinEvent) event;

            //// TEST
            ArrayList<ItemStack> kitItems = new ArrayList<>();

            ItemStack itemStack = new ItemStack(Material.COAL_ORE);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§cTest kit");
            itemStack.setItemMeta(itemMeta);

            kitItems.add(itemStack);

            Kit kit = Kit.newBuilder().addItems(kitItems).addItem(new ItemStack(Material.CARROT_ITEM)).addItem(Material.COAL).build();

            kitService.setKit(kit, event1.getPlayer());

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
