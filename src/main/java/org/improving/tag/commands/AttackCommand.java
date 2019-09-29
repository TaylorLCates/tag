package org.improving.tag.commands;

import org.improving.tag.Game;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command {
    public Random randomInt = new Random();

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input.trim();
        return input.equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game) {
        if (game.getPlayer().getLocation().getAdversary() == null) {
            System.out.println("Attack what?");
        } else {
            int swing = randomInt.nextInt(100) + 1;
            if (swing <= 99) {
                game.getPlayer().getLocation().getAdversary().damageCalculation(10);

            } else {
                System.out.println("Swing and a miss!");
            }
        }
        System.out.println(game.getPlayer().getLocation().getAdversary().getHitPoints());
        System.out.println(game.getPlayer().getLocation().getAdversary().getDamageTaken());
    }
}

