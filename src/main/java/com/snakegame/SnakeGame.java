package com.snakegame;

import javax.swing.*;

public class SnakeGame {

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        KeyListenerGameBoard keyListenerGameBoard = new KeyListenerGameBoard(gameBoard);

        JFrame frame = new JFrame();
        frame.addKeyListener(keyListenerGameBoard);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.add(gameBoard);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Game");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}





