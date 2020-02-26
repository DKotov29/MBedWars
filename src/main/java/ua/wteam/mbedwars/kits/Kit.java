package ua.wteam.mbedwars.kits;

import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.List;

public class Kit {

    private List<ItemStack> items;


    public Kit() {
        items = new ArrayList<>();
    }

    public static Builder newBuilder() {
        return new Kit().new Builder();
    }

    public List<ItemStack> getItems() {
        return items;
    }

    public class Builder {

        List<ItemStack> itemsList;

        public Builder addItems(List<ItemStack> items){
            Kit.this.items = items;
            return this;
        }

        public Kit build(){
            return Kit.this;
        }
    }
}
