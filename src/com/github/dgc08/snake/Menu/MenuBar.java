package com.github.dgc08.snake.Menu;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar{
    public static MenuBar INSTANCE;

    static {
        MenuBar.INSTANCE = new MenuBar();
        INSTANCE.setBackground(Color.GRAY);

        FileMenu.register();
    }
}
