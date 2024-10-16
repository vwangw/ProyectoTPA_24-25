package entities;

public abstract class Actor {
    protected String name;
    protected int speed;

    public Actor(String name, int speed){
        this.name = name;
        this.speed = speed;
    }
}
