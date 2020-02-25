package ua.wteam.mbedwars.services;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import ua.wteam.mbedwars.MBedWarsPlugin;
import ua.wteam.mbedwars.kits.Kit;

public class KitService {

    private MBedWarsPlugin main;

    public KitService(MBedWarsPlugin main){
        this.main = main;
    }

    public void setKit(Kit kit, Player player){
        Inventory inventory = player.getInventory();
        inventory.clear();
        kit.getItems().forEach(inventory::addItem);
    }
}
