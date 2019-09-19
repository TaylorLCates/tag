package org.improving.tag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start of main");
      Game game =  new Game();
        System.out.println("Declared game");
      game.run();
        System.out.println("Run completed");
      long elapsedTicks =  game.getEndTime().getTime() -
                      game.getStartTime().getTime();
      double elapsedSeconds = elapsedTicks / 1000.0;
      System.out.println("We were running for " + elapsedSeconds + "s.");
    }

}
