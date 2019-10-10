package org.improving.tag;

import org.improving.tag.commands.Command;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.improving.tag.items.UniqueItems.FOX_EAR;

@Component
public class Game {
    private Command[] commands;
    private InputOutput io;
    private Date startTime;
    private Date endTime;
    private Player p;
    private Location startingLocation;
    private List<Location> locationList = new ArrayList<>();
    private final SaveGameFactory saveFactory;

    public Game(Command[] commands, InputOutput io, SaveGameFactory saveFactory) {
        startingLocation = buildWorld();
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

    private Command getValidCommand(String input) {
       // for (Command command : commands) {
         //   if (command.isValid(input, this))


                return Stream.of(commands).filter(c -> c.isValid(input, this)).findFirst().orElse(null);

        }


    private Location buildWorld() {


        var tdh = new Location();
        tdh.setName("The Deathly Hallows");
        tdh.setTreasureChest(new TreasureChest(UniqueItems.BLUE_SHELL, "A rainbow box glows with radiance and an italian man lets out a loud yelp in the distance"));
        this.locationList.add(tdh);

        var td = new Location();
        td.setName("The Desert");
        Adversary adversarytd = new Adversary("Desert Fox", 50, FOX_EAR);
        this.locationList.add(td);

        var ta = new Location();
        ta.setName("The Amazon");
        this.locationList.add(ta);

        var tmcs = new Location();
        tmcs.setName("The Mac and Cheese Shop");
        tmcs.setTreasureChest(new TreasureChest(UniqueItems.THE_ONE_RING,"A blue Kraft dinner box rests on the table, pulsing ominously with blue light. You hear a voice saying lowly \"one shell \n to feed them all, one shell to find them, one shell to bring them all and in the cheese, satisfy them!\" "));
        this.locationList.add(tmcs);

        var ap = new Location();
        ap.setName("The Airport");
        this.locationList.add(ap);

        var ict = new Location();
        ict.setName("The Ice Cream Truck");
        this.locationList.add(ict);

        var vm = new Location();
        vm.setName("The Velvet Moose");
        this.locationList.add(vm);

        var tmo = new Location();
        tmo.setName("The Mountains");
        this.locationList.add(tmo);

        var tr = new Location();
        tr.setName("The Reef");
        this.locationList.add(tr);

        var tma = new Location();
        tma.setName("The Mall");
        this.locationList.add(tma);

        var md = new Location();
        md.setName("Mount Doom");
        Adversary adversarymd = new Adversary("Sauron", 100, null);
        this.locationList.add(md);

        var tvd = new Location();
        tvd.setName("The Volcano of Death");
        this.locationList.add(tvd);

        md.setAdversary(adversarymd);
        td.setAdversary(adversarytd);

        tdh.getExits().add(new Exit("Heaven Avenue", tmcs, "heaven", "h", "ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "brownie", "deathly", "the", "tdb"));
        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
        td.getExits().add(new Exit("The Dock", ap, "dock", "td"));
        td.getExits().add(new Exit("The Rocky Road", ict, "Rocky Road", "rr", "rocky", "road"));
        tmcs.getExits().add(new Exit("Highway 121", ta, "121", "hwy 121", "h121"));
        tmcs.getExits().add(new Exit("Highway 21", tvd, "21", "hwy 21", "highway 21"));
        tmcs.getExits().add(new Exit("Paradise Road", tr, "Road", "Paradise Road", "PR"));
        tr.getExits().add(new Exit("The Scenic Route", vm, "the scenic route", "scenic", "route"));
        tr.getExits().add(new Exit("The City Walk", tma, "The city walk", "city walk", "Walk", "city"));
        tma.getExits().add(new Exit("An escalator of Doom", tvd, "An escalator of Doom", "Escalator", "Doom"));
        tma.getExits().add(new Exit("Path to Doom", md, "Path", "Doom", "Path to Doom"));
        md.getExits().add(new Exit("Jump into Lava", tvd, "Jump", "Lava", "Jump into Lava"));
        ict.getExits().add(new Exit("Magic Portal", md, "Portal", "Magic", "Magic Portal"));
        tmo.getExits().add(new Exit("The Lava Flow", tvd, "The lava flow", "Flow", "Lava"));
        tmo.getExits().add(new Exit("The Narrow Trail", md, "The narrow trail", "narrow", "trail"));
        tmo.getExits().add(new Exit("The Plane", ta, "The plane", "plane"));
        tmo.getExits().add(new Exit("The Bike Trail", tr, "The bike trail", "Trail", "bike"));
        ap.getExits().add(new Exit("Flight 121", tmo, "Flight 121", "121", "Flight"));
        ap.getExits().add(new Exit("Flight to the Mall", tma, "Flight to the Mall", "FtM", "Flight", "Mall"));
        vm.getExits().add(new Exit("The Pudding Slide", ta, "The pudding slide", "Pudding", "Slide", "Pudding slide"));
        vm.getExits().add(new Exit("The Front Door", ta, "The front door", "Front", "Door", "fd"));
        tr.getExits().add(new Exit("The Amaz-ing Moose", vm, "The amaz-ing moose", "amaz-ing moose", "amazing moose", "amaz-ing", "moose", "am"));
        md.getExits().add(new Exit("The Cab", tma, "The cab", "Cab", "C"));

        return tdh;
    }

    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }
        return null;
    }
}

