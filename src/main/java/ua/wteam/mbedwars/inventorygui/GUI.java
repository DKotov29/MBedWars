package ua.wteam.mbedwars.inventorygui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class GUI {

    private GUIButton[] guiButtons;
    private String guiName;
    private int rows;

    public GUI(String name, int rows) {
        if (rows > 6) {
            this.rows = 6;
        } else if (rows < 1) {
            this.rows = 1;
        } else {
            this.rows = rows;
        }
        this.guiButtons = new GUIButton[rows*9];
        this.guiName = name.replace("&", "§");
    }

    public boolean addButtonToFirstEmptyPosition(GUIButton guiButton) {
        int i = findEmptyPosition();
        if (i == -1) {
            return false;
        } else {
            this.guiButtons[i] = guiButton;
            return true;
        }
    }



    public void setButtonToPosition(GUIButton guiButton, int position) {
        System.out.println(guiButtons);
        if (position < 0 || position > guiButtons.length) {
            return;
        }
        this.guiButtons[position] = guiButton;
    }

    private int findEmptyPosition() {
        for (int i = 0; i < guiButtons.length; i++) {
            if (guiButtons[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public GUIButton[] getItems() {
        return this.guiButtons;
    }

    public String getGuiName() {
        return this.guiName;
    }

    public Inventory toInventory() {
        Inventory inventory = Bukkit.createInventory(null, rows*9, this.guiName);
        for (int i = 0; i < guiButtons.length; i++) {
            if (guiButtons[i] != null) {
                inventory.setItem(i, guiButtons[i].getItemStackButton());
            }
        }
        return inventory;
    }
}
