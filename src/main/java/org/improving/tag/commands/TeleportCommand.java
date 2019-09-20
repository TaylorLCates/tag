package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class TeleportCommand extends BaseEmoteCommand {
    public TeleportCommand(InputOutput io) {
        super("Teleport", "You phase out of existence.", io);
        }
    }

