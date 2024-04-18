package com.snakegame.data;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

class Snake {

    private Point headPosition;
    private LinkedList<Point> bodyPositions;
    private Direction direction;
    
    public Snake() {
        headPosition = new Point(14, 14);
        bodyPositions = new LinkedList<Point>();
        bodyPositions.add(new Point(14, 13));
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

    public boolean detectColision() {
        // Detect colision with board
        if (headPosition.x>=31 || 
            headPosition.x<1 ||
            headPosition.y>=31 ||
            headPosition.y<1)
            return true;
        // Detect colision with body
            Iterator<Point> bodyPositions = this.bodyPositions.iterator();
            while (bodyPositions.hasNext()) {
                Point bodyPosition = bodyPositions.next();
                if (bodyPosition.x==headPosition.x && bodyPosition.y==headPosition.y)
                    return true;
            }
        return false;
    }
    
    public boolean detectFoodColision(Food food) {
        Point foodPosition = food.getPosition();
        if (headPosition.x==foodPosition.x &&
            headPosition.y==foodPosition.y){
            return true;
        }
        return false;
    }    

    public void increaseLength() {
        bodyPositions.addLast(bodyPositions.getLast());
    }

    public void setDirection(Direction direction) {
        if (this.direction==Direction.UP || this.direction==Direction.DOWN) { 
            if (direction==Direction.LEFT || direction==Direction.RIGHT) {
                this.direction = direction;
            }
        } else if (this.direction==Direction.LEFT || this.direction==Direction.RIGHT) {
            if (direction==Direction.UP || direction==Direction.DOWN) {
                this.direction = direction;
            }
        } else {
            this.direction = direction;
        }
    }

    public Direction getDirection() {
        return direction;
    }    
}
