package entities;

public abstract class Actor {
    protected int speed;
    protected int pos = 0;

    public Actor(int speed) {
        this.speed = speed;
    }
}
