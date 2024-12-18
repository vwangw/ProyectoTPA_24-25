package main;

import entities.Obstacle;
import entities.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GamePanel extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    public int getScreenWidth() {
        return screenWidth;
    }

    final int screenWidth = tileSize * maxScreenCol;

    public int getScreenHeight() {
        return screenHeight;
    }

    final int screenHeight = tileSize * maxScreenRow;

    BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/game_background.png")));

    int FPS = 60;

    Thread gameThread;
    KeyInputHandler keyInputHandler = new KeyInputHandler(this);
    public UI ui = new UI(this);
    Player player = new Player(this, keyInputHandler, ui);
    public HitboxChecker hitboxChecker = new HitboxChecker(this);
    public Obstacle[] obstacle = new Obstacle[3];
    public AssetSetter assetSetter = new AssetSetter(this);

    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int overState = 3;

    public GamePanel() throws IOException {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyInputHandler);
        this.setFocusable(true);
    }

    public void setupGame() throws IOException {
        assetSetter.obstaclesFactory();
        gameState = titleState;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000f/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer>=1000000000){
                System.out.println("FPS: "+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){

        if(gameState == playState){
            player.update();
            for (Obstacle value : obstacle) {
                if (value != null) {
                    value.update();
                }
            }
        }
        if(gameState == pauseState && gameState == overState){

        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, screenWidth, screenHeight, null);
        Graphics2D g2 = (Graphics2D)g;

        if (gameState == titleState) {
            ui.draw(g2);

        }else {
            for (Obstacle value : obstacle) {
                if (value != null) {
                    value.draw(g2);
                }
            }
            player.draw(g2);
            ui.draw(g2);
        }

        g2.dispose();
    }
}
