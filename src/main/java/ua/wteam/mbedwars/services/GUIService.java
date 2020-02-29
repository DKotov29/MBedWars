package ua.wteam.mbedwars.services;

import org.bukkit.entity.Player;
import ua.wteam.mbedwars.inventorygui.GUI;

public class GUIService {

    public void showGUIForPlayer(Player player, GUI gui){
        player.openInventory(gui.toInventory());
    }

}
