package org.improving.tag.commands;

import org.springframework.stereotype.Component;

@Component
public class JumpCommand extends BaseEmoteCommand {
    public JumpCommand() {
        super("Jump", "You jump up in the air.");
    }
}
