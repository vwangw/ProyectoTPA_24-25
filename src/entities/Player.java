package entities;

import main.GamePanel;
import main.KeyInputHandler;
import main.UI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Actor{

    GamePanel gamePanel;
    UI ui;
    KeyInputHandler keyInputHandler;
    BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player_car.png")));
    public int coinCount = 0;

    public Player(GamePanel gamePanel, KeyInputHandler keyInputHandler, UI ui) throws IOException {
        this.gamePanel = gamePanel;
        this.keyInputHandler = keyInputHandler;
        this.ui = ui;

        hitbox = new Rectangle(0, 0, gamePanel.tileSize, gamePanel.tileSize);
        hitboxDefaultX = 8;
        hitboxDefaultY = 16;

        setDefaultValue();
    }

    public void setDefaultValue(){

        x = gamePanel.getScreenWidth()/2;
        y = 500;
        speed = 6;
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

        collisionOn = false;
        int  ObsIndex = gamePanel.hitboxChecker.checkObstacle(this, true);
        interactObstacle(ObsIndex);
    }

    public void interactObstacle(int i){
        if(i != 999){
            String obstacleName = gamePanel.obstacle[i].name;

            switch(obstacleName){
                case "Coin":
                    coinCount++;
                    ui.pointsCounter += 10*50;
                    gamePanel.obstacle[i] = null;
                    break;
                case "Enemy":
                    gamePanel.gameState = gamePanel.overState;
                    break;
            }

        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(img, x, y, 30, 60, null);
    }
}
