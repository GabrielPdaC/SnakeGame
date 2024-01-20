package com.snakegame;

import java.awt.Point;
import java.util.LinkedList;

public class Snake {

    private Point headPosition;
    private LinkedList<Point> bodyPositions;
    private Direction direction;
    
    public Snake() {
        headPosition = new Point(14, 14);
        bodyPositions = new LinkedList<Point>();
        bodyPositions.add(new Point(14, 13));
        bodyPositions.add(new Point(14, 12));
        bodyPositions.add(new Point(14, 11));
        direction = Direction.NONE;
    }
    
    public Point getHeadPosition() {
        return headPosition;
    }

    public LinkedList<Point> getBodyPositions() {
        return bodyPositions;
    }

    public void updatePosition() {
        if (direction==Direction.NONE)
            return;
            
        int x = 0,y = 0;
        switch (direction) {
            case UP:
                y = -1;
                break;
            case DOWN:
                y = 1;
                break;
            case LEFT:
                x = -1;
                break;
            case RIGHT:
                x = 1;
                break;
            case NONE:
                break;
        }
        bodyPositions.addFirst(headPosition);
        headPosition = new Point(headPosition.x + x, headPosition.y + y);
        bodyPositions.removeLast();
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
