package gamestates;

import entities.Player;
import entities.inputs;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class GamePanel extends JPanel {

    private Game game;
    private Player player = new Player("sad", 10);
    private float xPos = 0, yPos = 0;
    public BufferedImage img;

    public GamePanel(Game game){
        this.game=game;
        importImg();
        addKeyListener(new inputs(this));

        setPanelSize();
    }

    public void importImg(){
        InputStream is = getClass().getResourceAsStream("/player_car.png");
        try{
            img = ImageIO.read(is);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setPanelSize(){
        Dimension size=new Dimension(500,500);
        setPreferredSize(size);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img,player.getPos(),0,64,128,null);
    }

}
