package ua.wteam.mbedwars.inventorygui;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GUIButton implements Listener {

    private ItemStack itemStackButton;
    private Consumer<? extends Event> action;

    public GUIButton(ItemStack itemStack){
        this.itemStackButton = itemStack;
        action = null;
    }

    public GUIButton(ItemStack itemStack, Consumer<? extends Event> action){
        this.itemStackButton = itemStack;
        this.action = action;
    }

    public GUIButton() {

    }

    public ItemStack getItemStackButton(){
        return this.itemStackButton;
    }

    public static Builder newBuilder(){
        return new Builder();
    }

    public static class Builder{

        private ItemStack itemStackButton;
        private Consumer<? extends Event> action;

        public Builder withItemStack(ItemStack itemStack){
            this.itemStackButton = itemStack;
            return this;
        }

        public Builder withActionOnCLick(Consumer<? extends Event> actionOnCLick){
            this.action = actionOnCLick;
            return this;
        }

        public Builder withActionOnCLickTest(Consumer<InventoryClickEvent> actionOnCLick){
            Map<GUIButton, Consumer<InventoryClickEvent>> action = new HashMap<>();
            action.put(build(), actionOnCLick);
         //   Test.actions.add(action);
            return this;
        }

        public GUIButton build(){
            if (this.itemStackButton == null){
                return null;
            }
            if (this.action == null){
                return new GUIButton(this.itemStackButton);
            }
            return new GUIButton(this.itemStackButton, this.action);
        }
    }

}
