package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Player extends Actor {

    private BufferedImage img;

    public Player(int speed) {
        super(speed);
        importImg();
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_car.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawPlayer(Graphics g) {
        g.drawImage(img, getPos(), 100, 64, 128, null);
    }

    public void updatePos(int value) {
        this.pos += value;
    }

    public int getPos() {
        return pos;
    }

    public int getSpeed(){return speed;}
}
