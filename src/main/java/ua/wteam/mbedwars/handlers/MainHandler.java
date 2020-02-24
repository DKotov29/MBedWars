package ua.wteam.mbedwars.handlers;

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
        listenersMap = new HashMap<>();
        //TEST
        List<EventActionConsumer> actionList = new ArrayList<>();
        actionList.add(event -> System.out.println(event.getEventName()));
        listenersMap.put("PlayerJoinEvent", actionList);

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Optional<List> listOptional = Optional.ofNullable(listenersMap.get(event.getClass().getName()));

        System.out.println(event.getClass().getName());
        if (listOptional.isPresent()){
            for ( Object eventAction : listOptional.get()){
                EventActionConsumer eventActionConsumer = (EventActionConsumer)eventAction;
                eventActionConsumer.accept(event);
            }
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerKickEvent event){

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){

    }
}
