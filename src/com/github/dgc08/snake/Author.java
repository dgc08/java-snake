package com.github.dgc08.snake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Author implements ActionListener {
    private static final String website = "https://github.com/dgc08/java-snake";
    private static final String aboutMsg = "This Game was written by Sinthoras39 \nCheck out the Game's GitHub Repo for Updates and more: " + website + "\n\nShould this Website be opened?";
    public static final String version = "0.0.0";

    public static void openWebsite() {

        Desktop desktop = Desktop.getDesktop();
        URL url = null;
        try {
            url = new URL(website);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        try {
            desktop.browse(url.toURI());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(Main.frame,
                aboutMsg,
                "Java Snake by Sinthoras39 v" + version,
                JOptionPane.YES_NO_OPTION);
        if (res == 0) {
            openWebsite();
        }
    }
}
