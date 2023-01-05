package com.github.dgc08.snake.Menu;

import java.awt.*;

public class FlowLayoutWrapper extends Container{
    public FlowLayout layout;

    public FlowLayoutWrapper(Component comp) {
        super();
        layout = new FlowLayout();
        setLayout(layout);
        add(comp);
    }
}
