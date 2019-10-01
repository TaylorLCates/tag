package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

@Component
public class OpenChestCommand extends BaseAliasedCommand {
    private InputOutput io;

    public OpenChestCommand(InputOutput io, String... aliases) {
        super(io, "open", "o", "chest");
        this.io = io;
    }
    @Override
    public void childExecute(String input, Game game) {
        Item item = game.getPlayer().getLocation().openTreasureChest();
        io.displayText("You open the chest to reveal " + item);
        game.getPlayer().getInventory().addItem(item);
    }

    @Override
    public String getErrorMessage() {
        return "Are you high?";
    }

}
