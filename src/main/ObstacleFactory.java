package main;

import entities.Coin;
import entities.Enemy;
import entities.Obstacle;

import java.io.IOException;

public class ObstacleFactory {
    public static Obstacle createObstacle(String type) throws IOException {
        return switch (type) {
            case "Coin" -> new Coin();
            case "Enemy" -> new Enemy();
            default -> throw new IllegalArgumentException("Error: " + type);
        };
    }
}
