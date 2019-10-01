package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class InventoryCommand extends BaseAliasedCommand {
    public InventoryCommand(InputOutput io, String... aliases) {
        super(io, "Inv", "I", "Inventory", "Inven");
    }
    @Override
    public void childExecute(String input, Game game){
        if (game.getPlayer().getInventory().isEmpty()) {
            io.displayText("You are broke af.");
        } else io.displayText(game.getPlayer().getInventory().getInventoryDisplay());
    }
}
