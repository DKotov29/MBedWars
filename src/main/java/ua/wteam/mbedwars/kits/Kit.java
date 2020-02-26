package ua.wteam.mbedwars.kits;

import org.bukkit.Material;
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

    public Builder newBuilder() {
        return new Builder();
    }

    public class Builder{

        private List<ItemStack> items;

        public Builder(){
            items = new ArrayList<>();
        }

        public Builder addItems(List<ItemStack> items){
            this.items.addAll(items);
            return this;
        }

        public Builder addItem(ItemStack item){
            this.items.add(item);
            return this;
        }

        public Builder addItem(Material item){
            this.items.add(new ItemStack(item));
            return this;
        }

        public Kit build(){
            return new Kit(items);
        }
    }
}
