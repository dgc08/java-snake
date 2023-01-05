package com.github.dgc08.snake.Menu;

import com.github.dgc08.snake.Main;
import com.github.dgc08.snake.MainPanel;
import com.github.dgc08.snake.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseDialog extends JDialog {
    public static int difficulty = 120;
    private Container mainPane = getContentPane();
    private JTextArea textArea = new JTextArea(Integer.toString(difficulty)) {
        {
            setPreferredSize(new Dimension(70,25));
        }
    };
    private JLabel label = new JLabel();

    public ChooseDialog() {
        setSize(new Dimension(300, 100));
        setLocationRelativeTo(Main.frame);

        mainPane.setLayout(new GridLayout(1,3));

        mainPane.add(new FlowLayoutWrapper(textArea));

        mainPane.add(new FlowLayoutWrapper(  new JButton("OK") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!Util.isNumeric(textArea.getText())) {
                            label.setText(Util.invalidDifficulty);
                            return;
                        }
                        difficulty = Integer.parseInt(textArea.getText());
                        Main.game.t = new Timer(difficulty, Main.game);
                        Main.game.t.start();
                        dispose();
                    }
                });
            }
        }));

        mainPane.add(label);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
