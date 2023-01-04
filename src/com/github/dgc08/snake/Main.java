package com.github.dgc08.snake;

import com.github.dgc08.snake.Menu.MenuBar;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static JFrame frame;
    public static MainPanel game;

    public static void main(String[] args) {
	// write your code here
        System.out.println();
        EventQueue.invokeLater(() -> {
            frame = new JFrame();
            initFrame();
            frame.setVisible(true);
        });
    }

    private static void initFrame() {
        game = new MainPanel();
        frame.add(game);
        frame.setResizable(false);
        frame.pack();

        frame.setTitle("Snake");
        frame.setIconImage(MainPanel.apple);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(MenuBar.INSTANCE);
    }
}
