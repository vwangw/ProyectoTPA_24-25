package entities;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Obstacle extends Actor{

    public boolean collision = false;
    public BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemy_car.jpg")));
    public String name;
    public Rectangle hitbox = new Rectangle(0,0,48,48);
    public int hitboxDefaultX = 0;
    public int hitboxDefaultY = 0;

    public Obstacle() throws IOException {
        super();
        x = (int)(Math.random() * 800);
        y = 0;
        speed = 5;
    }

    public void update(){
        y +=speed;

        if (y > 600) {
            y = 0;
            x = (int)(Math.random() * 800);
        }
    }

    public void draw(Graphics2D g2, GamePanel gamePanel){
        g2.drawImage(img, x,y , 30, 60, null);
    }

}
