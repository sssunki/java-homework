package com.team7.yourturn.test;

import javax.swing.*;
import java.awt.*;

public class ItemComponent extends JComponent {

    private static final int DEFAULT_WIDTH = 80;
    private static final int DEFAULT_HEIGHT = 80;

    private int width;
    private int height;

    private Image image;

    public ItemComponent(String filename, int width, int height) {
        image = new ImageIcon(getClass().getResource(filename)).getImage();
        this.width = width;
        this.height = height;
    }

    public ItemComponent(String filename) {
        image = new ImageIcon(getClass().getResource(filename)).getImage();
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
    }

    @Override
    public void paintComponent(Graphics g) throws NullPointerException {
        if (image == null) throw new NullPointerException("no image is set");

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        g.drawImage(image, 0, 0, width, height, null);
    }

    public Dimension getPreferredSized() {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
