package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private InputOutput io;
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
        String displayString = "You have these items: ";
//        items.sort(new ItemComparator());
//        items.stream().sorted().forEach(item -> System.out.println(item.getName()));
//        return displayString;

        return items.stream().sorted(new ItemComparator()).map(i -> "/n" + i)
                .reduce(displayString, (answer, itemValue) -> answer+= itemValue);
    }
}
