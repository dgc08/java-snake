package com.github.dgc08.snake.interaction;

import com.github.dgc08.snake.MainPanel;

import java.awt.event.KeyEvent;

public class getDirection implements java.awt.event.KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Direction direction = WASDWrapper.getDirection(e.getKeyCode());
        if (getOpposite(direction) != MainPanel.direction) {
            MainPanel.direction = direction;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public static Direction getOpposite(Direction direction) {
        Direction ret = Direction.NONE;
        switch (direction) {
            case EAST -> ret = Direction.WEST;
            case WEST -> ret = Direction.EAST;
            case NORTH -> ret = Direction.SOUTH;
            case SOUTH -> ret = Direction.NORTH;
        }

        return ret;
    }
}
