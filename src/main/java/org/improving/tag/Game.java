package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Scanner;

@Component
public class Game {
    private Command[] commands;
    private InputOutput io;
    private Date startTime;
    private Date endTime;

    public Game(Command[] commands, InputOutput io) {
        this.commands = commands;
        this.io = io;
    }
    public Date getStartTime() {
        return startTime;
    }
    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public void run() {

        this.setStartTime(new Date());

        boolean loop = true;
        while (loop) {
            io.displayPrompt("> ");
            String input = io.receiveInput();
            Command validCommand = getValidCommand(input);

            if (null != validCommand) {
                validCommand.execute(input);
            } else if (input.trim().equalsIgnoreCase("Exit")) {
                io.displayText("Goodbye.");
                loop = false;
            } else {
                io.displayText("Huh? I don't understand.");
            }
        }
        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        for (Command command : commands) {
            if(command.isValid(input)) {
                return command;
            }
        }
        return null;
    }

}
