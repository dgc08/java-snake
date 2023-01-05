package com.github.dgc08.snake.Menu;

import com.github.dgc08.snake.Author;
import com.github.dgc08.snake.Main;
import com.github.dgc08.snake.MainPanel;
import com.github.dgc08.snake.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileMenu{
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
    private static JMenuItem aboutItem = new JMenuItem("About the Game") {
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

    private static JMenuItem pauseResumeItem = new JMenuItem("Pause/Resume") {
        {
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pauseResume();
                }
            });
        }
    };

    private static JMenuItem chooseDifficultyItem = new JMenuItem("Choose Difficulty") {
        {
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pauseResume(true);
                    ChooseDialog dialog = new ChooseDialog();
                    dialog.setVisible(true);

                }
            });
        }
    };

    public static void pauseResume() {
        if (Util.running) {
            Main.game.t.stop();
            Util.running = false;
        }
        else {
            Main.game.t.start();
            Util.running = true;
        }
    }
    public static void pauseResume(boolean onlyStop) {
        if (Util.running && onlyStop) {
            Main.game.t.stop();
            Util.running = false;
        }
        if (!Util.running && !onlyStop) {
            Main.game.t.start();
            Util.running = true;
        }

    }

    public static void register() {
        file = new JMenu("Game");

        initItems();

        MenuBar.INSTANCE.add(file);
    }
    private static void initItems() {
        file.add(pauseResumeItem);
        file.add(chooseDifficultyItem);
        file.add(restartItem);
        file.add(endItem);

        file.addSeparator();

        file.add(aboutItem);

    }

}
