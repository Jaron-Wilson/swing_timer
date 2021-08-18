package com.zetcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public  class Main {
    public static void main(String[] args) {

    }

    class Board extends JPanel
            implements ActionListener {

        private final int B_HEIGHT = 350;
        private final int INITIAL_X = -40;
        private final int INITIAL_Y = -40;

        private Image star;
        private int x, y;

        public Board() {

            initBoard();
        }

        private void loadImage() {

            ImageIcon ii = new ImageIcon("src/resources/star.png");
            star = ii.getImage();
        }

        private void initBoard() {

            setBackground(Color.BLACK);
            int b_WIDTH = 350;
            setPreferredSize(new Dimension(b_WIDTH, B_HEIGHT));

            loadImage();

            x = INITIAL_X;
            y = INITIAL_Y;

            int DELAY = 25;
            Timer timer = new Timer(DELAY, this);
            timer.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            drawStar(g);
        }

        private void drawStar(Graphics g) {

            g.drawImage(star, x, y, this);
            Toolkit.getDefaultToolkit().sync();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            x += 1;
            y += 1;

            if (y > B_HEIGHT) {

                y = INITIAL_Y;
                x = INITIAL_X;
            }

            repaint();
        }
    }
}