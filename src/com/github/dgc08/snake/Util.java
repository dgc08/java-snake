package com.github.dgc08.snake;

public class Util {
    public static final String gameOverMessage = "GAME OVER. Get wrecked Noob :O";
    public static final String restartHelper = "Restart from the Game Menu.";
    public static final String invalidDifficulty = "That doesn't look like a Number. Try again.";

    public static boolean running = true;

    public static final int WIDTH = 500;
    public static final int SPAWNER_CONST_WIDTH = WIDTH/10 - 1;
    public static final int LENGTH = 500;
    public static final int SPAWNER_CONST_LENGTH = LENGTH/10 - 1;
    public static final int IMAGE_SIZE = 10;

    public static int negMod(int value, int max) {
        if (value > max) {
            return value % max;
        }
        if (value < 0) {
            return value + max;
        }
        return value;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}