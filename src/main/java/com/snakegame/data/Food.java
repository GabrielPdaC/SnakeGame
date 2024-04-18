package com.snakegame.data;

import java.awt.Point;
import java.util.Random;

class Food {
    
    Point position;

    public Food() {
        Random rand = new Random();
        int posX = rand.nextInt(30) + 1;
        int posY = rand.nextInt(30) + 1;
        position = new Point(posX, posY);
    }
    
    public Point getPosition() {
        return position;
    }
    
}
