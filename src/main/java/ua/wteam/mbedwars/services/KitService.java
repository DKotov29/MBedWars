package ua.wteam.mbedwars.services;

import org.bukkit.entity.Player;
import ua.wteam.mbedwars.MBedWarsPlugin;
import ua.wteam.mbedwars.kits.Kit;

public class KitService {

    private MBedWarsPlugin main;

//            ArrayList<ItemStack> kitItems = new ArrayList<>();
//            kitItems.add(new ItemBuilder()
//                    .material(Material.DIAMOND_BOOTS)
//                    .addUnsafeEnchant(Enchantment.ARROW_DAMAGE, 10)
//                    .build());
//            Kit kit = Kit.newBuilder()
//                    .addItems(kitItems)
//                    .build();
//            kitService.setPlayerInventoryWithKit(kit, eve.getPlayer());

    public KitService(MBedWarsPlugin main) {
        this.main = main;
    }

    public void setPlayerInventoryWithKit(Kit kit, Player player) {
        player.getInventory().clear();
        kit.getItems().forEach(player.getInventory()::addItem);
    }


}
