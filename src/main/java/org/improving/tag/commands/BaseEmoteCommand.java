package org.improving.tag.commands;

import org.improving.tag.InputOutput;

public abstract class BaseEmoteCommand implements Command {
    private String cmdText;
    private String cmdResponse;
    private InputOutput io;

    public BaseEmoteCommand(String cmdText, String cmdResponse, InputOutput io) {
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
        this.io = io;
    }
    @Override
    public boolean isValid(String input) {
        return ( input == null ? "" : input).trim().equalsIgnoreCase(cmdText);
    }
    @Override
    public void execute(String input) {
        io.displayText(cmdResponse);
    }
}
