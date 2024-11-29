package gamestates;

import main.Game;
import ui.MenuButton;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Menu extends State {

    private ArrayList<MenuButton> buttons;

    public Menu(Game game) {
        super(game);
        buttons = new ArrayList<>();
        buttons.add(new MenuButton(450, 200, 300, 50, "Comenzar"));
        buttons.add(new MenuButton(450, 400, 300, 50, "Salir"));
    }

    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 1200, 700);
        for (MenuButton button : buttons) {
            button.draw(g);
        }
    }

    public void mouseMoved(MouseEvent e) {
        for (MenuButton button : buttons) {
            if (isIn(e, button)) {
                button.setColor(Color.YELLOW);
            } else {
                button.setColor(Color.WHITE);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        for (MenuButton button : buttons) {
            if (isIn(e, button)) {
                if (button.getBounds().y == 200) {
                    game.changeState(new Playing(game, game.getPlayer()));
                } else if (button.getBounds().y == 400) {
                    System.exit(0);
                }
            }
        }
    }
}
