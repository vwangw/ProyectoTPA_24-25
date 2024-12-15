package entities;

import main.GamePanel;
import main.KeyInputHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Actor{

    GamePanel gamePanel;
    KeyInputHandler keyInputHandler;
    BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player_car.png")));

    public Player(GamePanel gamePanel, KeyInputHandler keyInputHandler) throws IOException {
        this.gamePanel = gamePanel;
        this.keyInputHandler = keyInputHandler;

        setDefaultValue();
    }

    public void setDefaultValue(){

        x = 100;
        y = 100;
        speed = 4;
    }

    public void update(){
        if(keyInputHandler.leftPressed){
            x -= speed;
        }else if(keyInputHandler.rightPressed){
            x += speed;
        }
        if(x>= gamePanel.getScreenWidth()-30){
            x = gamePanel.getScreenWidth()-30;
        }
        if(x<= 0){
            x = 0;
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(img, x, y, 30, 60, null);
    }
}
