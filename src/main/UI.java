package main;

import java.awt.*;

public class UI {

    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40;
    public long pointsCounter = 0;
    public boolean gameFinished = false;
    public int commandNum = 0;

    public UI (GamePanel gamePanel){
        this.gamePanel = gamePanel;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
    }

    public void draw (Graphics2D g2){
        this.g2 = g2;
        if(gamePanel.gameState == gamePanel.titleState){
            drawTitleScreen();
        }else if(gamePanel.gameState == gamePanel.playState){
            drawPlayingScreen();
        }else if(gamePanel.gameState == gamePanel.pauseState){
            drawPauseScreen();
        }else if(gamePanel.gameState == gamePanel.overState){
            drawOverScreen();
        }

    }

    public void drawTitleScreen(){

        g2.setColor(new Color(70,120,80));
        g2.fillRect(0,0,gamePanel.screenWidth,gamePanel.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Car Game";
        int x = getCenteredX(text);
        int y = gamePanel.tileSize*3;

        g2.setColor(Color.WHITE);
        g2.drawString(text,x,y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
        text = "START";
        x = getCenteredX(text);
        y += gamePanel.tileSize*4;
        g2.drawString(text,x,y);
        if(commandNum == 0){
            g2.drawString(">", x-gamePanel.tileSize,y);
        }

        text = "QUIT";
        x = getCenteredX(text);
        y += gamePanel.tileSize*2;
        g2.drawString(text,x,y);
        if(commandNum == 1){
            g2.drawString(">", x-gamePanel.tileSize,y);
        }

    }

    public void drawPlayingScreen(){
        if(gameFinished){
            gamePanel.gameState = gamePanel.overState;
        }else {
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);
            g2.drawString("Points: "+ (pointsCounter/50),25,40);
            pointsCounter++;
            if(pointsCounter > 60*50){
                gamePanel.ui.gameFinished = true;
                pointsCounter = 0;
            }
        }
    }

    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED";
        int x;
        x = getCenteredX(text);
        int y = gamePanel.screenHeight/2;

        g2.drawString(text,x,y);
    }

    public void drawOverScreen(){
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        String text = "Game Finished";
        g2.drawString(text, getCenteredX(text),gamePanel.screenHeight/2);

    }

    public int getCenteredX(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        return gamePanel.screenWidth/2-length/2;
    }
}
