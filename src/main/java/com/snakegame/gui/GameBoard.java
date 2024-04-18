package com.snakegame.gui;

import javax.swing.*;

import com.snakegame.data.GameData;
import com.snakegame.data.GameStatus;

import java.awt.*;
import java.util.LinkedList;

class GameBoard extends JPanel  {
    
    private final int GAMEBOARD_WIDTH = 320;
    private final int GAMEBOARD_HEIGHT = 340;

    private final int BOARD_LIMIT_WIDTH = 300;
    private final int BOARD_LIMIT_HEIGHT = 300;

    private final int SCORE_POSITION = 330;
    private final int START_POSITION = 150;

    private GameData gameData;

    GameBoard(GameData gameData) {
        setPreferredSize(new Dimension(GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        this.gameData = gameData;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameData.getGameStatus()==GameStatus.RUNNING) {
            paintGameDataComponent(g);
        } else {
            paintMenuComponent(g);
        }

    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    private void paintGameDataComponent(Graphics g) {
        // Paint snake head
        Point snakeHeadPosition = gameData.getSnakeHeadPosition();
        g.setColor(Color.MAGENTA);
        g.fillRect(snakeHeadPosition.x * 10, snakeHeadPosition.y * 10, 10, 10);
        // Paint snake body
        LinkedList<Point> snakeBodyPosition = gameData.getSnakeBodyPositions();
        g.setColor(Color.MAGENTA);
        snakeBodyPosition.forEach((bodyPosition) -> {
            g.fillRect(bodyPosition.x * 10 + 1, bodyPosition.y * 10 + 1, 8, 8);        
        });

        // Paint food
        Point foodPosition = gameData.getFoodPosition();
        g.setColor(Color.RED);
        g.fillRect(foodPosition.x * 10 + 1, foodPosition.y * 10 + 1, 8, 8);

        // Paint 
        g.drawRect(10, 10, BOARD_LIMIT_WIDTH, BOARD_LIMIT_HEIGHT);

        // Paint score
        g.drawString("Score: " + gameData.getScore(), 10, SCORE_POSITION);
        // Paint timer
        g.drawString("Time: " + gameData.getTimeElapsed()/10, 100, SCORE_POSITION);        
    }

    private void paintMenuComponent(Graphics g) {
        g.drawString("Press to Start...", 110, START_POSITION);
    }
    
}

