package ua.wteam.mbedwars.services;

import org.bukkit.entity.Player;
import ua.wteam.mbedwars.magic.MagicCore;

import java.util.HashMap;
import java.util.Map;

public class MagicService {

    public Map<Player, Long> playersMana;

    public MagicService(){
        playersMana = new HashMap<>();
    }

    public void startCoreAnimation(MagicCore core){

    }
}
