package com.github.dgc08.snake.interaction;
import java.awt.event.KeyEvent;

public class WASDWrapper {
    public static Direction getDirection(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                return Direction.NORTH;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                return Direction.SOUTH;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                return Direction.WEST;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                return Direction.EAST;
            default:
                return Direction.NONE;
        }
    }
}
