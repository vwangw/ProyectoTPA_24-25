package main;

import entities.Coin;
import entities.Enemy;

import java.io.IOException;
import java.util.Random;

public class AssetSetter {
    GamePanel gamePanel;
    private final Random random = new Random();

    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void randomPos() throws IOException {

        gamePanel.obstacle[0] = new Coin();
        gamePanel.obstacle[0].x = random.nextInt(gamePanel.getScreenHeight() - gamePanel.tileSize);
        gamePanel.obstacle[0].y = 0;

        gamePanel.obstacle[1] = new Enemy();
        gamePanel.obstacle[1].x = random.nextInt(gamePanel.getScreenHeight() - gamePanel.tileSize);
        gamePanel.obstacle[1].y = 0;

        while (samePos()) {
            gamePanel.obstacle[0].x = random.nextInt(gamePanel.getScreenHeight() - gamePanel.tileSize);
            gamePanel.obstacle[1].x = random.nextInt(gamePanel.getScreenHeight() - gamePanel.tileSize);
        }
    }

    public boolean samePos() {
        return (Math.abs(gamePanel.obstacle[0].x - gamePanel.obstacle[1].x) < 100) && (Math.abs(gamePanel.obstacle[0].y - gamePanel.obstacle[1].y) < 100);
    }
}
