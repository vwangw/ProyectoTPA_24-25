package gamestates;

import entities.Player;
import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Playing extends State {

    private BufferedImage backgroundImage;
    private Player player;

    public Playing(Game game, Player player) {
        super(game);
        this.player = player;
        loadBackgroundImage();
    }

    private void loadBackgroundImage() {
        InputStream is = getClass().getResourceAsStream("/game_background.png");
        if (is != null) {
            try {
                backgroundImage = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("No se pudo cargar la imagen de fondo.");
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, 1200, 700, null);
        player.drawPlayer(g);

    }
}
