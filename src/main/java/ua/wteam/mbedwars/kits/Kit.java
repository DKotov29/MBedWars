package ua.wteam.mbedwars.kits;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Kit {
    
    private List<ItemStack> items;

    public Kit(){
        this.items = new ArrayList<>();
    }

    public Kit(List<ItemStack> items){
        this.items = items;
    }

    public List<ItemStack> getItems() {
        return items;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder{

        private List<ItemStack> items;

        public Builder(){
            this.items = new ArrayList<>();
        }

        public Builder addItems(List<ItemStack> items){
            this.items.addAll(items);
            return this;
        }

        public Builder addItem(ItemStack item){
            this.items.add(item);
            return this;
        }

        public Kit build(){
            return new Kit(items);
        }
    }
}
