package entities;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Obstacle extends Actor{

    GamePanel gamePanel;
    BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemy_car.png")));

    public Obstacle(GamePanel gamePanel) throws IOException {
        super();
        this.gamePanel = gamePanel;


    }

    public void update(){

    }

    public void draw(Graphics2D g2){
        g2.drawImage(img, x, y, 30, 60, null);
    }

}
