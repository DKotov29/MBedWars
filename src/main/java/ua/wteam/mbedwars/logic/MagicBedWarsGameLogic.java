package ua.wteam.mbedwars.logic;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import ua.wteam.mbedwars.MBedWarsPlugin;

public class MagicBedWarsGameLogic implements GameLogic {

    private MBedWarsPlugin main;

    public MagicBedWarsGameLogic(MBedWarsPlugin main) {
        this.main = main;
    }

    @Override
    public void playerJoined(Player player) {

    }

    @Override
    public void playerLeaveFromGame(Player player) {

    }

    @Override
    public void playerMurdered(Player killer, Player killed) {

    }

    @Override
    public void blockBreak(Block block, Player player) {

    }

    @Override
    public void playerMove(Player player, Location from, Location to) {

    }

    @Override
    public void blockClick(Block block, Action action, Player player) {

    }
}
