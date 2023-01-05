package com.github.dgc08.snake.interaction;

import com.github.dgc08.snake.MainPanel;
import com.github.dgc08.snake.Menu.FileMenu;

import java.awt.event.KeyEvent;

public class getDirection implements java.awt.event.KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            FileMenu.pauseResume();
            return;
        }
        Direction direction = WASDWrapper.getDirection(e.getKeyCode());

        if (direction == Direction.NONE && e.getKeyCode() == KeyEvent.VK_K) {   // If you press K (ill), you will die in exactly 1 frames.
            MainPanel.direction = Direction.NONE;                               // The MainPanel won't move the head of the snake, because no Direction is defined.
                                                    // The Dead Checker will kill you because your head is there were your first tail is, that means you'll bite yourself.
        }

        if (direction == Direction.NONE) {
            return;
        }

        if ( getOpposite(direction) != MainPanel.direction) {
            MainPanel.direction = direction;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public static Direction getOpposite(Direction direction) {
        Direction ret = Direction.NONE;
        switch (direction) {
            case EAST:
                ret = Direction.WEST;
                break;
            case WEST:
                ret = Direction.EAST;
                break;
            case NORTH:
                ret = Direction.SOUTH;
                break;
            case SOUTH:
                ret = Direction.NORTH;
        }

        return ret;
    }
}
