package org.improving.tag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.trim().equals("Look")) {
                System.out.println("You look around.");
            } else if (input.trim().equals("Inventory")) {
                System.out.println("You are carrying nothing.");
            } else if (input.trim().equals("Dance")) {
                System.out.println("You dance around.");
            } else if (input.trim().equals("Jump")) {
                System.out.println("You jump in the air.");
            } else if (input.trim().equals("Exit")) {
                System.out.println("Goodbye.");
                loop = false;
            } else {
                System.out.println("Huh? I don't understand.");
            }
        }
    }

}
