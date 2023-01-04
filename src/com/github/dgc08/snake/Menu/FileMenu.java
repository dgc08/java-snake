package com.github.dgc08.snake.Menu;

import com.github.dgc08.snake.Author;
import com.github.dgc08.snake.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FileMenu{
    private static JMenu file;

    private static JMenuItem endItem = new JMenuItem("Quit") {
        {
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }
    };
    private static JMenuItem aboutItem = new JMenuItem("About the Program") {
        {
            addActionListener(new Author());
        }
    };

    private static JMenuItem restartItem = new JMenuItem("Restart") {
        {
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.game.restart();
                }
            });
        }
    };

    public static void register() {
        file = new JMenu("File");

        initItems();

        MenuBar.INSTANCE.add(file);
    }
    private static void initItems() {
        file.add(restartItem);
        file.add(endItem);

        file.addSeparator();

        file.add(aboutItem);

    }

}
