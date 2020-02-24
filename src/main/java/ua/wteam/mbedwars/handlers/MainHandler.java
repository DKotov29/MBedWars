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
import ua.wteam.mbedwars.actions.EventActionConsumer;

import java.util.*;


public class MainHandler implements Listener {

    private MBedWarsPlugin main;
    private Map<String, List<EventActionConsumer>> listenersMap;


    public MainHandler(MBedWarsPlugin main){
        this.main = main;
        listenersMap = new HashMap<String, List<EventActionConsumer>>();

        ///*****TEST
        List<EventActionConsumer> actionList = new ArrayList<>();
        actionList.add(event -> System.out.println(((BlockBreakEvent)event).getPlayer().getName()));
        listenersMap.put("BlockBreakEvent", actionList);
        /**/

    }

    public void handleEventAction(Event event){
        Optional<List<EventActionConsumer>> listOptional =
                Optional.ofNullable(listenersMap.get(event.getClass().getSimpleName()));
        if (listOptional.isPresent()){
            for (Object eventAction : listOptional.get()){
                EventActionConsumer eventActionConsumer = (EventActionConsumer)eventAction;
                eventActionConsumer.accept(event);
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        handleEventAction(event);
    }

    @EventHandler
    public void onPlayerLeave(PlayerKickEvent event){
        handleEventAction(event);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        handleEventAction(event);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        handleEventAction(event);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        handleEventAction(event);
    }
}
