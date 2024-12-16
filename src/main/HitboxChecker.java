package main;

import entities.Actor;

public class HitboxChecker {

    GamePanel gamePanel;

    public HitboxChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public int checkObstacle(Actor actor, boolean player){
        int index = 999;
        for(int i = 0; i<gamePanel.obstacle.length; i++){
            if(gamePanel.obstacle[i] != null){
                actor.hitbox.x = actor.getX() + actor.hitbox.x;
                actor.hitbox.y = actor.getY() + actor.hitbox.y;

                gamePanel.obstacle[i].hitbox.x = gamePanel.obstacle[i].x + gamePanel.obstacle[i].hitbox.x;
                gamePanel.obstacle[i].hitbox.y = gamePanel.obstacle[i].y + gamePanel.obstacle[i].hitbox.y;

                if(actor.hitbox.intersects(gamePanel.obstacle[i].hitbox)){
                    if(gamePanel.obstacle[i].collisionOn){
                        actor.collisionOn = true;
                    }
                    if(player){
                        index = i;
                    }
                    break;
                }
                actor.hitbox.x = actor.hitboxDefaultX;
                actor.hitbox.y = actor.hitboxDefaultY;
                gamePanel.obstacle[i].hitbox.x = gamePanel.obstacle[i].hitboxDefaultX;
                gamePanel.obstacle[i].hitbox.y = gamePanel.obstacle[i].hitboxDefaultY;
            }
        }
        return index;
    }
}
