package com.snakegame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.snakegame.data.Direction;
import com.snakegame.data.GameData;
import com.snakegame.data.GameStatus;

class KeyListenerSnake implements KeyListener {

    private GameData gameData;
    private boolean keyPressed;

    public KeyListenerSnake(GameData gameData) {
        this.gameData = gameData;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (keyPressed)
            return;

        gameData.setGameStatus(GameStatus.RUNNING);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gameData.setSnakeDirection(Direction.UP);
                break;
            case KeyEvent.VK_S:
                gameData.setSnakeDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_A:
                gameData.setSnakeDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                gameData.setSnakeDirection(Direction.RIGHT);
                break;
        }

        keyPressed = true;
    }

    @Override
    public void keyReleased(KeyEvent arg0) { }
    
    @Override
    public void keyTyped(KeyEvent arg0) { }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public void setKeyPressed(boolean keyPressed) {
        this.keyPressed = keyPressed;
    }
    
}