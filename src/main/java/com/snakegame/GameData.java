package com.snakegame;

import java.awt.*;
import java.util.LinkedList;

class GameData  {

    private int score;
    private int timeElapsed;
    private Food food;
    private Snake snake;
    private GameStatus gameStatus;

    GameData() {
        score = 0;
        timeElapsed = 0;
        food = new Food();
        snake = new Snake();
        gameStatus = GameStatus.STOPPED;
    }
    
    public void updateGameBoard() {
        if (snake.detectFoodColision(food)){
            snake.increaseLength();
            food = new Food();
            score++;
        }
        snake.updatePosition();
        if (snake.detectColision()) {
            food = new Food();
            gameStatus = GameStatus.STOPPED;
        }
    }

    public void incrementTimeElapsed() {
        timeElapsed++;
    }

    public Point getSnakeHeadPosition() {
        return snake.getHeadPosition();
    }

    public LinkedList<Point> getSnakeBodyPositions() {
        return snake.getBodyPositions();
    }
    
    public Point getFoodPosition() {
        return food.getPosition();
    }    

    public int getScore() {
        return score;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }    

    public void setSnakeDirection(Direction direction) {
        snake.setDirection(direction);
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

}

