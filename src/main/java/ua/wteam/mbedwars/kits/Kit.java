package ua.wteam.mbedwars.kits;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Kit {
    private List<ItemStack> items;

    public Kit(){
        items = new ArrayList<>();
    }

    public List<ItemStack> getItems() {
        return items;
    }

    public static Builder newBuilder() {
        return new Kit().new Builder();
    }

    public class Builder{

        public Builder addItems(List<ItemStack> items){
            Kit.this.items.addAll(items);
            return this;
        }

        public Builder addItem(ItemStack item){
            Kit.this.items.add(item);
            return this;
        }

        public Builder addItem(Material item){
            Kit.this.items.add(new ItemStack(item));
            return this;
        }

        public Kit build(){
            return Kit.this;
        }
    }
}
