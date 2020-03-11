package ua.wteam.mbedwars.logic;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

public interface GameLogic {

    void playerJoined(Player player);

    void playerLeaveFromGame(Player player);

    void playerMurdered(Player killer, Player killed);

    void blockBreak(Block block, Player player);

    void playerMove(Player player, Location from, Location to);

    void blockClick(Block block, Action action, Player player);

}
