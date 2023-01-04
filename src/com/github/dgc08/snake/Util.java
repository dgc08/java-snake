package com.github.dgc08.snake;

public class Util {
    public static String gameOverMessage = "GAME OVER. Get wrecked Noob :O";
    public static String restartHelper = "Restart from the File Menu.";

    public static int difficulty = 120;

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
}