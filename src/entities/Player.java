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

        hitbox = new Rectangle(0, 0, gamePanel.tileSize, gamePanel.tileSize);

        setDefaultValue();
    }

    public void setDefaultValue(){

        x = gamePanel.getScreenWidth()/2;
        y = 500;
        speed = 6;
        direction = "left";
    }

    public void update(){
        if(keyInputHandler.leftPressed){
            direction = "left";
            x -= speed;
        }else if(keyInputHandler.rightPressed){
            direction = "right";
            x += speed;
        }
        if(x>= gamePanel.getScreenWidth()-30){
            x = gamePanel.getScreenWidth()-30;
        }
        if(x<= 0){
            x = 0;
        }

        collisionOn = false;
        gamePanel.hitboxChecker.checkTile(this);

        if(collisionOn) {

        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(img, x, y, 30, 60, null);
    }
}
