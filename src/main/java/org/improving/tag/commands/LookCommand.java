package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends BaseEmoteCommand {
    public LookCommand(InputOutput io) {
        super("Look", "You look around.", io);
    }
}
