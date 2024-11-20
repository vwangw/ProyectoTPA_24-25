package entities;

import java.awt.*;
import java.awt.event.KeyEvent;

import gamestates.GamePanel;

public class Player extends Actor{

    private int health;
    public Player(String name, int speed) {

        super(name, speed);
    }

    public void updatePos(int value) {
        this.pos += value;
    }

    public int getPos(){return pos;}

}
