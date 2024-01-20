package com.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

class GameBoard extends JPanel implements ActionListener {
    private final int BOARD_WIDTH = 300;
    private final int BOARD_HEIGHT = 300;

    private Food food;
    private Snake snake;
    private Timer timer = new Timer(200, this);
    private GameStatus gameStatus;
    private boolean keyPressed;

    GameBoard() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        food = new Food();
        timer.start();
        gameStatus = GameStatus.STOPPED;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        keyPressed = false;
        if (gameStatus==GameStatus.STOPPED){
            snake = new Snake();
        }
        if (snake.detectFoodColision(food))
            food = new Food();
        snake.updatePosition();
        repaint();
        if (snake.detectColision()) {
            food = new Food();
            gameStatus = GameStatus.STOPPED;
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Paint snake head
        Point snakeHeadPosition = snake.getHeadPosition();
        g.setColor(Color.MAGENTA);
        g.fillRect(snakeHeadPosition.x * 10, snakeHeadPosition.y * 10, 10, 10);
        // Paint snake body
        LinkedList<Point> snakeBodyPosition = snake.getBodyPositions();
        g.setColor(Color.MAGENTA);
        snakeBodyPosition.forEach((bodyPosition) -> {
            g.fillRect(bodyPosition.x * 10 + 1, bodyPosition.y * 10 + 1, 8, 8);        
        });

        // Paint food
        Point foodPosition = food.getPosition();
        g.setColor(Color.RED);
        g.fillRect(foodPosition.x * 10 + 1, foodPosition.y * 10 + 1, 8, 8);
    }

    public Snake getSnake() {
        return snake;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }    

    public void setKeyPressed(boolean keyPressed) {
        this.keyPressed = keyPressed;
    }

    public boolean isKeyPressed() {
        return keyPressed;
    }

}

