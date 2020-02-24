package ua.wteam.mbedwars.services;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class MagicService {

    public Map<Player, Long> playersMana;

    public MagicService(){
        playersMana = new HashMap<>();
    }

}
