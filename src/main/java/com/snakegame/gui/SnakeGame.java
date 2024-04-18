package com.snakegame.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.snakegame.data.GameData;
import com.snakegame.data.GameStatus;

public class SnakeGame implements ActionListener {

    JFrame frame;
    GameData gameData;
    GameBoard gameBoard;
    KeyListenerSnake keyListenerSnake;
    Timer timer;
    boolean keyPressed;

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.run();
    }

    public SnakeGame() {
        timer = new Timer(100, this);
        gameData = new GameData();
        gameBoard = new GameBoard(gameData);
        keyListenerSnake = new KeyListenerSnake(gameData);
        
        frame = new JFrame();
        frame.addKeyListener(keyListenerSnake);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.add(gameBoard);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Game");
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    
    public void run(){
        timer.start();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameData.updateGameBoard();
        gameBoard.repaint();
        if (gameData.getGameStatus()==GameStatus.RUNNING) {
            gameData.incrementTimeElapsed();
        } else {
            gameData = new GameData();
            gameBoard.setGameData(gameData);
            keyListenerSnake.setGameData(gameData);
        }

        keyListenerSnake.setKeyPressed(false);
    }
}





