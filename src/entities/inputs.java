package entities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class inputs implements KeyListener {
    private Player player;

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyCode()){

            case KeyEvent.VK_A:
                player.pos += player.speed;
                break;
            case KeyEvent.VK_D:
                //player.;
                break;
            case KeyEvent.VK_S:
                //player.;
                break;
            case KeyEvent.VK_W:

                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
