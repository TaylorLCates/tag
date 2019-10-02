package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Item> items = new ArrayList();

    public Inventory() {
        items.add(UniqueItems.THE_ONE_RING);
        items.add(UniqueItems.WEIRD_EARS);
        items.add(UniqueItems.BEYBLADE);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getInventoryDisplay() {
        String displayString = "You have the following items in your inventory: ";
        items.sort(new ItemComparator());
        for (Item item :
                items) {
            displayString += "\n" + item;
        } return displayString;
    }
}
