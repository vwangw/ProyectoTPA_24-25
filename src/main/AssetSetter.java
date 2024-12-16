package main;

import entities.Coin;

import java.io.IOException;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setObject() throws IOException {
        gamePanel.obstacle[0] = new Coin();
        gamePanel.obstacle[0].worldX = 100;
        gamePanel.obstacle[0].worldY = 10;

        gamePanel.obstacle[1] = new Coin();
        gamePanel.obstacle[0].worldX = 50;
        gamePanel.obstacle[1].worldY = 10;

    }
}
