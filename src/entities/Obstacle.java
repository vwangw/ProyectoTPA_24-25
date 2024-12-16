package entities;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Obstacle{

    public boolean collision = false;
    public int worldX, worldY;
    public BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemy_car.png")));
    public String name;


    public Obstacle() throws IOException {
        super();
    }

    public void update(){

    }

    public void draw(Graphics2D g2, GamePanel gamePanel){
        g2.drawImage(img, worldX,worldY , 30, 60, null);
    }

}
