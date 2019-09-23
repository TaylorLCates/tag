package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.Player;
import org.springframework.stereotype.Component;

@Component
public class SetNameCommand implements Command{
    private InputOutput io;

    public SetNameCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input.trim();
        var parts = input.split("=");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("@set name");


    }

    @Override
    public void execute(String input, Game game) {
        var parts = input.split("=");
        var name = parts[1].trim();
        game.getPlayer().setName(name);
        io.displayText("Your name is now " + game.getPlayer().getName() + ".");
    }
}
