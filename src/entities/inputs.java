package entities;

import gamestates.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class inputs implements KeyListener {
    private Player player = new Player("sda", 10);
    private GamePanel gamePanel;
    public inputs (GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){

            case KeyEvent.VK_A:
                player.updatePos(-player.speed);
                break;
            case KeyEvent.VK_D:
                player.updatePos(player.speed);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
