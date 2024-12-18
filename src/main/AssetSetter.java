package main;

import entities.Obstacle;

import java.io.IOException;
import java.util.Random;

public class AssetSetter {
    GamePanel gamePanel;
    private final Random random = new Random();

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void obstaclesFactory() throws IOException {
        gamePanel.obstacle[0] = createAndPlaceObstacle("Coin");
        gamePanel.obstacle[1] = createAndPlaceObstacle("Enemy");

        while (samePos()) {
            gamePanel.obstacle[0] = createAndPlaceObstacle("Coin");
            gamePanel.obstacle[1] = createAndPlaceObstacle("Enemy");
        }
    }

    private Obstacle createAndPlaceObstacle(String type) throws IOException {
        Obstacle obstacle = ObstacleFactory.createObstacle(type);
        obstacle.x = random.nextInt(gamePanel.getScreenHeight() - gamePanel.tileSize);
        return obstacle;
    }

    public boolean samePos() {
        return (Math.abs(gamePanel.obstacle[0].x - gamePanel.obstacle[1].x) < 100)
                && (Math.abs(gamePanel.obstacle[0].y - gamePanel.obstacle[1].y) < 100);
    }
}
