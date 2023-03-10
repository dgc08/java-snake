package com.github.dgc08.snake;

import com.github.dgc08.snake.Menu.ChooseDialog;
import com.github.dgc08.snake.interaction.Direction;
import com.github.dgc08.snake.interaction.getDirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    //ATTR

    public static Image apple = null;
    private static Image snake = null;

    private int tail_amount;

    private int appleX;
    private int appleY;

    private int[] x = new int[Util.WIDTH*HEIGHT / Util.IMAGE_SIZE * Util.IMAGE_SIZE];
    private int[] y = new int[Util.WIDTH*HEIGHT / Util.IMAGE_SIZE * Util.IMAGE_SIZE];

    public static Direction direction = Direction.NORTH;
    public Timer t;

    private boolean gameIsRunning;

    // END ATTR

    private void initGame() {
        tail_amount = 3;
        x = new int[Util.WIDTH*HEIGHT / Util.IMAGE_SIZE * Util.IMAGE_SIZE];
        y = new int[Util.WIDTH*HEIGHT / Util.IMAGE_SIZE * Util.IMAGE_SIZE];

        for (int i = 0; i < tail_amount; i++) {
            x[i] = 100 - i * Util.IMAGE_SIZE;
            y[i] = Util.LENGTH/2;
        }

        gameIsRunning = true;
        t.start();
        spawnApple();
    }

    public MainPanel() {
        apple = new ImageIcon(getClass().getResource("resources/apple.png")).getImage();
        snake = new ImageIcon(getClass().getResource("resources/dot.png")).getImage();

        addKeyListener(new getDirection());
        setPreferredSize(new Dimension(Util.WIDTH, Util.LENGTH + 30)); // + 30 Becuse of Menu Bar

        setFocusable(true);
        setBackground(Color.DARK_GRAY );

        t = new Timer(ChooseDialog.difficulty, this);
        
        initGame();
    }

    private void spawnApple() {
        int random = (int) (Math.random() * Util.SPAWNER_CONST_WIDTH);
        appleX = random * Util.IMAGE_SIZE;

        random = (int) (Math.random() * Util.SPAWNER_CONST_LENGTH);
        appleY = random * Util.IMAGE_SIZE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameIsRunning) {
            checkAppleEat();
            checkDeath();
            moveSnake();
        }
        repaint();
    }

    private void checkDeath() {
        for (int i = tail_amount; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                gameIsRunning = false;
                t.stop();
            }
        }
    }

    private void moveSnake() {
        for (int i = tail_amount; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch (this.direction) {
            case NORTH :
                y[0] = Util.negMod(y[0] - Util.IMAGE_SIZE, Util.LENGTH);
                break;
            case SOUTH:
                y[0] = Util.negMod(y[0] + Util.IMAGE_SIZE, Util.LENGTH);
                break;

            case EAST:
                x[0] = Util.negMod(x[0] + Util.IMAGE_SIZE, Util.LENGTH);
                break;
            case WEST:
                x[0] = Util.negMod(x[0] - Util.IMAGE_SIZE, Util.LENGTH);
        }

    }

    private void checkAppleEat() {
        if(x[0] == appleX && y[0] == appleY) {
            tail_amount++;
            spawnApple();
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (gameIsRunning) {
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < tail_amount; i++) {
                g.drawImage(snake, x[i], y[i], this);
            }
            Toolkit.getDefaultToolkit().sync();
        }
        else {
            Font f = new Font("Calibri", Font.BOLD, 16);
            FontMetrics metrics = getFontMetrics(f);

            g.setColor(Color.WHITE);
            g.setFont(f);

            g.drawString(Util.gameOverMessage, (Util.WIDTH - (metrics.stringWidth(Util.gameOverMessage) )) / 2, Util.LENGTH/4);
            g.drawString(Util.restartHelper, (Util.WIDTH - (metrics.stringWidth(Util.restartHelper) )) / 2, Util.LENGTH/2);
        }
    }

    public void restart() {
        direction = Direction.NORTH;
        initGame();
    }
}
