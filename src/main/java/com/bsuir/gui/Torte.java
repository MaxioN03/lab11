package com.bsuir.gui;

import javax.swing.*;
import java.awt.*;

public class Torte extends JFrame {

    public static Integer[] values = {600, 175, 150, 50, 100, 125};
    public static int totalValue = calcTotalValue();
    public int xC = 40;
    public int yC = 60;
    Color colors[] = {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.BLUE,
            Color.MAGENTA,
            Color.PINK
    };
    public int cD = 200;
    static int windowWidth = 400;
    static int windowHeight = 400;

    public Torte(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static int calcTotalValue() {
        int buffer = 0;
        for (int i = 0; i < values.length; i++) {
            buffer += values[i];
        }
        return buffer;
    }

    @Override
    public void paint(Graphics g) {
        int start  = 0;
        int steps = values.length;
        int stepSize = 0;
        int total = values[0];
        for (int i = 1; i < steps; i++) {
            stepSize = getStepSize(values[i], total);
            g.setColor(colors[i - 1]);
            g.fillArc(xC, yC, cD, cD, start, stepSize);
            start += stepSize;
        }
    }

    private int getStepSize(Integer val, int total) {
        return (int)(360 * val) / total;
    }


    public static void main(String[] args) {
        new Torte("Measured Values", windowWidth, windowHeight);
    }

}
