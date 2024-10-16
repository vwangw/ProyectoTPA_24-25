package entities;

public abstract class Actor {
    protected String name;
    protected int speed=10;
    protected int pos=0;

    public Actor(String name, int speed){
        this.name = name;
        this.speed = speed;
        this.pos = pos;
    }
}
