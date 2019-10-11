package org.improving.tag;

import org.improving.tag.commands.Command;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Component
public class Game {
    private Command[] commands;
    private InputOutput io;
    private Date startTime;
    private Date endTime;
    private Player p;
    private Location startingLocation;
    private final SaveGameFactory saveFactory;
    private List<Location> locationList = new ArrayList<>();

    public Game(Command[] commands, InputOutput io, SaveGameFactory saveFactory, WorldBuilder worldBuilder) {
        startingLocation = worldBuilder.buildWorld();
        locationList = worldBuilder.getLocationList();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
        this.saveFactory = saveFactory;
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;
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

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public void run() {
        this.setStartTime(new Date());
        boolean loop = true;
        while (loop) {
            try {
                io.displayPrompt("> ");
                String input = io.receiveInput();
                Command validCommand = getValidCommand(input);

                if (null != validCommand) {
                    validCommand.execute(input, this);
                } else {
                    io.displayText("Huh? I don't understand.");
                }
            } catch (GameExitException ex) {
                loop = false;
            }
        }
        this.setEndTime(new Date());
    }

    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }
        return null;
    }

    private Command getValidCommand(String input) {
       // for (Command command : commands) {
         //   if (command.isValid(input, this))
        return Stream.of(commands).filter(c -> c.isValid(input, this)).findFirst().orElse(null);
        }
}

