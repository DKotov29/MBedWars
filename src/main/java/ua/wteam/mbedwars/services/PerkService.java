package ua.wteam.mbedwars.services;

import org.bukkit.entity.Player;
import ua.wteam.mbedwars.MBedWarsPlugin;
import ua.wteam.mbedwars.perks.Perk;

import java.util.ArrayList;
import java.util.List;

public class PerkService {

    private List<Perk> perks;
    private MBedWarsPlugin main;

    public PerkService(MBedWarsPlugin main){
        this.main = main;
        perks = new ArrayList<>();

    }

    public void applyPerk(Player player, Perk perk){

    }

}
