package com.snakegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyListenerSnake implements KeyListener {

    private Snake snake;

    public KeyListenerSnake(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_S:
                snake.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_A:
                snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                snake.setDirection(Direction.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) { }

    @Override
    public void keyTyped(KeyEvent arg0) { }
}