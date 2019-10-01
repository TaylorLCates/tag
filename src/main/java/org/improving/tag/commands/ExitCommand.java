package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand extends BaseAliasedCommand {
    private final SaveGameFactory saveGameFactory;

    public ExitCommand(InputOutput io, SaveGameFactory saveGameFactory) {
        super(io, "Exit", "ex", "esc", "quit");
        this.saveGameFactory = saveGameFactory;
    }

    @Override
    public void childExecute(String input, Game game) {
        saveGameFactory.save(game);
        io.displayText("Goodbye!");
        throw new GameExitException();
    }

}
