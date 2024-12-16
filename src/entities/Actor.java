package entities;

import java.awt.*;

public abstract class Actor {
    protected int speed;
    public int x, y;
    public Rectangle hitbox;
    public boolean collisionOn = false;
    public String direction;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
