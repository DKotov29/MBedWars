package ua.wteam.mbedwars.kits;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Kit {
    private List<ItemStack> items;

    public List<ItemStack> getItems() {
        return items;
    }

    public static Builder newBuilder() {
        return new Kit().new Builder();
    }

    public class Builder{

        public Builder addItems(List<ItemStack> items){
            Kit.this.items = items;
            return this;
        }

        public Kit build(){
            return Kit.this;
        }
    }
}
