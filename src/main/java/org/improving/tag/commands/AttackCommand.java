package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command {
    public Random randomInt = new Random();
    private InputOutput io;

    public AttackCommand(InputOutput io){
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input.trim();
        return input.equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game) {
        if (game.getPlayer().getLocation().getAdversary() == null) {
            io.displayText("Attack what?");
        } else {
            int swing = randomInt.nextInt(100) + 1;
            if (swing <= 99) {
                game.getPlayer().getLocation().getAdversary().damageCalculation(10);
                io.displayText(game.getPlayer().getLocation().getAdversary().getHitPoints());
            }
            else {
                io.displayText("Swing and a miss!");
            } if (game.getPlayer().getLocation().getAdversary().getHitPoints() <=0) {
                Item item = game.getPlayer().getLocation().getAdversary().getItem();
                io.displayText("You have vanquished " + game.getPlayer().getLocation().getAdversary().getName());
                io.displayText("You pick up " + item);
                game.getPlayer().getInventory().addItem(item);
                game.getPlayer().getLocation().setAdversary(null);

            }
        }

    }
}

