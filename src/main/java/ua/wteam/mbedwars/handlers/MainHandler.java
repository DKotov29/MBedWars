package ua.wteam.mbedwars.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ua.wteam.mbedwars.MBedWarsPlugin;
import ua.wteam.mbedwars.actions.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainHandler implements Listener {

    private MBedWarsPlugin main;
    private Map<String, List<Action>> listenersMap;


    public MainHandler(MBedWarsPlugin main){
        this.main = main;
        listenersMap = new HashMap<>();

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        List<Action> actions = listenersMap.get(event.getClass().getName());
        if (actions.isEmpty() || actions == null){
            System.out.println("0");

        }
      /*  for( Action a :  ){
            a.run();
        }*/
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
