package main;

import entities.Actor;

public class HitboxChecker {

    GamePanel gamePanel;

    public HitboxChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void checkTile(Actor actor){
        int actorLeftX = actor.getX() + actor.hitbox.x;
        int actorRightX = actor.getX() + actor.hitbox.x + actor.hitbox.width;
        int actorTopY = actor.getY() + actor.hitbox.y;
        int actorBottomY = actor.getY() + actor.hitbox.y + actor.hitbox.height;

        int actorLeftCol = actorLeftX/gamePanel.tileSize;
        int actorRightCol = actorRightX/gamePanel.tileSize;
        int actorTopRow = actorTopY/gamePanel.tileSize;
        int actorBottomRow = actorBottomY/gamePanel.tileSize;

        //if statement para ver si hay colision

    }
}
