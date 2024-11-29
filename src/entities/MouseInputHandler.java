package gamestates;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInputHandler extends MouseAdapter {

    private State state;

    public MouseInputHandler(State state) {
        this.state = state;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (state instanceof Menu) {
            ((Menu) state).mouseMoved(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (state instanceof Menu) {
            ((Menu) state).mousePressed(e);
        }
    }
}
