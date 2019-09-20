package org.improving.tag.commands;

import org.springframework.stereotype.Component;

@Component
public class DanceCommand extends BaseEmoteCommand {
    public DanceCommand() {
        super("Dance", "You dance around.");
    }
}
