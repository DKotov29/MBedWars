package ua.wteam.mbedwars.perks;

import org.bukkit.entity.Player;

public class Perk {

    double allDamageMultiplier = 1;
    double allDefenseMultipler = 1;

    double allEttackExtension = 0;
    double allDefenseExtension = 0;

    public void assignToPlayer(Player p){

    }

    public Builder getBuilder(){
        return new Builder();
    }

    private class Builder{



        public Perk build(){
            return new Perk();
        }

    }

}
