package ua.wteam.mbedwars.kits;


import java.util.List;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
public class Kit {
    private List<ItemStack> items;

    public class Builder{
    }

        return new Kit().new Builder();

    public static Builder newBuilder() {
    }
    public List<ItemStack> getItems() {
        return items;

        public Builder addItems(List<ItemStack> items){
            Kit.this.items = items;
            return this;
        }

        public Kit build(){
            return Kit.this;
        }
    }

    List<ItemStack> itemsList;

    public Kit() {
        itemsList = new ArrayList<>();
    }

    public class Builder {

        public Builder addItems(List<ItemStack> items){
            Kit.this.items = items;
            return this;
        }

        public Kit build(){
            return Kit.this;
        }
    }
}
