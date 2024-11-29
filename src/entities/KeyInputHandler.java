package entities;

import gamestates.Playing;

import gamestates.State;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {

    private State state;
    private Player player;

    public KeyInputHandler(State state, Player player) {
        this.state = state;
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (state instanceof Playing) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    player.updatePos(-player.getSpeed());
                    break;
                case KeyEvent.VK_D:
                    player.updatePos(player.getSpeed());
                    break;
            }
        }
    }
}
